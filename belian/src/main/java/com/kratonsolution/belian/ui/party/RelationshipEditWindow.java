/**
 * 
 */
package com.kratonsolution.belian.ui.party;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.dm.PartyRelationship;
import com.kratonsolution.belian.general.dm.PartyRelationshipType;
import com.kratonsolution.belian.general.dm.PartyRepository;
import com.kratonsolution.belian.general.dm.PartyRole;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.view.OrganizationController;
import com.kratonsolution.belian.general.view.PartyRelationshipTypeController;
import com.kratonsolution.belian.general.view.PartyRoleTypeController;
import com.kratonsolution.belian.general.view.PersonController;
import com.kratonsolution.belian.ui.FormToolbar;
import com.kratonsolution.belian.ui.Refreshable;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class RelationshipEditWindow extends Window
{
	private FormToolbar toolbar = new FormToolbar();
	
	private Grid layout = new Grid();
	
	private Datebox from = new Datebox();
	
	private Datebox to = new Datebox();
	
	private Listbox types = new Listbox();
	
	private Listbox fromRole = new Listbox();
	
	private Listbox toParty = new Listbox();
	
	private PersonController personController = Springs.get(PersonController.class);
	
	private OrganizationController organizationController = Springs.get(OrganizationController.class);

	private PartyRelationshipTypeController relationshipTypeController = Springs.get(PartyRelationshipTypeController.class);
	
	private PartyRepository partyRepository = Springs.get(PartyRepository.class);
	
	private PartyRoleTypeController roleTypeController = Springs.get(PartyRoleTypeController.class);
	
	private Party party;
	
	private PartyRelationship edited;
	
	public RelationshipEditWindow(Party party,PartyRelationship edited)
	{
		this.party = party;
		this.edited = edited;
		
		setMode(Mode.POPUP);
		setWidth("450px");
		setHeight("400px");
		setPosition("center");
		
		Caption caption = new Caption("Party Relationship");
		caption.setImage("/icons/relationshiptype.png");
		
		appendChild(caption);
		appendChild(toolbar);
		appendChild(layout);
		setClosable(true);
		
		initToolbar();
		initContent();
	}
	
	protected void initToolbar()
	{
		toolbar.setHeight("35px");
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				detach();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(party instanceof Organization)
				{
					Organization organization = organizationController.findOne(party.getId());
					if(organization != null)
					{
						for(PartyRelationship on:organization.getRelationships())
						{
							if(on.getId().equals(edited.getId()))
							{
								on.setFrom(from.getValue());
								on.setTo(to.getValue());
								on.setType(relationshipTypeController.findOne(types.getSelectedItem().getValue().toString()));
								on.setToParty(partyRepository.findOne(toParty.getSelectedItem().getValue().toString()));
								on.setFromRole(roleTypeController.findOne(fromRole.getSelectedItem().getValue().toString()));
								
								break;
							}
						}
						
						organizationController.edit(organization);
						((Refreshable)getParent()).refresh();
					}
				}
				
				if(party instanceof Person)
				{
					Person person = personController.findOne(party.getId());
					if(person != null)
					{
						for(PartyRelationship on:person.getRelationships())
						{
							if(on.getId().equals(edited.getId()))
							{
								on.setFrom(from.getValue());
								on.setTo(to.getValue());
								on.setType(relationshipTypeController.findOne(types.getSelectedItem().getValue().toString()));
								on.setToParty(partyRepository.findOne(toParty.getSelectedItem().getValue().toString()));
								on.setFromRole(roleTypeController.findOne(fromRole.getSelectedItem().getValue().toString()));
								break;
							}
						}
						
						personController.edit(person);
						((Refreshable)getParent()).refresh();
					}
				}
				
				detach();
			}
		});
	}
	
	protected void initContent()
	{
		from.setConstraint("no empty");
		from.setValue(edited.getFrom());
		
		to.setValue(edited.getTo());
		to.setValue(edited.getTo());
		
		types.setMold("select");
		fromRole.setMold("select");
		toParty.setMold("select");
		
		layout.appendChild(new Rows());
		layout.appendChild(new Columns());
		layout.getColumns().appendChild(new Column(null,null,"75px"));
		layout.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("From"));
		row1.appendChild(from);
		
		Row row3 = new Row();
		row3.appendChild(new Label("To"));
		row3.appendChild(to);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Type"));
		row4.appendChild(types);
		
		Row row5 = new Row();
		row5.appendChild(new Label("From Role"));
		row5.appendChild(fromRole);
		
		Row row6 = new Row();
		row6.appendChild(new Label("To Party"));
		row6.appendChild(toParty);
		
		for(PartyRelationshipType type:relationshipTypeController.findAll())
		{
			Listitem listitem = new Listitem(type.getName(),type.getId());
			types.appendChild(listitem);
			
			if(type.getId().equals(edited.getType().getId()))
				types.setSelectedItem(listitem);
		}
		
		for(Party pty:partyRepository.findAll())
		{
			Listitem listitem = new Listitem(pty.getName(),pty.getId());
			toParty.appendChild(listitem);
			
			if(pty.getId().equals(edited.getToParty().getId()))
				toParty.setSelectedItem(listitem);
		}
		
		for(PartyRole role:party.getRoles())
		{
			Listitem listitem = new Listitem(role.getType().getName(),role.getType().getId());
			fromRole.appendChild(listitem);
			
			if(role.getType().getId().equals(edited.getFromRole().getId()))
				fromRole.setSelectedItem(listitem);
		}
		
		layout.getRows().appendChild(row1);
		layout.getRows().appendChild(row3);
		layout.getRows().appendChild(row4);
		layout.getRows().appendChild(row5);
		layout.getRows().appendChild(row6);
	}
	
	@Override
	public void onClose()
	{
		setVisible(false);
		setParent(null);
	}
}
