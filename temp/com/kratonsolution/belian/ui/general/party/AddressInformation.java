/**
 * 
 */
package com.kratonsolution.belian.ui.general.party;

import java.util.Iterator;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Image;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.Treerow;

import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.partys.dm.Address;
import com.kratonsolution.belian.partys.dm.Organization;
import com.kratonsolution.belian.partys.dm.Party;
import com.kratonsolution.belian.partys.dm.Person;
import com.kratonsolution.belian.ui.Refreshable;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class AddressInformation extends Treeitem
{
	private Treerow row = new Treerow();
	
	public AddressInformation(Address address,Party party)
	{
		addDescription(address, party);
		addIcon(party, address);
		appendChild(row);
	}
	
	protected void addDescription(final Address address,final Party party)
	{
		Treecell cell = new Treecell(address.getAddress()+", "+address.getCity().getName()+", "+address.getProvince().getName()+", "+address.getCountry().getName());
		cell.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				getTree().getParent().appendChild(new AddressEditWindow(party, address));
			}
		});
	
		row.appendChild(cell);
	}
	
	protected void addIcon(final Party party,final Address address)
	{
		Image remove = new Image("/icons/deletesmall.png");
		Treecell delcell = new Treecell();
		delcell.appendChild(remove);
		delcell.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Messagebox.show("Are you sure want to remove the data(s) ?","Warning",Messagebox.CANCEL|Messagebox.OK, Messagebox.QUESTION,new EventListener<Event>()
				{
					@Override
					public void onEvent(Event event) throws Exception
					{
						if(event.getName().equals("onOK"))
							remove(party, address);
					}
				});
			}
		});
		
		row.appendChild(delcell);
	}
	
	protected void remove(final Party party,final Address address)
	{
		Iterator<Address> iterator = party.getAddresses().iterator();
		while (iterator.hasNext())
		{
			Address address2 = (Address) iterator.next();
			if(address2.getId().equals(address.getId()))
				iterator.remove();
		}
		
		if(party instanceof Person)
			Springs.get(PersonService.class).edit((Person)party);
		else if(party instanceof Organization)
			Springs.get(OrganizationService.class).edit((Organization)party);
		
		((Refreshable)getTree()).refresh();
	}
}
