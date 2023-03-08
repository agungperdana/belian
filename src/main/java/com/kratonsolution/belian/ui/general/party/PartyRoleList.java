/**
 * 
 */
package com.kratonsolution.belian.ui.general.party;

import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.partys.dm.Party;
import com.kratonsolution.belian.partys.dm.PartyRole;
import com.kratonsolution.belian.ui.component.AbstractList;
import com.kratonsolution.belian.ui.component.ListSelectionListener;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PartyRoleList extends AbstractList<PartyRole> implements ListSelectionListener<Party>
{
	private PartyRole role;

	public PartyRoleList(boolean fullspan,Party party)
	{
		this(fullspan,party,null);
	}

	public PartyRoleList(boolean fullspan,Party party,PartyRole role)
	{
		this.role = role;

		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");

		setMold("select");

		if(party != null)
		{
			for(PartyRole pr:party.getPartyRoles())
			{
				Listitem listitem = appendItem(pr.getType().display(utils.getLanguage()), pr.getId());
				if(role != null && role.getId().equals(pr.getId()))
					setSelectedItem(listitem);

				if(!maps.containsKey(pr.getId()))
					maps.put(pr.getId(), pr);
			}
		}
	}

	@Override
	public void fireItemSelected(Party party)
	{
		if(party != null)
		{
			getItems().clear();

			for(PartyRole pr:party.getPartyRoles())
			{
				Listitem listitem = appendItem(pr.getType().display(utils.getLanguage()), pr.getId());

				if(role != null && role.getId().equals(pr.getId()))
					setSelectedItem(listitem);

				if(!maps.containsKey(pr.getId()))
					maps.put(pr.getId(), pr);
			}
		}
	}

	@Override
	public PartyRole getDomain()
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
			PartyRole role = maps.get(getSelectedItem().getValue().toString());
			
			IDValueRef ref = new IDValueRef();
			ref.setId(role.getId());
			ref.setValue(role.getType().display(utils.getLanguage()));
			
			return ref;
		}
		
		return null;
	}

	@Override
	public void setDomain(PartyRole ref)
	{
		getItems().clear();

		for(PartyRole role:maps.values())
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

		for(PartyRole role:maps.values())
		{
			Listitem listitem = appendItem(role.getType().display(utils.getLanguage()), role.getId());
			if(ref != null && ref.getId().equals(role.getId()))
				setSelectedItem(listitem);
		}
	}
}