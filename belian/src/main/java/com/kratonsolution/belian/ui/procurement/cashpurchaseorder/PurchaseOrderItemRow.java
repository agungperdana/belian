/**
 * 
 */
package com.kratonsolution.belian.ui.procurement.cashpurchaseorder;

import java.util.ArrayList;
import java.util.Collection;

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
public class PurchaseOrderItemRow extends Row
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
	
	public PurchaseOrderItemRow(PurchaseOrderItem item)
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
			price.setValue(item.getUnitPrice().doubleValue());
			total.setValue(item.getUnitPrice().doubleValue()*buyed.getValue());
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
	}
}
