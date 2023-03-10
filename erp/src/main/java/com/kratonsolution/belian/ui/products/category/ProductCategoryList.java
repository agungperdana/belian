
package com.kratonsolution.belian.ui.products.category;

import org.zkoss.zul.Listitem;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.persistence.IDValueRef;
import com.kratonsolution.belian.products.dm.ProductCategory;
import com.kratonsolution.belian.products.svc.ProductCategoryService;
import com.kratonsolution.belian.ui.component.AbstractList;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductCategoryList extends AbstractList<ProductCategory>
{
	private ProductCategoryService service = Springs.get(ProductCategoryService.class);

	public ProductCategoryList(boolean fullspan)
	{
		this(fullspan,null);
	}

	public ProductCategoryList(boolean fullspan,ProductCategory category)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");

		setMold("select");

		for(ProductCategory geo:service.findAll())
		{
			Listitem listitem = appendItem(geo.getName(), geo.getId());
			if(category != null && category.getId().equals(geo.getId()))
				setSelectedItem(listitem);

			if(!maps.containsKey(geo.getName()))
				maps.put(geo.getName(), geo);
		}
	}

	public ProductCategory getDomain()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getLabel()))
			return maps.get(getSelectedItem().getLabel());

		return null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		ProductCategory domain = getDomain();
		if(domain != null)
		{
			IDValueRef ref = new  IDValueRef();
			ref.setId(domain.getId());
			ref.setValue(domain.getName());

			return ref;
		}

		return null;
	}

	public void setDomain(ProductCategory domain)
	{
		getItems().clear();

		if(domain != null && !Strings.isNullOrEmpty(domain.getId()) && !maps.containsKey(domain.getId()))
			maps.put(domain.getId(),domain);

		for(ProductCategory cache:maps.values())
		{
			Listitem item = appendItem(cache.getLabel(), cache.getId());
			if(domain != null && !Strings.isNullOrEmpty(domain.getId()) && domain.getId().equals(cache.getId()))
				setSelectedItem(item);
		}
	}

	@Override
	public void setDomainAsRef(IDValueRef domain)
	{
		getItems().clear();

		if(domain != null && !Strings.isNullOrEmpty(domain.getId()) && !maps.containsKey(domain.getId()))
			maps.put(domain.getId(), new ProductCategory(domain));

		for(ProductCategory cache:maps.values())
		{
			Listitem item = appendItem(cache.getLabel(), cache.getId());
			if(domain != null && !Strings.isNullOrEmpty(domain.getId()) && domain.getId().equals(cache.getId()))
				setSelectedItem(item);
		}
	}
}
