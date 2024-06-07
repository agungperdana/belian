
package com.kratonsolution.belian.ui.workefforts.workeffort;

import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.orm.IDValueRef;
import com.kratonsolution.belian.ui.component.AbstractList;
import com.kratonsolution.belian.workefforts.dm.WorkEffortType;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class WorkEffortTypeList extends AbstractList<WorkEffortType>
{
	
	public WorkEffortTypeList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public WorkEffortTypeList(boolean fullspan,WorkEffortType con)
	{
		super();
		
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setSelectedItem(null);
		
		for(WorkEffortType domain:WorkEffortType.values())
		{
			Listitem listitem = appendItem(domain.display(utils.getLanguage()), domain.name());
			if(con != null && con.equals(domain))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(domain.name()))
				maps.put(domain.name(), domain);
		}
	}

	@Override
	public WorkEffortType getDomain()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		WorkEffortType type = getDomain();
		if( type != null)
		{
			IDValueRef ref = new IDValueRef();
			ref.setId(type.name());
			ref.setValue(type.display(utils.getLanguage()));
			
			return ref;
		}
		
		return null;
	}

	@Override
	public void setDomain(WorkEffortType domain)
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
