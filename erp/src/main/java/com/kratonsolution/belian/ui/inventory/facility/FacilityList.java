
package com.kratonsolution.belian.ui.inventory.facility;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.Listitem;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.orm.IDValueRef;
import com.kratonsolution.belian.common.orm.Observer;
import com.kratonsolution.belian.facility.impl.orm.Facility;
import com.kratonsolution.belian.facility.impl.orm.FacilityOrganization;
import com.kratonsolution.belian.facility.impl.application.FacilityService;
import com.kratonsolution.belian.ui.component.AbstractList;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FacilityList extends AbstractList<Facility> implements Observer
{
	private FacilityService service = Springs.get(FacilityService.class);
	
	public FacilityList(boolean fullspan)
	{
		super();
		
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");

		initData();
	}

	private void initData()
	{
		getItems().clear();
		
		List<FacilityOrganization> lists = new ArrayList<>();
		
		if(utils.getOrganization() != null)
			lists.addAll(service.findOrganizations(utils.getOrganization().getId()));
		else
			lists.addAll(service.findOrganizations());
		
		for(FacilityOrganization facility:lists)
		{
			Listitem listitem = appendItem(facility.getFacility().getLabel(), facility.getFacility().getValue());
			
			if(utils.getFacility() != null && utils.getFacility().getId().equals(facility.getFacility().getId()))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(facility.getFacility().getId()))
				maps.put(facility.getFacility().getId(), facility.getFacility());
		}
	}

	@Override
	public Facility getDomain()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
		{
			Facility facility = maps.get(getSelectedItem().getValue().toString());
			
			IDValueRef ref = new IDValueRef();
			ref.setId(facility.getId());
			ref.setValue(facility.getName());
			ref.setType(Facility.class.getSimpleName());
			
			return ref;
		}
		
		return null;
	}

	@Override
	public void setDomain(Facility ref)
	{
		getItems().clear();

		if(ref != null && !Strings.isNullOrEmpty(ref.getId()))
			maps.put(ref.getId(), ref);
		
		for(Facility facility:maps.values())
		{
			Listitem listitem = appendItem(facility.getName(), facility.getId());
			if(ref != null && ref.getId().equals(facility.getId()))
				setSelectedItem(listitem);
		}
	}

	@Override
	public void setDomainAsRef(IDValueRef ref)
	{
		getItems().clear();

		if(ref != null && !Strings.isNullOrEmpty(ref.getId()))
			maps.put(ref.getId(), new Facility(ref));
		
		for(Facility facility:maps.values())
		{
			Listitem listitem = appendItem(facility.getName(), facility.getId());
			if(ref != null && ref.getId().equals(facility.getId()))
				setSelectedItem(listitem);
		}
	}

	@Override
	public void valueChange(IDValueRef value)
	{
		if(value != null && !Strings.isNullOrEmpty(value.getId()))
		{
			getItems().clear();
			maps.clear();
			
			for(FacilityOrganization com:service.findOrganizations(value.getId()))
			{
				Listitem listitem = appendItem(com.getFacility().getName(), com.getFacility().getId());
				if(utils.getFacility() != null && utils.getFacility().getId().equals(com.getFacility().getId()))
					setSelectedItem(listitem);
				
				if(!maps.containsKey(com.getFacility().getId()))
					maps.put(com.getFacility().getId(), com.getFacility());
			}
		}
	}
}
