/**
 * 
 */
package com.kratonsolution.belian.general.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.general.dm.CompanyStructure;
import com.kratonsolution.belian.general.dm.CompanyStructureRepository;
import com.kratonsolution.belian.general.dm.OrganizationUnitRepository;
import com.kratonsolution.belian.general.dm.PartyRoleRepository;
import com.kratonsolution.belian.global.dm.EconomicAgent;

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
	private PartyRoleRepository partyRoleRepository;

	@Autowired
	private OrganizationUnitRepository unitService;

	@Autowired
	private CompanyStructureRepository repository;

	@Secured("ROLE_COMPANY_STRUCTURE_READ")
	public CompanyStructure findOne(String id)
	{
		return repository.findOne(id);
	}

	@Secured("ROLE_COMPANY_STRUCTURE_READ")
	public List<CompanyStructure> findAll()
	{
		return repository.findAll();
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
	public List<EconomicAgent> findAllCompanyMembers()
	{
		return repository.findAllCompanyMembers();
	}
}
