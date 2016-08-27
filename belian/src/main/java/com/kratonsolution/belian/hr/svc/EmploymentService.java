/**
 * 
 */
package com.kratonsolution.belian.hr.svc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.dm.CurrencyRepository;
import com.kratonsolution.belian.accounting.dm.Tax;
import com.kratonsolution.belian.accounting.dm.TaxRepository;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.effort.dm.TimeEntry;
import com.kratonsolution.belian.effort.dm.TimeEntryRepository;
import com.kratonsolution.belian.general.dm.InternalOrganization;
import com.kratonsolution.belian.general.dm.InternalOrganizationRepository;
import com.kratonsolution.belian.general.dm.UOMFactor;
import com.kratonsolution.belian.general.dm.UOMFactorRepository;
import com.kratonsolution.belian.general.dm.UnitOfMeasure;
import com.kratonsolution.belian.general.dm.UnitOfMeasureRepository;
import com.kratonsolution.belian.global.dm.UserSetting;
import com.kratonsolution.belian.global.dm.UserSettingRepository;
import com.kratonsolution.belian.hr.dm.Benefit;
import com.kratonsolution.belian.hr.dm.Employee;
import com.kratonsolution.belian.hr.dm.EmployeeRepository;
import com.kratonsolution.belian.hr.dm.Employment;
import com.kratonsolution.belian.hr.dm.EmploymentRepository;
import com.kratonsolution.belian.hr.dm.PayHistory;
import com.kratonsolution.belian.hr.dm.PayrollPreference;
import com.kratonsolution.belian.security.dm.Role;
import com.kratonsolution.belian.security.dm.User;
import com.kratonsolution.belian.security.dm.UserRole;
import com.kratonsolution.belian.security.svc.RoleService;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class EmploymentService
{
	@Autowired
	private UOMFactorRepository factorRepo;

	@Autowired
	private UnitOfMeasureRepository measureRepo;
	
	@Autowired
	private EmploymentRepository repository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private InternalOrganizationRepository intOrgRepository;

	@Autowired
	private UserSettingRepository settingRepo;
	
	@Autowired
	private TaxRepository taxRepository;

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private CurrencyRepository currencyRepository;
	
	@Autowired
	private RoleService roleService;

	@Autowired
	private TimeEntryRepository timeEntryRepo;
	
	@Autowired
	private SessionUtils utils;
		
	@Secured("ROLE_EMPLOYMENT_READ")
	public Employment findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_EMPLOYMENT_READ")
	public Employment findOne(Employee employee)
	{
		if(employee != null)
			return repository.findOneByEmployeeId(employee.getId());
	
		return null;
	}
	
	@Secured("ROLE_EMPLOYMENT_READ")
	public List<Employment> findAll()
	{
		if(utils.getOrganizationIds() != null && !utils.getOrganizationIds().isEmpty())
			return repository.findAll(utils.getOrganizationIds());
			
		return repository.findAll();
	}
	
	@Secured("ROLE_EMPLOYMENT_READ")
	public List<Employment> findAll(String key)
	{
		if(Strings.isNullOrEmpty(key))
			return findAll();
		
		return repository.findAll(utils.getOrganizationIds(),key);
	}
	
	@Secured("ROLE_EMPLOYMENT_READ")
	public List<Employment> findAllIn(List<String> organizations)
	{
		return repository.findAll(organizations);
	}
	
	@Secured("ROLE_EMPLOYMENT_READ")
	public int getSize()
	{
		if(utils.isSysAdmin())
			return (int)repository.count();
		
		return repository.count(utils.getOrganization().getId()).intValue();
	}
	
	@Secured("ROLE_EMPLOYMENT_CREATE")
	public void add(Employment employment)
	{
		Employee employee = employeeRepository.findOneByPartyId(employment.getEmployee().getParty().getId());
		if(employee != null)
			employment.setEmployee(employee);
		else
		{
			User user = new User();
			user.setDeleteable(false);
			user.setEnabled(true);
			user.setEmail(employment.getEmployee().getParty().getName());
			user.setPassword(new StrongPasswordEncryptor().encryptPassword(employment.getEmployee().getParty().getName()));

			UserSetting setting = new UserSetting();
			setting.setOrganizationId(employment.getInternalOrganization().getParty().getId());
			setting.setOrganizationName(employment.getInternalOrganization().getParty().getName());
			setting.setLanguage("in_ID");
			
			Tax tax = taxRepository.findDefault();
			if(tax != null)
			{
				setting.setTaxId(tax.getId());
				setting.setTaxName(tax.getName());
			}
			
			Currency currency = currencyRepository.findDefault();
			if(currency != null)
			{
				setting.setCurrencyId(currency.getId());
				setting.setCurrencyName(currency.getName());
			}
			
			user.setSetting(setting);
			
			employment.getEmployee().setStart(employment.getStart());
			employment.getEmployee().setEnd(employment.getEnd());
			employment.getEmployee().setUser(user);
			
			
			for(Role role:roleService.findAll())
			{
				UserRole userRole = new UserRole();
				userRole.setEnabled(role.isMandatory());
				userRole.setRole(role);
				userRole.setUser(user);
				
				user.getRoles().add(userRole);
			}
			
			settingRepo.save(setting);
			employeeRepository.save(employment.getEmployee());
		}
		
		InternalOrganization organization = intOrgRepository.findOneByPartyId(employment.getInternalOrganization().getParty().getId());
		if(organization != null)
			employment.setInternalOrganization(organization);
		else
		{
			employment.getInternalOrganization().setStart(employment.getStart());
			employment.getInternalOrganization().setEnd(employment.getEnd());
			
			intOrgRepository.save(employment.getInternalOrganization());
		}
		
		repository.save(employment);
	}
	
	@Secured("ROLE_EMPLOYMENT_UPDATE")
	public void edit(Employment employment,Collection<PayHistory> salarys,Collection<Benefit> benefits,Collection<PayrollPreference> payrolls)
	{
		employment.getPreferences().clear();
		employment.getSalarys().clear();
		employment.getBenefits().clear();
		repository.saveAndFlush(employment);
		
		employment.getSalarys().addAll(salarys);
		employment.getBenefits().addAll(benefits);
		employment.getPreferences().addAll(payrolls);
		repository.saveAndFlush(employment);
	}
	
	@Secured("ROLE_EMPLOYMENT_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_EMPLOYMENT_READ")
	public List<Employment> findAll(int pageIndex,int itemsSize)
	{
		if(utils.isSysAdmin())
			return repository.findAll(new PageRequest(pageIndex, itemsSize)).getContent();
		
		if(utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();
		
		return repository.findAll(new PageRequest(pageIndex, itemsSize),utils.getOrganizationIds());
	}
	
	public BigDecimal getGross(Employment employment,Date date,Date start,Date end)
	{
		BigDecimal salary = BigDecimal.ZERO;
		BigDecimal gross = BigDecimal.ZERO;
		
		UnitOfMeasure hour = measureRepo.findOneByName("Hour");
		if(hour == null)
			throw new RuntimeException("Unit of Measure (Hour) doesnot exist or with deference name,please provide or change it first to (Hour).");
		
		for(PayHistory history:employment.getSalarys())
		{
			if(DateTimes.inRange(date,history.getStart(),history.getEnd()))
			{
				//check if this pay history in smallest uom (hour)
				if(history.getUom().getId().equals(hour.getId()))
					salary = history.getAmount();
				else
				{
					//uom of pay history not in smallest value,find multiplying factor to hour.
					for(UOMFactor factor:history.getUom().getFactors())
					{
						if(factor.getTo().getId().equals(hour.getId()))
						{
							salary = history.getAmount().divide(factor.getFactor(),RoundingMode.HALF_EVEN);
							break;
						}
					}
				}
				
				if(salary.compareTo(BigDecimal.ZERO) == 0)
					throw new RuntimeException("Salary/unit of measure not defined correctly.");
				
				break;
			}
		}
		
		List<TimeEntry> entrys = timeEntryRepo.findAllUnpaid(employment.getEmployee().getParty().getId(), start, end);
		if(entrys.isEmpty())
			throw new RuntimeException(employment.getEmployee().getParty().getName()+" doesnot have payable time entry.");

		for(TimeEntry entry:entrys)
			gross = gross.add(entry.getHour().multiply(salary));
		
		for(Benefit benefit:employment.getBenefits())
			gross = gross.add(benefit.getCost().multiply(benefit.getEmployerPaid()).divide(BigDecimal.valueOf(100),RoundingMode.HALF_EVEN));
		
		return gross;
	}
}
