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
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.general.dm.Address;
import com.kratonsolution.belian.general.dm.Contact;
import com.kratonsolution.belian.general.dm.PartyRelationship;
import com.kratonsolution.belian.general.dm.PartyRole;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.dm.Person.Gender;
import com.kratonsolution.belian.general.dm.Person.MaritalStatus;
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
	private final PersonService service = Springs.get(PersonService.class);

	private Textbox name = new Textbox();

	private Datebox date = new Datebox();

	private Textbox tax = new Textbox();

	private Listbox genders = new Listbox();

	private Listbox maritals = new Listbox();

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

				Person person = service.findOne(RowUtils.rowValue(row, 6));
				person.setName(name.getText());
				person.setBirthDate(date.getValue());
				person.setTaxCode(tax.getText());
				person.setGender(Gender.valueOf(genders.getSelectedItem().getValue().toString()));
				person.setMaritalStatus(MaritalStatus.valueOf(maritals.getSelectedItem().getValue().toString()));

				service.edit(person);

				PersonWindow window = (PersonWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		Person person = service.findOne(RowUtils.rowValue(row, 6));
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

			genders.setMold("select");
			genders.appendChild(new Listitem(Gender.MALE.toString(), Gender.MALE.toString()));
			genders.appendChild(new Listitem(Gender.FEMALE.toString(), Gender.FEMALE.toString()));
			
			if(person.getGender().equals(Gender.MALE))
				genders.setSelectedIndex(0);
			else
				genders.setSelectedIndex(1);
				
			maritals.setMold("select");
			maritals.appendChild(new Listitem(MaritalStatus.SINGLE.toString(), MaritalStatus.SINGLE.toString()));
			maritals.appendChild(new Listitem(MaritalStatus.MARIED.toString(), MaritalStatus.MARIED.toString()));
			maritals.appendChild(new Listitem(MaritalStatus.DEFORCE.toString(), MaritalStatus.DEFORCE.toString()));
			
			if(person.getMaritalStatus().equals(MaritalStatus.SINGLE))
				maritals.setSelectedIndex(0);
			else if(person.getMaritalStatus().equals(MaritalStatus.MARIED))
				maritals.setSelectedIndex(1);
			else
				maritals.setSelectedIndex(2);
				
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
			
			Row row4 = new Row();
			row4.appendChild(new Label("Gender"));
			row4.appendChild(genders);
			
			Row row5 = new Row();
			row5.appendChild(new Label("Status"));
			row5.appendChild(maritals);
			
			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
			rows.appendChild(row4);
			rows.appendChild(row5);
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
				appendChild(new AddressAddWindow(RowUtils.rowValue(row,6)));
			}
		});

		partyToolbar.getContact().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				appendChild(new ContactAddWindow(RowUtils.rowValue(row,6)));
			}
		});

		partyToolbar.getRole().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				appendChild(new RoleAddWindow(RowUtils.rowValue(row,6)));
			}
		});

		partyToolbar.getRelationship().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				appendChild(new RelationshipAddWindow(RowUtils.rowValue(row,6)));
			}
		});
	}

	protected void initTree()
	{
		information = new PartyInformation("Person Information");

		final Person person = service.findOne(RowUtils.rowValue(row, 6));
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
