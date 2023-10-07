
package com.kratonsolution.belian.ui.general.country;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.country.impl.orm.Country;
import com.kratonsolution.belian.country.impl.application.CountryService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public class CountryList extends Listbox
{
	private CountryService service = Springs.get(CountryService.class);
	
	private Map<String,Country> maps = new HashMap<String, Country>();
	
	public CountryList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public CountryList(boolean fullspan,Country in)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		setSelectedItem(null);
		for(Country country:service.findAll())
		{
			Listitem listitem = appendItem(country.getName(), country.getId());
			if(in != null && in.getId().equals(country.getId()))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(country.getName()))
				maps.put(country.getName(), country);
		}
	}
	
	public Country getCountry()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getLabel()))
			return maps.get(getSelectedItem().getLabel());
		
		return null;
	}
	
	public void setCountry(Country country)
	{
		if(country != null)
		{
			getItems().clear();
			setSelectedItem(appendItem(country.getName(), country.getId()));
			
			if(!maps.containsKey(country.getName()))
				maps.put(country.getName(), country);
		}
	}
}
