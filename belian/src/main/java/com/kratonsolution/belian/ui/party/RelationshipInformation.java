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

import com.kratonsolution.belian.general.dm.PartyRelationship;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.view.OrganizationController;
import com.kratonsolution.belian.general.view.PersonController;
import com.kratonsolution.belian.ui.Refreshable;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class RelationshipInformation extends Treeitem
{
	private Treerow row = new Treerow();
	
	private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	
	public RelationshipInformation(PartyRelationship relationship,Party party)
	{
		addDescription(relationship, party);
		addIcon(party, relationship);
		appendChild(row);
	}
	
	protected void addDescription(final PartyRelationship relationship,final Party party)
	{
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		builder.append(format.format(relationship.getFrom()));
		builder.append(" - ");
		builder.append(relationship.getTo()!=null?format.format(relationship.getTo()):"");
		builder.append("] - ");
		builder.append("AS ");
		builder.append(relationship.getFromRole().getName());
		builder.append(" to ");
		builder.append(relationship.getToParty().getName());
		
		Treecell cell = new Treecell(builder.toString());
		cell.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				getTree().getParent().appendChild(new RelationshipEditWindow(party, relationship));
			}
		});
	
		row.appendChild(cell);
	}
	
	protected void addIcon(final Party party,final PartyRelationship contact)
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
	
	protected void remove(final Party party,final PartyRelationship relationship)
	{
		Iterator<PartyRelationship> iterator = party.getRelationships().iterator();
		while (iterator.hasNext())
		{
			PartyRelationship relation = (PartyRelationship) iterator.next();
			if(relation.getId().equals(relationship.getId()))
				iterator.remove();
		}
		
		if(party instanceof Person)
			Springs.get(PersonController.class).edit((Person)party);
		else if(party instanceof Organization)
			Springs.get(OrganizationController.class).edit((Organization)party);
		
		((Refreshable)getTree()).refresh();
	}
}
