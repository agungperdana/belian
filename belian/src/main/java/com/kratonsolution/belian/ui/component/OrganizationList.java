/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class OrganizationList extends Listbox implements Serializable
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private Map<String,Organization> maps = new HashMap<>();
	
	public OrganizationList()
	{
		setWidth("300px");
		setMold("select");
		
		for(Organization organization:utils.getOrganizations())
		{
			Listitem item = appendItem(organization.getName(),organization.getId());
			if(!maps.containsKey(organization.getId()))
				maps.put(organization.getId(),organization);
		
			if(utils.getOrganization() != null && organization.getId().equals(utils.getOrganization().getId()))
				setSelectedItem(item);
		}
		
		if(getSelectedItem() == null && !getItems().isEmpty())
			setSelectedIndex(0);
	}
	
	public Organization getOrganization()
	{
		if(getSelectedItem() == null)
		{
			Clients.showNotification("Please select organization first.");
			return null;
		}
			
		return maps.get(getSelectedItem().getValue().toString());	
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
