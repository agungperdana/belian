/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.facility;

import java.util.ArrayList;
import java.util.Collection;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Center;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.google.common.base.Strings;
import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.inventory.dm.FacilityType;
import com.kratonsolution.belian.inventory.svc.ContainerService;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.ModelDataListener;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FacilityEditContent extends FormContent
{	
	private final FacilityService service = Springs.get(FacilityService.class);
	
	private final ContainerService containerService = Springs.get(ContainerService.class);
	
	private Textbox code = new Textbox();
	
	private Textbox name = new Textbox();
	
	private Textbox note = new Textbox();
	
	private Listbox types = Components.newSelect();

	private Facility facility;
	
	private Collection<ModelDataListener> listeners = new ArrayList<>();
	
	public FacilityEditContent(Facility facility)
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
				if(Strings.isNullOrEmpty(code.getText()))
					throw new WrongValueException(code,"Code cannot be empty");
			
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,"Name cannot be empty");
				
				if(facility != null)
				{
					facility.setCode(code.getText());
					facility.setName(name.getText());
					facility.setNote(note.getText());
					
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
					for(ModelDataListener listener:listeners)
						form.addModelDataListener(listener);
					
					canvas.getChildren().clear();
					canvas.appendChild(form);
				}
			}
		});
		
		Toolbarbutton inv = new Toolbarbutton("Add Inventory(s)","/icons/new-inv-item.png");
		toolbar.appendChild(inv);
		inv.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				FacilityEditContent.this.getParent().getChildren().clear();
				FacilityEditContent.this.getParent().appendChild(new FacilityFormContent(facility));
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
	
	public void addModelDataListener(ModelDataListener listener)
	{
		listeners.add(listener);
	}
}
