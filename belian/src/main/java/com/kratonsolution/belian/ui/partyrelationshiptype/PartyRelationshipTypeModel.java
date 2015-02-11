/**
 * 
 */
package com.kratonsolution.belian.ui.partyrelationshiptype;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.general.dm.PartyRelationshipType;
import com.kratonsolution.belian.general.svc.PartyRelationshipTypeService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class PartyRelationshipTypeModel implements ListModel<PartyRelationshipType>
{
	private final PartyRelationshipTypeService controller = Springs.get(PartyRelationshipTypeService.class);
	
	private List<PartyRelationshipType> data = new ArrayList<PartyRelationshipType>();
	
	public PartyRelationshipTypeModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public PartyRelationshipType getElementAt(int index)
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
