/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.pharmacysales;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.healtcare.dm.PharmacySales;
import com.kratonsolution.belian.healtcare.svc.PharmacySalesService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PharmacySalesModel implements ListModel<PharmacySales>
{
	private PharmacySalesService service = Springs.get(PharmacySalesService.class);
	
	private List<PharmacySales> data = new ArrayList<PharmacySales>();
	
	public PharmacySalesModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public PharmacySales getElementAt(int index)
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
