/**
 * 
 */
package com.kratonsolution.belian.ui.sales.billing;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.sales.dm.Billing;
import com.kratonsolution.belian.sales.srv.BillingService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BillingModel implements ListModel<Billing>
{
	private BillingService service = Springs.get(BillingService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private List<Billing> data = new ArrayList<Billing>();
	
	public BillingModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public Billing getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return data.size();
	}

	@Override
	public void addListDataListener(ListDataListener l)
	{
	}

	@Override
	public void removeListDataListener(ListDataListener l)
	{
	}

	public void next(int pageIndex,int itemSize)
	{
		data.clear();
		data.addAll(service.findAll(pageIndex,itemSize));
	}
}
