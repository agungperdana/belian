/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.labschedule;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.healtcare.dm.LaboratorySales;
import com.kratonsolution.belian.healtcare.svc.LaboratorySalesService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class LabScheduleModel implements ListModel<LaboratorySales>
{
	private final LaboratorySalesService service = Springs.get(LaboratorySalesService.class);
	
	private List<LaboratorySales> data = new ArrayList<LaboratorySales>();
	
	public LabScheduleModel(int itemSize)
	{
		next(0, itemSize);
	}

	@Override
	public LaboratorySales getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return data.size();
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
		data.addAll(service.findAllPaid());
	}
}
