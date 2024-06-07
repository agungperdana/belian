
package com.kratonsolution.belian.ui.healthcares.clinic.practitioner;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.healtcares.svc.PractitionerProviderRelationshipService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.general.party.GenderList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PractitionerFormContent extends AbstractForm
{	
	private PractitionerProviderRelationshipService service = Springs.get(PractitionerProviderRelationshipService.class);

	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();
	
	private Datebox birthDate = Components.datebox();

	private Textbox code = Components.stdTextBox(null,false);
	
	private Textbox name = Components.stdTextBox(null,false);
	
	private GenderList gender = new GenderList(false);
	
	public PractitionerFormContent()
	{
		super();
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
				Flow.next(getParent(), new PractitionerGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(organizations.getDomain() == null)
					throw new WrongValueException(organizations,lang.get("message.field.empty"));
				
				if(start.getValue() == null)
					throw new WrongValueException(start,lang.get("message.field.empty"));
				
				if(Strings.isNullOrEmpty(code.getText()))
					throw new WrongValueException(code,lang.get("message.field.empty"));
				
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,lang.get("message.field.empty"));
				
				if(birthDate.getValue() == null)
					throw new WrongValueException(birthDate,lang.get("message.field.empty"));
				
				if(gender.getGender() == null)
					throw new WrongValueException(gender,lang.get("message.field.empty"));
				
				if(service.isExist(code.getText(), name.getText()))
					throw new WrongValueException(name,lang.get("message.field.exist"));
				
				service.add(DateTimes.sql(start.getValue()),code.getText(),name.getText(),DateTimes.sql(birthDate.getValue()),gender.getGender());
				
				Flow.next(getParent(), new PractitionerGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("clinic.practitioner.grid.column.start")));
		row1.appendChild(start);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("clinic.practitioner.grid.column.end")));
		row2.appendChild(end);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("clinic.practitioner.grid.column.code")));
		row3.appendChild(code);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("clinic.practitioner.grid.column.name")));
		row4.appendChild(name);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("clinic.practitioner.grid.column.birthdate")));
		row5.appendChild(birthDate);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("clinic.practitioner.grid.column.gender")));
		row6.appendChild(gender);

		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
	}
}
