
package com.kratonsolution.belian.ui.general.party;

import org.zkoss.zul.Listitem;

import com.google.common.base.Strings;
import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.api.dm.Observer;
import com.kratonsolution.belian.general.dm.Geographic;
import com.kratonsolution.belian.partys.dm.Address;
import com.kratonsolution.belian.partys.dm.Party;
import com.kratonsolution.belian.partys.svc.PartyService;
import com.kratonsolution.belian.ui.component.AbstractList;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PartyAddressList extends AbstractList<Address> implements Observer
{
	private PartyService service = Springs.get(PartyService.class);
	
	public PartyAddressList(boolean fullspan,Party party)
	{
		this(fullspan,party,null);
	}

	public PartyAddressList(boolean fullspan,Party party,Address address)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");

		setMold("select");

		if(party != null)
		{
			for(Address pr:party.getAddresses())
			{
				Listitem listitem = appendItem(pr.getType().display(utils.getLanguage()), pr.getId());
				if(address != null && address.getId().equals(pr.getId()))
					setSelectedItem(listitem);

				if(!maps.containsKey(pr.getId()))
					maps.put(pr.getId(), pr);
			}
		}
	}

	@Override
	public Address getDomain()
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
			Address address = maps.get(getSelectedItem().getValue().toString());
			
			IDValueRef ref = new IDValueRef();
			ref.setId(address.getId());
			ref.setValue(address.getAddress()+"("+address.getType().display(utils.getLanguage())+")");
			ref.setType(Geographic.class.getSimpleName());
			
			return ref;
		}
		
		return null;
	}

	@Override
	public void setDomain(Address ref)
	{
		getItems().clear();

		if(ref != null && !maps.containsKey(ref.getId()))
			maps.put(ref.getId(), ref);
		
		for(Address role:maps.values())
		{
			Listitem listitem = appendItem(role.getType().display(utils.getLanguage()), role.getId());
			if(ref != null && ref.getId().equals(role.getId()))
				setSelectedItem(listitem);
		}
	}

	@Override
	public void setDomainAsRef(IDValueRef ref)
	{
		getItems().clear();
		
		if(ref != null && !maps.containsKey(ref.getId()))
			maps.put(ref.getId(), new Address(ref));

		for(Address role:maps.values())
		{
			Listitem listitem = appendItem(role.getType().display(utils.getLanguage()), role.getId());
			if(ref != null && ref.getId().equals(role.getId()))
				setSelectedItem(listitem);
		}
	}

	@Override
	public void valueChange(IDValueRef value)
	{
		if(value != null && !Strings.isNullOrEmpty(value.getId()))
		{
			getItems().clear();

			Party party = service.findById(value.getId());
			if(party != null)
			{
				for(Address pr:party.getAddresses())
				{
					setSelectedItem(appendItem(pr.getAddress()+" ("+pr.getType().display(utils.getLanguage())+")", pr.getId()));;

					if(!maps.containsKey(pr.getId()))
						maps.put(pr.getId(), pr);
				}
			}
		}
	}
}