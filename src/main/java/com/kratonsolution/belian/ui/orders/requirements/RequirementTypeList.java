
package com.kratonsolution.belian.ui.orders.requirements;

import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.requirement.dm.RequirementType;
import com.kratonsolution.belian.ui.component.AbstractList;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class RequirementTypeList extends AbstractList<RequirementType>
{
	
	public RequirementTypeList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public RequirementTypeList(boolean fullspan,RequirementType con)
	{
		super();
		
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setSelectedItem(null);
		
		for(RequirementType domain:RequirementType.values())
		{
			Listitem listitem = appendItem(domain.display(utils.getLanguage()), domain.name());
			if(con != null && con.equals(domain))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(domain.name()))
				maps.put(domain.name(), domain);
		}
	}

	@Override
	public RequirementType getDomain()
	{
		if(getSelectedItem() != null)
		{
			RequirementType type = RequirementType.valueOf(getSelectedItem().getValue());
			
			if(!maps.containsKey(getSelectedItem().getValue()))
				maps.put(type.name(), type);

			return type;
		}
		
		return null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		RequirementType type = getDomain();
		if(type != null)
		{
			IDValueRef ref = new IDValueRef();
			ref.setId(type.name());
			ref.setValue(type.display(utils.getLanguage()));
			
			return ref;
		}
		
		return null;
	}

	@Override
	public void setDomain(RequirementType domain)
	{
		if(domain != null)
		{
			if(!maps.containsKey(domain.name()))
			{
				maps.put(domain.name(), domain);
				setSelectedItem(appendItem(domain.display(utils.getLanguage()), domain.name()));
			}
			else
			{
				for(Listitem item:getItems())
				{
					if(item.getValue().toString().equals(domain.name()))
					{
						setSelectedItem(item);
						break;
					}
				}
			}
		}
	}

	@Override
	public void setDomainAsRef(IDValueRef ref)
	{
		
	}
}
