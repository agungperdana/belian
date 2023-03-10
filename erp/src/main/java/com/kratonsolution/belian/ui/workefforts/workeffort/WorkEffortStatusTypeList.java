
package com.kratonsolution.belian.ui.workefforts.workeffort;

import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.persistence.IDValueRef;
import com.kratonsolution.belian.ui.component.AbstractList;
import com.kratonsolution.belian.workefforts.dm.WorkEffortStatusType;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class WorkEffortStatusTypeList extends AbstractList<WorkEffortStatusType>
{
	public WorkEffortStatusTypeList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public WorkEffortStatusTypeList(boolean fullspan,WorkEffortStatusType con)
	{
		super();
		
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setSelectedItem(null);
		
		for(WorkEffortStatusType domain:WorkEffortStatusType.values())
		{
			Listitem listitem = appendItem(domain.display(utils.getLanguage()), domain.name());
			if(con != null && con.equals(domain))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(domain.name()))
				maps.put(domain.name(), domain);
		}
	}

	@Override
	public WorkEffortStatusType getDomain()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		WorkEffortStatusType type = getDomain();
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
	public void setDomain(WorkEffortStatusType domain)
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
