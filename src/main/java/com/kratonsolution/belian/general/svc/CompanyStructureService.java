/**
 * 
 */
package com.kratonsolution.belian.general.svc;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.dm.CompanyStructure;
import com.kratonsolution.belian.general.dm.CompanyStructureRepository;
import com.kratonsolution.belian.partys.dm.Organization;
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
	public List<Organization> findAllAsOrganizations()
	{
		return repository.findAllAsOrganizations();
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
	}
	
	public List<Organization> findAllChild(Organization organization)
	{
		List<Organization> list = new ArrayList<>();
		
		if(organization == null || Strings.isNullOrEmpty(organization.getId()))
			return new ArrayList<>();
		
		CompanyStructure structure = byOrganization(organization.getId());
		if(structure == null)
			return new ArrayList<>();
				
		getChild(list, structure);
		
		return list;
	}
	
	public List<String> findAllChild(String parentOrganization)
	{
		List<String> list = new ArrayList<>();
		
		if(Strings.isNullOrEmpty(parentOrganization))
			return new ArrayList<>();
		
		CompanyStructure structure = byOrganization(parentOrganization);
		if(structure == null)
			return new ArrayList<>();
		
		extract(list, structure);
		
		return list;
	}
	
	private void extract(Collection<String> list,CompanyStructure parent)
	{
		for(CompanyStructure child:parent.getChilds())
		{
			list.add(child.getOrganization().getId());
			if(!child.getChilds().isEmpty())
				extract(list, child);
		}
	}
	
	private void getChild(Collection<Organization> list,CompanyStructure parent)
	{
		for(CompanyStructure child:parent.getChilds())
		{
			list.add(child.getOrganization());
			if(!child.getChilds().isEmpty())
				getChild(list, child);
		}
	}
}
