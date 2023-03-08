/**
 * 
 */
package com.kratonsolution.belian.ui.inventorys.stockadjustment;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.inventory.dm.StockAdjustment;
import com.kratonsolution.belian.inventory.svc.StockAdjustmentService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StockAdjustmentModel implements ListModel<StockAdjustment>
{
	private StockAdjustmentService service = Springs.get(StockAdjustmentService.class);
	
	private List<StockAdjustment> data = new ArrayList<StockAdjustment>();
	
	private String key;
	
	public StockAdjustmentModel(int itemSize)
	{
		next(0, itemSize,null);
	}
	
	public StockAdjustmentModel(int itemSize,String key)
	{
		this.key = key;
		next(0, itemSize,key);
	}
	
	@Override
	public StockAdjustment getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return service.size(this.key);
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

	public void next(int pageIndex,int itemSize,String key)
	{
		data.clear();
		data.addAll(service.findAll(0, (itemSize*pageIndex)+itemSize,key));
	}
}
