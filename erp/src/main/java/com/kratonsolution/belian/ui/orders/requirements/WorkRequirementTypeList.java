
package com.kratonsolution.belian.ui.orders.requirements;

import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.orm.IDValueRef;
import com.kratonsolution.belian.requirement.dm.WorkRequirementType;
import com.kratonsolution.belian.ui.component.AbstractList;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class WorkRequirementTypeList extends AbstractList<WorkRequirementType>
{
	
	public WorkRequirementTypeList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public WorkRequirementTypeList(boolean fullspan,WorkRequirementType con)
	{
		super();
		
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setSelectedItem(null);
		
		for(WorkRequirementType domain:WorkRequirementType.values())
		{
			Listitem listitem = appendItem(domain.display(utils.getLanguage()), domain.name());
			if(con != null && con.equals(domain))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(domain.name()))
				maps.put(domain.name(), domain);
		}
	}

	@Override
	public WorkRequirementType getDomain()
	{
		if(getSelectedItem() != null)
		{
			WorkRequirementType type = WorkRequirementType.valueOf(getSelectedItem().getValue());
			
			if(!maps.containsKey(getSelectedItem().getValue()))
				maps.put(type.name(), type);

			return type;
		}
		
		return null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		WorkRequirementType type = getDomain();
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
	public void setDomain(WorkRequirementType domain)
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
