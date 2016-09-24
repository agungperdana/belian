/**
 * 
 */
package com.kratonsolution.belian.ui.education.studyday;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.education.dm.StudyDay;
import com.kratonsolution.belian.education.svc.StudyDayService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StudyDayList extends Listbox
{
	private StudyDayService service = Springs.get(StudyDayService.class);
	
	private Map<String,StudyDay> maps = new HashMap<String, StudyDay>();
	
	public StudyDayList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public StudyDayList(boolean fullspan,StudyDay onday)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		
		for(StudyDay day:service.findAll())
		{
			Listitem listitem = appendItem(day.getLabel(), day.getId());
			if(onday != null && onday.getId().equals(day.getId()))
				setSelectedItem(listitem);
				
			if(!maps.containsKey(day.getValue()))
				maps.put(day.getValue(), day);
		}
	}
	
	public StudyDay getStudyDay()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}
	
	public void setStudyDay(StudyDay day)
	{
		if(day != null)
		{
			getItems().clear();
			setSelectedItem(appendItem(day.getLabel(), day.getId()));
			
			for(StudyDay map:maps.values())
			{
				if(!map.getId().equals(day.getId()))
					appendItem(map.getLabel(), map.getId());
			}
			
			if(!maps.containsKey(day.getValue()))
				maps.put(day.getValue(), day);
		}
	}
}
