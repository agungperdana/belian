
package com.kratonsolution.belian.ui.general.uom;

import org.zkoss.zul.Listitem;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.orm.IDValueRef;
import com.kratonsolution.belian.common.orm.Observer;
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.UnitOfMeasure;
import com.kratonsolution.belian.products.svc.ProductService;
import com.kratonsolution.belian.products.svc.UnitOfMeasureService;
import com.kratonsolution.belian.ui.component.AbstractList;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class UOMList extends AbstractList<UnitOfMeasure> implements Observer
{
	private ProductService productService = Springs.get(ProductService.class);
	
	private UnitOfMeasureService service = Springs.get(UnitOfMeasureService.class);
	
	public UOMList(boolean fullspan)
	{
		this(fullspan,null);
	}
		
	public UOMList(boolean fullspan,UnitOfMeasure uom)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		
		for(UnitOfMeasure measure:service.findAll())
		{
			Listitem listitem = appendItem(measure.getName(), measure.getId());
			if(uom != null && uom.getId().equals(measure.getId()))
				setSelectedItem(listitem);
				
			if(!maps.containsKey(measure.getId()))
				maps.put(measure.getId(), measure);
		}
	}

	@Override
	public UnitOfMeasure getDomain()
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
			UnitOfMeasure uom = maps.get(getSelectedItem().getValue().toString());

			IDValueRef ref = new IDValueRef();
			ref.setId(uom.getId());
			ref.setValue(uom.getName());
			ref.setType(UnitOfMeasure.class.getSimpleName());
			
			return ref;
		}
		
		return null;
	}

	@Override
	public void setDomain(UnitOfMeasure ref)
	{
		getItems().clear();

		if(ref != null && !maps.containsKey(ref.getId()))
			maps.put(ref.getId(), ref);
		
		for(UnitOfMeasure cache:maps.values())
		{
			Listitem item = appendItem(cache.getName(), cache.getId());
			if(ref != null && ref.getId().equals(cache.getId()))
				setSelectedItem(item);
		}
	}

	@Override
	public void setDomainAsRef(IDValueRef ref)
	{
		getItems().clear();

		if(ref != null && !maps.containsKey(ref.getId()))
			maps.put(ref.getId(), new UnitOfMeasure(ref));
		
		for(UnitOfMeasure cache:maps.values())
		{
			Listitem item = appendItem(cache.getName(), cache.getId());
			if(ref != null && ref.getId().equals(cache.getId()))
				setSelectedItem(item);
		}
	}

	@Override
	public void valueChange(IDValueRef value)
	{
		if(value != null && !Strings.isNullOrEmpty(value.getType()) && value.getType().equals(Product.class.getSimpleName()))
		{
			Product product = productService.findById(value.getId());
			if(product != null)
				setDomainAsRef(product.getUom());
		}
	}
}
