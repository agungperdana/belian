/**
 * 
 */
package com.kratonsolution.belian.accounting.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.accounting.dm.GLAccount;
import com.kratonsolution.belian.accounting.dm.GLAccountChangeEventListener;
import com.kratonsolution.belian.accounting.dm.GLAccountRepository;
import com.kratonsolution.belian.accounting.dm.GLAccountType;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class GLAccountService
{
	@Autowired
	private GLAccountRepository repository;
	
	@Autowired
	private List<GLAccountChangeEventListener> listeners;
	
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
	
	@Secured("ROLE_COA_READ")
	public long nextNumber(GLAccountType type)
	{
		Long out = repository.lastNumber(type);
		return (out.longValue()+1);
	}
	
	@Secured("ROLE_COA_CREATE")
	public void add(GLAccount coa)
	{
		repository.save(coa);
		
		for(GLAccountChangeEventListener listener:listeners)
			listener.fireObjectCreated(coa);
	}
	
	@Secured("ROLE_COA_UPDATE")
	public void edit(GLAccount coa)
	{
		repository.saveAndFlush(coa);
	}
	
	@Secured("ROLE_COA_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
		
		for(GLAccountChangeEventListener listener:listeners)
			listener.fireObjectDeleted(id);
	}
	
	@Secured("ROLE_COA_DELETE")
	public void delete(GLAccount account)
	{
		repository.delete(account);
		
		for(GLAccountChangeEventListener listener:listeners)
			listener.fireObjectDeleted(account.getId());
		
		System.out.println("delete done");
	}
	
	@Secured("ROLE_COA_READ")
	public int countRoot()
	{
		return repository.countRoot();
	}
}
