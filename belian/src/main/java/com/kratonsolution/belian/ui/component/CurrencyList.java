/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.svc.CurrencyService;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CurrencyList extends Listbox
{
	private CurrencyService service = Springs.get(CurrencyService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Language lang = Springs.get(Language.class);
	
	private Map<String,Currency> maps = new HashMap<>();
	
	public CurrencyList()
	{
		setMold("select");
		setWidth("250px");
		
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
	
	public Currency getCurrency()
	{
		if(getSelectedItem() == null)
			throw new WrongValueException(this,lang.get("message.field.empty"));
		
		return maps.get(getSelectedItem().getValue().toString());
	}
	
	public void setCurrency(Currency currency)
	{
		if(currency != null)
		{
			getItems().clear();
			appendItem(currency.getLabel(), currency.getValue());
			setSelectedIndex(0);
			
			if(!maps.containsKey(currency.getId()))
				maps.put(currency.getId(), currency);
		}
	}
}
