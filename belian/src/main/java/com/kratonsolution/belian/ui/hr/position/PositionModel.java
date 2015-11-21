/**
 * 
 */
package com.kratonsolution.belian.ui.hr.position;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.hr.dm.Position;
import com.kratonsolution.belian.hr.svc.PositionService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PositionModel implements ListModel<Position>
{
	private final PositionService service = Springs.get(PositionService.class);
	
	private List<Position> data = new ArrayList<Position>();
	
	public PositionModel(int itemSize)
	{
		next(0, itemSize);
	}

	@Override
	public Position getElementAt(int index)
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
