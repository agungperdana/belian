/**
 * 
 */
package com.kratonsolution.belian.ui.orders.pos;

import java.math.BigDecimal;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Button;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class POSPayment extends Window
{
	private Language lang = Springs.get(Language.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Listbox method = Components.fullSpanSelect();
	
	private Textbox cardNumber = new Textbox();
	
	private Decimalbox nominal = Components.fullspanReadonlyDecimalbox(BigDecimal.ZERO);

	private Decimalbox paid = Components.fullspanDecimalbox(BigDecimal.ZERO);

	private Decimalbox change = Components.fullspanReadonlyDecimalbox(BigDecimal.ZERO);
	
	private Button ok = new Button(lang.get("label.component.generic.pay"));
	
	public POSPayment(BigDecimal amount,boolean isdropship)
	{
		setHeight("210px");
		setWidth("400px");
		setPosition("center");
		setMaximizable(false);
		setMinimizable(false);
		setClosable(false);
		
		Grid grid = new Grid();
		grid.setHflex("1");
		grid.setVflex("1");
		grid.appendChild(new Columns());
		grid.appendChild(new Rows());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		grid.setSpan("1");
		
		nominal.setValue(amount);
		
		method.appendItem(lang.get("order.pos.grid.column.cash"), "CASH");
		method.appendItem(lang.get("order.pos.grid.column.debit"), "DEBIT");
		method.appendItem(lang.get("order.pos.grid.column.cc"), "CREDITCARD");
		method.appendItem(lang.get("order.pos.grid.column.term"), "TERM");
		
		if(!isdropship)
			method.setSelectedIndex(0);
		else
			method.setSelectedIndex(3);
		
		method.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				if(method.getSelectedIndex() == 1 || method.getSelectedIndex() == 2)
					grid.getRows().getChildren().get(1).setVisible(true);
				else
					grid.getRows().getChildren().get(1).setVisible(false);
			}
		});
		
		cardNumber.setHflex("1");
		
		ok.setIconSclass("z-icon-plus-circle");

		Button cancel = new Button(lang.get("label.component.button.close"));
		cancel.setIconSclass("z-icon-remove");
		cancel.addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				detach();
			}
		});
	
		paid.setFocus(true);
		paid.addEventListener(Events.ON_CHANGING,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(event instanceof InputEvent)
				{
					try
					{
						InputEvent input = (InputEvent)event;
						
						if(!Strings.isNullOrEmpty(input.getValue()))
						{
							BigDecimal in = new BigDecimal(input.getValue());
							change.setValue(in.subtract(amount));
						}
					} 
					catch (NumberFormatException e){}
				}
			}
		});
		
		paid.addEventListener(Events.ON_OK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				ok.setFocus(true);
			}
		});
		
		Hbox hbox = new Hbox();
		hbox.setHflex("1");
		hbox.setPack("end");
		hbox.appendChild(cancel);
		hbox.appendChild(ok);
		
		grid.getRows().appendChild(RowUtils.row(lang.get("order.pos.grid.column.method"),method));
		grid.getRows().appendChild(RowUtils.row(lang.get("order.pos.grid.column.cardnumber"),cardNumber));
		grid.getRows().appendChild(RowUtils.row(lang.get("order.pos.grid.column.price"),nominal));
		grid.getRows().appendChild(RowUtils.row(lang.get("order.pos.grid.column.payment"), paid));
		grid.getRows().appendChild(RowUtils.row(lang.get("order.pos.grid.column.change"), change));
		grid.setSpan("1");
		grid.getRows().getChildren().get(1).setVisible(false);

		Row row = new Row();
		row.appendChild(new Label());
		row.appendChild(hbox);
		
		grid.getRows().appendChild(row);
		
		appendChild(grid);
	}

	public Decimalbox getPaid()
	{
		return paid;
	}

	public Decimalbox getChange()
	{
		return change;
	}

	public Button getOk()
	{
		return ok;
	}
	
	public String getReference()
	{
		return cardNumber.getText();
	}
	
	public boolean isCash()
	{
		return getMethod().getSelectedItem().getValue().toString().equals("CASH");
	}
	
	public boolean isDebit()
	{
		return getMethod().getSelectedItem().getValue().toString().equals("DEBIT");
	}
	
	public boolean isCreditCard()
	{
		return getMethod().getSelectedItem().getValue().toString().equals("CREDITCARD");
	}
}
