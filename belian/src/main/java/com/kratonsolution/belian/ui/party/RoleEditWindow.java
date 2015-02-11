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
import com.kratonsolution.belian.general.dm.PartyRole;
import com.kratonsolution.belian.general.dm.PartyRoleType;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.view.OrganizationController;
import com.kratonsolution.belian.general.view.PartyRoleTypeController;
import com.kratonsolution.belian.general.view.PersonController;
import com.kratonsolution.belian.ui.FormToolbar;
import com.kratonsolution.belian.ui.Refreshable;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class RoleEditWindow extends Window
{
	private FormToolbar toolbar = new FormToolbar();
	
	private Grid layout = new Grid();
	
	private Datebox from = new Datebox();
	
	private Datebox to = new Datebox();
	
	private Listbox roles = new Listbox();
	
	private PersonController personController = Springs.get(PersonController.class);
	
	private OrganizationController organizationController = Springs.get(OrganizationController.class);

	private PartyRoleTypeController partyRoleTypeController = Springs.get(PartyRoleTypeController.class);
	
	private Party party;
	
	private PartyRole edited;
	
	public RoleEditWindow(Party party,PartyRole edited)
	{
		this.party = party;
		this.edited = edited;
		
		setMode(Mode.POPUP);
		setWidth("450px");
		setHeight("400px");
		setPosition("center");
		
		Caption caption = new Caption("Party Role");
		caption.setImage("/icons/contact.png");
		
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
						for(PartyRole on:organization.getRoles())
						{
							if(on.getId().equals(edited.getId()))
							{
								on.setFrom(from.getValue());
								on.setTo(to.getValue());
								on.setType(partyRoleTypeController.findOne(roles.getSelectedItem().getValue().toString()));
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
						for(PartyRole on:person.getRoles())
						{
							if(on.getId().equals(edited.getId()))
							{
								on.setFrom(from.getValue());
								on.setTo(to.getValue());
								on.setType(partyRoleTypeController.findOne(roles.getSelectedItem().getValue().toString()));
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
		roles.setMold("select");
		
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
		row4.appendChild(roles);
		
		for(PartyRoleType type:partyRoleTypeController.findAll())
		{
			Listitem listitem = new Listitem(type.getName(),type.getId());
			roles.appendChild(listitem);
			
			if(type.getId().equals(edited.getType().getId()))
				roles.setSelectedItem(listitem);
		}
		
		layout.getRows().appendChild(row1);
		layout.getRows().appendChild(row3);
		layout.getRows().appendChild(row4);
	}
	
	@Override
	public void onClose()
	{
		setVisible(false);
		setParent(null);
	}
}
