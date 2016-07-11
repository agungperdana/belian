/**
 * 
 */
package com.kratonsolution.belian.ui.education.studyroom;

import java.util.List;

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
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.education.dm.CourseRegistration;
import com.kratonsolution.belian.education.dm.StudyRoom;
import com.kratonsolution.belian.education.svc.CourseRegistrationService;
import com.kratonsolution.belian.education.svc.StudyDayService;
import com.kratonsolution.belian.education.svc.StudyPeriodService;
import com.kratonsolution.belian.education.svc.StudyRoomService;
import com.kratonsolution.belian.education.svc.StudyTimeService;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductFeature;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.FacilityList;
import com.kratonsolution.belian.ui.component.ModelListener;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.education.courseregistration.CourseClassBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
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
	
	private CourseRegistrationService registrationService = Springs.get(CourseRegistrationService.class);
	
	private StudyDayService dayService = Springs.get(StudyDayService.class);
	
	private StudyTimeService timeService = Springs.get(StudyTimeService.class);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private OrganizationList companys = new OrganizationList();
	
	private FacilityList rooms = new FacilityList();
	
	private Listbox periods = Components.newSelect(periodService.findAll(),false);
	
	private Listbox days = Components.newSelect(dayService.findAll(),false);
	
	private Listbox times = Components.newSelect(timeService.findAll(),false);
	
	private CourseClassBox courses = new CourseClassBox(false);
	
	private Listbox feature = Components.newSelect();
	
	private Grid items = new Grid();
	
	public StudyRoomFormContent()
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
				Flow.next(getParent(),new StudyRoomGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				
				StudyRoom day = new StudyRoom();
				
				service.add(day);
				
				Flow.next(getParent(),new StudyRoomGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		feature.addEventListener(Events.ON_SELECT, new EventListener<Event>()
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
				
				if(feature.getSelectedCount() == 0)
					throw new WrongValueException(feature,"message.field.empty");
			
				items.getRows().getChildren().clear();
				
				List<CourseRegistration> list = registrationService.findAll(courses.getProduct().getId(),
												Components.string(periods),Components.string(days),
												Components.string(times),Components.string(feature));
				
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
		items.getColumns().appendChild(new Column());
		items.getColumns().appendChild(new Column());
		items.getColumns().appendChild(new Column());
		items.getColumns().appendChild(new Column());
		
		appendChild(items);
	}

	@Override
	public void fireEvent(Product model)
	{
		feature.getItems().clear();
		
		for(ProductFeature feat:model.getFeatures())
			feature.appendItem(feat.getValue(), feat.getId());
	}
}
