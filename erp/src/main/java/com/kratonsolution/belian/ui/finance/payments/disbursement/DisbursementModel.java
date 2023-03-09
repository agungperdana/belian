
package com.kratonsolution.belian.ui.finance.payments.disbursement;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.payments.dm.Disbursement;
import com.kratonsolution.belian.payments.svc.DisbursementService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DisbursementModel implements ListModel<Disbursement>
{
	private DisbursementService service = Springs.get(DisbursementService.class);
	
	private List<Disbursement> data = new ArrayList<Disbursement>();
	
	public DisbursementModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public Disbursement getElementAt(int index)
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
