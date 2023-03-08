/**
 * 
 */
package com.kratonsolution.belian.ui.orders;

import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.orders.dm.OrderTermType;
import com.kratonsolution.belian.ui.component.AbstractList;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class OrderTermTypeList extends AbstractList<OrderTermType>
{
	public OrderTermTypeList(boolean fullspan)
	{
		this(fullspan,null);
	}

	public OrderTermTypeList(boolean fullspan,OrderTermType term)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");

		setMold("select");

		for(OrderTermType type:OrderTermType.values())
		{
			Listitem listitem = appendItem(type.display(utils.getLanguage()), type.name());
			if(term != null && type.equals(term))
				setSelectedItem(listitem);

			if(!maps.containsKey(type.name()))
				maps.put(type.name(), type);
		}
	}

	public OrderTermType getDomain()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());

		return null;
	}

	public void setDomain(OrderTermType ref)
	{
		if(ref != null && !maps.containsKey(ref.name()))
			maps.put(ref.name(), ref);

		for(OrderTermType cache:maps.values())
		{
			Listitem item = appendItem(cache.display(utils.getLanguage()), cache.name());
			if(ref != null && ref.equals(cache))
				setSelectedItem(item);
		}
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		OrderTermType domain = getDomain();
		if(domain != null)
		{
			IDValueRef ref = new  IDValueRef();
			ref.setId(domain.name());
			ref.setValue(domain.display(utils.getLanguage()));

			return ref;
		}

		return null;
	}

	@Override
	public void setDomainAsRef(IDValueRef ref)
	{
		if(ref != null && !maps.containsKey(ref.getId()))
			maps.put(ref.getId(), OrderTermType.valueOf(ref.getId()));

		for(OrderTermType cache:maps.values())
		{
			Listitem item = appendItem(cache.display(utils.getLanguage()), cache.name());
			if(ref != null && ref.equals(cache))
				setSelectedItem(item);
		}
	}
}
