/**
 * 
 */
package com.kratonsolution.belian.ui.sales.cashier;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.sales.dm.Billable;
import com.kratonsolution.belian.sales.srv.BillingService;
import com.kratonsolution.belian.ui.SearchCriteria;
import com.kratonsolution.belian.ui.Searchable;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashierModel implements ListModel<Billable>,Searchable
{
	private BillingService service = Springs.get(BillingService.class);
	
	private List<Billable> data = new ArrayList<Billable>();
	
	public CashierModel(int itemSize,String companyId)
	{
		next(0, itemSize,companyId);
	}
	
	@Override
	public Billable getElementAt(int index)
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

	public void next(int pageIndex,int itemSize,String companyId)
	{
		data.clear();
		data.addAll(service.forCashier());
	}

	@Override
	public void search(String param)
	{
		data.clear();
		data.addAll(service.findAllCurrent(param));
	}

	@Override
	public void search(SearchCriteria criteria)
	{
	}
}
