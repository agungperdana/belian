
package com.kratonsolution.belian.ui.workefforts.workeffort;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.ui.util.Springs;
import com.kratonsolution.belian.workefforts.dm.WorkEffort;
import com.kratonsolution.belian.workefforts.svc.WorkEffortService;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class WorkEffortModel implements ListModel<WorkEffort>
{
	private WorkEffortService service = Springs.get(WorkEffortService.class);
	
	private List<WorkEffort> data = new ArrayList<WorkEffort>();
	
	public WorkEffortModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public WorkEffort getElementAt(int index)
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
