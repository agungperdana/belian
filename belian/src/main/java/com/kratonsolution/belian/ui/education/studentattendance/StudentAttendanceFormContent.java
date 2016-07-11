/**
 * 
 */
package com.kratonsolution.belian.ui.education.studentattendance;

import org.zkoss.zk.ui.WrongValueException;
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

import com.kratonsolution.belian.education.svc.StudentAttendanceService;
import com.kratonsolution.belian.education.svc.StudyDayService;
import com.kratonsolution.belian.education.svc.StudyPeriodService;
import com.kratonsolution.belian.education.svc.StudyTimeService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.inventory.dm.Product;
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
public class StudentAttendanceFormContent extends FormContent implements ModelListener<Product>
{	
	private StudentAttendanceService service = Springs.get(StudentAttendanceService.class);

	private PersonService personService = Springs.get(PersonService.class);
	
	private StudyPeriodService periodService = Springs.get(StudyPeriodService.class);
	
	private StudyDayService dayService = Springs.get(StudyDayService.class);
	
	private StudyTimeService timeService = Springs.get(StudyTimeService.class);
	
	private OrganizationList companys = new OrganizationList();
	
	private Datebox date = Components.currentDatebox();
	
	private CourseClassBox products = new CourseClassBox(false);
	
	private FacilityList rooms = new FacilityList();
	
	private Listbox periods = Components.newSelect(periodService.findAll(),true);

	private Listbox days = Components.newSelect(dayService.findAll(),true);
	
	private Listbox times = Components.newSelect(timeService.findAll(),true);
	
	private Grid items = new Grid();
	
	public StudentAttendanceFormContent()
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
				Flow.next(getParent(),new StudentAttendanceGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(products.getProduct() == null)
					throw new WrongValueException(products,lang.get("message.field.empty"));
				
				Flow.next(getParent(),new StudentAttendanceGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		products.addListener(StudentAttendanceFormContent.this);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"115px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("generic.grid.column.company")));
		row1.appendChild(companys);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("generic.grid.column.date")));
		row2.appendChild(date);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("studentattendance.grid.column.period")));
		row3.appendChild(periods);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("studentattendance.grid.column.day")));
		row4.appendChild(days);

		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("studentattendance.grid.column.time")));
		row5.appendChild(times);

		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("studentattendance.grid.column.class")));
		row6.appendChild(products);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
	}

	private void initItems()
	{
		grid.setWidth("100%");
		grid.appendChild(new Columns());
		grid.appendChild(new Rows());
		
	}
	
	@Override
	public void fireEvent(Product model)
	{
		// TODO Auto-generated method stub
		
	}
}
