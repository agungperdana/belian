package com.kratonsolution.belian.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.common.app.Language;
import com.kratonsolution.belian.core.companystructure.impl.application.CompanyStructureService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.dm.Tax;
import com.kratonsolution.belian.accounting.svc.CurrencyService;
import com.kratonsolution.belian.accounting.svc.TaxService;
import com.kratonsolution.belian.common.orm.IDValueRef;
import com.kratonsolution.belian.core.geographic.impl.orm.Geographic;
import com.kratonsolution.belian.global.dm.PrinterType;
import com.kratonsolution.belian.global.dm.UserSettingRepository;
import com.kratonsolution.belian.hr.dm.Employee;
import com.kratonsolution.belian.hr.dm.EmployeeRepository;
import com.kratonsolution.belian.hr.dm.Employment;
import com.kratonsolution.belian.hr.dm.EmploymentRepository;
import com.kratonsolution.belian.facility.impl.orm.Facility;
import com.kratonsolution.belian.core.party.impl.orm.Organization;
import com.kratonsolution.belian.core.party.impl.orm.Party;
import com.kratonsolution.belian.core.party.impl.orm.Person;
import com.kratonsolution.belian.core.party.impl.application.OrganizationService;
import com.kratonsolution.belian.core.party.impl.application.PartyService;
import com.kratonsolution.belian.authentication.Authority;
import com.kratonsolution.belian.authentication.SecurityInformation;
import com.kratonsolution.belian.access.user.impl.orm.User;
import com.kratonsolution.belian.access.user.impl.application.UserService;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
@Service
@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
@AllArgsConstructor
public class SessionUtils
{
	private Language lang;

	private UserService service;

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
//		if(information.getUser().getSetting() != null)
//			information.getUser().setSetting(settingRepo.findById(information.getUser().getSetting().getId()).orElse(null));
		
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
			Employee employee = employeeRepo.findByUsername(logedin.getUserName());
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
//		if(getUser() != null && getUser().getSetting() != null &&
//		   getUser().getSetting().getOrganization()!= null &&
//		   !Strings.isNullOrEmpty(getUser().getSetting().getOrganization().getId()))
//		{
//			Organization organization = organizationService.findById(getUser().getSetting().getOrganization().getId());
//			if(organization == null)
//			{
//				organization = new Organization();
//				organization.setId(getUser().getSetting().getOrganization().getId());
//				organization.setName(getUser().getSetting().getOrganization().getValue());
//			}
//
//			return organization;
//		}

		// return empty organization instance for now, need to change it to actual object
		return new Organization();
	}
	
	public Facility getFacility()
	{
//		if(getUser() != null && getUser().getSetting() != null && getUser().getSetting().getFacility()!= null && !Strings.isNullOrEmpty(getUser().getSetting().getFacility().getId()))
//			return new Facility(getUser().getSetting().getFacility());

		// TODO: return actual facility
		return new Facility();
	}

	public List<Geographic> getLocations()
	{
		List<Geographic> locations = new ArrayList<Geographic>();

		return locations;
	}

	public Currency getCurrency()
	{
//		if(getUser() != null && getUser().getSetting() != null &&
//			getUser().getSetting().getCurrency() != null &&
//			!Strings.isNullOrEmpty(getUser().getSetting().getCurrency().getId()))
//	{
//		Currency currency = currencyService.findById(getUser().getSetting().getCurrency().getId());
//		if(currency == null)
//		{
//			currency = new Currency();
//			currency.setId(getUser().getSetting().getCurrency().getId());
//			currency.setName(getUser().getSetting().getCurrency().getValue());
//		}
//
//		return currency;
//	}

		// TODO: return actual currency
		return new Currency();
	}

	public Geographic getLocation()
	{
//		if(getUser() != null && getUser().getSetting() != null &&
//		   getUser().getSetting().getLocation() != null &&
//		  !Strings.isNullOrEmpty(getUser().getSetting().getLocation().getId()))
//		{
//			Geographic geographic = new Geographic();
//			geographic.setId(getUser().getSetting().getLocation().getId());
//			geographic.setName(getUser().getSetting().getLocation().getValue());
//
//			return geographic;
//		}

		// TODO: return actual geographic instance
		return new Geographic();
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
//		if(getUser() == null || getUser().getSetting() == null)
//			return 25;
//
//		return getUser().getSetting().getRowPerPage();

		// TODO: return actual row-per-page based on user seting
		return 50;
	}

	public String getLanguage()
	{
//		if(getUser().getSetting() == null)
//			return "en_us";
//
//		return getUser().getSetting().getLanguage();

		// TODO: return actual language
		return "en_us";
	}

	public Tax getTax()
	{
//		if(getUser() != null && getUser().getSetting() != null &&
//		   getUser().getSetting().getTax() != null &&
//		   !Strings.isNullOrEmpty(getUser().getSetting().getTax().getId()))
//
//			return taxService.findById(getUser().getSetting().getTax().getId());

		// TODO: return actual tax instance
		return new Tax();
	}

	public PrinterType getPrinterType()
	{
//		if(getUser() != null && getUser().getSetting() != null && getUser().getSetting().getPrinter() != null)
//			return getUser().getSetting().getPrinter();

		// TODO: return actual printer-type
		return PrinterType.POS;
	}

	public boolean isPos()
	{
		return getPrinterType().equals(PrinterType.POS);
	}
	
	public String getPersonId()
	{
		Employee employee = employeeRepo.findByUsername(getUser().getUserName());
		if(employee != null)
			return employee.getParty().getId();
	
		return null;
	}
	
	public Person getPerson()
	{
		Employee employee = employeeRepo.findByUsername(getUser().getUserName());
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
