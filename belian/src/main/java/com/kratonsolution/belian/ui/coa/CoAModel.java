/**
 * 
 */
package com.kratonsolution.belian.ui.coa;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.accounting.dm.GLAccount;
import com.kratonsolution.belian.accounting.svc.GLAccountService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class CoAModel implements ListModel<GLAccount>
{
	private final GLAccountService service = Springs.get(GLAccountService.class);
	
	private List<GLAccount> data = new ArrayList<GLAccount>();
	
	public CoAModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public GLAccount getElementAt(int index)
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
		data.addAll(service.findAllRoot(0, (itemSize*pageIndex)+itemSize));
	}
}
