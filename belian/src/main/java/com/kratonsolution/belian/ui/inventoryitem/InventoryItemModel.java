/**
 * 
 */
package com.kratonsolution.belian.ui.inventoryitem;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.svc.InventoryItemService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class InventoryItemModel implements ListModel<InventoryItem>
{
	private final InventoryItemService service = Springs.get(InventoryItemService.class);
	
	private List<InventoryItem> data = new ArrayList<InventoryItem>();
	
	public InventoryItemModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public InventoryItem getElementAt(int index)
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
