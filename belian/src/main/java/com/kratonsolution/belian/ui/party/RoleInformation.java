/**
 * 
 */
package com.kratonsolution.belian.ui.party;

import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Image;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.Treerow;

import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.PartyRole;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.global.dm.EconomicAgent;
import com.kratonsolution.belian.ui.Refreshable;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class RoleInformation extends Treeitem
{
	private Treerow row = new Treerow();
	
	private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	
	public RoleInformation(PartyRole role,EconomicAgent party)
	{
		addDescription(role, party);
		addIcon(party, role);
		appendChild(row);
	}
	
	protected void addDescription(final PartyRole role,final EconomicAgent party)
	{
		Treecell cell = new Treecell("["+format.format(role.getFrom())+" - "+(role.getTo()!=null?format.format(role.getTo()):"")+"]"+" AS  "+role.getType().getName());
		cell.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				getTree().getParent().appendChild(new RoleEditWindow(role));
			}
		});
	
		row.appendChild(cell);
	}
	
	protected void addIcon(final EconomicAgent party,final PartyRole role)
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
							remove(party, role);
					}
				});
			}
		});
		
		row.appendChild(delcell);
	}
	
	protected void remove(final EconomicAgent party,final PartyRole role)
	{
		Iterator<PartyRole> iterator = party.getRoles().iterator();
		while (iterator.hasNext())
		{
			PartyRole role2 = (PartyRole) iterator.next();
			if(role2.getId().equals(role.getId()))
				iterator.remove();
		}
		
		if(party instanceof Person)
			Springs.get(PersonService.class).edit((Person)party);
		else if(party instanceof Organization)
			Springs.get(OrganizationService.class).edit((Organization)party);
		
		((Refreshable)getTree()).refresh();
	}
}
