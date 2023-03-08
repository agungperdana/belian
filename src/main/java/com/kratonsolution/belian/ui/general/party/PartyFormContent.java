/**
 * 
 */
package com.kratonsolution.belian.ui.general.party;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.dm.GeographicType;
import com.kratonsolution.belian.partys.dm.Address;
import com.kratonsolution.belian.partys.dm.Contact;
import com.kratonsolution.belian.partys.dm.Gender;
import com.kratonsolution.belian.partys.dm.Organization;
import com.kratonsolution.belian.partys.dm.Party;
import com.kratonsolution.belian.partys.dm.Person;
import com.kratonsolution.belian.partys.svc.OrganizationService;
import com.kratonsolution.belian.partys.svc.PartyService;
import com.kratonsolution.belian.partys.svc.PersonService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.general.country.CountryList;
import com.kratonsolution.belian.ui.general.geographic.GeographicList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PartyFormContent extends AbstractForm
{	
	private PartyService partyService = Springs.get(PartyService.class);
	
	private PersonService personService = Springs.get(PersonService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);

	private Radiogroup radiogroup = new Radiogroup();
	
	private Radio org = new Radio(lang.get("navbar.menu.general.organization"));
	
	private Radio peo = new Radio(lang.get("navbar.menu.general.person"));
	
	private Textbox code = Components.mandatoryTextBox(false);

	private Textbox name = Components.mandatoryTextBox(false);

	private GeographicList birthPlace = new GeographicList(false,GeographicType.CITY);

	private Datebox birthDate = Components.currentDatebox();

	private Textbox taxCode = Components.stdTextBox(null, false);

	private GenderList genders = new GenderList(false,Gender.MALE);
	
	private Tabbox tabbox = new Tabbox();

	private Grid address = new Grid();

	private Grid contacts = new Grid();
	
	private PartyBox box;
	
	public PartyFormContent(PartyBox box,boolean isPerson)
	{
		super();
		if(isPerson)
			peo.setChecked(true);
		else
			org.setChecked(true);
		
		this.box = box;
		initToolbar();
		initForm();
		initTab();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				getParent().detach();
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(code,lang.get("message.field.empty"));

				if(name.getValue() == null)
					throw new WrongValueException(name,lang.get("message.field.empty"));

				Party party = null;
				
				if(org.isChecked())
					party = new Organization();
				else
				{
					party = new Person();
					((Person)party).setGender(genders.getGender());
				}
				
				party.setCode(code.getText());
				party.setName(name.getText());
				party.setBirthPlace(birthPlace.getDomain());
				party.setBirthDate(DateTimes.sql(birthDate.getValue()));
				party.setTaxCode(taxCode.getText());
				
				for(Component com:address.getRows().getChildren())
				{
					Row rw = (Row)com;
					
					GeographicList city = (GeographicList)rw.getChildren().get(3);
					GeographicList province = (GeographicList)rw.getChildren().get(4);
					CountryList country = (CountryList)rw.getChildren().get(5);
					AddressTypeList type = (AddressTypeList)rw.getChildren().get(6);
					
					Address add = new Address();
					add.setActive(RowUtils.isChecked(rw, 7));
					add.setAddress(RowUtils.string(rw, 1));
					add.setCity(city.getDomain());
					add.setCountry(country.getCountry());
					add.setParty(party);
					add.setPostal(RowUtils.string(rw, 2));
					add.setProvince(province.getDomain());
					add.setType(type.getAddressType());
					
					party.getAddresses().add(add);
				}
				
				for(Component com:contacts.getRows().getChildren())
				{
					Row rw = (Row)com;
					
					ContactTypeList type = (ContactTypeList)rw.getChildren().get(2);

					Contact contact = new Contact();
					contact.setActive(RowUtils.isChecked(rw, 3));
					contact.setContact(RowUtils.string(rw, 1));
					contact.setParty(party);
					contact.setType(type.getContactType());
					
					party.getContacts().add(contact);
				}

				if(org.isChecked())
					organizationService.add((Organization)party);
				else
					personService.add((Person)party);

				box.setDomain(party);
				
				getParent().detach();
			}
		});
	}

	@Override
	public void initForm()
	{
		org.setDisabled(true);
		peo.setDisabled(true);
		
		radiogroup.setStyle("padding:5px;");
		radiogroup.appendChild(org);
		radiogroup.appendChild(peo);
		
		code.addEventListener(Events.ON_CHANGING, new EventListener<InputEvent>()
		{
			@Override
			public void onEvent(InputEvent event) throws Exception
			{
				if(!Strings.isNullOrEmpty(event.getValue()))
				{
					Party party = partyService.findByCode(event.getValue());
					if(party != null)
						throw new WrongValueException(lang.get("message.field.exist"));
				}
			}
		});

		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());

		Row row0 = new Row();
		row0.appendChild(new Label(lang.get("person.grid.column.code")));
		row0.appendChild(radiogroup);
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("person.grid.column.code")));
		row1.appendChild(code);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("person.grid.column.name")));
		row2.appendChild(name);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("person.grid.column.birthplace")));
		row3.appendChild(birthPlace);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("person.grid.column.birthdate")));
		row4.appendChild(birthDate);

		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("person.grid.column.tax")));
		row5.appendChild(taxCode);

		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("person.grid.column.gender")));
		row6.appendChild(genders);

		rows.appendChild(row0);
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		
		if(peo.isChecked())
			rows.appendChild(row6);
		else
			rows.removeChild(row6);
	}
	
	public void initTab()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab(lang.get("person.grid.column.address")));
		tabbox.getTabs().appendChild(new Tab(lang.get("person.grid.column.contacts")));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		
		appendChild(tabbox);
		
		initAddress();
		initContacts();
	}
	
	private void initAddress()
	{
		address.setWidth("100%");
		address.setEmptyMessage(lang.get("message.grid.empty"));
		address.appendChild(new Columns());
		address.appendChild(new Rows());
		address.getColumns().appendChild(new Column(null,null,"25px"));
		address.getColumns().appendChild(new Column(lang.get("person.grid.column.description")));
		address.getColumns().appendChild(new Column(lang.get("person.grid.column.postal"),null,"80px"));
		address.getColumns().appendChild(new Column(lang.get("person.grid.column.city"),null,"100px"));
		address.getColumns().appendChild(new Column(lang.get("person.grid.column.province"),null,"100px"));
		address.getColumns().appendChild(new Column(lang.get("person.grid.column.country"),null,"100px"));
		address.getColumns().appendChild(new Column(lang.get("person.grid.column.type"),null,"100px"));
		address.getColumns().appendChild(new Column(lang.get("person.grid.column.status"),null,"70px"));
		address.setSpan("1");
		
		NRCToolbar nrc = new NRCToolbar(address);
		nrc.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryTextBox(true));
				row.appendChild(Components.textBox(null));
				row.appendChild(new GeographicList(true,GeographicType.CITY));
				row.appendChild(new GeographicList(true,GeographicType.PROVINCE));
				row.appendChild(new CountryList(true));
				row.appendChild(new AddressTypeList(true));
				row.appendChild(Components.status(true));
				
				address.getRows().appendChild(row);
			}
		});
		
		tabbox.getTabpanels().getFirstChild().appendChild(nrc);
		tabbox.getTabpanels().getFirstChild().appendChild(address);
	}
	
	private void initContacts()
	{
		contacts.setWidth("100%");
		contacts.setEmptyMessage(lang.get("message.grid.empty"));
		contacts.appendChild(new Columns());
		contacts.appendChild(new Rows());
		contacts.getColumns().appendChild(new Column(null,null,"25px"));
		contacts.getColumns().appendChild(new Column(lang.get("person.grid.column.description")));
		contacts.getColumns().appendChild(new Column(lang.get("person.grid.column.type"),null,"100px"));
		contacts.getColumns().appendChild(new Column(lang.get("person.grid.column.status"),null,"80px"));
		contacts.setSpan("1");
		
		NRCToolbar nrc = new NRCToolbar(contacts);
		nrc.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryTextBox(true));
				row.appendChild(new ContactTypeList(true));
				row.appendChild(Components.status(true));
				
				contacts.getRows().appendChild(row);
			}
		});
		
		tabbox.getTabpanels().getChildren().get(1).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(1).appendChild(contacts);
	}
}
