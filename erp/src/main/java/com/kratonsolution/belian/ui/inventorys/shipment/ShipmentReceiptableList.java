
package com.kratonsolution.belian.ui.inventorys.shipment;

import org.zkoss.zul.Listitem;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.persistence.IDValueRef;
import com.kratonsolution.belian.common.persistence.Observer;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.shipment.dm.Shipment;
import com.kratonsolution.belian.shipment.svc.ShipmentService;
import com.kratonsolution.belian.ui.component.AbstractList;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ShipmentReceiptableList extends AbstractList<Shipment> implements Observer
{	
	private ShipmentService service = Springs.get(ShipmentService.class);
	
	public ShipmentReceiptableList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public ShipmentReceiptableList(boolean fullspan,Shipment con)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		for(Shipment shipment:service.findAllIssuable())
		{
			Listitem listitem = appendItem(DateTimes.format(shipment.getEntryDate())+" "+shipment.getNumber(),shipment.getId());
			if(con != null && con.getId().equals(shipment.getId()))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(shipment.getId()))
				maps.put(shipment.getId(), shipment);
		}
	}

	@Override
	public Shipment getDomain()
	{
		return getSelectedItem()!=null && maps.containsKey(getSelectedItem().getValue().toString())?
				maps.get(getSelectedItem().getValue().toString()):null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		Shipment buff = getDomain();
		if(buff != null)
			return buff.toRef();
		
		return null;
	}

	@Override
	public void setDomain(Shipment domain)
	{
		if(domain != null)
		{
			if(!maps.containsKey(domain.getId()))
			{
				maps.put(domain.getId(), domain);
				setSelectedItem(appendItem(DateTimes.format(domain.getEntryDate())+" "+domain.getNumber(),domain.getId()));
			}
			else
			{
				for(Listitem listitem:getItems())
				{
					if(listitem.getValue().toString().equals(domain.getId()))
					{
						setSelectedItem(listitem);
						break;
					}
				}
			}
		}
	}

	@Override
	public void setDomainAsRef(IDValueRef ref)
	{
		if(ref != null && !Strings.isNullOrEmpty(ref.getId()))
		{
			Shipment buff = service.getOne(ref.getId());
			if(buff != null)
				setDomain(buff);
		}
	}

	@Override
	public void valueChange(IDValueRef value)
	{
		if(value != null && !Strings.isNullOrEmpty(value.getId()))
		{
			getItems().clear();
			maps.clear();
			
			for(Shipment shipment:service.findAllReceiptable(value.getId()))
			{
				if(!shipment.isDelivered())
				{
					appendItem(DateTimes.format(shipment.getEntryDate())+" "+shipment.getNumber(),shipment.getId());
					
					if(!maps.containsKey(shipment.getId()))
						maps.put(shipment.getId(), shipment);
				}
			}
		}
	}
}
