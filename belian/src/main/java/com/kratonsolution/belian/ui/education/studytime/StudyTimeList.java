/**
 * 
 */
package com.kratonsolution.belian.ui.education.studytime;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.education.dm.StudyTime;
import com.kratonsolution.belian.education.svc.StudyTimeService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StudyTimeList extends Listbox
{
	private StudyTimeService service = Springs.get(StudyTimeService.class);
	
	private Map<String,StudyTime> maps = new HashMap<String, StudyTime>();
	
	public StudyTimeList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public StudyTimeList(boolean fullspan,StudyTime ontime)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		
		for(StudyTime time:service.findAll())
		{
			Listitem listitem = appendItem(time.getLabel(), time.getId());
			if(ontime != null && ontime.getId().equals(time.getId()))
				setSelectedItem(listitem);
				
			if(!maps.containsKey(time.getValue()))
				maps.put(time.getValue(), time);
		}
	}
	
	public StudyTime getStudyTime()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}
	
	public void setStudyTime(StudyTime time)
	{
		if(time != null)
		{
			getItems().clear();
			setSelectedItem(appendItem(time.getLabel(), time.getId()));
			
			for(StudyTime map:maps.values())
			{
				if(!map.getId().equals(time.getId()))
					appendItem(map.getLabel(), map.getId());
			}
			
			if(!maps.containsKey(time.getValue()))
				maps.put(time.getValue(), time);
		}
	}
}
