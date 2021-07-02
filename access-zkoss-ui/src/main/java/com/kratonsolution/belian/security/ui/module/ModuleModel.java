package com.kratonsolution.belian.security.ui.module;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.access.api.ModuleData;
import com.kratonsolution.belian.access.api.application.ModuleService;
import com.kratonsolution.belian.common.ui.UISetting;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.common.ui.util.UIHelper;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class ModuleModel implements ListModel<ModuleData>
{
	private final ModuleService service = Springs.get(ModuleService.class);
	
	private final UISetting setting = UIHelper.getSetting();
	
	private List<ModuleData> data = new ArrayList<ModuleData>();
	
	public ModuleModel(){
		next(0);
	}
	
	@Override
	public ModuleData getElementAt(int index) {
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize() {
		return service.count();
	}

	@Override
	public void addListDataListener(ListDataListener l) {
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
	}

	public void next(int pageIndex) {
		data.clear();
		data.addAll(service.getAllModules(pageIndex, (setting.getMaxRow()*pageIndex)+setting.getMaxRow()));
	}
}
