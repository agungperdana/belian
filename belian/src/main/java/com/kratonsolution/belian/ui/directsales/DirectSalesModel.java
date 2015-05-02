/**
 * 
 */
package com.kratonsolution.belian.ui.directsales;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.sales.dm.DirectSales;
import com.kratonsolution.belian.sales.srv.CashSalesService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class DirectSalesModel implements ListModel<DirectSales>
{
	private final CashSalesService service = Springs.get(CashSalesService.class);
	
	private List<DirectSales> data = new ArrayList<DirectSales>();
	
	public DirectSalesModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public DirectSales getElementAt(int index)
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
