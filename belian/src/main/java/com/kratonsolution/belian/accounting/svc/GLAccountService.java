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

import com.kratonsolution.belian.accounting.dm.GLAccount;
import com.kratonsolution.belian.accounting.dm.GLAccountRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class GLAccountService
{
	@Autowired
	private GLAccountRepository repository;
	
	@Secured("ROLE_COA_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_COA_READ")
	public GLAccount findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_COA_READ")
	public List<GLAccount> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_COA_READ")
	public List<GLAccount> findAllRoot()
	{
		return repository.findAllByParentIsNull();
	}
	
	@Secured("ROLE_COA_READ")
	public List<GLAccount> findAllRoot(int pageIndex,int pageSize)
	{
		return repository.findAllByParentIsNull(new PageRequest(pageIndex, pageSize));
	}
	
	@Secured("ROLE_COA_READ")
	public GLAccount findOneByName(String name)
	{
		return repository.findOneByName(name);
	}
	
	@Secured("ROLE_COA_READ")
	public List<GLAccount> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_COA_CREATE")
	public void add(GLAccount coa)
	{
		repository.save(coa);
	}
	
	@Secured("ROLE_COA_UPDATE")
	public void edit(GLAccount coa)
	{
		repository.save(coa);
	}
	
	@Secured("ROLE_COA_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
