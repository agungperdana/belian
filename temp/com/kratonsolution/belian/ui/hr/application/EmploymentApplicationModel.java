/**
 * 
 */
package com.kratonsolution.belian.ui.hr.application;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.hr.dm.EmploymentApplication;
import com.kratonsolution.belian.hr.svc.EmploymentApplicationService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class EmploymentApplicationModel implements ListModel<EmploymentApplication>
{
	private final EmploymentApplicationService service = Springs.get(EmploymentApplicationService.class);
	
	private List<EmploymentApplication> data = new ArrayList<EmploymentApplication>();
	
	public EmploymentApplicationModel(int itemSize)
	{
		next(0, itemSize);
	}

	@Override
	public EmploymentApplication getElementAt(int index)
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
		data.addAll(service.findAll(0, (itemSize*pageIndex)+itemSize));
	}
}
