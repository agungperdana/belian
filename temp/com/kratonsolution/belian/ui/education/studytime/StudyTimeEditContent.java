/**
 * 
 */
package com.kratonsolution.belian.ui.education.studytime;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Timebox;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.education.dm.StudyTime;
import com.kratonsolution.belian.education.svc.StudyTimeService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StudyTimeEditContent extends FormContent
{	
	private StudyTimeService service = Springs.get(StudyTimeService.class);

	private Timebox start = Components.currentTimebox();
	
	private Timebox end = Components.timebox();

	private Row row;

	public StudyTimeEditContent(Row row)
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
				Flow.next(getParent(),new StudyTimeGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(start.getValue() == null)
					throw new WrongValueException(start,"start cannot be empty");
				
				if(end.getValue() == null)
					throw new WrongValueException(end,"start cannot be empty");
				
				StudyTime time = service.findOne(RowUtils.id(row));
				if(time != null)
				{				
					time.setStart(DateTimes.time(start.getValue()));
					time.setEnd(DateTimes.time(end.getValue()));
					
					service.edit(time);
				}

				Flow.next(getParent(),new StudyTimeGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		StudyTime time = service.findOne(RowUtils.id(row));
		if(time != null)
		{
			start.setValue(time.getStart());
			end.setValue(time.getEnd());
		}

		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("generic.grid.column.start")));
		row1.appendChild(start);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("generic.grid.column.end")));
		row2.appendChild(end);

		rows.appendChild(row1);
		rows.appendChild(row2);
	}
}
