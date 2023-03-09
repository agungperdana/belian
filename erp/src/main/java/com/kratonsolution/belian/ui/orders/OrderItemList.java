
package com.kratonsolution.belian.ui.orders;

import java.util.Collection;

import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.orders.dm.OrderItem;
import com.kratonsolution.belian.ui.component.AbstractList;
import com.kratonsolution.belian.ui.component.ListSelectionListener;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class OrderItemList extends AbstractList<OrderItem> implements ListSelectionListener<OrderItem>
{
	public OrderItemList(boolean fullspan)
	{
		this(fullspan,null,null);
	}
	
	public OrderItemList(boolean fullspan,Collection<OrderItem> items,OrderItem item)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		
		if(items != null)
		{
			for(OrderItem term:items)
			{
				Listitem listitem = appendItem(term.getLabel(), term.getId());
				if(item != null && item.getId().equals(term.getId()))
					setSelectedItem(listitem);
					
				if(!maps.containsKey(term.getId()))
					maps.put(term.getId(), term);
			}
		}
	}
	
	public OrderItem getDomain()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}
	
	public void setDomain(OrderItem term)
	{
		if(term != null)
		{
			getItems().clear();
			setSelectedItem(appendItem(term.getLabel(), term.getId()));
			
			if(!maps.containsKey(term.getId()))
				maps.put(term.getId(), term);
		}
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		OrderItem domain = getDomain();
		if(domain != null)
		{
			IDValueRef ref = new  IDValueRef();
			ref.setId(domain.getId());
			ref.setValue(domain.getLabel());
			
			return ref;
		}
		
		return null;
	}

	@Override
	public void setDomainAsRef(IDValueRef ref)
	{
		getItems().clear();

		for(OrderItem cache:maps.values())
		{
			Listitem item = appendItem(cache.getLabel(), cache.getId());
			if(ref != null && ref.getId().equals(cache.getId()))
				setSelectedItem(item);
		}
	}

	@Override
	public void fireItemSelected(OrderItem model)
	{
		if(model != null && !maps.containsKey(model.getId()))
		{
			maps.put(model.getId(), model);
			appendItem(model.getLabel(), model.getId());
		}
	}
}
