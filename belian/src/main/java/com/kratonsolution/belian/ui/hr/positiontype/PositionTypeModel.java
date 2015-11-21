/**
 * 
 */
package com.kratonsolution.belian.ui.hr.positiontype;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.hr.dm.PositionType;
import com.kratonsolution.belian.hr.svc.PositionTypeService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PositionTypeModel implements ListModel<PositionType>
{
	private final PositionTypeService service = Springs.get(PositionTypeService.class);
	
	private List<PositionType> data = new ArrayList<PositionType>();
	
	public PositionTypeModel(int itemSize)
	{
		next(0, itemSize);
	}

	@Override
	public PositionType getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return data.size();
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
		data.addAll(service.findAll(0, (itemSize*pageIndex)+itemSize));
	}
}
