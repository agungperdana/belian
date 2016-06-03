/**
 * 
 */
package com.kratonsolution.belian.ui.payment.methodtype;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.payment.dm.PaymentMethodType;
import com.kratonsolution.belian.payment.svc.PaymentMethodTypeService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PaymentMethodTypeModel implements ListModel<PaymentMethodType>
{
	private final PaymentMethodTypeService service = Springs.get(PaymentMethodTypeService.class);
	
	private List<PaymentMethodType> data = new ArrayList<PaymentMethodType>();
	
	public PaymentMethodTypeModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public PaymentMethodType getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return service.size();
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

	public void next(int pageIndex,int itemSize)
	{
		data.clear();
		data.addAll(service.findAll(0, (itemSize*pageIndex)+itemSize));
	}
}