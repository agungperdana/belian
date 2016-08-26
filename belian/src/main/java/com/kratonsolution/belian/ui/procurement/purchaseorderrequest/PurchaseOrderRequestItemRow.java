/**
 * 
 */
package com.kratonsolution.belian.ui.procurement.purchaseorderrequest;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.procurement.dm.PurchaseOrderItem;
import com.kratonsolution.belian.procurement.dm.PurchaseOrderRequestItem;
import com.kratonsolution.belian.ui.StateListener;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Numbers;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PurchaseOrderRequestItemRow extends Row
{
	private PurchaseOrderRequestItem item;
	
	private PurchaseOrderItem orderItem;
	
	private Textbox product = Components.readOnlyTextBox();
	
	private Textbox requested = Components.readOnlyTextBox();
	
	private Doublebox buyed = Components.doubleBox(0);
	
	private Textbox uom = Components.readOnlyTextBox();
	
	private Datebox expired = Components.fullSpanDatebox(DateTimes.currentDate());
	
	private Doublebox price = Components.doubleBox(0);
	
	private Doublebox total = Components.readOnlyDoubleBox(0);
	
	private Collection<StateListener> listeners = new ArrayList();
	
	public PurchaseOrderRequestItemRow(PurchaseOrderRequestItem item)
	{
		this.item = item;
		initGUI();
		
		if(this.item != null && this.item.getQuantity().subtract(this.item.getOrdered()).compareTo(BigDecimal.ZERO) > 0)
		{
			product.setText(item.getResource());
			requested.setText(Numbers.format(this.item.getQuantity()));
			buyed.setValue(this.item.getQuantity().subtract(this.item.getOrdered()).doubleValue());
			uom.setText(this.item.getUom());
			
			BigDecimal prc = item.getEstimatedPrice();
			if(prc == null)
				prc = BigDecimal.ZERO;
			
			price.setValue(prc.doubleValue());
			total.setValue(prc.doubleValue()*buyed.getValue());
		}
	}
	
	public PurchaseOrderRequestItemRow(PurchaseOrderItem item)
	{
		this.orderItem = item;
		initGUI();
		
		if(orderItem != null)
		{
			product.setText(orderItem.getProduct().getName());
			requested.setText(Numbers.format(orderItem.getRequestItem().getQuantity()));
			buyed.setValue(item.getQuantity().doubleValue());
			uom.setText(orderItem.getProduct().getUom().getCode());
			expired.setValue(orderItem.getExpiredDate());
			
			
			BigDecimal prc = item.getRequestItem().getEstimatedPrice();
			if(prc == null)
				prc = BigDecimal.ZERO;
			
			price.setValue(prc.doubleValue());
			total.setValue(prc.doubleValue()*buyed.getValue());
		}
	}
	
	private void initGUI()
	{
		appendChild(product);
		appendChild(requested);
		appendChild(buyed);
		appendChild(uom);
		appendChild(expired);
		appendChild(price);
		appendChild(total);
		
		Handler handler = new Handler();
		
		buyed.addEventListener(Events.ON_CHANGE,handler);
		buyed.addEventListener(Events.ON_BLUR,handler);
		price.addEventListener(Events.ON_CHANGE,handler);
		price.addEventListener(Events.ON_BLUR,handler);
	}
	
	public BigDecimal getBuyed()
	{
		return BigDecimal.valueOf(buyed.doubleValue());
	}
	
	public Date getExpired()
	{
		return DateTimes.sql(expired.getValue());
	}
	
	public PurchaseOrderRequestItem getItem()
	{
		return this.item;
	}
	
	public boolean isBuyed()
	{
		return buyed.doubleValue() > 0d;
	}

	public Doublebox getPrice()
	{
		return price;
	}

	public Doublebox getTotal()
	{
		return total;
	}
	
	public void addListener(StateListener listener)
	{
		if(listener != null)
			listeners.add(listener);
	}
	
	private class Handler implements EventListener<Event>
	{
		@Override
		public void onEvent(Event event) throws Exception
		{
			if(event instanceof InputEvent)
				total.setValue(buyed.getValue()*price.getValue());
		
			for(StateListener listener:listeners)
				listener.stateChanged();
		}
	}
}
