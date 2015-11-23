/**
 * 
 */
package com.kratonsolution.belian.ui.budget;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.accounting.dm.Budget;
import com.kratonsolution.belian.accounting.svc.BudgetService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BudgetModel implements ListModel<Budget>
{
	private final BudgetService controller = Springs.get(BudgetService.class);
	
	private List<Budget> data = new ArrayList<Budget>();
	
	public BudgetModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public Budget getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return controller.size();
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
		data.addAll(controller.findAll(0, (itemSize*pageIndex)+itemSize));
	}
}
