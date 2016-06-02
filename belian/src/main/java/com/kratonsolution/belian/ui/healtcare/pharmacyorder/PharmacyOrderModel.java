/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.pharmacyorder;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.healtcare.dm.MedicalSales;
import com.kratonsolution.belian.healtcare.svc.MedicalSalesService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PharmacyOrderModel implements ListModel<MedicalSales>
{
	private MedicalSalesService service = Springs.get(MedicalSalesService.class);
	
	private List<MedicalSales> data = new ArrayList<MedicalSales>();
	
	public PharmacyOrderModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public MedicalSales getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return service.sizePaid();
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
		data.addAll(service.findAllPaid());
	}
}
