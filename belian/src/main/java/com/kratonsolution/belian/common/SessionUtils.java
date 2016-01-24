/**
 * 
 */
package com.kratonsolution.belian.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.dm.Tax;
import com.kratonsolution.belian.accounting.svc.CurrencyService;
import com.kratonsolution.belian.accounting.svc.TaxService;
import com.kratonsolution.belian.general.dm.Address;
import com.kratonsolution.belian.general.dm.Geographic;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.security.app.SecurityInformation;
import com.kratonsolution.belian.security.dm.AccessRole;
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
	
	@Autowired
	private CurrencyService currencyService;
	
	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private TaxService taxService;
	
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
	
	public List<String> getOrganizationIds()
	{
		List<String> list = new ArrayList<String>();
		
		for(UserRole role:getUser().getRoles())
		{
			if(role.isEnabled())
			{
				for(AccessibleOrganization organization:role.getRole().getOrganizations())
				{
					if(organization.isSelected())
						list.add(organization.getOrganization().getId());
				}
			}
		}
			
		return list;
	}
	
	public Organization getOrganization()
	{
		Organization organization = organizationService.findOne(getUser().getSetting().getOrganizationId());
		if(organization == null)
		{
			organization = new Organization();
			organization.setId(getUser().getSetting().getOrganizationId());
			organization.setName(getUser().getSetting().getOrganizationName());
		}
		
		return organization;
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
		Currency currency = currencyService.findOne(getUser().getSetting().getCurrencyId());
		if(currency == null)
		{
			currency = new Currency();
			currency.setId(getUser().getSetting().getCurrencyId());
			currency.setName(getUser().getSetting().getCurrencyName());
		}
		
		return currency;
	}
	
	public Geographic getLocation()
	{
		Geographic geographic = new Geographic();
		geographic.setId(getUser().getSetting().getLocationId());
		geographic.setName(getUser().getSetting().getLocationName());
		
		return geographic;
	}
	
	public Map<String,Boolean> getAccessibleModules()
	{
		Map<String,Boolean> modules = new HashMap<String,Boolean>();
		
		for(UserRole role:getUser().getRoles())
		{
			if(role.isEnabled())
			{
				for(AccessRole accessRole:role.getRole().getAccesses())
				{
					if(!modules.containsKey(accessRole.getModule().getCode()))
						modules.put(accessRole.getModule().getCode(),accessRole.isCanRead());
				}
			}
		}
		
		return modules;
	}
	
	public int getRowPerPage()
	{
		if(getUser() == null || getUser().getSetting() == null)
			return 25;
		
		return getUser().getSetting().getRowPerPage();
	}
	
	public String getLanguage()
	{
		return getUser().getSetting().getLanguage();
	}
	
	public Tax getTax()
	{
		if(getUser() != null && getUser().getSetting() != null && !Strings.isNullOrEmpty(getUser().getSetting().getTaxId()))
			return taxService.findOne(getUser().getSetting().getTaxId());
			
		return null;
	}
}
