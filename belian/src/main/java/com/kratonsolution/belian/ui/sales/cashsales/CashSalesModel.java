/**
 * 
 */
package com.kratonsolution.belian.ui.sales.cashsales;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.sales.dm.CashSales;
import com.kratonsolution.belian.sales.srv.CashSalesService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashSalesModel implements ListModel<CashSales>
{
	private CashSalesService service = Springs.get(CashSalesService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private List<CashSales> data = new ArrayList<CashSales>();
	
	public CashSalesModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public CashSales getElementAt(int index)
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
	}

	public void next(int pageIndex,int itemSize)
	{
		data.clear();
		data.addAll(service.findAll(0, (itemSize*pageIndex)+itemSize));
	}
}
