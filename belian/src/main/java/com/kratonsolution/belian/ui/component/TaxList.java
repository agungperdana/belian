/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.accounting.dm.Tax;
import com.kratonsolution.belian.accounting.svc.TaxService;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class TaxList extends Listbox
{
	private TaxService service = Springs.get(TaxService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);

	private Language lang = Springs.get(Language.class);
	
	private Map<String,Tax> maps = new HashMap<>();

	public TaxList()
	{
		setMold("select");
		setWidth("250px");
		
		for(Tax tax:service.findAll())
		{
			Listitem listitem = appendItem(tax.getLabel(), tax.getValue());
			if(tax.isBase())
				setSelectedItem(listitem);
			
			if(utils.getTax() != null && utils.getTax().getId().equals(tax.getId()))
				setSelectedItem(listitem);
		
			if(!maps.containsKey(tax.getId()))
				maps.put(tax.getId(), tax);
		}
	}
	
	public Tax getTax()
	{
		if(getSelectedItem() == null)
			throw new WrongValueException(this,lang.get("message.field.empty"));
		
		return maps.get(getSelectedItem().getValue().toString());
	}
}
