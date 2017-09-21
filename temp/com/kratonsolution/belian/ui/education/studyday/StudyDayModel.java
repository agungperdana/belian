/**
 * 
 */
package com.kratonsolution.belian.ui.education.studyday;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.education.dm.StudyDay;
import com.kratonsolution.belian.education.svc.StudyDayService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StudyDayModel implements ListModel<StudyDay>
{
	private StudyDayService service = Springs.get(StudyDayService.class);
	
	private List<StudyDay> data = new ArrayList<StudyDay>();
	
	public StudyDayModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public StudyDay getElementAt(int index)
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
