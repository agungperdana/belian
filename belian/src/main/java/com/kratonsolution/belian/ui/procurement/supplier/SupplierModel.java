/**
 * 
 */
package com.kratonsolution.belian.ui.procurement.supplier;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.procurement.dm.SupplierRelationship;
import com.kratonsolution.belian.procurement.svc.SupplierRelationshipService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SupplierModel implements ListModel<SupplierRelationship>
{
	private SupplierRelationshipService service = Springs.get(SupplierRelationshipService.class);
	
	private List<SupplierRelationship> data = new ArrayList<SupplierRelationship>();
	
	public SupplierModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public SupplierRelationship getElementAt(int index)
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
