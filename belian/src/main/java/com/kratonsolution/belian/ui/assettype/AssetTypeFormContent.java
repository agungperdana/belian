/**
 * 
 */
package com.kratonsolution.belian.ui.assettype;

import java.util.ArrayList;
import java.util.Collection;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.inventory.dm.FacilityOrganization;
import com.kratonsolution.belian.inventory.dm.FacilityType;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class AssetTypeFormContent extends FormContent
{	
	private FacilityService service = Springs.get(FacilityService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private Textbox code = new Textbox();
	
	private Textbox name = new Textbox();
	
	private Textbox note = new Textbox();
	
	private Listbox types = new Listbox();
	
	private Facility parent;
	
	private Collection<FacilityDataListener> listeners = new ArrayList<>();
	
	private Tabbox tabbox = new Tabbox();
	
	private Grid orgs = new Grid();
	
	public AssetTypeFormContent(Facility parent)
	{
		super();
		
		this.parent = parent;

		removeChild(grid);
		
		tabbox.setHeight("100%");
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab("FORM"));
		tabbox.getTabs().appendChild(new Tab("ORGANIZATION(S)"));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().getChildren().get(0).appendChild(grid);

		appendChild(tabbox);
		
		initToolbar();
		initForm();
		initOrganization();
	}

	@Override
	public void initToolbar()
	{
		toolbar.removeChild(toolbar.getCancel());
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(code.getText()))
					throw new WrongValueException(code,"Code cannot be empty");
			
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,"Name cannot be empty");
				
				Facility out = service.findOneByCode(code.getText());
				if(out != null)
				{
					Clients.showNotification("Facility with code "+code.getText()+" already exist.");
					return;
				}
					
				Facility facility = new Facility();
				facility.setCode(code.getText());
				facility.setName(name.getText());
				facility.setNote(note.getText());
				facility.setType(FacilityType.valueOf(types.getSelectedItem().getValue().toString()));
				
				if(parent != null)
					facility.setParent(parent);
				
				for(Component com:orgs.getRows().getChildren())
				{
					Row row = (Row)com;
					
					FacilityOrganization organization = new FacilityOrganization();
					organization.setEnabled(RowUtils.isChecked(row, 0));
					organization.setFacility(facility);
					organization.setOrganization(organizationService.findOne(RowUtils.string(row, 2)));
					
					facility.getOrganizations().add(organization);
				}
				
				service.add(facility);
				
				for(FacilityDataListener listener:listeners)
					listener.fireDataAdded(facility);
				
				Clients.showNotification("Data successfully added.");
			}
		});
	}

	@Override
	public void initForm()
	{
		code.setConstraint("no empty");
		code.setWidth("200px");
		
		name.setConstraint("no empty");
		name.setWidth("300px");
		
		note.setWidth("350px");
		
		types.setMold("select");
		for(FacilityType type:FacilityType.values())
			types.appendChild(new Listitem(type.name(),type.name()));
		
		types.setSelectedIndex(0);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Code"));
		row1.appendChild(code);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Name"));
		row2.appendChild(name);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Type"));
		row3.appendChild(types);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Note"));
		row4.appendChild(note);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
	}
	
	public void initOrganization()
	{
		orgs.appendChild(new Columns());
		orgs.appendChild(new Rows());
		orgs.getColumns().appendChild(new Column(null,null,"25px"));
		orgs.getColumns().appendChild(new Column("Organization",null,"150px"));
		orgs.getColumns().appendChild(new Column(null,null,"0px"));
		orgs.getColumns().getChildren().get(2).setVisible(false);
		
		for(Organization organization:utils.getOrganizations())
		{
			Row row = new Row();
			row.appendChild(Components.checkbox(false));
			row.appendChild(new Label(organization.getName()));
			row.appendChild(new Label(organization.getId()));
		
			orgs.getRows().appendChild(row);
		}
		
		tabbox.getTabpanels().getChildren().get(1).appendChild(orgs);
	}
	
	public void addModelDataListener(FacilityDataListener listener)
	{
		listeners.add(listener);
	}
}
