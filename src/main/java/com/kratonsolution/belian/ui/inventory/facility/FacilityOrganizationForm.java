
package com.kratonsolution.belian.ui.inventory.facility;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Column;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.general.dm.CompanyStructure;
import com.kratonsolution.belian.general.svc.CompanyStructureService;
import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.inventory.dm.FacilityOrganization;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.partys.svc.OrganizationService;
import com.kratonsolution.belian.ui.BForm;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FacilityOrganizationForm extends BForm
{	
	private FacilityService service = Springs.get(FacilityService.class);
	
	private CompanyStructureService structureService = Springs.get(CompanyStructureService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private FacilityTypeList types = new FacilityTypeList(false);
	
	private Textbox note = Components.stdTextBox(null,false);
	
	private Facility facility;
	
	public FacilityOrganizationForm(Facility facility)
	{
		super();
		
		this.facility = facility;
		
		initToolbar();
		initForm();
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
				Facility out = service.findById(facility.getId());
				if(out != null)
				{
					Map<String,FacilityOrganization> maps = new HashMap<>();
					for(FacilityOrganization organization:out.getOrganizations())
						maps.put(organization.getId(), organization);
					
					out.getOrganizations().clear();
					
					for(Component com:grid.getRows().getChildren())
					{
						Row row = (Row)com;
						
						FacilityOrganization in = maps.get(RowUtils.id(row));
						if(in == null)
							in = new FacilityOrganization();
						
						in.setEnabled(RowUtils.isChecked(row, 0));
						in.setFacility(out);
						in.setOrganization(IDValueRef.toRef(organizationService.findById(RowUtils.string(row, 2))));
						
						out.getOrganizations().add(in);
					}
					
					service.edit(out);
					
					Clients.showNotification(lang.get("message.updatedata"));
				}
			}
		});
	}

	@Override
	public void initForm()
	{
		Map<String, FacilityOrganization> maps = new HashMap<>();
		
		grid.getColumns().appendChild(new Column(null,null,"25px"));
		grid.getColumns().appendChild(new Column(lang.get("generic.grid.column.name"),null,"25px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().appendChild(new Column());
		grid.getColumns().getChildren().get(2).setVisible(false);
		grid.getColumns().getLastChild().setVisible(false);
		grid.setSpan("1");

		Facility out = service.findById(facility.getId());
		if(out != null)
		{
			for(FacilityOrganization organization:out.getOrganizations())
				maps.put(organization.getOrganization().getId(), organization);

			for(CompanyStructure structure:structureService.findAll())
			{
				if(!maps.containsKey(structure.getOrganization().getId()))
				{
					FacilityOrganization organization = new FacilityOrganization();
					organization.setFacility(out);
					organization.setOrganization(IDValueRef.toRef(structure.getOrganization()));
					
					maps.put(structure.getOrganization().getId(), organization);
				}
			}
			
			for(FacilityOrganization organization:maps.values())
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(organization.isEnabled()));
				row.appendChild(new Label(organization.getOrganization().getValue()));
				row.appendChild(new Label(organization.getOrganization().getId()));
				row.appendChild(new Label(organization.getId()));
				
				grid.getRows().appendChild(row);
			}
		}
	}
}
