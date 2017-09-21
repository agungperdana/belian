/**
 * 
 */
package com.kratonsolution.belian.ui.education.courseregistration;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.education.dm.CourseRegistration;
import com.kratonsolution.belian.education.svc.CourseRegistrationService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CourseRegistrationModel implements ListModel<CourseRegistration>
{
	private CourseRegistrationService service = Springs.get(CourseRegistrationService.class);
	
	private List<CourseRegistration> data = new ArrayList<CourseRegistration>();
	
	private String key;
	
	public CourseRegistrationModel(int itemSize)
	{
		next(0, itemSize,null);
	}
	
	public CourseRegistrationModel(int itemSize,String key)
	{
		this.key = key;
		next(0, itemSize,key);
	}
	
	@Override
	public CourseRegistration getElementAt(int index)
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
