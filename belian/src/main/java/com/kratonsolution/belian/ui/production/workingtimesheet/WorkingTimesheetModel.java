/**
 * 
 */
package com.kratonsolution.belian.ui.production.workingtimesheet;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.production.dm.Timesheet;
import com.kratonsolution.belian.production.svc.WorkingTimesheetService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class WorkingTimesheetModel implements ListModel<Timesheet>
{
	private WorkingTimesheetService service = Springs.get(WorkingTimesheetService.class);
	
	private List<Timesheet> data = new ArrayList<Timesheet>();
	
	private String key;
	
	public WorkingTimesheetModel(int itemSize)
	{
		next(0, itemSize,null);
	}
	
	public WorkingTimesheetModel(int itemSize,String key)
	{
		this.key = key;
		next(0, itemSize,key);
	}
	
	@Override
	public Timesheet getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return service.getSize(this.key);
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

	public void next(int pageIndex,int itemSize,String key)
	{
		data.clear();
		data.addAll(service.findAll(0, (itemSize*pageIndex)+itemSize,key));
	}
}
