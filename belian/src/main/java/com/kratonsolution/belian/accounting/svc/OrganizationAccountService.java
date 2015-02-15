/**
 * 
 */
package com.kratonsolution.belian.accounting.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.accounting.dm.OrganizationAccount;
import com.kratonsolution.belian.accounting.dm.OrganizationAccountRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
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
	public List<OrganizationAccount> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_ORGANIZATIONACCOUNT_READ")
	public List<OrganizationAccount> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_ORGANIZATIONACCOUNT_CREATE")
	public void add(OrganizationAccount currency)
	{
		repository.save(currency);
	}
	
	@Secured("ROLE_ORGANIZATIONACCOUNT_UPDATE")
	public void edit(OrganizationAccount currency)
	{
		repository.save(currency);
	}
	
	@Secured("ROLE_ORGANIZATIONACCOUNT_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
