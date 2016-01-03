/**
 * 
 */
package com.kratonsolution.belian.ui.sales.cashier;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.sales.dm.Billing;
import com.kratonsolution.belian.sales.srv.BillingService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashierModel implements ListModel<Billing>
{
	private final BillingService service = Springs.get(BillingService.class);
	
	private List<Billing> data = new ArrayList<Billing>();
	
	public CashierModel(int itemSize,String companyId)
	{
		next(0, itemSize,companyId);
	}
	
	@Override
	public Billing getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return data.size();
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

	public void next(int pageIndex,int itemSize,String companyId)
	{
		data.clear();
		data.addAll(service.findAllByDateAndOrganizationIdAndPaid(new Date(System.currentTimeMillis()),companyId,false));
	}
}
