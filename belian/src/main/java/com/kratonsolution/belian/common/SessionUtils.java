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
import com.kratonsolution.belian.general.dm.CompanyStructure;
import com.kratonsolution.belian.general.dm.Geographic;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.svc.CompanyStructureService;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.global.dm.PrinterType;
import com.kratonsolution.belian.hr.dm.Employment;
import com.kratonsolution.belian.security.app.SecurityInformation;
import com.kratonsolution.belian.security.dm.AccessRole;
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
	private CompanyStructureService companyStructureService;
	
	@Autowired
	private TaxService taxService;
	
	public boolean isEmployee()
	{
		return getEmployee() != null;
	}
	
	public Person getEmployee()
	{
		return getUser().getPerson();
	}

	public boolean isSysAdmin()
	{
		return getUser().getEmail().equals("admin@belian.com");
	}
	
	public User getUser()
	{
		SecurityInformation information = (SecurityInformation)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return service.findOne(information.getUser().getId());
	}

	public List<Organization> getOrganizations()
	{
		List<Organization> list = new ArrayList<Organization>();
		
		if(getUser() != null)
		{
			if(getUser().getEmail().equals("admin@belian.com"))
			{
				for(CompanyStructure com:companyStructureService.findAll())
					list.add(com.getOrganization());
			}
			else
			{
				for(Employment employment:getUser().getEmployee().getEmployments())
				{
					if(employment.isValid())
						list.add(employment.getInternalOrganization().getOrganization());
				}
			}
		}

		return list;
	}

	public List<String> getOrganizationIds()
	{
		List<String> list = new ArrayList<String>();

		if(getUser() != null)
		{
			if(getUser().getEmail().equals("admin@belian.com"))
			{
				for(CompanyStructure com:companyStructureService.findAll())
					list.add(com.getOrganization().getId());
			}
			else
			{
				for(Employment employment:getUser().getEmployee().getEmployments())
				{
					if(employment.isValid())
						list.add(employment.getInternalOrganization().getOrganization().getId());
				}
			}
		}

		return list;
	}

	public boolean hasDefaultOrganization()
	{
		return getOrganization() != null;
	}
	
	public Organization getOrganization()
	{
		if(getUser() != null && getUser().getSetting() != null && !Strings.isNullOrEmpty(getUser().getSetting().getOrganizationId()))
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

		return null;
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
		if(getUser() != null && getUser().getSetting() != null && !Strings.isNullOrEmpty(getUser().getSetting().getCurrencyId()))
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

		return null;
	}

	public Geographic getLocation()
	{
		if(getUser() != null && getUser().getSetting() != null && !Strings.isNullOrEmpty(getUser().getSetting().getLocationId()))
		{
			Geographic geographic = new Geographic();
			geographic.setId(getUser().getSetting().getLocationId());
			geographic.setName(getUser().getSetting().getLocationName());

			return geographic;
		}
		
		return null;
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
		if(getUser().getSetting() == null)
			return "en-US";

		return getUser().getSetting().getLanguage();
	}

	public Tax getTax()
	{
		if(getUser() != null && getUser().getSetting() != null && !Strings.isNullOrEmpty(getUser().getSetting().getTaxId()))
			return taxService.findOne(getUser().getSetting().getTaxId());

		return null;
	}

	public PrinterType getPrinterType()
	{
		if(getUser() != null && getUser().getSetting() != null && getUser().getSetting().getPrinter() != null)
			return getUser().getSetting().getPrinter();

		return PrinterType.POS;
	}

	public boolean isPos()
	{
		return getPrinterType().equals(PrinterType.POS);
	}
}
