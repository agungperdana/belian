/**
 * 
 */
package com.kratonsolution.belian.ui.person;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.general.dm.Address;
import com.kratonsolution.belian.general.dm.Contact;
import com.kratonsolution.belian.general.dm.PartyRelationship;
import com.kratonsolution.belian.general.dm.PartyRole;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.Refreshable;
import com.kratonsolution.belian.ui.party.AddressAddWindow;
import com.kratonsolution.belian.ui.party.AddressInformation;
import com.kratonsolution.belian.ui.party.ContactAddWindow;
import com.kratonsolution.belian.ui.party.ContactInformation;
import com.kratonsolution.belian.ui.party.PartyInformation;
import com.kratonsolution.belian.ui.party.PartyToolbar;
import com.kratonsolution.belian.ui.party.RelationshipAddWindow;
import com.kratonsolution.belian.ui.party.RelationshipInformation;
import com.kratonsolution.belian.ui.party.RoleAddWindow;
import com.kratonsolution.belian.ui.party.RoleInformation;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class PersonEditContent extends FormContent implements Refreshable
{	
	private final PersonService controller = Springs.get(PersonService.class);
	
	private Textbox name = new Textbox();
	
	private Datebox date = new Datebox();
	
	private Textbox tax = new Textbox();
	
	private Row row;
	
	private PartyInformation information = new PartyInformation("Person Information");
	
	private PartyToolbar partyToolbar = new PartyToolbar();
	
	public PersonEditContent(Row row)
	{
		super();
		this.row = row;
		initToolbar();
		initForm();
		initInformation();
		initTree();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PersonWindow window = (PersonWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,"Name cannot be empty");
			
				Person person = new Person();
				person.setId(RowUtils.rowValue(row, 2));
				person.setName(name.getText());
				person.setBirthDate(date.getValue());
				person.setTaxCode(tax.getText());
				
				controller.edit(person);
				
				PersonWindow window = (PersonWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		Person person = controller.findOne(RowUtils.rowValue(row, 4));
		if(person != null)
		{
			name.setConstraint("no empty");
			name.setText(person.getName());
			name.setWidth("300px");
			
			date.setConstraint("no empty");
			date.setValue(person.getBirthDate());
			date.setWidth("250px");
			
			tax.setText(person.getTaxCode());
			tax.setWidth("300px");
			
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"75px"));
			grid.getColumns().appendChild(new Column());
			
			Row row1 = new Row();
			row1.appendChild(new Label("Name"));
			row1.appendChild(name);
			
			Row row2 = new Row();
			row2.appendChild(new Label("Birth Date"));
			row2.appendChild(date);
			
			Row row3 = new Row();
			row3.appendChild(new Label("Tax Number"));
			row3.appendChild(tax);
			
			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
		}
	}
	
	public void initInformation()
	{
		appendChild(partyToolbar);
		
		partyToolbar.getAddress().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				appendChild(new AddressAddWindow(controller.findOne(RowUtils.rowValue(row,4))));
			}
		});
		
		partyToolbar.getContact().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				appendChild(new ContactAddWindow(controller.findOne(RowUtils.rowValue(row,4))));
			}
		});
		
		partyToolbar.getRole().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				appendChild(new RoleAddWindow(controller.findOne(RowUtils.rowValue(row,4))));
			}
		});
		
		partyToolbar.getRelationship().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				appendChild(new RelationshipAddWindow(controller.findOne(RowUtils.rowValue(row,4))));
			}
		});
	}
	
	protected void initTree()
	{
		information = new PartyInformation("Person Information");
		
		final Person person = controller.findOne(RowUtils.rowValue(row, 4));
		if(person != null)
		{
			if(!person.getAddresses().isEmpty())
			{
				for(final Address address:person.getAddresses())
					information.addAddress(new AddressInformation(address,person));
			}
			
			if(!person.getContacts().isEmpty())
			{
				for(final Contact contact:person.getContacts())
					information.addContact(new ContactInformation(contact, person));
			}
			
			if(!person.getRoles().isEmpty())
			{
				for(final PartyRole role:person.getRoles())
					information.addRole(new RoleInformation(role, person));
			}
			
			if(!person.getRelationships().isEmpty())
			{
				for(final PartyRelationship partyRelationship:person.getRelationships())
					information.addRelationship(new RelationshipInformation(partyRelationship, person));
			}
		}
		
		appendChild(information);
	}
	
	public void refresh()
	{
		removeChild(information);
		initTree();
	}
}
