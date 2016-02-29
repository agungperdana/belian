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

import com.google.common.base.Strings;
import com.kratonsolution.belian.healtcare.dm.Patient;
import com.kratonsolution.belian.healtcare.svc.PatientService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PatientBox extends Combobox implements EventListener<Event>
{
	private PatientService service = Springs.get(PatientService.class);
	
	private Patient patient;
	
	public PatientBox()
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

			for(Patient patient:service.findAll(input.getValue()))
			{
				Comboitem item = new Comboitem();
				item.setLabel(patient.getFrom().getName()+(Strings.isNullOrEmpty(patient.getBpjs().getCard())?"":" (BPJS)"));
				item.setId(patient.getId());

				appendChild(item);
			}
		}
	}
	
	public Patient getPatient()
	{
		if(getSelectedItem() != null)
			return service.findOne(getSelectedItem().getId());
		
		return null;
	}
}
