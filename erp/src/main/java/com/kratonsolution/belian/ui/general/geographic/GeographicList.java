
package com.kratonsolution.belian.ui.general.geographic;

import com.kratonsolution.belian.geographic.impl.application.GeographicService;
import com.kratonsolution.belian.geographic.impl.orm.Geographic;
import com.kratonsolution.belian.geographic.impl.orm.GeographicType;
import org.zkoss.zul.Listitem;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.persistence.IDValueRef;
import com.kratonsolution.belian.ui.component.AbstractList;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
public class GeographicList extends AbstractList<Geographic>
{
	private GeographicService service = Springs.get(GeographicService.class);

	public GeographicList(boolean fullspan, GeographicType type)
	{
		this(fullspan,type,null);
	}

	public GeographicList(boolean fullspan, GeographicType type,Geographic geographic)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");

		setMold("select");

		for(Geographic geo:service.findAllByType(type))
		{
			Listitem listitem = appendItem(geo.getName(), geo.getId());
			if(geographic != null && geographic.getId().equals(geo.getId()))
				setSelectedItem(listitem);
			else if(utils.getLocation() != null && utils.getLocation().getId().equals(geo.getId()))
				setSelectedItem(listitem);
				
			if(!maps.containsKey(geo.getId()))
				maps.put(geo.getId(), geo);
		}
	}

	@Override
	public Geographic getDomain()
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
			Geographic geo = maps.get(getSelectedItem().getValue().toString());
			
			IDValueRef ref = new IDValueRef();
			ref.setId(geo.getId());
			ref.setValue(geo.getName());
			
			return ref;
		}
		
		return null;
	}

	@Override
	public void setDomain(Geographic domain)
	{
		getItems().clear();

		if(domain != null && !Strings.isNullOrEmpty(domain.getId()) && !maps.containsKey(domain.getId()))
			maps.put(domain.getId(), domain);
		
		for(Geographic geo:maps.values())
		{
			Listitem listitem = appendItem(geo.getName(), geo.getId());
			if(domain != null && !Strings.isNullOrEmpty(domain.getId()) && domain.getId().equals(geo.getId()))
				setSelectedItem(listitem);
		}
	}

	@Override
	public void setDomainAsRef(IDValueRef domain)
	{
		getItems().clear();

		if(domain != null && !Strings.isNullOrEmpty(domain.getId()) && !maps.containsKey(domain.getId()))
			maps.put(domain.getId(), new Geographic(domain));
		
		for(Geographic geo:maps.values())
		{
			Listitem listitem = appendItem(geo.getName(), geo.getId());
			if(domain != null && !Strings.isNullOrEmpty(domain.getId()) && domain.getId().equals(geo.getId()))
				setSelectedItem(listitem);
		}
	}
}
