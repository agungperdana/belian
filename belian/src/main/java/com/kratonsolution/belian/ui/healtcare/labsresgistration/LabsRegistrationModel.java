/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.labsresgistration;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.healtcare.dm.LaboratorySales;
import com.kratonsolution.belian.healtcare.svc.LaboratorySalesService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class LabsRegistrationModel implements ListModel<LaboratorySales>
{
	private LaboratorySalesService service = Springs.get(LaboratorySalesService.class);
	
	private List<LaboratorySales> data = new ArrayList<LaboratorySales>();
	
	public LabsRegistrationModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public LaboratorySales getElementAt(int index)
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
	}

	@Override
	public void removeListDataListener(ListDataListener l)
	{
	}

	public void next(int pageIndex,int itemSize)
	{
		data.clear();
		data.addAll(service.findAll(0, (itemSize*pageIndex)+itemSize));
	}
}
