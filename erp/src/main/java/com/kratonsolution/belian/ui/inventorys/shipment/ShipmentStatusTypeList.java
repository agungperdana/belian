
package com.kratonsolution.belian.ui.inventorys.shipment;

import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.orm.IDValueRef;
import com.kratonsolution.belian.shipment.dm.ShipmentStatusType;
import com.kratonsolution.belian.ui.component.AbstractList;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ShipmentStatusTypeList extends AbstractList<ShipmentStatusType>
{	
	public ShipmentStatusTypeList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public ShipmentStatusTypeList(boolean fullspan,ShipmentStatusType con)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		setSelectedItem(null);
		
		for(ShipmentStatusType type:ShipmentStatusType.values())
		{
			Listitem listitem = appendItem(type.display(utils.getLanguage()), type.name());
			if(con != null && con.equals(type))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(type.name()))
				maps.put(type.name(), type);
		}
	}

	@Override
	public ShipmentStatusType getDomain()
	{
		return getSelectedItem()!=null?ShipmentStatusType.valueOf(getSelectedItem().getValue()):null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		return null;
	}

	@Override
	public void setDomain(ShipmentStatusType domain)
	{
		if(domain != null)
		{
			getItems().clear();
			
			if(!maps.containsKey(domain.name()))
				maps.put(domain.name(), domain);
			
			for(ShipmentStatusType type:maps.values())
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
