/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.journalsetting;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.accounting.dm.AutoJournalSetting;
import com.kratonsolution.belian.accounting.svc.JournalSettingService;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class JournalSettingModel implements ListModel<AutoJournalSetting>
{
	private JournalSettingService controller = Springs.get(JournalSettingService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private List<AutoJournalSetting> data = new ArrayList<AutoJournalSetting>();
	
	public JournalSettingModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public AutoJournalSetting getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return controller.count(utils.getOrganizationIds());
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
		data.addAll(controller.findAll(0, (itemSize*pageIndex)+itemSize,utils.getOrganizationIds()));
	}
}
