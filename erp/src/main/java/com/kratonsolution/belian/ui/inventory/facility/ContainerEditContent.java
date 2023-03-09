
package com.kratonsolution.belian.ui.inventory.facility;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.google.common.base.Strings;
import com.kratonsolution.belian.inventory.dm.Container;
import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.inventory.svc.ContainerService;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ContainerEditContent extends AbstractForm
{	
	private FacilityService service = Springs.get(FacilityService.class);
	
	private ContainerService containerService = Springs.get(ContainerService.class);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private ContainerTypeList types = new ContainerTypeList(false);
	
	private Textbox note = Components.stdTextBox(null,false);
	
	private ContainerList containers = new ContainerList(false);
	
	private FacilityList facilitys = new FacilityList(false);
	
	private Facility root;
	
	private Container container;
	
	public ContainerEditContent(Facility facility,Container container)
	{
		super();
		this.root = facility;
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
				
				container = containerService.getOne(container.getId());
				if(container != null)
				{
					container.setFacility(facilitys.getDomain());
					container.setName(name.getText());
					container.setNote(note.getText());
					container.setParent(containers.getDomain());
					container.setType(types.getContainerType());
					
					containerService.edit(container);
				}
				
				Flow.next(getParent().getParent().getParent(), new ContainerContent(root));
			}
		});
		
		Toolbarbutton kid = new Toolbarbutton(lang.get("generic.grid.column.child"), "/icons/new-warehouse.png");
		kid.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(container != null)
				{
					Flow.next(getParent(), new ContainerFormContent(root, container.getId()));
				}
			}
		});
		
		toolbar.appendChild(kid);
	}

	@Override
	public void initForm()
	{
		
		if(container != null)
		{
			name.setText(container.getName());
			types.setContainerType(container.getType());
			note.setText(container.getNote());
			containers.setDomain(container.getParent());
			facilitys.setDomain(container.getFacility());
		}
		
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
