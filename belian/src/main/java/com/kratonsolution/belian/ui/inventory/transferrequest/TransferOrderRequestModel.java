/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.transferrequest;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.inventory.dm.TransferOrderRequest;
import com.kratonsolution.belian.inventory.svc.TransferOrderRequestService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class TransferOrderRequestModel implements ListModel<TransferOrderRequest>
{
	private final TransferOrderRequestService service = Springs.get(TransferOrderRequestService.class);
	
	private List<TransferOrderRequest> data = new ArrayList<TransferOrderRequest>();
	
	public TransferOrderRequestModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public TransferOrderRequest getElementAt(int index)
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
	}

	@Override
	public void removeListDataListener(ListDataListener l)
	{
	}

	public void next(int pageIndex,int itemSize)
	{
		data.clear();
		data.addAll(service.findAll(0, (itemSize*pageIndex)+itemSize));
	}
}
