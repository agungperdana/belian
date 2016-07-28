/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.organizationaccount;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.OGLAccount;
import com.kratonsolution.belian.accounting.dm.OrganizationAccount;
import com.kratonsolution.belian.accounting.svc.OrganizationAccountService;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class OGLAccountList extends Listbox
{
	private Language lang = Springs.get(Language.class);
	
	private OrganizationAccountService service = Springs.get(OrganizationAccountService.class);
	
	private Map<String,OGLAccount> maps = new HashMap<>();
	
	public OGLAccountList(Organization company)
	{
		setWidth("250px");
		setMold("select");

		if(company != null)
			populate(company.getId());
	}
	
	public OGLAccountList(String company)
	{
		setWidth("250px");
		setMold("select");

		if(!Strings.isNullOrEmpty(company))
			populate(company);
	}
	
	public OGLAccountList()
	{
		setWidth("250px");
		setMold("select");
	}
	
	private void populate(String company)
	{
		if(Strings.isNullOrEmpty(company))
			throw new RuntimeException(lang.get("message.field.company"));

		getItems().clear();
		
		OrganizationAccount org = service.findOneByOrganization(company);
		if(org == null)
			throw new RuntimeException(lang.get("message.field.company"));
		
		for(OGLAccount account:org.getAccounts())
		{
			appendItem(account.getLabel(), account.getValue());
			
			if(!maps.containsKey(account.getId()))
				maps.put(account.getId(), account);
		}
		
		if(getItemCount() > 0)
			setSelectedIndex(0);
	}
	
	public OGLAccount getAccount()
	{
		if(getSelectedCount() > 0 && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}
	
	public void setAccount(OGLAccount account)
	{
		if(account != null)
		{
			if(getItems().isEmpty())
				appendItem(account.getLabel(), account.getValue());
			else
			{
				for(Listitem item:getItems())
				{
					if(item.getValue().toString().equals(account.getId()))
					{
						setSelectedItem(item);
						break;
					}
				}
			}
			
			if(!maps.containsKey(account.getId()))
				maps.put(account.getId(), account);
		}
	}
	
	public void repopulate(Organization organization)
	{
		if(organization != null)
			populate(organization.getId());
	}
}
