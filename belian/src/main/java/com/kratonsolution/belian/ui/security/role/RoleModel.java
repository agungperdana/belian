/**
 * 
 */
package com.kratonsolution.belian.ui.security.role;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.security.dm.Role;
import com.kratonsolution.belian.security.svc.RoleService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class RoleModel implements ListModel<Role>
{
	private final RoleService service = Springs.get(RoleService.class);
	
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
		return service.size();
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
		data.addAll(service.findAll(0, (itemSize*pageIndex)+itemSize));
	}
}
