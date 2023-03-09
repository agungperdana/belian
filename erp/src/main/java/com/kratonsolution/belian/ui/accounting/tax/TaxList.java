
package com.kratonsolution.belian.ui.accounting.tax;

import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.accounting.dm.Tax;
import com.kratonsolution.belian.accounting.svc.TaxService;
import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.ui.component.AbstractList;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class TaxList extends AbstractList<Tax>
{
	private TaxService service = Springs.get(TaxService.class);

	public TaxList(boolean fullspan)
	{
		setMold("select");

		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");

		for(Tax tax:service.findAll())
		{
			Listitem listitem = appendItem(tax.getLabel(), tax.getValue());
			if(tax.isBase())
				setSelectedItem(listitem);

			if(utils.getTax() != null && utils.getTax().getId().equals(tax.getId()))
				setSelectedItem(listitem);

			if(!maps.containsKey(tax.getId()))
				maps.put(tax.getLabel(), tax);
		}
	}

	public Tax getTax()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getLabel()))
			return maps.get(getSelectedItem().getLabel());

		return null;
	}

	public void setTax(Tax tax)
	{
		if(tax != null)
		{
			getItems().clear();
			appendItem(tax.getLabel(), tax.getValue());
			setSelectedIndex(0);

			if(!maps.containsKey(tax.getLabel()))
				maps.put(tax.getLabel(), tax);
		}
	}

	@Override
	public Tax getDomain()
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
			Tax tax = maps.get(getSelectedItem().getValue().toString());
			
			IDValueRef ref = new IDValueRef();
			ref.setId(tax.getId());
			ref.setValue(tax.getCode());
			
			return ref;
		}
		
		return null;
	}

	@Override
	public void setDomain(Tax ref)
	{
		getItems().clear();

		for(Tax tax:maps.values())
		{
			Listitem listitem = appendItem(tax.getCode(), tax.getId());
			if(ref != null && ref.getId().equals(tax.getId()))
				setSelectedItem(listitem);
		}
	}

	@Override
	public void setDomainAsRef(IDValueRef ref)
	{
		getItems().clear();

		for(Tax tax:maps.values())
		{
			Listitem listitem = appendItem(tax.getCode(), tax.getId());
			if(ref != null && ref.getId().equals(tax.getId()))
				setSelectedItem(listitem);
		}
	}
}
