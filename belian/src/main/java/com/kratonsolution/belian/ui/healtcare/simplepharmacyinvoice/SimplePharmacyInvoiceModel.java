/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.simplepharmacyinvoice;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.healtcare.dm.SimplePharmacyInvoice;
import com.kratonsolution.belian.healtcare.svc.SimplePharmacyInvoiceService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SimplePharmacyInvoiceModel implements ListModel<SimplePharmacyInvoice>
{
	private SimplePharmacyInvoiceService service = Springs.get(SimplePharmacyInvoiceService.class);
	
	private List<SimplePharmacyInvoice> data = new ArrayList<SimplePharmacyInvoice>();
	
	public SimplePharmacyInvoiceModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public SimplePharmacyInvoice getElementAt(int index)
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
