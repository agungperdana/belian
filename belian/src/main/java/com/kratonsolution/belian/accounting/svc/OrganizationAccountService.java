/**
 * 
 */
package com.kratonsolution.belian.accounting.svc;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.accounting.dm.OrganizationAccount;
import com.kratonsolution.belian.accounting.dm.OrganizationAccountRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class OrganizationAccountService
{
	@Autowired
	private OrganizationAccountRepository repository;
	
	@Secured("ROLE_ORGANIZATIONACCOUNT_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_ORGANIZATIONACCOUNT_READ")
	public OrganizationAccount findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_ORGANIZATIONACCOUNT_READ")
	public OrganizationAccount findOneByOrganization(String id)
	{
		return repository.findOneByOrganizationId(id);
	}
	
	@Secured("ROLE_ORGANIZATIONACCOUNT_READ")
	public List<OrganizationAccount> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_ORGANIZATIONACCOUNT_READ")
	public List<OrganizationAccount> findAll(int pageIndex,int pageSize,List<String> companys)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize),companys);
	}
	
	@Secured("ROLE_ORGANIZATIONACCOUNT_READ")
	public List<OrganizationAccount> findAllByOrganization(String organization)
	{
		return repository.findAllByOrganization(organization);
	}
	
	@Secured("ROLE_ORGANIZATIONACCOUNT_CREATE")
	public void add(OrganizationAccount org)
	{
		org.setId(UUID.randomUUID().toString());
		repository.save(org);
	}
	
	@Secured("ROLE_ORGANIZATIONACCOUNT_UPDATE")
	public void edit(OrganizationAccount org)
	{
		repository.saveAndFlush(org);
	}
	
	@Secured("ROLE_ORGANIZATIONACCOUNT_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
