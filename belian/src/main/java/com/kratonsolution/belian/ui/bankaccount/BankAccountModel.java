/**
 * 
 */
package com.kratonsolution.belian.ui.bankaccount;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.accounting.dm.BankAccount;
import com.kratonsolution.belian.accounting.svc.BankAccountService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class BankAccountModel implements ListModel<BankAccount>
{
	private final BankAccountService service = Springs.get(BankAccountService.class);
	
	private List<BankAccount> data = new ArrayList<BankAccount>();
	
	public BankAccountModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public BankAccount getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return service.size();
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
		data.addAll(service.findAll(0, (itemSize*pageIndex)+itemSize));
	}
}
