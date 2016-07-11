/**
 * 
 */
package com.kratonsolution.belian.ui.education.studyroom;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.education.dm.StudyRoom;
import com.kratonsolution.belian.education.svc.StudyRoomService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StudyRoomModel implements ListModel<StudyRoom>
{
	private StudyRoomService service = Springs.get(StudyRoomService.class);
	
	private List<StudyRoom> data = new ArrayList<StudyRoom>();
	
	private String key;
	
	public StudyRoomModel(int itemSize)
	{
		next(0, itemSize,null);
	}
	
	public StudyRoomModel(int itemSize,String key)
	{
		next(0, itemSize,key);
	}
	
	@Override
	public StudyRoom getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return service.getSize(this.key);
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

	public void next(int pageIndex,int itemSize,String key)
	{
		data.clear();
		data.addAll(service.findAll(0, (itemSize*pageIndex)+itemSize,key));
	}
}
