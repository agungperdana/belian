/**
 * 
 */
package com.kratonsolution.belian.ui.module;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.security.dm.Module;
import com.kratonsolution.belian.security.view.ModuleController;
import com.kratonsolution.belian.ui.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class ModuleModel implements ListModel<Module>
{
	private final ModuleController controller = Springs.get(ModuleController.class);
	
	private List<Module> data = new ArrayList<Module>();
	
	public ModuleModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public Module getElementAt(int index)
	{
		if(index >= data.size())
			return data.get(data.size()-1);
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListDataListener(ListDataListener l)
	{
		// TODO Auto-generated method stub
		
	}

	public void next(int pageIndex,int itemSize)
	{
		if(data.size() < getSize())
			data.addAll(controller.findAll(pageIndex,itemSize));
	}
}
