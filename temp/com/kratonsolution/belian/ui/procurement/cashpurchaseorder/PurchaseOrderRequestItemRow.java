/**
 * 
 */
package com.kratonsolution.belian.ui.procurement.cashpurchaseorder;

import java.math.BigDecimal;
import java.sql.Date;

import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.procurement.dm.PurchaseOrderItem;
import com.kratonsolution.belian.procurement.dm.PurchaseOrderRequestItem;
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
		}
	}
	
	private void initGUI()
	{
		appendChild(product);
		appendChild(requested);
		appendChild(buyed);
		appendChild(uom);
		appendChild(expired);
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
}
