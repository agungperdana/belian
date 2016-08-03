/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctor;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.dm.InternalOrganization;
import com.kratonsolution.belian.healtcare.dm.Doctor;
import com.kratonsolution.belian.healtcare.dm.DoctorRelationship;
import com.kratonsolution.belian.healtcare.svc.DoctorRelationshipService;
import com.kratonsolution.belian.healtcare.svc.DoctorTypeService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.component.PersonBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorFormContent extends FormContent
{	
	private DoctorRelationshipService service = Springs.get(DoctorRelationshipService.class);
	
	private DoctorTypeService doctorTypeService = Springs.get(DoctorTypeService.class);
	
	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();
	
	private OrganizationList companys = new OrganizationList();
	
	private PersonBox person = new PersonBox(true);
	
	private Listbox classifications = Components.newSelect(doctorTypeService.findAll(), true);
	
	public DoctorFormContent()
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
				Flow.next(getParent(), new DoctorGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(person.getPerson() == null)
					throw new WrongValueException(person,lang.get("message.field.empty"));
				
				DoctorRelationship relationship = new DoctorRelationship();
				relationship.setStart(DateTimes.sql(start.getValue()));
				relationship.setEnd(DateTimes.sql(end.getValue()));
				relationship.setCategory(doctorTypeService.findOne(Components.string(classifications)));
				
				Doctor doctor = new Doctor();
				doctor.setStart(DateTimes.sql(start.getValue()));
				doctor.setEnd(DateTimes.sql(end.getValue()));
				
				doctor.setParty(person.getPerson());
				
				InternalOrganization organization = new InternalOrganization();
				organization.setStart(DateTimes.sql(start.getValue()));
				organization.setEnd(DateTimes.sql(end.getValue()));
				organization.setParty(companys.getOrganization());
				
				relationship.setDoctor(doctor);
				relationship.setOrganization(organization);
				
				service.add(relationship);
				
				Flow.next(getParent(), new DoctorGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		grid.setSpan("1");
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("doctor.grid.column.start")));
		row1.appendChild(start);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("doctor.grid.column.end")));
		row2.appendChild(end);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("doctor.grid.column.company")));
		row3.appendChild(companys);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("doctor.grid.column.person")));
		row4.appendChild(person);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("doctor.grid.column.type")));
		row5.appendChild(classifications);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}
}
