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

import com.kratonsolution.belian.education.dm.StudyPeriod;
import com.kratonsolution.belian.education.svc.StudyPeriodService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StudyPeriodFormContent extends FormContent
{	
	private StudyPeriodService service = Springs.get(StudyPeriodService.class);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private Textbox note = Components.stdTextBox(null,false);
	
	public StudyPeriodFormContent()
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
				Flow.next(getParent(),new StudyPeriodGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(name.getValue() == null)
					throw new WrongValueException(name,"Name cannot be empty");
			
				StudyPeriod time = new StudyPeriod();
				time.setName(name.getText());
				time.setNote(note.getText());
				
				service.add(time);
				
				Flow.next(getParent(),new StudyPeriodGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
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
