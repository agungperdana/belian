/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.facility;

import java.util.ArrayList;
import java.util.Collection;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Checkbox;
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
import com.kratonsolution.belian.facility.dm.Facility;
import com.kratonsolution.belian.facility.dm.FacilityOrganization;
import com.kratonsolution.belian.facility.dm.FacilityType;
import com.kratonsolution.belian.general.dm.CompanyStructure;
import com.kratonsolution.belian.general.svc.CompanyStructureService;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FacilityFormContent extends FormContent
{	
	private FacilityService service = Springs.get(FacilityService.class);
	
	private CompanyStructureService companyStructureService = Springs.get(CompanyStructureService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private Textbox code = Components.mandatoryTextBox(false);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private Textbox note = Components.stdTextBox(null,false);
	
	private Listbox types = Components.newSelect();
	
	private Facility parent;
	
	private Collection<FacilityDataListener> listeners = new ArrayList<>();
	
	private Tabbox tabbox = new Tabbox();
	
	private Grid orgs = new Grid();
	
	public FacilityFormContent(Facility parent)
	{
		super();
		
		this.parent = parent;

		removeChild(grid);
		
		tabbox.setHeight("100%");
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab(lang.get("facility.grid.column.form")));
		tabbox.getTabs().appendChild(new Tab(lang.get("facility.grid.column.org")));
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
					throw new WrongValueException(code,lang.get("message.field.empty"));
			
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,lang.get("message.field.empty"));
					
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
				
				Flow.next(getParent().getParent().getParent(),new FacilityContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		code.addEventListener(Events.ON_CHANGING,new EventListener<InputEvent>()
		{
			@Override
			public void onEvent(InputEvent input) throws Exception
			{
				if(!Strings.isNullOrEmpty(input.getValue()))
				{
					Facility out = service.findOneByCode(input.getValue());
					if(out != null)
						throw new WrongValueException(code,lang.get("message.field.code"));
				}
			}
		});
		
		name.addEventListener(Events.ON_CHANGING,new EventListener<InputEvent>()
		{
			@Override
			public void onEvent(InputEvent input) throws Exception
			{
				if(!Strings.isNullOrEmpty(input.getValue()))
				{
					Facility out = service.findOneByName(input.getValue());
					if(out != null)
						throw new WrongValueException(name,lang.get("message.field.name"));
				}
			}
		});
		
		for(FacilityType type:FacilityType.values())
			types.appendChild(new Listitem(type.name(),type.name()));
		
		types.setSelectedIndex(0);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("facility.grid.column.code")));
		row1.appendChild(code);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("facility.grid.column.name")));
		row2.appendChild(name);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("facility.grid.column.type")));
		row3.appendChild(types);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("facility.grid.column.note")));
		row4.appendChild(note);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
	}
	
	public void initOrganization()
	{
		Checkbox all = Components.checkbox(false);
		all.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				if(all.isChecked())
				{
					for(Component com:orgs.getRows().getChildren())
						RowUtils.checked((Row)com, 0);
				}
				else
				{
					for(Component com:orgs.getRows().getChildren())
						RowUtils.unchecked((Row)com, 0);
				}
			}
		});
		
		
		orgs.appendChild(new Columns());
		orgs.appendChild(new Rows());
		orgs.getColumns().appendChild(new Column(null,null,"25px"));
		orgs.getColumns().appendChild(new Column(lang.get("facility.grid.column.organization"),null,"150px"));
		orgs.getColumns().appendChild(new Column());
		orgs.getColumns().getLastChild().setVisible(false);
		orgs.setSpan("1");
		orgs.getColumns().getChildren().get(0).appendChild(all);
		
		for(CompanyStructure com:companyStructureService.findAll())
		{
			Row row = new Row();
			row.appendChild(Components.checkbox(false));
			row.appendChild(new Label(com.getOrganization().getName()));
			row.appendChild(new Label(com.getOrganization().getId()));
		
			orgs.getRows().appendChild(row);
		}
		
		tabbox.getTabpanels().getChildren().get(1).appendChild(orgs);
	}
	
	public void addModelDataListener(FacilityDataListener listener)
	{
		listeners.add(listener);
	}
}
