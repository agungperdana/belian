/**
 * 
 */
package com.kratonsolution.belian.ui.education.courseattendance;

import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.education.dm.AttendanceStatus;
import com.kratonsolution.belian.education.dm.CourseAttendance;
import com.kratonsolution.belian.education.dm.CourseAttendanceItem;
import com.kratonsolution.belian.education.svc.CourseAttendanceService;
import com.kratonsolution.belian.education.svc.CourseScheduleService;
import com.kratonsolution.belian.education.svc.StudyPeriodService;
import com.kratonsolution.belian.education.svc.StudyRoomService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CourseAttendanceEditContent extends FormContent
{	
	private CourseAttendanceService service = Springs.get(CourseAttendanceService.class);

	private StudyRoomService roomService = Springs.get(StudyRoomService.class);
	
	private StudyPeriodService periodService = Springs.get(StudyPeriodService.class);
	
	private CourseScheduleService scheduleService = Springs.get(CourseScheduleService.class);
	
	private PersonService personService = Springs.get(PersonService.class);
	
	private OrganizationList companys = new OrganizationList();
	
	private Datebox date = Components.currentDatebox();
	
	private Listbox periods = Components.newSelect(periodService.findAll(),false);
	
	private Listbox schedules = Components.newSelect("350px");
	
	private Listbox programs = Components.newSelect();
	
	private Grid items = new Grid();

	private Row row;

	public CourseAttendanceEditContent(Row row)
	{
		super();
		this.row = row;
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
				CourseAttendance attendance = service.findOne(RowUtils.id(row));
				if(attendance != null)
				{
					Vector<CourseAttendanceItem> vector = new Vector<>();
					for(Component com:items.getRows().getChildren())
					{
						Row row = (Row)com;
						
						CourseAttendanceItem item = new CourseAttendanceItem();
						item.setId(RowUtils.id(row));
						item.setAttendance(attendance);
						item.setPerson(personService.findOne(RowUtils.string(row,0)));
						item.setStatus(AttendanceStatus.valueOf(RowUtils.string(row, 1)));
						
						vector.add(item);
					}
					
					service.edit(attendance,vector);
				}

				Flow.next(getParent(),new CourseAttendanceGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		CourseAttendance attendance = service.findOne(RowUtils.id(row));
		if(attendance != null)
		{
			companys.setOrganization(attendance.getOrganization());
			date.setValue(attendance.getDate());
			periods.setSelectedItem(periods.appendItem(attendance.getSchedule().getRequirement().getPeriod().getLabel(),attendance.getSchedule().getRequirement().getPeriod().getValue()));
			programs.setSelectedItem(programs.appendItem(attendance.getSchedule().getRequirement().getName(), attendance.getSchedule().getRequirement().getId()));

			StringBuilder builder = new StringBuilder();
			builder.append("["+DateTimes.format(attendance.getSchedule().getStart())+"-"+DateTimes.format(attendance.getSchedule().getEnd())+"] ");
			builder.append(attendance.getSchedule().getDay()+"-");
			builder.append(attendance.getSchedule().getProduct().getName()+"-");
			builder.append(attendance.getSchedule().getWorker().getName());
			
			schedules.setSelectedItem(schedules.appendItem(builder.toString(), attendance.getSchedule().getId()));
		}
		
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
		items.setSpan("0");
		items.getColumns().appendChild(new Column());
		items.getColumns().getLastChild().setVisible(false);
	
		CourseAttendance attendance = service.findOne(RowUtils.id(row));
		if(attendance != null)
		{
			for(CourseAttendanceItem item:attendance.getItems())
			{
				if(item.getAttendance().getSchedule().getWorker().getId().equals(item.getPerson().getId()))
				{
					Row row = new Row();
					
					Listbox person = Components.fullSpanSelect();
					person.setSelectedItem(person.appendItem(item.getPerson().getName()+" [Mentor]",item.getPerson().getId()));
					person.setStyle("font-weight:bold;color:blue;");
					
					row.appendChild(person);
					
					Listbox listbox = Components.fullSpanSelect();
					for(AttendanceStatus status:AttendanceStatus.values())
					{
						Listitem listitem = listbox.appendItem(status.display(utils.getLanguage()), status.display(utils.getLanguage()));
						if(status.equals(item.getStatus()))
							listbox.setSelectedItem(listitem);
					}
					
					row.appendChild(listbox);
					row.appendChild(Components.label(item.getId()));
					
					items.getRows().appendChild(row);
					break;
				}
			}
			
			for(CourseAttendanceItem item:attendance.getItems())
			{
				if(!item.getAttendance().getSchedule().getWorker().getId().equals(item.getPerson().getId()))
				{
					Row row = new Row();
					
					Listbox person = Components.fullSpanSelect();
					person.setSelectedItem(person.appendItem(item.getPerson().getName(),item.getPerson().getId()));
					
					row.appendChild(person);
					
					Listbox listbox = Components.fullSpanSelect();
					for(AttendanceStatus status:AttendanceStatus.values())
					{
						Listitem listitem = listbox.appendItem(status.display(utils.getLanguage()), status.display(utils.getLanguage()));
						if(status.equals(item.getStatus()))
							listbox.setSelectedItem(listitem);
					}
					
					row.appendChild(listbox);
					row.appendChild(Components.label(item.getId()));
					
					items.getRows().appendChild(row);
				}
			}
		}
		
		appendChild(items);
	}
}
