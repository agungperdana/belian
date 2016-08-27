/**
 * 
 */
package com.kratonsolution.belian.ui.education.studyroom;

import java.util.List;
import java.util.UUID;
import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
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
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.FacilityList;
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
public class StudyRoomEditContent extends FormContent
{	
	private StudyRoomService service = Springs.get(StudyRoomService.class);

	private StudyPeriodService periodService = Springs.get(StudyPeriodService.class);

	private CourseRegistrationService registrationService = Springs.get(CourseRegistrationService.class);

	private EmploymentService employmentService = Springs.get(EmploymentService.class);
	
	private PersonService personService = Springs.get(PersonService.class);
	
	private StudyDayService dayService = Springs.get(StudyDayService.class);

	private StudyTimeService timeService = Springs.get(StudyTimeService.class);

	private ProductService productService = Springs.get(ProductService.class);
	
	private Textbox name = Components.mandatoryTextBox(false);

	private OrganizationList companys = new OrganizationList();

	private FacilityList rooms = new FacilityList();

	private Listbox periods = Components.newSelect();

	private Listbox days = Components.newSelect();

	private Listbox times = Components.newSelect();

	private CourseClassBox courses = new CourseClassBox(false);

	private Listbox feature = Components.newSelect();

	private Tabbox tabbox = new Tabbox();

	private Grid items = new Grid();

	private Grid schedules = new Grid();

	private Row row;

	public StudyRoomEditContent(Row row)
	{
		super();
		this.row = row;
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
				StudyRoom room = service.findOne(RowUtils.id(row));
				if(room != null)
				{
					for(Component com:items.getRows().getChildren())
					{
						Row row = (Row)com;

						Checkbox check = (Checkbox)row.getFirstChild();
						if(check.getAttributes().containsKey("prim"))
						{
							CourseRegistration reg = registrationService.findOne(check.getAttribute("prim").toString());
							if(reg != null)
							{
								if(check.isChecked())
								{
									reg.setRoom(room);
									room.getRegistrations().add(reg);
								}
								else
								{
									reg.setRoom(null);
									room.getRegistrations().add(reg);
								}
							}
						}
					}

					Vector<CourseSchedule> scd = new Vector<>();
					for(Component com:schedules.getRows().getChildren())
					{
						Row row = (Row)com;
						
						CourseSchedule crs = new CourseSchedule();
						crs.setId(RowUtils.id(row));
						crs.setDay(RowUtils.string(row, 1));
//						crs.setStart(RowUtils.time(row, 2));
//						crs.setEnd(RowUtils.time(row, 3));
						crs.setProduct(productService.findOne(RowUtils.string(row, 4)));
						crs.setRequirement(room);
//						crs.setWorker(personService.findOne(RowUtils.string(row, 5)));
						
						scd.add(crs);
					}
					
					if(!room.getRegistrations().isEmpty())
						service.edit(room,scd);
				}

				Flow.next(getParent(),new StudyRoomGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		StudyRoom room = service.findOne(RowUtils.id(row));
		if(room != null)
		{
//			name.setText(room.getName());
//			companys.setOrganization(room.getOrganization());
			rooms.appendItem(room.getRoom().getLabel(), room.getRoom().getValue());
			rooms.setSelectedIndex(0);
			periods.appendItem(room.getPeriod().getLabel(), room.getPeriod().getValue());
			periods.setSelectedIndex(0);
			days.appendItem(room.getDay().getLabel(), room.getDay().getValue());
			days.setSelectedIndex(0);
			times.appendItem(room.getTime().getLabel(), room.getTime().getValue());
			times.setSelectedIndex(0);
			courses.setProduct(room.getCourse());
			feature.appendItem(room.getFeature().getValue(), room.getFeature().getId());
			feature.setSelectedIndex(0);
		}

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
		row8.appendChild(feature);

		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		rows.appendChild(row7);
		rows.appendChild(row8);
	}

	private void initItems()
	{
		items.setWidth("100%");
		items.appendChild(new Columns());
		items.appendChild(new Rows());
		items.getColumns().appendChild(new Column());

		tabbox.getTabpanels().getFirstChild().appendChild(items);

		StudyRoom room = service.findOne(RowUtils.id(row));
		if(room != null)
		{
			for(CourseRegistration reg:room.getRegistrations())
			{
				Row row = new Row();

				Checkbox checkbox = new Checkbox(reg.getStudent().getName());
				checkbox.setAttribute("prim", reg.getId());
				checkbox.setChecked(true);

				row.appendChild(checkbox);					

				items.getRows().appendChild(row);
			}
		}

		List<CourseRegistration> list = registrationService.findAllNoRoom(courses.getProduct().getId(),
				Components.string(periods),Components.string(days),
				Components.string(times),Components.string(feature));
		
		for(CourseRegistration reg:list)
		{
			Row row = new Row();

			Checkbox checkbox = new Checkbox(reg.getStudent().getName());
			checkbox.setAttribute("prim", reg.getId());

			row.appendChild(checkbox);					

			items.getRows().appendChild(row);
		}
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
		schedules.getColumns().appendChild(new Column());
		schedules.getColumns().getLastChild().setVisible(false);
		schedules.setSpan("5");
		
		StudyRoom rm = service.findOne(RowUtils.id(row));
		if(rm != null)
		{
			for(CourseSchedule schedule:rm.getEfforts())
			{
				Listbox listbox = Components.fullSpanSelect();
				listbox.setSelectedItem(listbox.appendItem(schedule.getDay(),schedule.getDay()));
				
				CourseClassBox box = new CourseClassBox(false);
				box.setProduct(schedule.getProduct());
				
				Row row = new Row();
				row.appendChild(schedule.getAttendances().isEmpty()?Components.checkbox(false):Components.readOnlyCheckbox());
				row.appendChild(listbox);
//				row.appendChild(Components.fullspanTimebox(schedule.getStart()));
//				row.appendChild(Components.fullspanTimebox(schedule.getEnd()));
				row.appendChild(Components.fullSpanSelect(rm.getCourse().getComponents(),schedule.getProduct()));
//				row.appendChild(Components.fullSpanSelect(schedule.getWorker()));
				row.appendChild(Components.label(schedule.getId()));
			
				schedules.getRows().appendChild(row);
			}
		}
		
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
				
				if(feature.getSelectedCount() == 0)
					throw new WrongValueException(feature,"message.field.empty");
				
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
				row.appendChild(Components.label(UUID.randomUUID().toString()));
			
				schedules.getRows().appendChild(row);
			}
		});
		
		tabbox.getTabpanels().getLastChild().appendChild(nrc);
		tabbox.getTabpanels().getLastChild().appendChild(schedules);
	}
}
