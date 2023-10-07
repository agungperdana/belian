package com.kratonsolution.belian.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.kratonsolution.belian.common.util.DateTimes;
import com.kratonsolution.belian.company.structure.impl.application.CompanyStructureService;
import com.kratonsolution.belian.geographic.impl.orm.Geographic;
import com.kratonsolution.belian.party.impl.orm.Organization;
import com.kratonsolution.belian.party.impl.orm.Party;
import com.kratonsolution.belian.party.impl.orm.Person;
import com.kratonsolution.belian.user.impl.orm.PrinterType;
import com.kratonsolution.belian.user.impl.orm.UserSettingRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.dm.Tax;
import com.kratonsolution.belian.accounting.svc.CurrencyService;
import com.kratonsolution.belian.accounting.svc.TaxService;
import com.kratonsolution.belian.common.persistence.IDValueRef;
import com.kratonsolution.belian.hr.dm.Employee;
import com.kratonsolution.belian.hr.dm.EmployeeRepository;
import com.kratonsolution.belian.hr.dm.Employment;
import com.kratonsolution.belian.hr.dm.EmploymentRepository;
import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.partys.svc.OrganizationService;
import com.kratonsolution.belian.partys.svc.PartyService;
import com.kratonsolution.belian.security.impl.app.Authority;
import com.kratonsolution.belian.security.impl.app.SecurityInformation;
import com.kratonsolution.belian.user.impl.orm.User;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
@AllArgsConstructor
@Service
@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
public class SessionUtils
{
	private Language lang;

	private UserSettingRepository settingRepo;

	private CurrencyService currencyService;

	private OrganizationService organizationService;

	private CompanyStructureService companyStructureService;
	
	private EmployeeRepository employeeRepo;

	private EmploymentRepository employmentRepo;
	
	private TaxService taxService;
	
	private PartyService partyService;
		
	public User getUser()
	{
		SecurityInformation information = (SecurityInformation)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(information.getUser() == null)
			throw new RuntimeException(lang.get("message.user.empty"));
		
		//Update user setting with latest from database
		if(information.getUser().getSetting() != null)
			information.getUser().setSetting(settingRepo.getOne(information.getUser().getSetting().getId()));
		
		return information.getUser();
	}
	
	public Collection<Organization> getGrantedOrganizations()
	{
		Vector<Organization> vectors = new Vector<>();
		
		User logedin = getUser();

		if(logedin.getUserName().equals("admin@belian.com"))
			vectors.addAll(companyStructureService.findAllAsOrganizations());
		else
		{
			Employee employee = employeeRepo.getOneByUsername(logedin.getUserName());
			if(employee != null)
			{
				List<Employment> employments = employmentRepo.findAll(employee.getId(),employee.getParty().getId(), DateTimes.currentDate());
				for(Employment emp:employments)
				{
					if(emp.getToParty() instanceof Organization)
					{
						Organization parent = (Organization)emp.getToParty();
						vectors.add(parent);
						vectors.addAll(companyStructureService.findAllChild(parent));
					}
				}
			}
		}
		
		return vectors;
	}

	public List<String> getOrganizationIds()
	{
		List<String> granted = new ArrayList();

		for(Organization organization:getGrantedOrganizations())
			granted.add(organization.getId());
		
		return granted;
	}
	
	public Organization getOrganization()
	{
		if(getUser() != null && getUser().getSetting() != null && 
		   getUser().getSetting().getOrganization()!= null && 
		   !Strings.isNullOrEmpty(getUser().getSetting().getOrganization().getId()))
		{
			Organization organization = organizationService.getOne(getUser().getSetting().getOrganization().getId());
			if(organization == null)
			{
				organization = new Organization();
				organization.setId(getUser().getSetting().getOrganization().getId());
				organization.setName(getUser().getSetting().getOrganization().getValue());
			}

			return organization;
		}

		return null;
	}
	
	public Facility getFacility()
	{
		if(getUser() != null && getUser().getSetting() != null && getUser().getSetting().getFacility()!= null && !Strings.isNullOrEmpty(getUser().getSetting().getFacility().getId()))
			return new Facility(getUser().getSetting().getFacility());

		return null;
	}

	public List<Geographic> getLocations()
	{
		List<Geographic> locations = new ArrayList<Geographic>();

		return locations;
	}

	public Currency getCurrency()
	{
		if(getUser() != null && getUser().getSetting() != null && 
		   getUser().getSetting().getCurrency() != null &&
		  !Strings.isNullOrEmpty(getUser().getSetting().getCurrency().getId()))
		{
			Currency currency = currencyService.getOne(getUser().getSetting().getCurrency().getId());
			if(currency == null)
			{
				currency = new Currency();
				currency.setId(getUser().getSetting().getCurrency().getId());
				currency.setName(getUser().getSetting().getCurrency().getValue());
			}
			
			return currency;
		}

		return null;
	}

	public Geographic getLocation()
	{
		if(getUser() != null && getUser().getSetting() != null && 
		   getUser().getSetting().getLocation() != null &&
		  !Strings.isNullOrEmpty(getUser().getSetting().getLocation().getId()))
		{
			Geographic geographic = new Geographic();
			geographic.setId(getUser().getSetting().getLocation().getId());
			geographic.setName(getUser().getSetting().getLocation().getValue());

			return geographic;
		}
		
		return null;
	}

	public Map<String,Boolean> getAccessibleModules()
	{
		Map<String,Boolean> modules = new HashMap<String,Boolean>();

		SecurityInformation information = (SecurityInformation)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(information != null)
		{
			for(Authority authority:information.getAuthorities())
				modules.put(authority.toString(),true);
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
			return "en_us";

		return getUser().getSetting().getLanguage();
	}

	public Tax getTax()
	{
		if(getUser() != null && getUser().getSetting() != null && 
		   getUser().getSetting().getTax() != null &&
		   !Strings.isNullOrEmpty(getUser().getSetting().getTax().getId()))

			return taxService.getOne(getUser().getSetting().getTax().getId());

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
	
	public String getPersonId()
	{
		Employee employee = employeeRepo.getOneByUsername(getUser().getUserName());
		if(employee != null)
			return employee.getParty().getId();
	
		return null;
	}
	
	public Person getPerson()
	{
		Employee employee = employeeRepo.getOneByUsername(getUser().getUserName());
		if(employee != null && employee.getParty() instanceof Person)
			return (Person)employee.getParty();
	
		return null;
	}
	
	public IDValueRef getAnonymouseCustomer()
	{
		Party party = partyService.findByCode("ANS");
		if(party != null)
			return party.toRef();
		
		IDValueRef ref = new IDValueRef();
		ref.setId("0");
		ref.setValue("ANONYMOUS");
		
		return ref;
	}
}
