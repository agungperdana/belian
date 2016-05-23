/**
 * 
 */
package com.kratonsolution.belian.ui.general.companystructure;

import java.util.ArrayList;
import java.util.Collection;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.general.dm.CompanyStructure;
import com.kratonsolution.belian.general.dm.CompanyStructureType;
import com.kratonsolution.belian.general.svc.CompanyStructureService;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Dates;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CompanyStructureEditContent extends FormContent
{	
private final CompanyStructureService service = Springs.get(CompanyStructureService.class);
	
	private final OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private Datebox from = Components.currentDatebox();
	
	private Datebox to = Components.datebox();
	
	private Listbox organizations = Components.newSelect(organizationService.findAll(), false);
	
	private Listbox types = Components.newSelect();
	
	private Collection<CompanyStructureDataListener> listeners = new ArrayList<CompanyStructureDataListener>();
	
	private CompanyStructure structure;

	private Component canvas;
	
	public CompanyStructureEditContent(Component canvas,CompanyStructure structure)
	{
		super();
		this.canvas = canvas;
		this.structure = structure;
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
				if(structure != null)
				{
					structure.setFrom(Dates.sql(from.getValue()));
					structure.setTo(Dates.sql(to.getValue()));
					service.edit(structure);
				
					for(CompanyStructureDataListener listener:listeners)
						listener.fireDataUpdated(structure);
				
					Clients.showNotification("Data successfully updated.");
				}
			}
		});
		
		Toolbarbutton toolbarbutton = new Toolbarbutton("New Child", "/icons/new-warehouse.png");
		toolbarbutton.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(structure != null)
				{
					CompanyStructureFormContent form = new CompanyStructureFormContent(structure);
					for(CompanyStructureDataListener listener:listeners)
						form.addDataListener(listener);
					
					canvas.getChildren().clear();
					canvas.appendChild(form);
				}
			}
		});
		
		toolbar.appendChild(toolbarbutton);
	}

	@Override
	public void initForm()
	{
		if(structure != null)
		{
			for(CompanyStructureType type:CompanyStructureType.values())
			{
				Listitem item = new Listitem(type.name(), type.name());
				types.appendChild(item);
				if(structure.getType().equals(type))
					types.setSelectedItem(item);
			}
			
			for(Listitem com:organizations.getItems())
			{
				if(com.getValue().toString().equals(structure.getOrganization().getId()))
					organizations.setSelectedItem(com);
			}
			
			types.setDisabled(true);
			organizations.setDisabled(true);
			
			from.setValue(structure.getFrom());
			to.setValue(structure.getTo());
			
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
			grid.getColumns().appendChild(new Column());
			
			Row row1 = new Row();
			row1.appendChild(new Label("Start Date"));
			row1.appendChild(from);
			
			Row row2 = new Row();
			row2.appendChild(new Label("End Date"));
			row2.appendChild(to);
			
			Row row3 = new Row();
			row3.appendChild(new Label("Organization"));
			row3.appendChild(organizations);
			
			Row row4 = new Row();
			row4.appendChild(new Label("Type"));
			row4.appendChild(types);
			
			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
			rows.appendChild(row4);
		}
	}
	
	public void addDataListener(CompanyStructureDataListener listener)
	{
		listeners.add(listener);
	}
}
