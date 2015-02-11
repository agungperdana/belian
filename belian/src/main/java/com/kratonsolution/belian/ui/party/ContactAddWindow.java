/**
 * 
 */
package com.kratonsolution.belian.ui.party;

import java.util.UUID;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.general.dm.Contact;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.view.OrganizationController;
import com.kratonsolution.belian.general.view.PersonController;
import com.kratonsolution.belian.ui.FormToolbar;
import com.kratonsolution.belian.ui.Refreshable;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class ContactAddWindow extends Window
{
	private FormToolbar toolbar = new FormToolbar();
	
	private Grid layout = new Grid();
	
	private Textbox number = new Textbox();
	
	private Listbox type = new Listbox();
	
	private Checkbox status = new Checkbox("Active");
	
	private PersonController personController = Springs.get(PersonController.class);
	
	private OrganizationController organizationController = Springs.get(OrganizationController.class);
	
	private Party party;
	
	public ContactAddWindow(Party party)
	{
		this.party = party;
		
		setMode(Mode.POPUP);
		setWidth("450px");
		setHeight("400px");
		setPosition("center");
		
		Caption caption = new Caption("Contact");
		caption.setImage("/icons/contact.png");
	
		type.setMold("select");
		
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
						Contact contact = new Contact();
						contact.setId(UUID.randomUUID().toString());
						contact.setDescription(number.getText());
						contact.setActive(status.isChecked());
						contact.setType(Contact.Type.valueOf(type.getSelectedItem().getValue().toString()));
					
						organization.getContacts().add(contact);
						
						organizationController.edit(organization);
						
						((Refreshable)getParent()).refresh();
					}
				}
				
				if(party instanceof Person)
				{
					Person person = personController.findOne(party.getId());
					if(person != null)
					{
						Contact contact = new Contact();
						contact.setId(UUID.randomUUID().toString());
						contact.setDescription(number.getText());
						contact.setActive(status.isChecked());
						contact.setType(Contact.Type.valueOf(type.getSelectedItem().getValue().toString()));
					
						person.getContacts().add(contact);
						
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
		number.setWidth("300px");
		number.setConstraint("no empty");
		
		layout.appendChild(new Rows());
		layout.appendChild(new Columns());
		layout.getColumns().appendChild(new Column(null,null,"75px"));
		layout.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Number"));
		row1.appendChild(number);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Status"));
		row3.appendChild(status);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Type"));
		row4.appendChild(type);

		for(Contact.Type _type:Contact.Type.values())
			type.appendChild(new Listitem(_type.name(),_type.name()));
		
		type.setSelectedIndex(0);
		
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
