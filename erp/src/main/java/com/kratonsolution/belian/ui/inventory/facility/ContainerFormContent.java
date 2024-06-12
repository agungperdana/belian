
package com.kratonsolution.belian.ui.inventory.facility;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.orm.Observer;
import com.kratonsolution.belian.facility.impl.orm.Container;
import com.kratonsolution.belian.facility.impl.orm.Facility;
import com.kratonsolution.belian.facility.impl.application.ContainerService;
import com.kratonsolution.belian.facility.impl.application.FacilityService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.CenterContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ContainerFormContent extends AbstractForm
{	
	private FacilityService service = Springs.get(FacilityService.class);
	
	private ContainerService containerService = Springs.get(ContainerService.class);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private ContainerTypeList types = new ContainerTypeList(false);
	
	private Textbox note = Components.stdTextBox(null,false);
	
	private ContainerList containers = new ContainerList(false);
	
	private FacilityList facilitys = new FacilityList(false);
	
	private Facility facility;
	
	private String container;
	
	public ContainerFormContent(Facility facility,String container)
	{
		super();
		this.facility = facility;
		this.container = container;
		
		initToolbar();
		initForm();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), null);
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,lang.get("message.field.empty"));
			
				if(types.getContainerType() == null)
					throw new WrongValueException(types,lang.get("message.field.empty"));
				
				Container container = new Container();
				container.setName(name.getText());
				container.setNote(note.getText());
				container.setParent(containers.getDomain());
				container.setType(types.getContainerType());
				
				containerService.add(container);
				
				if(getParent() != null && getParent() instanceof CenterContent)
				{
					for(Observer observer:((CenterContent)getParent()).getObservers())
						observer.valueChange(null);
				}
				
				Clients.showNotification(lang.get("message.savedata"));
			}
		});
	}

	@Override
	public void initForm()
	{
		if(!Strings.isNullOrEmpty(container))
			containers.setDomain(containerService.findById(container));
		
		if(facility != null && Strings.isNullOrEmpty(container))
			facilitys.setDomain(facility);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("generic.grid.column.name")));
		row1.appendChild(name);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("generic.grid.column.type")));
		row2.appendChild(types);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("generic.grid.column.note")));
		row3.appendChild(note);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("facility.grid.column.container")));
		row4.appendChild(containers);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("facility.grid.column.facility")));
		row5.appendChild(facilitys);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}
}
