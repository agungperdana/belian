
package com.kratonsolution.belian.ui.finance.invoices.purchase;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.invoice.dm.PurchaseInvoice;
import com.kratonsolution.belian.invoice.svc.PurchaseInvoiceService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PurchaseInvoiceModel implements ListModel<PurchaseInvoice>
{
	private PurchaseInvoiceService service = Springs.get(PurchaseInvoiceService.class);
	
	private List<PurchaseInvoice> data = new ArrayList<PurchaseInvoice>();
	
	public PurchaseInvoiceModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public PurchaseInvoice getElementAt(int index)
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
