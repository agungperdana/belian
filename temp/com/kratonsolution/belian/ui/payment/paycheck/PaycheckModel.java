/**
 * 
 */
package com.kratonsolution.belian.ui.payment.paycheck;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.payment.dm.Paycheck;
import com.kratonsolution.belian.payment.svc.PaycheckService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PaycheckModel implements ListModel<Paycheck>
{
	private final PaycheckService service = Springs.get(PaycheckService.class);
	
	private List<Paycheck> data = new ArrayList<Paycheck>();
	
	private String key;
	
	public PaycheckModel(int itemSize)
	{
		next(0, itemSize,null);
	}
	
	public PaycheckModel(int itemSize,String key)
	{
		this.key = key;
		next(0, itemSize,key);
	}
	
	@Override
	public Paycheck getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return service.size(this.key);
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
