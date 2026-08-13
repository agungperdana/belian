
package com.kratonsolution.belian.ui.general.uom;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.products.dm.UnitOfMeasure;
import com.kratonsolution.belian.products.svc.UnitOfMeasureService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class UOMModel implements ListModel<UnitOfMeasure>
{
	private UnitOfMeasureService service = Springs.get(UnitOfMeasureService.class);
	
	private List<UnitOfMeasure> data = new ArrayList<UnitOfMeasure>();
	
	public UOMModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public UnitOfMeasure getElementAt(int index)
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
