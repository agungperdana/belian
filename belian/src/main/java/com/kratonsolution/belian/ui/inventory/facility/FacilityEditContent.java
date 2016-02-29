/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.facility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Center;
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
import org.zkoss.zul.Toolbarbutton;

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
public class FacilityEditContent extends FormContent
{	
	private final FacilityService service = Springs.get(FacilityService.class);

	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);

	private Textbox code = new Textbox();

	private Textbox name = new Textbox();

	private Textbox note = new Textbox();

	private Listbox types = Components.newSelect();

	private Facility facility;

	private Collection<FacilityDataListener> listeners = new ArrayList<>();

	private Tabbox tabbox = new Tabbox();

	private Grid orgs = new Grid();

	public FacilityEditContent(Facility facility)
	{
		super();

		this.facility = facility;
		
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

				if(facility != null)
				{
					facility.setCode(code.getText());
					facility.setName(name.getText());
					facility.setNote(note.getText());
					facility.getOrganizations().clear();
					
					for(Component com:orgs.getRows().getChildren())
					{
						Row row = (Row)com;
						
						FacilityOrganization organization = new FacilityOrganization();
						organization.setEnabled(RowUtils.isChecked(row, 0));
						organization.setFacility(facility);
						organization.setOrganization(organizationService.findOne(RowUtils.string(row, 2)));
						
						facility.getOrganizations().add(organization);
					}
					
					service.edit(facility);
				}

				Clients.showNotification("Data successfully updated.");
			}
		});

		Toolbarbutton child = new Toolbarbutton("New Facility","/icons/new-warehouse.png");
		toolbar.appendChild(child);
		child.addEventListener(Events.ON_CLICK,new EventListener<Event>()
				{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Center canvas = (Center)FacilityEditContent.this.getParent();
				if(canvas != null)
				{
					FacilityFormContent form = new FacilityFormContent(facility);
					for(FacilityDataListener listener:listeners)
						form.addModelDataListener(listener);

					canvas.getChildren().clear();
					canvas.appendChild(form);
				}
			}
		});
	}

	@Override
	public void initForm()
	{
		code.setConstraint("no empty");
		code.setText(facility.getCode());
		code.setWidth("250px");

		name.setConstraint("no empty");
		name.setWidth("300px");
		name.setText(facility.getName());

		note.setText(facility.getNote());
		note.setWidth("350px");

		types.setMold("select");

		for(FacilityType type:FacilityType.values())
		{
			Listitem listitem = new Listitem(type.name(),type.name());
			types.appendChild(listitem);
			if(type.equals(facility.getType()))
				types.setSelectedItem(listitem);
		}

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
		
		Collection<Organization> fresh = new Vector<>();
		for(Organization organization:utils.getOrganizations())
		{
			boolean in = true;
			for(FacilityOrganization org:facility.getOrganizations())
			{
				if(org.getOrganization() != null && org.getOrganization().getId().equals(organization.getId()))
					in = false;
			}
		
			if(in)
				fresh.add(organization);
		}
		
		
		for(FacilityOrganization organization:facility.getOrganizations())
		{
			if(organization.getOrganization() != null)
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(organization.isEnabled()));
				row.appendChild(new Label(organization.getOrganization().getName()));
				row.appendChild(new Label(organization.getOrganization().getId()));
			
				orgs.getRows().appendChild(row);
			}
		}
		
		for(Organization organization:fresh)
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
