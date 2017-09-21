package com.kratonsolution.belian.ui.healthcares.clinic.patient;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.healtcares.dm.PatientProviderRelationship;
import com.kratonsolution.belian.healtcares.svc.PatientProviderRelationshipService;
import com.kratonsolution.belian.partys.dm.Person;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.general.party.GenderList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PatientEditContent extends AbstractForm
{	
	private PatientProviderRelationshipService service = Springs.get(PatientProviderRelationshipService.class);

	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();
	
	private Datebox birthDate = Components.datebox();

	private Textbox code = Components.stdTextBox(null,false);
	
	private Textbox name = Components.stdTextBox(null,false);
	
	private GenderList gender = new GenderList(false);

	private Row row;

	public PatientEditContent(Row row)
	{
		super();
		this.row = row;
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
				Flow.next(getParent(), new PatientGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PatientProviderRelationship out = service.findOne(RowUtils.id(row));
				if(out != null)
				{
					out.setStart(DateTimes.sql(start.getValue()));
					out.setEnd(DateTimes.sql(end.getValue()));
					out.getFromParty().setCode(code.getText());
					out.getFromParty().setName(name.getText());
					out.getFromParty().setBirthDate(DateTimes.sql(birthDate.getValue()));
					((Person)out.getFromParty()).setGender(gender.getGender());
					
					service.edit(out);
				}
				
				Flow.next(getParent(), new PatientGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		PatientProviderRelationship on = service.findOne(RowUtils.id(row));
		if(on != null)
		{
			start.setValue(on.getStart());
			end.setValue(on.getEnd());
			code.setText(on.getFromParty().getCode());
			name.setText(on.getFromParty().getName());
			birthDate.setValue(on.getFromParty().getBirthDate());
			gender.setGender(((Person)on.getFromParty()).getGender());
		}
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("clinic.patient.grid.column.start")));
		row1.appendChild(start);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("clinic.patient.grid.column.end")));
		row2.appendChild(end);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("clinic.patient.grid.column.code")));
		row3.appendChild(code);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("clinic.patient.grid.column.name")));
		row4.appendChild(name);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("clinic.patient.grid.column.birthdate")));
		row5.appendChild(birthDate);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("clinic.patient.grid.column.gender")));
		row6.appendChild(gender);

		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
	}
}
