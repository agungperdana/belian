/**
 * 
 */
package com.kratonsolution.belian.ui.education.student;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.A;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Hbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.education.dm.Student;
import com.kratonsolution.belian.education.dm.StudentRelationship;
import com.kratonsolution.belian.education.dm.StudentRepository;
import com.kratonsolution.belian.education.svc.StudentRelationshipService;
import com.kratonsolution.belian.partys.dm.Person;
import com.kratonsolution.belian.ui.component.ModelListener;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StudentBox extends Hbox implements ModelListener<Student>
{
	private Language lang = Springs.get(Language.class);
	
	private StudentRelationshipService service = Springs.get(StudentRelationshipService.class);
	
	private StudentRepository repository = Springs.get(StudentRepository.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Combobox students = new Combobox();

	private A link = new A(lang.get("navbar.menu.education.newstudent"));
	
	private Map<String,Student> maps = new HashMap<String, Student>(); 

	public StudentBox(boolean showCreateLink)
	{
		students.setAutocomplete(true);
		students.setAutodrop(true);
		students.setConstraint("no empty");
		students.setWidth("290px");
		students.setPlaceholder(lang.get("message.field.iden"));
		students.addEventListener(Events.ON_CHANGING, new Handler());
		
		setWidth("400px");

		appendChild(students);

		if(showCreateLink)
			appendChild(link);
		
		link.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				StudentFormContent content = new StudentFormContent();
				content.addListener(StudentBox.this);
				
				StudentWindow window = StudentWindow.injectInto(getPage());
				window.removeGrid();
				window.appendChild(content);
				window.doModal();
			}
		});
	}
	
	private class Handler implements EventListener<Event>
	{

		@Override
		public void onEvent(Event ev) throws Exception
		{
			if(ev instanceof InputEvent)
			{
				InputEvent iv = (InputEvent)ev;
				
				students.getChildren().clear();
				
				for(StudentRelationship rel:service.findAll(iv.getValue()))
				{
					String key = rel.getStudent().getParty().getIdentity()+" "+rel.getStudent().getParty().getName();
					students.appendItem(key);
					if(!maps.containsKey(key))
						maps.put(key, rel.getStudent());
				}
			}
		}
	}
	
	public Person getStudent()
	{
		if(Strings.isNullOrEmpty(students.getValue()) || !maps.containsKey(students.getValue()))
			throw new WrongValueException(this,lang.get("message.field.empty"));
		
		return (Person)maps.get(students.getValue()).getParty();
	}
	
	public void setStudent(Person person)
	{
		Student student = repository.findOneByPartyId(person.getId());
		if(student != null && !maps.containsKey(person.getIdentity()+" "+person.getName()))
			maps.put(person.getIdentity()+" "+person.getName(), student);
		
		students.setSelectedItem(students.appendItem(person.getIdentity()+" "+person.getName()));
	}

	@Override
	public void fireEvent(Student model)
	{
		if(model != null)
			setStudent((Person)model.getParty());
	}
}
