/**
 * 
 */
package com.kratonsolution.belian.ui.education.student;

import java.util.Vector;

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
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.education.dm.InfoSource;
import com.kratonsolution.belian.education.dm.Student;
import com.kratonsolution.belian.education.dm.StudentRelationship;
import com.kratonsolution.belian.education.svc.StudentRelationshipService;
import com.kratonsolution.belian.general.dm.InternalOrganization;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.Listenable;
import com.kratonsolution.belian.ui.component.ModelListener;
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
public class StudentFormContent extends FormContent implements Listenable<ModelListener<Student>>
{	
	private StudentRelationshipService service = Springs.get(StudentRelationshipService.class);

	private PersonService personService = Springs.get(PersonService.class);
	
	private OrganizationList companys = new OrganizationList();
	
	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();
	
	private PersonBox person = new PersonBox(true);

	private Textbox parent = Components.mandatoryTextBox(false);

	private Textbox school = Components.mandatoryTextBox(false);
	
	private Listbox sources = Components.newSelect();
	
	private Vector<ModelListener<Student>> listeners = new Vector<>();

	public StudentFormContent()
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
				Flow.next(getParent(),new StudentGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(person.getPerson() == null)
					throw new WrongValueException(person,lang.get("message.field.empty"));
				
				if(Strings.isNullOrEmpty(school.getText()))
					throw new WrongValueException(school,lang.get("message.field.empty"));
				
				if(Strings.isNullOrEmpty(parent.getText()))
					throw new WrongValueException(parent,lang.get("message.field.empty"));
				
				Student student = new Student();
				student.setStart(DateTimes.sql(start.getValue()));
				student.setEnd(DateTimes.sql(end.getValue()));
				student.setParentName(parent.getText());
				student.setParty(person.getPerson());
				student.setSchoolName(school.getText());
				student.setSource(InfoSource.valueOf(Components.string(sources)));
				
				InternalOrganization organization = new InternalOrganization();
				organization.setStart(DateTimes.sql(start.getValue()));
				organization.setEnd(DateTimes.sql(end.getValue()));
				organization.setParty(companys.getOrganization());
				
				StudentRelationship relationship = new StudentRelationship();
				relationship.setStart(DateTimes.sql(start.getValue()));
				relationship.setEnd(DateTimes.sql(end.getValue()));
				relationship.setStudent(student);
				relationship.setOrganization(organization);

				service.add(relationship);
				
				for(ModelListener<Student> listener:listeners)
					listener.fireEvent(student);
				
				Flow.next(getParent(),new StudentGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		for(InfoSource source:InfoSource.values())
		{
			sources.appendItem(source.name(), source.name());
			sources.setSelectedIndex(0);
		}
				
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"135px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("generic.grid.column.company")));
		row1.appendChild(companys);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("generic.grid.column.start")));
		row2.appendChild(start);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("generic.grid.column.end")));
		row3.appendChild(end);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("generic.grid.column.person")));
		row4.appendChild(person);

		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("student.grid.column.parent")));
		row5.appendChild(parent);

		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("student.grid.column.school")));
		row6.appendChild(school);
		
		Row row7 = new Row();
		row7.appendChild(new Label(lang.get("student.grid.column.source")));
		row7.appendChild(sources);

		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		rows.appendChild(row7);
	}

	@Override
	public void addListener(ModelListener<Student> listener)
	{
		listeners.add(listener);
	}
}
