/**
 * 
 */
package com.kratonsolution.belian.ui.party;

import java.util.Iterator;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Image;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.Treerow;

import com.kratonsolution.belian.general.dm.Contact;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.ui.Refreshable;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class ContactInformation extends Treeitem
{
	private Treerow row = new Treerow();
	
	public ContactInformation(Contact contact,Party party)
	{
		addDescription(contact, party);
		addIcon(party, contact);
		appendChild(row);
	}
	
	protected void addDescription(final Contact contact,final Party party)
	{
		Treecell cell = new Treecell((contact.isActive()?"Active - ":"Inactive - ")+contact.getDescription()+" - "+contact.getType());
		cell.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				getTree().getParent().appendChild(new ContactEditWindow(party, contact));
			}
		});
	
		row.appendChild(cell);
	}
	
	protected void addIcon(final Party party,final Contact contact)
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
							remove(party, contact);
					}
				});
			}
		});
		
		row.appendChild(delcell);
	}
	
	protected void remove(final Party party,final Contact contact)
	{
		Iterator<Contact> iterator = party.getContacts().iterator();
		while (iterator.hasNext())
		{
			Contact contact2 = (Contact) iterator.next();
			if(contact2.getId().equals(contact.getId()))
				iterator.remove();
		}
		
		if(party instanceof Person)
			Springs.get(PersonService.class).edit((Person)party);
		else if(party instanceof Organization)
			Springs.get(OrganizationService.class).edit((Organization)party);
		
		((Refreshable)getTree()).refresh();
	}
}