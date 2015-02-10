/**
 * 
 */
package com.kratonsolution.belian.ui.role;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.security.dm.Role;
import com.kratonsolution.belian.security.view.RoleController;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class RoleModel implements ListModel<Role>
{
	private final RoleController controller = Springs.get(RoleController.class);
	
	private List<Role> data = new ArrayList<Role>();
	
	public RoleModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public Role getElementAt(int index)
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
		data.addAll(controller.findAll(0, (itemSize*pageIndex)+itemSize));
	}
}
