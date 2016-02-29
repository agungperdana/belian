/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.pharmacyorder;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.healtcare.dm.Medication;
import com.kratonsolution.belian.healtcare.svc.MedicationService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PharmacyOrderModel implements ListModel<Medication>
{
	private MedicationService service = Springs.get(MedicationService.class);
	
	private List<Medication> data = new ArrayList<Medication>();
	
	public PharmacyOrderModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public Medication getElementAt(int index)
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
