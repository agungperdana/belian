/**
 * 
 */
package com.kratonsolution.belian.ui.products.feature;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zul.Listitem;

import com.google.common.base.Strings;
import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.ProductFeature;
import com.kratonsolution.belian.products.dm.ProductFeatureApplicability;
import com.kratonsolution.belian.products.svc.ProductFeatureService;
import com.kratonsolution.belian.ui.component.AbstractList;
import com.kratonsolution.belian.ui.component.ListSelectionListener;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductFeatureList extends AbstractList<ProductFeature> implements ListSelectionListener<Product>
{
	private ProductFeatureService service = Springs.get(ProductFeatureService.class);
	
	private Map<String,ProductFeature> maps = new HashMap<String, ProductFeature>();
	
	public ProductFeatureList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public ProductFeatureList(boolean fullspan,ProductFeature in)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		
		for(ProductFeature feature:service.findAll())
		{
			Listitem listitem = appendItem(feature.getValue(), feature.getId());
			if(in != null && in.getId().equals(feature.getId()))
				setSelectedItem(listitem);
				
			if(!maps.containsKey(feature.getId()))
				maps.put(feature.getId(), feature);
		}
	}
	
	public ProductFeature getProductFeature()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue()))
			return maps.get(getSelectedItem().getValue());
		
		return null;
	}
	
	public void setProductFeature(ProductFeature feature)
	{
		if(feature != null)
		{
			getItems().clear();
			setSelectedItem(appendItem(feature.getValue(), feature.getId()));
			
			if(!maps.containsKey(feature.getValue()))
				maps.put(feature.getValue(), feature);
		}
	}

	@Override
	public void fireItemSelected(Product product)
	{
		getItems().clear();
		for(ProductFeatureApplicability feature:product.getFeatures())
			appendItem(feature.getFeature().getValue(),feature.getFeature().getId());
	}

	@Override
	public ProductFeature getDomain()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
			
		return null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
		{
			ProductFeature feature = maps.get(getSelectedItem().getValue().toString());
			
			IDValueRef domain = new IDValueRef();
			domain.setId(feature.getId());
			domain.setValue(feature.getValue());
			domain.setType(ProductFeature.class.getSimpleName());
			
			return domain;
		
		}
		return null;
	}

	@Override
	public void setDomain(ProductFeature domain)
	{
		getItems().clear();

		if(domain != null && !Strings.isNullOrEmpty(domain.getId()) && !maps.containsKey(domain.getId()))
			maps.put(domain.getId(), domain);
		
		for(ProductFeature cache:maps.values())
		{
			Listitem item = appendItem(domain.getValue(), domain.getId());
			if(domain != null && !Strings.isNullOrEmpty(domain.getId()) && domain.getId().equals(cache.getId()))
				setSelectedItem(item);
		}
	}

	@Override
	public void setDomainAsRef(IDValueRef domain)
	{
		getItems().clear();

		if(domain != null && !Strings.isNullOrEmpty(domain.getId())  && !maps.containsKey(domain.getId()))
			maps.put(domain.getId(), new ProductFeature(domain));
		
		for(ProductFeature cache:maps.values())
		{
			Listitem item = appendItem(cache.getValue(), cache.getId());
			if(domain != null && !Strings.isNullOrEmpty(domain.getId()) && domain.getId().equals(cache.getId()))
				setSelectedItem(item);
		}
	}
}
