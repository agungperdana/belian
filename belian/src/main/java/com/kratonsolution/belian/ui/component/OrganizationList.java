/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.io.Serializable;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class OrganizationList extends Listbox implements Serializable
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	public OrganizationList()
	{
		setWidth("300px");
		setMold("select");
		
		for(Organization organization:utils.getOrganizations())
		{
			appendItem(organization.getName(),organization.getId());
			getAttributes().put(organization.getId(),organization);
		}
		
		if(getItems().size() > 0)
			setSelectedIndex(0);
	}
	
	public Organization getOrganization()
	{
		return organizationService.findOne(Components.string(this));	
	}
	
	public void setOrganization(Organization organization)
	{
		if(organization != null)
		{
			for(Listitem listitem:getItems())
			{
				if(listitem.getValue().toString().equals(organization.getId()))
				{
					setSelectedItem(listitem);
					break;
				}
			}
		}
	}
}
