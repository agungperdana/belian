/**
 * 
 */
package com.kratonsolution.belian.ui.education.studyroom;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;

import com.kratonsolution.belian.education.dm.StudyDay;
import com.kratonsolution.belian.education.svc.StudyDayService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StudyRoomFormContent extends FormContent
{	
	private StudyDayService service = Springs.get(StudyDayService.class);
	
	private Checkbox monday = new Checkbox();
	
	private Checkbox tuesday = new Checkbox();
	
	private Checkbox wednesday = new Checkbox();
	
	private Checkbox thursday = new Checkbox();
	
	private Checkbox friday = new Checkbox();
	
	private Checkbox saturday = new Checkbox();
	
	public StudyRoomFormContent()
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
				Flow.next(getParent(),new StudyRoomGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				
				StudyDay day = new StudyDay();
				day.setMonday(monday.isChecked());
				day.setTuesday(tuesday.isChecked());
				day.setWednesday(wednesday.isChecked());
				day.setThursday(thursday.isChecked());
				day.setFriday(friday.isChecked());
				day.setSaturday(saturday.isChecked());
				
				service.add(day);
				
				Flow.next(getParent(),new StudyRoomGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("generic.grid.column.monday")));
		row1.appendChild(monday);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("generic.grid.column.tuesday")));
		row2.appendChild(tuesday);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("generic.grid.column.wednesday")));
		row3.appendChild(wednesday);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("generic.grid.column.thursday")));
		row4.appendChild(thursday);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("generic.grid.column.friday")));
		row5.appendChild(friday);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("generic.grid.column.saturday")));
		row6.appendChild(saturday);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
	}
}
