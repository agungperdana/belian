/**
 * 
 */
package com.kratonsolution.belian.ui.hr.positiontype;

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
import com.kratonsolution.belian.hr.dm.PositionType;
import com.kratonsolution.belian.hr.svc.PositionTypeService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class PositionTypeEditContent extends FormContent
{	
	private final PositionTypeService service = Springs.get(PositionTypeService.class);
	
	private Textbox title = new Textbox();
	
	private Textbox description = new Textbox();
	
	private Row row;
	
	public PositionTypeEditContent(Row row)
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
				PositionTypeWindow window = (PositionTypeWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(title.getText()))
					throw new WrongValueException(title,"Title cannot be empty");
			
				if(Strings.isNullOrEmpty(description.getText()))
					throw new WrongValueException(description,"Description cannot be empty");
				
				PositionType type = service.findOne(RowUtils.string(row, 3));
				type.setTitle(title.getText());
				type.setDescription(description.getText());
				
				service.edit(type);
				
				PositionTypeWindow window = (PositionTypeWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		title.setConstraint("no empty");
		title.setText(RowUtils.string(this.row,1));
		title.setWidth("300px");
		
		description.setConstraint("no empty");
		description.setWidth("300px");
		description.setText(RowUtils.string(row, 2));

		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Title"));
		row1.appendChild(title);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Description"));
		row2.appendChild(description);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
	}
}
