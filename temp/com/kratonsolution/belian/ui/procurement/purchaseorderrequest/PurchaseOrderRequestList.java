/**
 * 
 */
package com.kratonsolution.belian.ui.procurement.purchaseorderrequest;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zul.Listbox;

import com.kratonsolution.belian.procurement.dm.PurchaseOrderRequest;
import com.kratonsolution.belian.procurement.svc.PurchaseOrderRequestService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PurchaseOrderRequestList extends Listbox
{
	private PurchaseOrderRequestService requestService = Springs.get(PurchaseOrderRequestService.class);
	
	private Map<String,PurchaseOrderRequest> maps = new HashMap<>();
	
	public PurchaseOrderRequestList()
	{
		setMold("select");
		setWidth("300px");
		
		for(PurchaseOrderRequest request:requestService.findAllIncomplete())
		{
			if(!request.isCompleted())
			{
				appendItem(request.getLabel(), request.getValue());
				if(!maps.containsKey(request.getValue()))
					maps.put(request.getValue(), request);
			}
		}
	}
	
	public PurchaseOrderRequest getRequest()
	{
		if(getSelectedItem() != null)
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}
}
