/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.labschedule;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.healtcare.dm.LaboratoryBilling;
import com.kratonsolution.belian.healtcare.svc.LaboratoryBillingService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class LabScheduleModel implements ListModel<LaboratoryBilling>
{
	private final LaboratoryBillingService service = Springs.get(LaboratoryBillingService.class);
	
	private List<LaboratoryBilling> data = new ArrayList<LaboratoryBilling>();
	
	public LabScheduleModel(int itemSize)
	{
		next(0, itemSize);
	}

	@Override
	public LaboratoryBilling getElementAt(int index)
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
