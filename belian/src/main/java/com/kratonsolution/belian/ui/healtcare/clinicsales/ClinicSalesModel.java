/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.clinicsales;

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
public class ClinicSalesModel implements ListModel<Medication>
{
	private MedicationService service = Springs.get(MedicationService.class);
	
	private List<Medication> data = new ArrayList<Medication>();
	
	private String key;
	
	public ClinicSalesModel(int itemSize)
	{
		next(0, itemSize,null);
	}
	
	public ClinicSalesModel(int itemSize,String key)
	{
		this.key=key;
		next(0, itemSize,key);
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
	}

	public void next(int pageIndex,int itemSize,String key)
	{
		data.clear();
		data.addAll(service.findAll(0, (itemSize*pageIndex)+itemSize,key));
	}
}
