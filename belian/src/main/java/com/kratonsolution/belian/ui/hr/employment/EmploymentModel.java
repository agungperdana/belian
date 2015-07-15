/**
 * 
 */
package com.kratonsolution.belian.ui.hr.employment;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.general.dm.Employment;
import com.kratonsolution.belian.general.svc.EmploymentService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class EmploymentModel implements ListModel<Employment>
{
	private EmploymentService service = Springs.get(EmploymentService.class);
	
	private List<Employment> data = new ArrayList<Employment>();
	
	public EmploymentModel(int itemSize)
	{
		next(0, itemSize);
	}

	@Override
	public Employment getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return service.getSize();
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
