/**
 * 
 */
package com.kratonsolution.belian.ui.general.party;

import java.text.SimpleDateFormat;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Image;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.Treerow;

import com.kratonsolution.belian.general.dm.PartyRelationship;
import com.kratonsolution.belian.global.dm.EconomicAgent;

/**
 * @author agungdodiperdana
 *
 */
public class RelationshipInformation extends Treeitem
{
	private Treerow row = new Treerow();
	
	private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	
	public RelationshipInformation(PartyRelationship relationship,EconomicAgent party)
	{
		addDescription(relationship, party);
		addIcon(party, relationship);
		appendChild(row);
	}
	
	protected void addDescription(final PartyRelationship relationship,final EconomicAgent party)
	{
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		builder.append(format.format(relationship.getFrom()));
		builder.append(" - ");
		builder.append(relationship.getTo()!=null?format.format(relationship.getTo()):"");
		builder.append("] - ");
		builder.append("AS ");
		builder.append(relationship.getType().toString());
		
		Treecell cell = new Treecell(builder.toString());
		cell.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				getTree().getParent().appendChild(new RelationshipEditWindow(relationship));
			}
		});
	
		row.appendChild(cell);
	}
	
	protected void addIcon(final EconomicAgent party,final PartyRelationship contact)
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
	
	protected void remove(final EconomicAgent party,final PartyRelationship relationship)
	{
	}
}
