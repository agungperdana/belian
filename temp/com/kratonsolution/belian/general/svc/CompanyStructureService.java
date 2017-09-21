/**
 * 
 */
package com.kratonsolution.belian.general.svc;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.dm.CompanyStructure;
import com.kratonsolution.belian.general.dm.CompanyStructureRepository;
import com.kratonsolution.belian.partys.dm.Party;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CompanyStructureService
{	
	@Autowired
	private CompanyStructureRepository repository;

	@Secured("ROLE_COMPANY_STRUCTURE_READ")
	public CompanyStructure findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured({"ROLE_COMPANY_STRUCTURE_READ","ROLE_SYSTEM_READ"})
	public CompanyStructure byOrganization(String organization)
	{
		return repository.findOneByOrganizationId(organization);
	}

	@Secured("ROLE_COMPANY_STRUCTURE_READ")
	public List<CompanyStructure> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_COMPANY_STRUCTURE_READ")
	public List<CompanyStructure> findAllCompany(Date date)
	{
		if(date == null)
			return repository.findAllCompany(DateTimes.currentDate());
		else
			return repository.findAllCompany(date);
	}
	
	@Secured("ROLE_COMPANY_STRUCTURE_READ")
	public List<String> findAllOrganizationId()
	{
		return repository.findAllOrganizationId();
	}
	
	@Secured("ROLE_COMPANY_STRUCTURE_READ")
	public List<CompanyStructure> findAllParent()
	{
		return repository.findAllParent();
	}

	@Secured("ROLE_COMPANY_STRUCTURE_READ")
	public List<CompanyStructure> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}

	@Secured("ROLE_COMPANY_STRUCTURE_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}

	@Secured("ROLE_COMPANY_STRUCTURE_CREATE")
	public void add(CompanyStructure companyStructure)
	{
		repository.save(companyStructure);
	}

	@Secured("ROLE_COMPANY_STRUCTURE_UPDATE")
	public void edit(CompanyStructure companyStructure)
	{
		repository.saveAndFlush(companyStructure);
	}

	@Secured("ROLE_COMPANY_STRUCTURE_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_COMPANY_STRUCTURE_READ")
	public List<Party> findAllCompanyMembers()
	{
		return new ArrayList<>();
//		return repository.findAllCompanyMembers();
	}
}
