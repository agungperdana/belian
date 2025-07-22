
package com.kratonsolution.belian.ui.products.feature;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.products.dm.ProductFeature;
import com.kratonsolution.belian.products.svc.ProductFeatureService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FeatureModel implements ListModel<ProductFeature>
{
	private ProductFeatureService controller = Springs.get(ProductFeatureService.class);
	
	private List<ProductFeature> data = new ArrayList<ProductFeature>();
	
	private String key;
	
	public FeatureModel(int itemSize)
	{
		next(0, itemSize,null);
	}
	
	public FeatureModel(int itemSize,String key)
	{
		this.key = key;
		next(0, itemSize,key);
	}
	
	@Override
	public ProductFeature getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return controller.size();
	}

	@Override
	public void addListDataListener(ListDataListener l)
	{
	}

	@Override
	public void removeListDataListener(ListDataListener l)
	{
	}

	public void next(int pageIndex,int itemSize,String key)
	{
		data.clear();
		data.addAll(controller.findAll(0, (itemSize*pageIndex)+itemSize));
	}
}
