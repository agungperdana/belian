
package com.kratonsolution.belian.ui.inventorys.shipment;

import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.persistence.IDValueRef;
import com.kratonsolution.belian.shipment.dm.ShipmentMethodType;
import com.kratonsolution.belian.ui.component.AbstractList;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ShipmentMethodTypeList extends AbstractList<ShipmentMethodType>
{	
	public ShipmentMethodTypeList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public ShipmentMethodTypeList(boolean fullspan,ShipmentMethodType con)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		setSelectedItem(null);
		
		for(ShipmentMethodType type:ShipmentMethodType.values())
		{
			Listitem listitem = appendItem(type.display(utils.getLanguage()), type.name());
			if(con != null && con.equals(type))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(type.name()))
				maps.put(type.name(), type);
		}
	}

	@Override
	public ShipmentMethodType getDomain()
	{
		return getSelectedItem()!=null?ShipmentMethodType.valueOf(getSelectedItem().getValue()):null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		return null;
	}

	@Override
	public void setDomain(ShipmentMethodType domain)
	{
		if(domain != null)
		{
			getItems().clear();
			
			if(!maps.containsKey(domain.name()))
				maps.put(domain.name(), domain);
			
			for(ShipmentMethodType type:maps.values())
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
