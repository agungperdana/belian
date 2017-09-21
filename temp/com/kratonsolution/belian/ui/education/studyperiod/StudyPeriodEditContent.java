/**
 * 
 */
package com.kratonsolution.belian.ui.education.studyperiod;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.education.dm.StudyPeriod;
import com.kratonsolution.belian.education.svc.StudyPeriodService;
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
public class StudyPeriodEditContent extends FormContent
{	
	private StudyPeriodService service = Springs.get(StudyPeriodService.class);

private Textbox name = Components.mandatoryTextBox(false);
	
	private Textbox note = Components.stdTextBox(null,false);

	private Row row;

	public StudyPeriodEditContent(Row row)
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
				Flow.next(getParent(),new StudyPeriodGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,"Name cannot be empty");
				
				StudyPeriod period = service.findOne(RowUtils.id(row));
				if(period != null)
				{				
					period.setName(name.getText());
					period.setNote(note.getText());
					
					service.edit(period);
				}

				Flow.next(getParent(),new StudyPeriodGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		StudyPeriod period = service.findOne(RowUtils.id(row));
		if(period != null)
		{
			name.setText(period.getName());
			note.setText(period.getNote());
		}

		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("generic.grid.column.name")));
		row1.appendChild(name);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("generic.grid.column.note")));
		row2.appendChild(note);

		rows.appendChild(row1);
		rows.appendChild(row2);
	}
}
