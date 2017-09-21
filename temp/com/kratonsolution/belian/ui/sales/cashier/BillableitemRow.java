/**
 * 
 */
package com.kratonsolution.belian.ui.sales.cashier;

import java.math.BigDecimal;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.sales.dm.BillableItem;
import com.kratonsolution.belian.ui.component.HasAmount;
import com.kratonsolution.belian.ui.util.Components;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BillableitemRow extends Row implements HasAmount
{
	private BillableItem item;
	
	private Textbox products = Components.readOnlyTextBox();

	private Doublebox prices = Components.doubleBox();

	private Doublebox discounts = Components.doubleBox();

	private Textbox uoms = Components.readOnlyTextBox();
	
	private Doublebox charges = Components.doubleBox();
	
	private Doublebox quantity = Components.doubleBox();

	private Textbox note = Components.textBox(null);
	
	public BillableitemRow()
	{
		appendChild(products);
		appendChild(quantity);
		appendChild(uoms);
		appendChild(prices);
		appendChild(discounts);
		appendChild(charges);
		appendChild(note);
	}
	
	public void setItem(BillableItem item)
	{
		this.item = item;
		
		products.setText(item.getProduct().getName());
		quantity.setValue(item.getQuantity().doubleValue());
		uoms.setText(item.getMeasure());
		prices.setValue(item.getUnitPrice().doubleValue());
		discounts.setValue(0d);
		charges.setValue(0d);
		note.setText(item.getNote());
	}
	
	public void updateItem(BillableItem item)
	{
		if(this.item != null && item.getId().equals(this.item.getId()))
		{
			item.setQuantity(BigDecimal.valueOf(quantity.doubleValue()));
			item.setPrice(BigDecimal.valueOf(prices.doubleValue()));
		}
	}
	
	public void setEventListener(EventListener<Event> listener)
	{
		quantity.addEventListener(Events.ON_CHANGE, listener);
		prices.addEventListener(Events.ON_CHANGE, listener);
	}

	@Override
	public BigDecimal getAmount()
	{
		return BigDecimal.valueOf(prices.doubleValue()).multiply(BigDecimal.valueOf(quantity.doubleValue()));
	}
}
