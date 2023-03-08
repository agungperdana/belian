/**
 * 
 */
package com.kratonsolution.belian.ui.orders.purchaseorder;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.orders.dm.PurchaseOrder;
import com.kratonsolution.belian.orders.svc.PurchaseOrderService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class POModel implements ListModel<PurchaseOrder>
{
	private PurchaseOrderService service = Springs.get(PurchaseOrderService.class);
	
	private List<PurchaseOrder> data = new ArrayList<PurchaseOrder>();
	
	private String key;
	
	public POModel(int itemSize)
	{
		next(0, itemSize,null);
	}
	
	public POModel(int itemSize,String key)
	{
		this.key = key;
		next(0, itemSize,key);
	}
	
	@Override
	public PurchaseOrder getElementAt(int index)
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
