/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import org.zkoss.zul.Listbox;

import com.kratonsolution.belian.accounting.dm.OrganizationAccount;
import com.kratonsolution.belian.accounting.svc.OrganizationAccountService;
import com.kratonsolution.belian.partys.dm.Organization;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ChartOfAccountList extends Listbox
{
	private OrganizationAccountService service = Springs.get(OrganizationAccountService.class);
	
	public ChartOfAccountList()
	{
		setMold("select");
		setWidth("300px");
		
		for(OrganizationAccount account:service.findAll())
			setSelectedItem(appendItem(account.getOrganization().getName(), account.getId()));
	}
	
	public OrganizationAccount getOrganization()
	{
		if(getSelectedItem() != null)
			return service.findOne(getSelectedItem().getValue().toString());
		
		return null;
	}
	
	public void setOrganization(OrganizationAccount account)
	{
		if(account != null)
		{
			getItems().clear();
			setSelectedItem(appendItem(account.getOrganization().getName(), account.getId()));
		}
	}
	
	public void setOrganization(Organization org)
	{
		if(org != null)
		{
			OrganizationAccount account = service.findOneByOrganization(org.getId());
			if(account != null)
			{
				
			}
		}
	}
}
