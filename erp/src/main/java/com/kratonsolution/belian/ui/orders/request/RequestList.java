
package com.kratonsolution.belian.ui.orders.request;

import org.zkoss.zul.Listitem;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.persistence.IDValueRef;
import com.kratonsolution.belian.orders.dm.Request;
import com.kratonsolution.belian.orders.svc.RequestService;
import com.kratonsolution.belian.ui.component.AbstractList;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class RequestList extends AbstractList<Request>
{	
	private RequestService service = Springs.get(RequestService.class);
	
	public RequestList(boolean fullspan)
	{
		this(fullspan,null);
	}

	public RequestList(boolean fullspan,Request request)
	{
		super();
		
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
	}

	@Override
	public Request getDomain()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue()))
			return maps.get(getSelectedItem().getValue());

		return null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue()))
		{
			Request request = maps.get(getSelectedItem().getValue());
			
			IDValueRef ref = new IDValueRef();
			ref.setId(request.getId());
			ref.setValue(request.getNumber());
			
			return ref;
		}

		return null;
	}

	@Override
	public void setDomain(Request com)
	{
		getItems().clear();

		for(Request org:maps.values())
		{
			Listitem item = appendItem(org.getNumber(), org.getId());

			if(com != null && org.getId().equals(com.getId()))
				setSelectedItem(item);
		}
	}

	@Override
	public void setDomainAsRef(IDValueRef com)
	{
		getItems().clear();

		for(Request org:maps.values())
		{
			Listitem item = appendItem(org.getNumber(), org.getId());

			if(com != null && org.getId().equals(com.getId()))
				setSelectedItem(item);
		}
	}
	
	public void refresh(String responding)
	{
		getItems().clear();
		
		if(!Strings.isNullOrEmpty(responding))
		{
			for(Request request:service.findAllUnclosed(utils.getOrganization().getId(), responding))
				appendItem(request.getNumber(), request.getId());
		}
	}
}
