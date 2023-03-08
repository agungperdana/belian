/**
 * 
 */
package com.kratonsolution.belian.ui.orders.salesorder;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.orders.dm.SalesOrder;
import com.kratonsolution.belian.orders.svc.SalesOrderService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SalesOrderModel implements ListModel<SalesOrder>
{
	private SalesOrderService service = Springs.get(SalesOrderService.class);
	
	private List<SalesOrder> data = new ArrayList<SalesOrder>();
	
	private String key;
	
	public SalesOrderModel(int itemSize)
	{
		next(0, itemSize,null);
	}
	
	public SalesOrderModel(int itemSize,String key)
	{
		this.key = key;
		next(0, itemSize,key);
	}
	
	@Override
	public SalesOrder getElementAt(int index)
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
