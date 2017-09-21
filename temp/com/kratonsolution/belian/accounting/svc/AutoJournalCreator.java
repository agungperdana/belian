/**
 * 
 */
package com.kratonsolution.belian.accounting.svc;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.kratonsolution.belian.accounting.dm.AccountingPeriod;
import com.kratonsolution.belian.accounting.dm.AccountingPeriodRepository;
import com.kratonsolution.belian.accounting.dm.AutoJournalSetting;
import com.kratonsolution.belian.accounting.dm.AutoJournalSettingRepository;
import com.kratonsolution.belian.accounting.dm.JournalEntry;
import com.kratonsolution.belian.accounting.dm.OrganizationAccount;
import com.kratonsolution.belian.accounting.dm.OrganizationAccountRepository;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.CompanyStructure;
import com.kratonsolution.belian.general.dm.CompanyStructureRepository;
import com.kratonsolution.belian.general.dm.CompanyStructureType;
import com.kratonsolution.belian.partys.dm.Organization;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class AutoJournalCreator<E extends Journalable>
{
	@Autowired
	protected AutoJournalSettingRepository repository;
	
	@Autowired
	protected OrganizationAccountRepository coaRepo;
	
	@Autowired
	protected AccountingPeriodRepository periodRepo;

	@Autowired
	protected CompanyStructureRepository structureRepo;
	
	@Autowired
	protected SessionUtils utils;
	
	public abstract boolean isSupported(Object target);
	
	public abstract JournalEntry generate(E e);
	
	protected AutoJournalSetting getAutoJournalSetting(Organization organization)
	{
		CompanyStructure structure = structureRepo.findOneByOrganizationId(organization.getId());
		if(structure == null)
			throw new RuntimeException();

		if(!structure.getType().equals(CompanyStructureType.BRANCH))
			return getAutoJournalSetting(structure.getParent().getOrganization());
		else
			return repository.findOneByOrganizationId(organization.getId());
	}

	protected OrganizationAccount getCOA(Organization organization)
	{
		CompanyStructure structure = structureRepo.findOneByOrganizationId(organization.getId());
		if(structure == null)
			throw new RuntimeException();
		
		if(!structure.getType().equals(CompanyStructureType.BRANCH))
			return getCOA(structure.getParent().getOrganization());
		else
			return coaRepo.findOneByOrganizationId(organization.getId());
	}
	
	protected AccountingPeriod getAccountingPeriod(Organization organization,Date date)
	{
		CompanyStructure structure = structureRepo.findOneByOrganizationId(organization.getId());
		if(structure == null)
			throw new RuntimeException();
		
		if(!structure.getType().equals(CompanyStructureType.BRANCH))
			return getAccountingPeriod(structure.getParent().getOrganization(),date);
		else
			return periodRepo.findOneOpenChild(organization.getId(),date);
	}
}
