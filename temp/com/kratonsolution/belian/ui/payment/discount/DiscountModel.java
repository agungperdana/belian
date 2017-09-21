/**
 * 
 */
package com.kratonsolution.belian.ui.payment.discount;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.payment.dm.Discount;
import com.kratonsolution.belian.payment.svc.DiscountService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DiscountModel implements ListModel<Discount>
{
	private final DiscountService service = Springs.get(DiscountService.class);
	
	private List<Discount> data = new ArrayList<Discount>();
	
	public DiscountModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public Discount getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return service.getSize();
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
