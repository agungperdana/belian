/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.productretur;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.inventory.dm.ProductRetur;
import com.kratonsolution.belian.inventory.svc.ProductReturService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductReturModel implements ListModel<ProductRetur>
{
	private ProductReturService service = Springs.get(ProductReturService.class);
	
	private List<ProductRetur> data = new ArrayList<ProductRetur>();
	
	public ProductReturModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public ProductRetur getElementAt(int index)
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
