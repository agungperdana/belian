/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.patient;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.healtcare.dm.PatientRelationship;
import com.kratonsolution.belian.healtcare.svc.PatientService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PatientModel implements ListModel<PatientRelationship>
{
	private final PatientService service = Springs.get(PatientService.class);
	
	private List<PatientRelationship> data = new ArrayList<PatientRelationship>();
	
	public PatientModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public PatientRelationship getElementAt(int index)
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
