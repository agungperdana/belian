
package com.kratonsolution.belian.ui.inventory.facility;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Column;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.ui.BForm;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FacilityForm extends BForm
{	
	private FacilityService service = Springs.get(FacilityService.class);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private FacilityTypeList types = new FacilityTypeList(false);
	
	private Textbox note = Components.stdTextBox(null,false);
	
	private Facility facility;
	
	private FacilityNav nav;
	
	public FacilityForm(Facility facility,FacilityNav nav)
	{
		super();
		
		this.facility = facility;
		this.nav = nav;
		
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
				Flow.next(getParent(), new FacilityGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,lang.get("message.field.empty"));
			
				if(facility.getId().equals("0"))
				{
					facility.setNote(note.getText());
					facility.setName(name.getText());
					facility.setType(types.getDomain());
					
					service.add(facility);
				}
				else
				{
					Facility out = service.findById(facility.getId());
					if(out != null)
					{
						out.setNote(note.getText());
						out.setName(name.getText());
						out.setType(types.getDomain());
					
						service.edit(out);
					}
				}
				
				Clients.showNotification(lang.get("message.savedata"));
				
				nav.setAddMode(false);
			}
		});
	}

	@Override
	public void initForm()
	{
		if(!Strings.isNullOrEmpty(facility.getName()))
			name.setText(facility.getName());
		
		types.setDomain(facility.getType());
		note.setText(facility.getNote());
		
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
		
		addRow(row1);
		addRow(row2);
		addRow(row3);
	}
}
