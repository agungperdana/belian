/**
 * 
 */
package com.kratonsolution.belian.ui.healthcares.clinic.practitioner;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.healtcares.dm.PractitionerProviderRelationship;
import com.kratonsolution.belian.healtcares.svc.PractitionerProviderRelationshipService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PractitionerModel implements ListModel<PractitionerProviderRelationship>
{
	private PractitionerProviderRelationshipService service = Springs.get(PractitionerProviderRelationshipService.class);
	
	private List<PractitionerProviderRelationship> data = new ArrayList<PractitionerProviderRelationship>();
	
	public PractitionerModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public PractitionerProviderRelationship getElementAt(int index)
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
