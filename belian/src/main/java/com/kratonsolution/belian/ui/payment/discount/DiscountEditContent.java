/**
 * 
 */
package com.kratonsolution.belian.ui.payment.discount;

import java.math.BigDecimal;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.payment.dm.Discount;
import com.kratonsolution.belian.payment.svc.DiscountService;
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
public class DiscountEditContent extends FormContent
{	
	private DiscountService service = Springs.get(DiscountService.class);

	private Datebox start = Components.currentDatebox();

	private Datebox end = Components.datebox();

	private Textbox name = Components.mandatoryTextBox(false);

	private Doublebox value = Components.stdDoubleBox(0);
	
	private Checkbox percent = new Checkbox();

	private Row row;

	public DiscountEditContent(Row row)
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
				Flow.next(getParent(),new DiscountGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(value.getText()))
					throw new WrongValueException(value,"Value cannot be empty");
			
				Discount discount = service.findOne(RowUtils.id(row));
				if(discount != null)
				{
					discount.setStart(DateTimes.sql(start.getValue()));
					discount.setEnd(DateTimes.sql(end.getValue()));
					discount.setName(name.getText());
					discount.setValue(BigDecimal.valueOf(value.doubleValue()));
					discount.setPercent(percent.isChecked());
					
					service.add(discount);
				}
				
				Flow.next(getParent(),new DiscountGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		Discount discount = service.findOne(RowUtils.id(row));
		if(discount != null)
		{
			start.setValue(discount.getStart());
			end.setValue(discount.getEnd());
			name.setText(discount.getName());
			value.setValue(discount.getValue().doubleValue());
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
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("generic.grid.column.name")));
		row3.appendChild(name);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("generic.grid.column.amount")));
		row4.appendChild(value);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("generic.grid.column.persent")));
		row5.appendChild(percent);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}
}
