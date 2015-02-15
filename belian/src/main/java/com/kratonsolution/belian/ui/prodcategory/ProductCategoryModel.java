/**
 * 
 */
package com.kratonsolution.belian.ui.prodcategory;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.inventory.dm.ProductCategory;
import com.kratonsolution.belian.inventory.svc.ProductCategoryService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class ProductCategoryModel implements ListModel<ProductCategory>
{
	private final ProductCategoryService service = Springs.get(ProductCategoryService.class);
	
	private List<ProductCategory> data = new ArrayList<ProductCategory>();
	
	public ProductCategoryModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public ProductCategory getElementAt(int index)
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
