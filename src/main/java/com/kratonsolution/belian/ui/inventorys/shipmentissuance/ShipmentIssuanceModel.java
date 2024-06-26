
package com.kratonsolution.belian.ui.inventorys.shipmentissuance;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.shipment.dm.ShipmentIssuance;
import com.kratonsolution.belian.shipment.svc.ShipmentIssuanceService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ShipmentIssuanceModel implements ListModel<ShipmentIssuance>
{
	private ShipmentIssuanceService service = Springs.get(ShipmentIssuanceService.class);
	
	private List<ShipmentIssuance> data = new ArrayList<ShipmentIssuance>();
	
	public ShipmentIssuanceModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public ShipmentIssuance getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return service.size();
	}

	@Override
	public void addListDataListener(ListDataListener l)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListDataListener(ListDataListener l)
	{
		// TODO Auto-generated method stub
		
	}

	public void next(int pageIndex,int itemSize)
	{
		data.clear();
		data.addAll(service.findAll(0, (itemSize*pageIndex)+itemSize));
	}
}
