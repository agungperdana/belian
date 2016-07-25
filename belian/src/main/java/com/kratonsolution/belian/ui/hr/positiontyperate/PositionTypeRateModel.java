/**
 * 
 */
package com.kratonsolution.belian.ui.hr.positiontyperate;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.hr.dm.PositionTypeRate;
import com.kratonsolution.belian.hr.svc.PositionTypeRateService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PositionTypeRateModel implements ListModel<PositionTypeRate>
{
	private PositionTypeRateService controller = Springs.get(PositionTypeRateService.class);
	
	private List<PositionTypeRate> data = new ArrayList<PositionTypeRate>();
	
	public PositionTypeRateModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public PositionTypeRate getElementAt(int index)
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
		data.addAll(controller.findAll(0, (itemSize*pageIndex)+itemSize));
	}
}
