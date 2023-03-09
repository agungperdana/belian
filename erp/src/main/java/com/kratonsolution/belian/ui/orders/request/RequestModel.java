
package com.kratonsolution.belian.ui.orders.request;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.orders.dm.Request;
import com.kratonsolution.belian.orders.svc.RequestService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class RequestModel implements ListModel<Request>
{
	private RequestService service = Springs.get(RequestService.class);
	
	private List<Request> data = new ArrayList<Request>();
	
	private String key;
	
	public RequestModel(int itemSize,String key)
	{
		this.key = key;
		next(0, itemSize,key);
	}
	
	public RequestModel(int itemSize)
	{
		next(0, itemSize,null);
	}
	
	@Override
	public Request getElementAt(int index)
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

	public void next(int pageIndex,int itemSize,String key)
	{
		data.clear();
		data.addAll(service.findAll(0, (itemSize*pageIndex)+itemSize,key));
	}
}
