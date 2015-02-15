/**
 * 
 */
package com.kratonsolution.belian.ui.organizationaccount;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.accounting.dm.OrganizationAccount;
import com.kratonsolution.belian.accounting.svc.OrganizationAccountService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class OrganizationAccountModel implements ListModel<OrganizationAccount>
{
	private final OrganizationAccountService controller = Springs.get(OrganizationAccountService.class);
	
	private List<OrganizationAccount> data = new ArrayList<OrganizationAccount>();
	
	public OrganizationAccountModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public OrganizationAccount getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return controller.size();
	}

	@Override
	public void addListDataListener(ListDataListener l)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListDataListener(ListDataListener l)
	{
		// TODO Auto-generated method stub
		
	}

	public void next(int pageIndex,int itemSize)
	{
		data.clear();
		data.addAll(controller.findAll(0, (itemSize*pageIndex)+itemSize));
	}
}
