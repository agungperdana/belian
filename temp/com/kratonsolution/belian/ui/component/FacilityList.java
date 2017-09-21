/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zul.Listbox;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.facility.dm.Facility;
import com.kratonsolution.belian.facility.dm.FacilityOrganization;
import com.kratonsolution.belian.partys.dm.Organization;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FacilityList extends Listbox
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Map<String,Facility> maps = new HashMap<>();
	
	public FacilityList()
	{
		setMold("select");
		setWidth("300px");
		
		for(Organization organization:utils.getOrganizations())
		{
			for(FacilityOrganization org:organization.getFacilitys())
			{
				if(org.isEnabled())
				{
					appendItem(org.getFacility().getLabel(),org.getFacility().getValue());
					if(!maps.containsKey(org.getFacility().getId()))
						maps.put(org.getFacility().getValue(), org.getFacility());
				}
			}
		}
		
		if(!getChildren().isEmpty())
			setSelectedIndex(0);
	}
	
	public Facility getFacility()
	{
		if(getSelectedItem() != null)
			return maps.get(getSelectedItem().getValue().toString());
	
		return null;
	}
	
	public void setFacility(Facility facility)
	{
		if(facility != null)
		{
			appendItem(facility.getLabel(),facility.getValue());
			setSelectedIndex(0);
			if(!maps.containsKey(facility.getId()))
				maps.put(facility.getValue(), facility);
			
		}
	}
}