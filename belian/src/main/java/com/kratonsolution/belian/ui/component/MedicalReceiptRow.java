/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.math.BigDecimal;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.payment.dm.PaymentMethodType;
import com.kratonsolution.belian.payment.dm.Receipt;
import com.kratonsolution.belian.payment.svc.PaymentMethodTypeService;
import com.kratonsolution.belian.sales.dm.Billable;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class MedicalReceiptRow extends Row
{
	private PaymentMethodTypeService service = Springs.get(PaymentMethodTypeService.class);
	
	private Listbox types = Components.fullSpanSelect();
	
	private Textbox ref = Components.textBox(null);
	
	private Doublebox amount = Components.doubleBox(0);
	
	public MedicalReceiptRow()
	{
		this(BigDecimal.ZERO);
	}
	
	public MedicalReceiptRow(BigDecimal paidAmount)
	{
		for(PaymentMethodType type:service.findAll())
		{
			Listitem listitem = types.appendItem(type.getName(), type.getId());
			if(type.getName().equals("Cash"))
				types.setSelectedItem(listitem);
		}
		
		if(paidAmount != null)
			amount.setValue(paidAmount.doubleValue());
		
		appendChild(types);
		appendChild(amount);
		appendChild(ref);
	
		types.addEventListener(Events.ON_SELECT,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(types.getSelectedItem() != null && types.getSelectedItem().getValue().toString().equals("Cash"))
					ref.setReadonly(true);
				else
					ref.setReadonly(false);
			}
		});
	}
	
	public boolean create(Billable billable)
	{
		if(billable != null)
		{
			Receipt receipt = new Receipt();
			receipt.setBillable(billable);
			receipt.setAmount(BigDecimal.valueOf(amount.doubleValue()));
			receipt.setDate(DateTimes.currentDate());
			receipt.setReference(ref.getText());
			receipt.setType(service.findOne(Components.string(types)));
		
			billable.getReceipts().add(receipt);
			
			return true;
		}
		
		return false;
	}
}