/**
 * 
 */
package com.kratonsolution.belian.ui.procurement.cashpurchaseorder;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.procurement.dm.CashPurchaseOrder;
import com.kratonsolution.belian.procurement.svc.CashPurchaseOrderService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashPurchaseOrderModel implements ListModel<CashPurchaseOrder>
{
	private CashPurchaseOrderService service = Springs.get(CashPurchaseOrderService.class);
	
	private List<CashPurchaseOrder> data = new ArrayList<CashPurchaseOrder>();
	
	public CashPurchaseOrderModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public CashPurchaseOrder getElementAt(int index)
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
