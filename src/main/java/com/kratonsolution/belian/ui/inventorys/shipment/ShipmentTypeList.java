
package com.kratonsolution.belian.ui.inventorys.shipment;

import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.shipment.dm.ShipmentType;
import com.kratonsolution.belian.ui.component.AbstractList;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ShipmentTypeList extends AbstractList<ShipmentType>
{	
	public ShipmentTypeList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public ShipmentTypeList(boolean fullspan,ShipmentType con)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		setSelectedItem(null);
		
		for(ShipmentType type:ShipmentType.values())
		{
			Listitem listitem = appendItem(type.display(utils.getLanguage()), type.name());
			if(con != null && con.equals(type))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(type.name()))
				maps.put(type.name(), type);
		}
	}

	@Override
	public ShipmentType getDomain()
	{
		return getSelectedItem()!=null?ShipmentType.valueOf(getSelectedItem().getValue()):null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		return null;
	}

	@Override
	public void setDomain(ShipmentType domain)
	{
		if(domain != null)
		{
			getItems().clear();
			
			if(!maps.containsKey(domain.name()))
				maps.put(domain.name(), domain);
			
			for(ShipmentType type:maps.values())
			{
				Listitem listitem = appendItem(type.display(utils.getLanguage()), type.name());
				if(type.equals(domain))
					setSelectedItem(listitem);
			}
		}
	}

	@Override
	public void setDomainAsRef(IDValueRef ref)
	{
		// TODO Auto-generated method stub
		
	}
}
