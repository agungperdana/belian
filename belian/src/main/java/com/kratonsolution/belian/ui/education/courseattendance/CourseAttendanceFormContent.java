/**
 * 
 */
package com.kratonsolution.belian.ui.education.courseattendance;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.education.dm.AttendanceStatus;
import com.kratonsolution.belian.education.dm.CourseRegistration;
import com.kratonsolution.belian.education.dm.CourseSchedule;
import com.kratonsolution.belian.education.dm.StudyRoom;
import com.kratonsolution.belian.education.svc.CourseAttendanceService;
import com.kratonsolution.belian.education.svc.CourseScheduleService;
import com.kratonsolution.belian.education.svc.StudyPeriodService;
import com.kratonsolution.belian.education.svc.StudyRoomService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CourseAttendanceFormContent extends FormContent
{	
	private CourseAttendanceService service = Springs.get(CourseAttendanceService.class);

	private StudyRoomService roomService = Springs.get(StudyRoomService.class);
	
	private StudyPeriodService periodService = Springs.get(StudyPeriodService.class);
	
	private CourseScheduleService scheduleService = Springs.get(CourseScheduleService.class);
	
	private OrganizationList companys = new OrganizationList();
	
	private Datebox date = Components.currentDatebox();
	
	private Listbox periods = Components.newSelect(periodService.findAll(),false);
	
	private Listbox schedules = Components.newSelect("350px");
	
	private Listbox programs = Components.newSelect();
	
	private Grid items = new Grid();
	
	public CourseAttendanceFormContent()
	{
		super();
		initToolbar();
		initForm();
		initItems();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(),new CourseAttendanceGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(),new CourseAttendanceGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		periods.addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				programs.getChildren().clear();
			
				for(StudyRoom room:roomService.findAll(Components.string(periods)))
					programs.appendItem(room.getName(), room.getId());
			}
		});
		
		programs.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				schedules.getItems().clear();
				
				StudyRoom room = roomService.findOne(Components.string(programs));
				if(room != null)
				{
					for(CourseSchedule schedule:room.getSchedules())
					{
						StringBuilder builder = new StringBuilder();
						builder.append("["+DateTimes.format(schedule.getStart())+"-"+DateTimes.format(schedule.getEnd())+"] ");
						builder.append(schedule.getDay()+"-");
						builder.append(schedule.getProduct().getName()+"-");
						builder.append(schedule.getTeacher().getName());

						schedules.appendItem(builder.toString(), schedule.getId());
					}
				}
			}
		});
		
		schedules.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				StudyRoom room = roomService.findOne(Components.string(programs));
				if(room != null)
					initItemRows(room);
			}
		});
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"115px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("courseattendance.grid.column.company")));
		row1.appendChild(companys);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("courseattendance.grid.column.date")));
		row2.appendChild(date);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("courseattendance.grid.column.period")));
		row3.appendChild(periods);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("courseattendance.grid.column.class")));
		row4.appendChild(programs);

		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("courseattendance.grid.column.schedule")));
		row5.appendChild(schedules);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}

	private void initItems()
	{
		items.setWidth("100%");
		items.appendChild(new Columns());
		items.appendChild(new Rows());
		items.getColumns().appendChild(new Column(lang.get("generic.grid.column.person"),null,"225px"));
		items.getColumns().appendChild(new Column(lang.get("generic.grid.column.status"),null,"100px"));
	
		appendChild(items);
	}
	
	private void initItemRows(StudyRoom room)
	{
		items.getRows().getChildren().clear();

		if(schedules.getSelectedCount() != 0)
		{
			CourseSchedule schedule = scheduleService.findOne(Components.string(schedules));
			if(schedule != null)
			{
				Row row = new Row();
				row.appendChild(new Label(schedule.getTeacher().getName()+" [Mentor]"));
				
				Listbox _listbox = Components.fullSpanSelect();
				for(AttendanceStatus status:AttendanceStatus.values())
					_listbox.setSelectedItem(_listbox.appendItem(status.display(utils.getLanguage()), status.display(utils.getLanguage())));
				
				row.appendChild(_listbox);
				
				items.getRows().appendChild(row);
				items.getRows().appendChild(new Row());
			}
		}

		for(CourseRegistration registered:room.getRegistrations())
		{
			Row row = new Row();
			row.appendChild(new Label(registered.getStudent().getName()));
			
			Listbox listbox = Components.fullSpanSelect();
			for(AttendanceStatus status:AttendanceStatus.values())
				listbox.setSelectedItem(listbox.appendItem(status.display(utils.getLanguage()), status.display(utils.getLanguage())));
			
			row.appendChild(listbox);
			items.getRows().appendChild(row);
		}
	}
}
