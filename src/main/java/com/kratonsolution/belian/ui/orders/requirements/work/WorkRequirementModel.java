
package com.kratonsolution.belian.ui.orders.requirements.work;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.requirement.dm.WorkRequirement;
import com.kratonsolution.belian.requirement.svc.WorkRequirementService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class WorkRequirementModel implements ListModel<WorkRequirement>
{
	private WorkRequirementService service = Springs.get(WorkRequirementService.class);
	
	private List<WorkRequirement> data = new ArrayList<WorkRequirement>();
	
	public WorkRequirementModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public WorkRequirement getElementAt(int index)
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
