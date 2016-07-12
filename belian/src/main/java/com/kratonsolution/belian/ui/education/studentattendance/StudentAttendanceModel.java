/**
 * 
 */
package com.kratonsolution.belian.ui.education.studentattendance;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.education.dm.StudentAttendance;
import com.kratonsolution.belian.education.svc.StudentAttendanceService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StudentAttendanceModel implements ListModel<StudentAttendance>
{
	private StudentAttendanceService service = Springs.get(StudentAttendanceService.class);
	
	private List<StudentAttendance> data = new ArrayList<StudentAttendance>();
	
	private String key;
	
	public StudentAttendanceModel(int itemSize)
	{
		next(0, itemSize,null);
	}
	
	public StudentAttendanceModel(int itemSize,String key)
	{
		this.key = key;
		next(0, itemSize,key);
	}
	
	@Override
	public StudentAttendance getElementAt(int index)
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