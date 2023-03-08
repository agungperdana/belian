/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.currency;

import org.zkoss.zul.Listitem;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.svc.CurrencyService;
import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.ui.component.AbstractList;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CurrencyList extends AbstractList<Currency>
{
	private CurrencyService service = Springs.get(CurrencyService.class);
	
	public CurrencyList(boolean fullspan)
	{
		setMold("select");

		if(!fullspan)
			setWidth("250px");
		else
			setWidth("100%");
		
		for(Currency currency:service.findAll())
		{
			Listitem item = appendItem(currency.getLabel(), currency.getValue());
			
			if(!maps.containsKey(currency.getId()))
				maps.put(currency.getId(), currency);
			
			if(currency.isBase())
				setSelectedItem(item);
			
			if(utils.getCurrency() != null && currency.getId().equals(utils.getCurrency().getId()))
				setSelectedItem(item);
		}
	}

	@Override
	public Currency getDomain()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
		{
			Currency currency = maps.get(getSelectedItem().getValue().toString());

			IDValueRef ref = new IDValueRef();
			ref.setId(currency.getId());
			ref.setValue(currency.getName());
			ref.setType(Currency.class.getSimpleName());
			
			return ref;
		}
		
		return null;
	}

	@Override
	public void setDomain(Currency currency)
	{
		getItems().clear();

		if(currency != null && !maps.containsKey(currency.getId()))
			maps.put(currency.getId(), currency);
		
		for(Currency cache:maps.values())
		{
			Listitem item = appendItem(currency.getValue(), currency.getId());
			if(currency != null && !Strings.isNullOrEmpty(currency.getId())  && currency.getId().equals(cache.getId()))
				setSelectedItem(item);
		}
	}

	@Override
	public void setDomainAsRef(IDValueRef currency)
	{
		getItems().clear();
		
		if(currency != null && !maps.containsKey(currency.getId()))
			maps.put(currency.getId(), new Currency(currency));

		for(Currency cache:maps.values())
		{
			Listitem item = appendItem(cache.getName(),cache.getId());
			if(currency != null && !Strings.isNullOrEmpty(currency.getId()) && currency.getId().equals(cache.getId()))
				setSelectedItem(item);
		}
	}
}
