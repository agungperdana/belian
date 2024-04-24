
package com.kratonsolution.belian.ui.general.organization;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.partys.dm.Organization;
import com.kratonsolution.belian.partys.svc.OrganizationService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class OrganizationModel implements ListModel<Organization>
{
	private OrganizationService service = Springs.get(OrganizationService.class);
	
	private List<Organization> data = new ArrayList<Organization>();
	
	public OrganizationModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public Organization getElementAt(int index)
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
