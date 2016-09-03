/**
 * 
 */
package com.kratonsolution.belian.ui.education.student;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.education.dm.InfoSource;
import com.kratonsolution.belian.education.dm.StudentGrade;
import com.kratonsolution.belian.education.dm.StudentRelationship;
import com.kratonsolution.belian.education.svc.StudentRelationshipService;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.component.PersonBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StudentEditContent extends FormContent
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
	
	private Listbox grades = Components.newSelect();

	private Row row;

	public StudentEditContent(Row row)
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
				Flow.next(getParent(),new StudentGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				StudentRelationship relationship = service.findOne(RowUtils.id(row));
				if(relationship != null)
				{
					if(Strings.isNullOrEmpty(school.getText()))
						throw new WrongValueException(school,lang.get("message.field.empty"));

					if(Strings.isNullOrEmpty(parent.getText()))
						throw new WrongValueException(parent,lang.get("message.field.empty"));

					relationship.setEnd(DateTimes.sql(end.getValue()));
					relationship.getStudent().setParentName(parent.getText());
					relationship.getStudent().setSchoolName(school.getText());
					relationship.getStudent().setSource(InfoSource.valueOf(Components.string(sources)));
					relationship.getStudent().setGrade(StudentGrade.valueOf(Components.string(grades)));
					
					service.add(relationship);
				}

				Flow.next(getParent(),new StudentGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		for(InfoSource source:InfoSource.values())
			sources.appendItem(source.name(), source.name());
		
		for(StudentGrade grade:StudentGrade.values())
			grades.setSelectedItem(grades.appendItem(grade.display(utils.getLanguage()), grade.name()));
		
		StudentRelationship relationship = service.findOne(RowUtils.id(row));
		if(relationship != null)
		{
			start.setValue(relationship.getStart());
			end.setValue(relationship.getEnd());
			person.setPerson((Person)relationship.getStudent().getParty());
			parent.setText(relationship.getStudent().getParentName());
			school.setText(relationship.getStudent().getSchoolName());
			
			for(Listitem src:sources.getItems())
			{
				if(relationship.getStudent().getSource().name().equals(src.getValue().toString()))
				{
					sources.setSelectedItem(src);
					break;
				}
			}
			
			for(Listitem grd:grades.getItems())
			{
				if(relationship.getStudent().getGrade().name().equals(grd.getValue().toString()))
				{
					grades.setSelectedItem(grd);
					break;
				}
			}
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
		row7.appendChild(new Label(lang.get("student.grid.column.grade")));
		row7.appendChild(grades);
		
		Row row8 = new Row();
		row8.appendChild(new Label(lang.get("student.grid.column.source")));
		row8.appendChild(sources);

		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		rows.appendChild(row7);
		rows.appendChild(row8);
	}
}
