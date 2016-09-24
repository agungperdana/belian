/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.facility;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FacilityList extends Listbox
{
	private FacilityService service = Springs.get(FacilityService.class);
	
	private Map<String,Facility> maps = new HashMap<String, Facility>();
	
	public FacilityList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public FacilityList(boolean fullspan,Facility onfacility)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		
		for(Facility facility:service.findAll())
		{
			Listitem listitem = appendItem(facility.getLabel(), facility.getId());
			if(onfacility != null && onfacility.getId().equals(facility.getId()))
				setSelectedItem(listitem);
				
			if(!maps.containsKey(facility.getValue()))
				maps.put(facility.getValue(), facility);
		}
	}
	
	public Facility getFacility()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}
	
	public void setFacility(Facility facility)
	{
		if(facility != null)
		{
			getItems().clear();
			setSelectedItem(appendItem(facility.getLabel(), facility.getId()));
			
			if(!maps.containsKey(facility.getValue()))
				maps.put(facility.getValue(), facility);
		}
	}
}
