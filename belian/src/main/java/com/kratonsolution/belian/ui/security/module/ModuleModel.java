/**
 * 
 */
package com.kratonsolution.belian.ui.security.module;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.security.dm.Module;
import com.kratonsolution.belian.security.svc.ModuleService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ModuleModel implements ListModel<Module>
{
	private final ModuleService controller = Springs.get(ModuleService.class);
	
	private List<Module> data = new ArrayList<Module>();
	
	public ModuleModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public Module getElementAt(int index)
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
