/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.patient;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Cell;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.dm.InternalOrganization;
import com.kratonsolution.belian.healtcare.dm.BPJS;
import com.kratonsolution.belian.healtcare.dm.Patient;
import com.kratonsolution.belian.healtcare.dm.PatientRelationship;
import com.kratonsolution.belian.healtcare.svc.PatientService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.CompanyList;
import com.kratonsolution.belian.ui.component.PersonBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PatientFormContent extends FormContent
{	
	private PatientService service = Springs.get(PatientService.class);

	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();
	
	private PersonBox person = new PersonBox(true);
	
	private Textbox bpjsNumber = new Textbox();
	
	private CompanyList companys = new CompanyList();
	
	private Checkbox bpjsStatus = new Checkbox(lang.get("generic.grid.column.active"));
	
	public PatientFormContent()
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
				Flow.next(getParent(), new PatientGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(person.getPerson() == null)
					throw new WrongValueException(person,lang.get("message.field.empty"));
				
				BPJS bpjs = new BPJS();
				bpjs.setActive(bpjsStatus.isChecked());
				bpjs.setCard(bpjsNumber.getText());
				
				Patient patient = new Patient();
				patient.setStart(DateTimes.sql(start.getValue()));
				patient.setParty(person.getPerson());
				patient.setBpjs(bpjs);
				
				InternalOrganization organization = new InternalOrganization();
				organization.setParty(utils.getOrganization());
				organization.setStart(DateTimes.sql(start.getValue()));
				
				PatientRelationship relationship = new PatientRelationship();
				relationship.setStart(DateTimes.sql(start.getValue()));
				relationship.setEnd(DateTimes.sql(end.getValue()));
				relationship.setPatient(patient);
				relationship.setOrganization(organization);
				
				service.add(relationship);
				
				Flow.next(getParent(), new PatientGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("patient.grid.column.start")));
		row1.appendChild(start);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("patient.grid.column.end")));
		row2.appendChild(end);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("patient.grid.column.company")));
		row3.appendChild(companys);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("patient.grid.column.person")));
		row4.appendChild(person);
		
		Cell cell = new Cell();
		cell.appendChild(new Label(lang.get("patient.grid.column.bpjsinfo")));
		cell.setColspan(2);
		
		Row row5 = new Row();
		row5.appendChild(cell);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("patient.grid.column.card")));
		row6.appendChild(bpjsNumber);
		
		Row row7 = new Row();
		row7.appendChild(new Label(lang.get("patient.grid.column.status")));
		row7.appendChild(bpjsStatus);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		rows.appendChild(row7);
	}
}
