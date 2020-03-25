package com.kratonsolution.belian.security.ui.role;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.common.ui.util.UIHelper;
import com.kratonsolution.belian.security.api.RoleData;
import com.kratonsolution.belian.security.api.application.RoleService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class RoleModel implements ListModel<RoleData>
{
	private RoleService service = Springs.get(RoleService.class);
	
	private List<RoleData> data = new ArrayList<RoleData>();
	
	public RoleModel() {
		next(0);
	}
	
	@Override
	public RoleData getElementAt(int index) {
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize() {
		return service.count();
	}

	@Override
	public void addListDataListener(ListDataListener l){
	}

	@Override
	public void removeListDataListener(ListDataListener l){
	}

	public void next(int pageIndex){
		
		int size = UIHelper.getSetting().getMaxRow();
		
		data.clear();
		data.addAll(service.getAllRoles(0, (size*pageIndex)+size));
	}
}
