/**
 * 
 */
package com.kratonsolution.belian.ui.geographic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.general.dm.Geographic;
import com.kratonsolution.belian.general.view.GeographicController;
import com.kratonsolution.belian.ui.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class GeographicModel implements ListModel<Geographic>
{
	private List<Geographic> data = new ArrayList<Geographic>();
	
	private GeographicController controller = Springs.get(GeographicController.class);
	
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
		if(data.size() < getSize())
		{
			Page<Geographic> page = controller.findAll(pageIndex,itemSize);
			data.addAll(page.getContent());
		}
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
