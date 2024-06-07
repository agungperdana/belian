
package com.kratonsolution.belian.ui.general.party;

import org.zkoss.zul.Listitem;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.orm.IDValueRef;
import com.kratonsolution.belian.common.orm.Observer;
import com.kratonsolution.belian.core.party.impl.orm.Contact;
import com.kratonsolution.belian.core.party.impl.orm.Party;
import com.kratonsolution.belian.core.party.impl.application.PartyService;
import com.kratonsolution.belian.ui.component.AbstractList;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PartyContactList extends AbstractList<Contact> implements Observer
{
	private PartyService service = Springs.get(PartyService.class);
	
	public PartyContactList(boolean fullspan,Party party)
	{
		this(fullspan,party,null);
	}

	public PartyContactList(boolean fullspan,Party party,Contact address)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");

		setMold("select");

		if(party != null)
		{
			for(Contact pr:party.getContacts())
			{
				Listitem listitem = appendItem(pr.getContact()+" ("+pr.getType().display(utils.getLanguage())+")", pr.getId());
				if(address != null && address.getId().equals(pr.getId()))
					setSelectedItem(listitem);

				if(!maps.containsKey(pr.getId()))
					maps.put(pr.getId(), pr);
			}
		}
	}

	@Override
	public Contact getDomain()
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
			Contact address = maps.get(getSelectedItem().getValue().toString());
			
			IDValueRef ref = new IDValueRef();
			ref.setId(address.getId());
			ref.setValue(address.getContact()+"("+address.getType().display(utils.getLanguage())+")");
			
			return ref;
		}
		
		return null;
	}

	@Override
	public void setDomain(Contact ref)
	{
		getItems().clear();
		
		if(ref != null && !maps.containsKey(ref.getId()))
			maps.put(ref.getId(), ref);

		for(Contact role:maps.values())
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
			maps.put(ref.getId(), new Contact(ref));
		
		for(Contact role:maps.values())
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
			for(Contact contact:party.getContacts())
			{
				setSelectedItem(appendItem(contact.getContact()+" ("+contact.getType().display(utils.getLanguage())+")", contact.getId()));;

				if(!maps.containsKey(contact.getId()))
					maps.put(contact.getId(), contact);
			}
		}
	}
}