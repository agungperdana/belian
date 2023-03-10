
package com.kratonsolution.belian.ui.orders;

import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.persistence.IDValueRef;
import com.kratonsolution.belian.orders.dm.RoleType;
import com.kratonsolution.belian.ui.component.AbstractList;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class RoleTypeList extends AbstractList<RoleType>
{	
	public RoleTypeList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public RoleTypeList(boolean fullspan,RoleType type)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		setSelectedItem(null);

		getItems().clear();
		
		for(RoleType domain:RoleType.values())
		{
			Listitem listitem = appendItem(domain.display(utils.getLanguage()), domain.name());
			if(type != null && type.equals(domain))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(domain.name()))
				maps.put(domain.name(), domain);
		}
	}

	@Override
	public RoleType getDomain()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDomain(RoleType domain)
	{
		if(domain != null)
		{
			getItems().clear();
			setSelectedItem(appendItem(domain.display(utils.getLanguage()), domain.name()));
			
			if(!maps.containsKey(domain.name()))
				maps.put(domain.name(), domain);
		}
	}

	@Override
	public void setDomainAsRef(IDValueRef ref)
	{
		// TODO Auto-generated method stub
		
	}
}
