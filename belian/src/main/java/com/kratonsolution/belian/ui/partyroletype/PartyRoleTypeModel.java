/**
 * 
 */
package com.kratonsolution.belian.ui.partyroletype;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.general.dm.PartyRoleType;
import com.kratonsolution.belian.general.svc.PartyRoleTypeService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class PartyRoleTypeModel implements ListModel<PartyRoleType>
{
	private final PartyRoleTypeService controller = Springs.get(PartyRoleTypeService.class);
	
	private List<PartyRoleType> data = new ArrayList<PartyRoleType>();
	
	public PartyRoleTypeModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public PartyRoleType getElementAt(int index)
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
