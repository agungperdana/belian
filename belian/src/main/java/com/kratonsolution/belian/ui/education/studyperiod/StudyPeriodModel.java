/**
 * 
 */
package com.kratonsolution.belian.ui.education.studyperiod;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.education.dm.StudyPeriod;
import com.kratonsolution.belian.education.svc.StudyPeriodService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StudyPeriodModel implements ListModel<StudyPeriod>
{
	private StudyPeriodService service = Springs.get(StudyPeriodService.class);
	
	private List<StudyPeriod> data = new ArrayList<StudyPeriod>();
	
	public StudyPeriodModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public StudyPeriod getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return service.getSize();
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
