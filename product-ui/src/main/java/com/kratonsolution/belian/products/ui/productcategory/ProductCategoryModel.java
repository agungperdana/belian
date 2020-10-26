package com.kratonsolution.belian.products.ui.productcategory;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.common.ui.UISetting;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.common.ui.util.UIHelper;
import com.kratonsolution.belian.products.api.ProductCategoryData;
import com.kratonsolution.belian.products.api.application.ProductCategoryService;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class ProductCategoryModel implements ListModel<ProductCategoryData>
{
	private final ProductCategoryService service = Springs.get(ProductCategoryService.class);
	
	private final UISetting setting = UIHelper.getSetting();
	
	private List<ProductCategoryData> data = new ArrayList<ProductCategoryData>();
	
	public ProductCategoryModel(){
		next(0);
	}
	
	@Override
	public ProductCategoryData getElementAt(int index) {
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize() {
		return service.count();
	}

	@Override
	public void addListDataListener(ListDataListener l) {
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
	}

	public void next(int pageIndex) {
		data.clear();
		data.addAll(service.getAllProductCategorys(pageIndex, (setting.getMaxRow()*pageIndex)+setting.getMaxRow()));
	}
}
