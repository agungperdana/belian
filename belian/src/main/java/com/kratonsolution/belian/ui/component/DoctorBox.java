/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;

import com.kratonsolution.belian.healtcare.dm.Doctor;
import com.kratonsolution.belian.healtcare.svc.DoctorService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorBox extends Combobox implements EventListener<Event>
{
	private DoctorService service = Springs.get(DoctorService.class);
	
	private Doctor doctor;
	
	public DoctorBox()
	{
		setAutocomplete(true);
		setAutodrop(true);
		setWidth("300px");
		setConstraint("no empty");
		addEventListener(Events.ON_CHANGING,this);
	}

	@Override
	public void onEvent(Event event) throws Exception
	{
		if(event instanceof InputEvent)
		{
			InputEvent input = (InputEvent)event;

			getChildren().clear();
			
			for(Doctor doctor:service.findAll(input.getValue()))
			{
				Comboitem item = new Comboitem();
				item.setLabel(doctor.getFrom().getName());
				item.setId(doctor.getId());

				appendChild(item);
			}
		}
	}
	
	public Doctor getDoctor()
	{
		if(getSelectedItem() != null)
			return service.findOne(getSelectedItem().getId());
		
		return null;
	}
}
