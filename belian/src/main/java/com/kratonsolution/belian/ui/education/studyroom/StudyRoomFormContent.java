/**
 * 
 */
package com.kratonsolution.belian.ui.education.studyroom;

import java.util.List;
import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.education.dm.CourseRegistration;
import com.kratonsolution.belian.education.dm.CourseSchedule;
import com.kratonsolution.belian.education.dm.StudyDay;
import com.kratonsolution.belian.education.dm.StudyRoom;
import com.kratonsolution.belian.education.dm.StudyTime;
import com.kratonsolution.belian.education.svc.CourseRegistrationService;
import com.kratonsolution.belian.education.svc.StudyDayService;
import com.kratonsolution.belian.education.svc.StudyPeriodService;
import com.kratonsolution.belian.education.svc.StudyRoomService;
import com.kratonsolution.belian.education.svc.StudyTimeService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.hr.svc.EmploymentService;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductFeature;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.production.dm.WorkEffortPurpose;
import com.kratonsolution.belian.production.dm.WorkEffortType;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.FacilityList;
import com.kratonsolution.belian.ui.component.ModelListener;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.education.courseregistration.CourseClassBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StudyRoomFormContent extends FormContent implements ModelListener<Product>
{	
	private StudyRoomService service = Springs.get(StudyRoomService.class);
	
	private StudyPeriodService periodService = Springs.get(StudyPeriodService.class);
	
	private ProductService productService = Springs.get(ProductService.class);
	
	private PersonService personService = Springs.get(PersonService.class);
	
	private CourseRegistrationService registrationService = Springs.get(CourseRegistrationService.class);
	
	private EmploymentService employmentService = Springs.get(EmploymentService.class);
	
	private StudyDayService dayService = Springs.get(StudyDayService.class);
	
	private StudyTimeService timeService = Springs.get(StudyTimeService.class);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private OrganizationList companys = new OrganizationList();
	
	private FacilityList rooms = new FacilityList();
	
	private Listbox periods = Components.newSelect(periodService.findAll(),false);
	
	private Listbox days = Components.newSelect(dayService.findAll(),false);
	
	private Listbox times = Components.newSelect(timeService.findAll(),false);
	
	private CourseClassBox courses = new CourseClassBox(false);
	
	private Listbox features = Components.newSelect();
	
	private Tabbox tabbox = new Tabbox();
	
	private Grid items = new Grid();
	
	private Grid schedules = new Grid();
	
	public StudyRoomFormContent()
	{
		super();
		initToolbar();
		initForm();
		initTabbox();
		initItems();
		initSchedules();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(),new StudyRoomGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(periods.getSelectedCount() == 0)
					throw new WrongValueException(periods,"message.field.empty");
				
				if(days.getSelectedCount() == 0)
					throw new WrongValueException(days,"message.field.empty");
				
				if(times.getSelectedCount() == 0)
					throw new WrongValueException(times,"message.field.empty");
				
				if(courses.getProduct() == null)
					throw new WrongValueException(courses,"message.field.empty");
				
				if(features.getSelectedCount() == 0)
					throw new WrongValueException(features,"message.field.empty");
				
				StudyRoom room = new StudyRoom();
				room.setCourse(courses.getProduct());
				room.setDay(dayService.findOne(Components.string(days)));
				room.setName(name.getText());
				room.setOrganization(companys.getOrganization());
				room.setPeriod(periodService.findOne(Components.string(periods)));
				room.setRoom(rooms.getFacility());
				room.setTime(timeService.findOne(Components.string(times)));
				room.setStaff(utils.getEmployee());
				room.setDate(DateTimes.currentDate());
				room.setReason("Course programm for "+name.getText());
				room.setRequired(DateTimes.currentDate());

				for(ProductFeature feature:courses.getProduct().getFeatures())
				{
					if(feature.getId().equals(Components.string(features)))
					{
						room.setFeature(feature);
						break;
					}
				}
				
				if(room.getFeature() == null)
					throw new WrongValueException(features,"message.field.empty");

				Vector<CourseRegistration> students = new Vector<>();
				
				for(Component com:items.getRows().getChildren())
				{
					Row row = (Row)com;
					
					Checkbox check = (Checkbox)row.getFirstChild();
					if(check.isChecked() && check.getAttributes().containsKey("prim"))
					{
						CourseRegistration reg = registrationService.findOne(check.getAttribute("prim").toString());
						if(reg != null)
							students.add(reg);
					}
				}
				
				for(Component com:schedules.getRows().getChildren())
				{
					Row row = (Row)com;
					
					CourseSchedule schedule = new CourseSchedule();
					schedule.setDate(room.getDate());
					schedule.setDay(RowUtils.string(row, 1));
					schedule.setStart(RowUtils.time(row, 2));
					schedule.setEnd(RowUtils.time(row, 3));
					schedule.setProduct(productService.findOne(RowUtils.string(row, 4)));
					schedule.setRequirement(room);
					schedule.setPerson(personService.findOne(RowUtils.string(row, 5)));
					schedule.setPurpose(WorkEffortPurpose.Production);
					schedule.setType(WorkEffortType.Task);
					
					room.getEfforts().add(schedule);
				}
				
				if(students.isEmpty() || room.getEfforts().isEmpty())
					throw new WrongValueException("Detail cannot be empty");
				
				service.add(room,students);
				
				Flow.next(getParent(),new StudyRoomGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		features.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				if(periods.getSelectedCount() == 0)
					throw new WrongValueException(periods,"message.field.empty");
				
				if(days.getSelectedCount() == 0)
					throw new WrongValueException(days,"message.field.empty");
				
				if(times.getSelectedCount() == 0)
					throw new WrongValueException(times,"message.field.empty");
				
				if(courses.getProduct() == null)
					throw new WrongValueException(courses,"message.field.empty");
				
				if(features.getSelectedCount() == 0)
					throw new WrongValueException(features,"message.field.empty");
			
				items.getRows().getChildren().clear();
				
				List<CourseRegistration> list = registrationService.findAllNoRoom(courses.getProduct().getId(),
												Components.string(periods),Components.string(days),
												Components.string(times),Components.string(features));
				
				if(list.isEmpty())
				{
					Clients.showNotification(lang.get("studyroom.grid.column.empty"));
					return;
				}
				
				for(CourseRegistration reg:list)
				{
					Row row = new Row();

					Checkbox checkbox = new Checkbox(reg.getStudent().getName());
					checkbox.setAttribute("prim", reg.getId());
					
					row.appendChild(checkbox);					
					
					items.getRows().appendChild(row);
				}
			}
		});
		
		courses.addListener(StudyRoomFormContent.this);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("studyroom.grid.column.name")));
		row1.appendChild(name);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("studyroom.grid.column.company")));
		row2.appendChild(companys);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("studyroom.grid.column.room")));
		row3.appendChild(rooms);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("studyroom.grid.column.period")));
		row4.appendChild(periods);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("studyroom.grid.column.day")));
		row5.appendChild(days);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("studyroom.grid.column.time")));
		row6.appendChild(times);
		
		Row row7 = new Row();
		row7.appendChild(new Label(lang.get("studyroom.grid.column.course")));
		row7.appendChild(courses);
		
		Row row8 = new Row();
		row8.appendChild(new Label(lang.get("studyroom.grid.column.feature")));
		row8.appendChild(features);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		rows.appendChild(row7);
		rows.appendChild(row8);
	}
	
	private void initTabbox()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab(lang.get("studyroom.grid.column.student")));
		tabbox.getTabs().appendChild(new Tab(lang.get("studyroom.grid.column.schedule")));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		
		appendChild(tabbox);
	}
	
	private void initItems()
	{
		items.setWidth("100%");
		items.appendChild(new Columns());
		items.appendChild(new Rows());
		items.getColumns().appendChild(new Column());
		
		tabbox.getTabpanels().getFirstChild().appendChild(items);
	}
	
	private void initSchedules()
	{
		schedules.setWidth("100%");
		schedules.appendChild(new Columns());
		schedules.appendChild(new Rows());
		schedules.getColumns().appendChild(new Column(null,null,"25px"));
		schedules.getColumns().appendChild(new Column(lang.get("courseschedule.grid.column.day"),null,"90px"));
		schedules.getColumns().appendChild(new Column(lang.get("courseschedule.grid.column.start"),null,"75px"));
		schedules.getColumns().appendChild(new Column(lang.get("courseschedule.grid.column.end"),null,"75px"));
		schedules.getColumns().appendChild(new Column(lang.get("courseschedule.grid.column.program"),null,"150px"));
		schedules.getColumns().appendChild(new Column(lang.get("courseschedule.grid.column.teacher"),null,"150px"));
		schedules.setSpan("5");
		
		NRCToolbar nrc = new NRCToolbar(schedules);
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(periods.getSelectedCount() == 0)
					throw new WrongValueException(periods,"message.field.empty");
				
				if(days.getSelectedCount() == 0)
					throw new WrongValueException(days,"message.field.empty");
				
				if(times.getSelectedCount() == 0)
					throw new WrongValueException(times,"message.field.empty");
				
				if(courses.getProduct() == null)
					throw new WrongValueException(courses,"message.field.empty");
				
				if(features.getSelectedCount() == 0)
					throw new WrongValueException(features,"message.field.empty");
				
				Listbox _days = Components.fullSpanSelect();
				
				StudyDay day = dayService.findOne(Components.string(days));
				if(day != null)
				{
					if(day.isMonday())
						_days.appendItem(lang.get("generic.grid.column.monday"), lang.get("generic.grid.column.monday"));
					
					if(day.isTuesday())
						_days.appendItem(lang.get("generic.grid.column.tuesday"), lang.get("generic.grid.column.tuesday"));
					
					if(day.isWednesday())
						_days.appendItem(lang.get("generic.grid.column.wednesday"), lang.get("generic.grid.column.wednesday"));
					
					if(day.isThursday())
						_days.appendItem(lang.get("generic.grid.column.thursday"), lang.get("generic.grid.column.thursday"));
					
					if(day.isFriday())
						_days.appendItem(lang.get("generic.grid.column.friday"), lang.get("generic.grid.column.friday"));
					
					if(day.isSaturday())
						_days.appendItem(lang.get("generic.grid.column.saturday"), lang.get("generic.grid.column.saturday"));
				}

				StudyTime _time = timeService.findOne(Components.string(times));
				Product _course = courses.getProduct();
				
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(_days);
				row.appendChild(_time!=null?Components.fullspanTimebox(_time.getStart()):Components.fullspanTimebox(null));
				row.appendChild(_time!=null?Components.fullspanTimebox(_time.getEnd()):Components.fullspanTimebox(null));
				row.appendChild(Components.fullSpanSelect(_course.getComponents(), true));
				row.appendChild(Components.fullSpanSelect(employmentService.findAll(), true));
			
				schedules.getRows().appendChild(row);
			}
		});
		
		tabbox.getTabpanels().getLastChild().appendChild(nrc);
		tabbox.getTabpanels().getLastChild().appendChild(schedules);
	}

	@Override
	public void fireEvent(Product model)
	{
		features.getItems().clear();
		
		for(ProductFeature feat:model.getFeatures())
			features.appendItem(feat.getValue(), feat.getId());
	}
}
