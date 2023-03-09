
package com.kratonsolution.belian.ui.global;

import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.global.dm.StatusType;
import com.kratonsolution.belian.ui.component.AbstractList;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StatusTypeList extends AbstractList<StatusType>
{
	public StatusTypeList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public StatusTypeList(boolean fullspan,StatusType con)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		setSelectedItem(null);
		
		for(StatusType type:StatusType.values())
		{
			Listitem listitem = appendItem(type.display(utils.getLanguage()), type.name());
			if(con != null && con.equals(type))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(type.name()))
				maps.put(type.name(), type);
		}
	}

	@Override
	public StatusType getDomain()
	{
		return getSelectedItem()!=null?StatusType.valueOf(getSelectedItem().getValue()):null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		StatusType type = getDomain();
		if(type != null)
		{
			IDValueRef ref = new IDValueRef();
			ref.setId(type.name());
			ref.setValue(type.display());
			
			return ref;
		}
		
		return null;
	}

	@Override
	public void setDomain(StatusType domain)
	{
		if(domain != null)
		{
			getItems().clear();
			
			if(!maps.containsKey(domain.name()))
				maps.put(domain.name(), domain);
			
			for(StatusType type:maps.values())
			{
				Listitem listitem = appendItem(type.display(utils.getLanguage()), type.name());
				if(type.equals(domain))
					setSelectedItem(listitem);
			}
		}
	}

	@Override
	public void setDomainAsRef(IDValueRef ref)
	{
	}
}
