/**
 * 
 */
package com.kratonsolution.belian.ui.finance.payments.receipt;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.payments.dm.Receipt;
import com.kratonsolution.belian.payments.svc.ReceiptService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ReceiptModel implements ListModel<Receipt>
{
	private ReceiptService service = Springs.get(ReceiptService.class);
	
	private List<Receipt> data = new ArrayList<Receipt>();
	
	public ReceiptModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public Receipt getElementAt(int index)
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
