/**
 * 
 */
package com.kratonsolution.belian.ui.general.companystructure;

import org.zkoss.zul.Listitem;

import com.google.common.base.Strings;
import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.partys.dm.Organization;
import com.kratonsolution.belian.ui.component.AbstractList;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CompanyStructureList extends AbstractList<Organization>
{		
	public CompanyStructureList(boolean fullspan)
	{
		this(fullspan,null);
	}

	public CompanyStructureList(boolean fullspan,Organization organization)
	{
		super();
		
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");

		setMold("select");
		
		for(Organization com:utils.getGrantedOrganizations())
		{
			Listitem listitem = appendItem(com.getName(), com.getId());
			
			if(utils.getOrganization() != null && utils.getOrganization().getId().equals(com.getId()))
				setSelectedItem(listitem);
			
			if(organization != null && organization.getId().equals(com.getId()))
				setSelectedItem(listitem);

			if(!maps.containsKey(com.getId()))
				maps.put(com.getId(), com);
		}

	}

	@Override
	public Organization getDomain()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue()))
			return maps.get(getSelectedItem().getValue());

		return null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		if(getSelectedItem() != null)
		{
			IDValueRef ref = new IDValueRef();
			ref.setId(getSelectedItem().getValue().toString());
			ref.setValue(getSelectedItem().getLabel().toString());
			ref.setType("Organization");
			
			return ref;
		}

		return null;
	}

	@Override
	public void setDomain(Organization com)
	{
		setDomainAsRef(IDValueRef.toRef(com));
	}

	@Override
	public void setDomainAsRef(IDValueRef com)
	{
		if(com != null && !Strings.isNullOrEmpty(com.getId()))
		{
			getItems().clear();

			if(com != null && !maps.containsKey(com.getId()))
				maps.put(com.getId(), new Organization(com));
			
			for(Organization org:maps.values())
			{
				Listitem item = appendItem(org.getName(), org.getId());

				if(com != null && org.getId().equals(com.getId()))
					setSelectedItem(item);
			}
		}
	}
}
