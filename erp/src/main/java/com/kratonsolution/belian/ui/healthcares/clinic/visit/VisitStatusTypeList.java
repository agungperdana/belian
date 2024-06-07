
package com.kratonsolution.belian.ui.healthcares.clinic.visit;

import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.orm.IDValueRef;
import com.kratonsolution.belian.healtcares.dm.VisitStatusType;
import com.kratonsolution.belian.ui.component.AbstractList;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class VisitStatusTypeList extends AbstractList<VisitStatusType>
{	
	public VisitStatusTypeList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public VisitStatusTypeList(boolean fullspan,VisitStatusType con)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		setSelectedItem(null);
		
		for(VisitStatusType type:VisitStatusType.values())
		{
			Listitem listitem = appendItem(type.display(utils.getLanguage()), type.name());
			if(con != null && con.equals(type))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(type.name()))
				maps.put(type.name(), type);
		}
	}

	@Override
	public VisitStatusType getDomain()
	{
		return getSelectedItem()!=null?VisitStatusType.valueOf(getSelectedItem().getValue()):null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		return null;
	}

	@Override
	public void setDomain(VisitStatusType domain)
	{
		if(domain != null)
		{
			getItems().clear();
			
			if(!maps.containsKey(domain.name()))
				maps.put(domain.name(), domain);
			
			for(VisitStatusType type:maps.values())
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
		// TODO Auto-generated method stub
		
	}
}
