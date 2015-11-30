/**
 * 
 */
package com.kratonsolution.belian.accounting.svc;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.accounting.dm.GLAccount;
import com.kratonsolution.belian.accounting.dm.GLAccountChangeEventListener;
import com.kratonsolution.belian.accounting.dm.OGLAccount;
import com.kratonsolution.belian.accounting.dm.OrganizationAccount;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class OrganizationGLEventListener implements GLAccountChangeEventListener
{
	@Autowired
	private OrganizationAccountService service;
	
	@Autowired
	private GLAccountService accountService;
	
	@Override
	public void fireObjectCreated(GLAccount account)
	{
		for(OrganizationAccount organizationAccount:service.findAll())
		{
			OGLAccount oglAccount = new OGLAccount();
			oglAccount.setAccount(account);
			oglAccount.setParent(organizationAccount);
			oglAccount.setSelected(false);
			
			organizationAccount.getAccounts().add(oglAccount);
			
			service.edit(organizationAccount);
		}
	}

	@Override
	public void fireObjectDeleted(String id)
	{
		for(OrganizationAccount organizationAccount:service.findAll())
		{
			Iterator<OGLAccount> iterator = organizationAccount.getAccounts().iterator();
			while (iterator.hasNext())
			{
				OGLAccount oglAccount = (OGLAccount) iterator.next();
				if(oglAccount.getAccount() == null || accountService.findOne(oglAccount.getAccount().getId()) == null || oglAccount.getAccount().getId().equals(id))
				{
					oglAccount.setParent(null);
					organizationAccount.getAccounts().remove(oglAccount);
					break;
				}
			}
			
			service.edit(organizationAccount);
		}
	}
}
