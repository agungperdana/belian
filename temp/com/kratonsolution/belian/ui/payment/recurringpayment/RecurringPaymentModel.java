/**
 * 
 */
package com.kratonsolution.belian.ui.payment.recurringpayment;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.payment.dm.RecurringPayment;
import com.kratonsolution.belian.payment.svc.RecurringPaymentService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class RecurringPaymentModel implements ListModel<RecurringPayment>
{
	private final RecurringPaymentService service = Springs.get(RecurringPaymentService.class);
	
	private List<RecurringPayment> data = new ArrayList<RecurringPayment>();
	
	private String key;
	
	public RecurringPaymentModel(int itemSize)
	{
		next(0, itemSize,null);
	}
	
	public RecurringPaymentModel(int itemSize,String key)
	{
		this.key = key;
		next(0, itemSize,key);
	}
	
	@Override
	public RecurringPayment getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return service.getSize(this.key);
	}

	@Override
	public void addListDataListener(ListDataListener l)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListDataListener(ListDataListener l)
	{
		// TODO Auto-generated method stub
		
	}

	public void next(int pageIndex,int itemSize,String key)
	{
		data.clear();
		data.addAll(service.findAll(0, (itemSize*pageIndex)+itemSize,key));
	}
}
