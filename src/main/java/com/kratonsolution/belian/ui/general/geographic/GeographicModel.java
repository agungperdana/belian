
package com.kratonsolution.belian.ui.general.geographic;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.general.dm.Geographic;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GeographicModel implements ListModel<Geographic>
{
	private List<Geographic> data = new ArrayList<Geographic>();
	
	private GeographicService controller = Springs.get(GeographicService.class);
	
	private GeographicModel(){}
	
	public GeographicModel(int itemSize)
	{
		next(0,itemSize);
	}
	
	@Override
	public Geographic getElementAt(int index)
	{
		if(index >= data.size())
			return null;
			
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return controller.getSize();
	}
	
	public void next(int pageIndex,int itemSize)
	{
		data.clear();
		data.addAll(controller.findAll(0, (itemSize*pageIndex)+itemSize));
	}
	
	@Override
	public void addListDataListener(ListDataListener l)
	{
	}

	@Override
	public void removeListDataListener(ListDataListener l)
	{
	}
}
