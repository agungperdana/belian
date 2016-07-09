/**
 * 
 */
package com.kratonsolution.belian.ui.education.studytime;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.education.dm.StudyTime;
import com.kratonsolution.belian.education.svc.StudyTimeService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StudyTimeModel implements ListModel<StudyTime>
{
	private StudyTimeService service = Springs.get(StudyTimeService.class);
	
	private List<StudyTime> data = new ArrayList<StudyTime>();
	
	public StudyTimeModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public StudyTime getElementAt(int index)
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
