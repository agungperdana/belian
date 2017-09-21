/**
 * 
 */
package com.kratonsolution.belian.ui.finance.invoices;

import org.zkoss.zul.Listitem;

import com.google.common.base.Strings;
import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.invoice.dm.InvoiceItem;
import com.kratonsolution.belian.ui.component.AbstractList;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class InvoiceItemList extends AbstractList<InvoiceItem>
{
	
	public InvoiceItemList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public InvoiceItemList(boolean fullspan,InvoiceItem con)
	{
		super();
		
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setSelectedItem(null);
	}

	@Override
	public InvoiceItem getDomain()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		InvoiceItem item = getDomain();
		if( item != null)
		{
			IDValueRef ref = new IDValueRef();
			ref.setId(item.getId());
			
			if(!Strings.isNullOrEmpty(item.getProduct().getValue()))
				ref.setValue(item.getProduct().getValue());
			else if(!Strings.isNullOrEmpty(item.getFeature().getValue()))
				ref.setValue(item.getFeature().getValue());
			
			return ref;
		}
		
		return null;
	}

	@Override
	public void setDomain(InvoiceItem domain)
	{
		if(domain != null && !Strings.isNullOrEmpty(domain.getId()))
		{
			if(!maps.containsKey(domain.getId()))
			{
				maps.put(domain.getId(), domain);
				
				Listitem item = new Listitem();
				
				if(!Strings.isNullOrEmpty(domain.getProduct().getValue()))
				{
					item.setValue(domain.getId());
					item.setLabel(domain.getProduct().getValue());
				}
				else if(!Strings.isNullOrEmpty(domain.getFeature().getValue()))
				{
					item.setValue(domain.getFeature().getId());
					item.setLabel(domain.getFeature().getValue());
				}
				
				setSelectedItem(item);
			}
			else
			{
				for(Listitem item:getItems())
				{
					if(item.getValue().toString().equals(domain.getId()))
					{
						setSelectedItem(item);
						break;
					}
				}
			}
		}
	}

	@Override
	public void setDomainAsRef(IDValueRef ref)
	{
		setDomain(new InvoiceItem(ref));
	}
}
