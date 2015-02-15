/**
 * 
 */
package com.kratonsolution.belian.accounting.svc;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.accounting.dm.GLAccount;
import com.kratonsolution.belian.accounting.dm.GLAccountChangeEventListener;
import com.kratonsolution.belian.accounting.dm.OGLAccount;
import com.kratonsolution.belian.accounting.dm.OrganizationAccount;
import com.kratonsolution.belian.accounting.dm.OrganizationAccountRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class OrganizationGLEventListener implements GLAccountChangeEventListener
{
	@Autowired
	private OrganizationAccountRepository repository;
	
	@Override
	public void fireObjectCreated(GLAccount account)
	{
		for(OrganizationAccount organizationAccount:repository.findAll())
		{
			OGLAccount oglAccount = new OGLAccount();
			oglAccount.setId(account.getId());
			oglAccount.setAccount(account);
			oglAccount.setSelected(false);
			
			organizationAccount.getAccounts().add(oglAccount);
			
			repository.save(organizationAccount);
		}
	}

	@Override
	public void fireObjectDeleted(String id)
	{
		for(OrganizationAccount organizationAccount:repository.findAll())
		{
			Iterator<OGLAccount> iterator = organizationAccount.getAccounts().iterator();
			while (iterator.hasNext())
			{
				OGLAccount oglAccount = (OGLAccount) iterator.next();
				if(oglAccount.getId().equals(id))
					iterator.remove();
			}
			
			repository.save(organizationAccount);
		}
	}
}
