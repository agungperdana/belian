/**
 * 
 */
package com.kratonsolution.belian.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.general.dm.Address;
import com.kratonsolution.belian.general.dm.Geographic;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.security.app.SecurityInformation;
import com.kratonsolution.belian.security.dm.AccessibleOrganization;
import com.kratonsolution.belian.security.dm.User;
import com.kratonsolution.belian.security.dm.UserRole;
import com.kratonsolution.belian.security.svc.UserService;


/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
public class SessionUtils
{
	@Autowired
	private UserService service;
	
	public User getUser()
	{
		SecurityInformation information = (SecurityInformation)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return service.findOne(information.getUser().getId());
				
	}
	
	public List<Organization> getOrganizations()
	{
		List<Organization> list = new ArrayList<Organization>();
		
		for(UserRole role:getUser().getRoles())
		{
			if(role.isEnabled())
			{
				for(AccessibleOrganization organization:role.getRole().getOrganizations())
				{
					if(organization.isSelected())
						list.add(organization.getOrganization());
				}
			}
		}
			
		return list;
	}
	
	public Organization getOrganization()
	{
		return getUser().getSetting().getOrganization();
	}
	
	public List<Geographic> getLocations()
	{
		List<Geographic> locations = new ArrayList<Geographic>();
		
		for(Organization organization:getOrganizations())
		{
			for(Address address:organization.getAddresses())
				locations.add(address.getCity());
		}
		
		return locations;
	}
	
	public Currency getCurrency()
	{
		return getUser().getSetting().getCurrency();
	}
	
	public Geographic getLocation()
	{
		return getUser().getSetting().getLocation();
	}
	
	public String getLanguage()
	{
		return getUser().getSetting().getLanguage();
	}
}
