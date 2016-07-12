/**
 * 
 */
package com.kratonsolution.belian.ui.education.studyroom;

import java.util.List;

import org.zkoss.zk.ui.Component;
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
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.education.dm.CourseRegistration;
import com.kratonsolution.belian.education.dm.StudyRoom;
import com.kratonsolution.belian.education.svc.CourseRegistrationService;
import com.kratonsolution.belian.education.svc.StudyDayService;
import com.kratonsolution.belian.education.svc.StudyPeriodService;
import com.kratonsolution.belian.education.svc.StudyRoomService;
import com.kratonsolution.belian.education.svc.StudyTimeService;
import com.kratonsolution.belian.ui.FormContent;
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

	private StudyDayService dayService = Springs.get(StudyDayService.class);

	private StudyTimeService timeService = Springs.get(StudyTimeService.class);

	private Textbox name = Components.mandatoryTextBox(false);

	private OrganizationList companys = new OrganizationList();

	private FacilityList rooms = new FacilityList();

	private Listbox periods = Components.newSelect();

	private Listbox days = Components.newSelect();

	private Listbox times = Components.newSelect();

	private CourseClassBox courses = new CourseClassBox(false);

	private Listbox feature = Components.newSelect();

	private Grid items = new Grid();

	private Row row;

	public StudyRoomEditContent(Row row)
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
					
					if(!room.getRegistrations().isEmpty())
						service.add(room);
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
			name.setText(room.getName());
			companys.setOrganization(room.getOrganization());
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
		
		appendChild(items);
		
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
}
