/**
 * 
 */
package com.kratonsolution.belian.ui.budgettype;

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
import com.kratonsolution.belian.accounting.dm.BudgetType;
import com.kratonsolution.belian.accounting.svc.BudgetTypeService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class BudgetTypeEditContent extends FormContent
{	
	private final BudgetTypeService service = Springs.get(BudgetTypeService.class);
	
	private Textbox name = new Textbox();
	
	private Textbox description = new Textbox();
	
	private Row row;
	
	public BudgetTypeEditContent(Row row)
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
				BudgetTypeWindow window = (BudgetTypeWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,"Name cannot be empty");
			
				BudgetType budgetType = service.findOne(RowUtils.string(row, 3));
				if(budgetType != null)
				{
					budgetType.setName(name.getText());
					budgetType.setDescription(description.getText());
					
					service.edit(budgetType);
				}
				
				BudgetTypeWindow window = (BudgetTypeWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		name.setConstraint("no empty");
		name.setText(RowUtils.string(row, 1));
		name.setWidth("300px");
		
		description.setText(RowUtils.string(row,2));
		description.setWidth("300px");
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row2 = new Row();
		row2.appendChild(new Label("Name"));
		row2.appendChild(name);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Description"));
		row3.appendChild(description);
		
		rows.appendChild(row2);
		rows.appendChild(row3);
	}
}
