
package com.kratonsolution.belian.ui.general.person;

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
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.util.DateTimes;
import com.kratonsolution.belian.geographic.impl.orm.GeographicType;
import com.kratonsolution.belian.party.impl.orm.Address;
import com.kratonsolution.belian.party.impl.orm.Citizenship;
import com.kratonsolution.belian.party.impl.orm.Contact;
import com.kratonsolution.belian.party.impl.orm.Gender;
import com.kratonsolution.belian.party.impl.orm.MaritalStatus;
import com.kratonsolution.belian.party.impl.orm.Party;
import com.kratonsolution.belian.party.impl.orm.PartyClassification;
import com.kratonsolution.belian.party.impl.orm.PartyRole;
import com.kratonsolution.belian.party.impl.orm.PartySkill;
import com.kratonsolution.belian.party.impl.orm.Person;
import com.kratonsolution.belian.party.impl.orm.PhysicalCharacteristic;
import com.kratonsolution.belian.partys.svc.PartyService;
import com.kratonsolution.belian.partys.svc.PersonService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.general.country.CountryList;
import com.kratonsolution.belian.ui.general.geographic.GeographicList;
import com.kratonsolution.belian.ui.general.party.AddressTypeList;
import com.kratonsolution.belian.ui.general.party.ContactTypeList;
import com.kratonsolution.belian.ui.general.party.GenderList;
import com.kratonsolution.belian.ui.general.party.PartyClassificationTypeList;
import com.kratonsolution.belian.ui.general.party.PartyRoleTypeList;
import com.kratonsolution.belian.ui.general.party.PartySkillTypeList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PersonFormContent extends AbstractForm
{	
	private PartyService partyService = Springs.get(PartyService.class);
	
	private PersonService service = Springs.get(PersonService.class);

	private Textbox code = Components.mandatoryTextBox(false);

	private Textbox name = Components.mandatoryTextBox(false);

	private GeographicList birthPlace = new GeographicList(false,GeographicType.CITY);

	private Datebox birthDate = Components.currentDatebox();

	private Textbox taxCode = Components.stdTextBox(null, false);

	private GenderList genders = new GenderList(false,Gender.MALE);
	
	private Tabbox tabbox = new Tabbox();

	private Grid address = new Grid();

	private Grid contacts = new Grid();

	private Grid roles = new Grid();

	private Grid skills = new Grid();

	private Grid classifications = new Grid();
	
	private Grid maritals = new Grid();

	private Grid physicals = new Grid();
	
	private Grid citizenships = new Grid();
	
	public PersonFormContent()
	{
		super();
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
				Flow.next(getParent(), new PersonGridContent());
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

				Person person = new Person();
				person.setCode(code.getText());
				person.setName(name.getText());
				person.setBirthPlace(birthPlace.getDomain());
				person.setBirthDate(DateTimes.sql(birthDate.getValue()));
				person.setTaxCode(taxCode.getText());
				person.setGender(genders.getGender());
				
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
					add.setParty(person);
					add.setPostal(RowUtils.string(rw, 2));
					add.setProvince(province.getDomain());
					add.setType(type.getAddressType());
					
					person.getAddresses().add(add);
				}
				
				for(Component com:contacts.getRows().getChildren())
				{
					Row rw = (Row)com;
					
					ContactTypeList type = (ContactTypeList)rw.getChildren().get(2);

					Contact contact = new Contact();
					contact.setActive(RowUtils.isChecked(rw, 3));
					contact.setContact(RowUtils.string(rw, 1));
					contact.setParty(person);
					contact.setType(type.getContactType());
					
					person.getContacts().add(contact);
				}
				
				for(Component com:roles.getRows().getChildren())
				{
					Row rw = (Row)com;
					
					PartyRoleTypeList type = (PartyRoleTypeList)rw.getChildren().get(3);

					PartyRole role = new PartyRole();
					role.setEnd(RowUtils.sql(rw, 2));
					role.setParty(person);
					role.setStart(RowUtils.sql(rw, 1));
					role.setType(type.getPartyRoleType());
					
					person.getPartyRoles().add(role);
				}
				
				for(Component com:skills.getRows().getChildren())
				{
					Row rw = (Row)com;
					
					PartySkillTypeList type = (PartySkillTypeList)rw.getChildren().get(3);
					
					PartySkill skill = new PartySkill();
					skill.setEnd(RowUtils.sql(rw, 2));
					skill.setParty(person);
					skill.setStart(RowUtils.sql(rw, 1));
					skill.setType(type.getPartySkillType());
					
					person.getSkills().add(skill);
				}
				
				for(Component com:classifications.getRows().getChildren())
				{
					Row rw = (Row)com;
					
					PartyClassificationTypeList type = (PartyClassificationTypeList)rw.getChildren().get(4);
					
					PartyClassification classification = new PartyClassification();
					classification.setEnd(RowUtils.sql(rw, 2));
					classification.setParty(person);
					classification.setStart(RowUtils.sql(rw, 1));
					classification.setValue(RowUtils.string(rw,3));
					classification.setType(type.getPartyClassificationType());
					
					person.getClassifications().add(classification);
				}
				
				for(Component com:maritals.getRows().getChildren())
				{
					Row rw = (Row)com;
					
					MaritalStatusTypeList type = (MaritalStatusTypeList)rw.getChildren().get(3);
					
					MaritalStatus status = new MaritalStatus();
					status.setEnd(RowUtils.sql(rw, 2));
					status.setPerson(person);
					status.setStart(RowUtils.sql(rw, 1));
					status.setType(type.getMaritalStatusType());
					
					person.getMaritalStatuses().add(status);
				}
				
				for(Component com:physicals.getRows().getChildren())
				{
					Row rw = (Row)com;
					
					PhysicalCharacteristicTypeList type = (PhysicalCharacteristicTypeList)rw.getChildren().get(4);
					
					PhysicalCharacteristic physic = new PhysicalCharacteristic();
					physic.setEnd(RowUtils.sql(rw, 2));
					physic.setPerson(person);
					physic.setStart(RowUtils.sql(rw, 1));
					physic.setValue(RowUtils.string(rw,3));
					physic.setType(type.getPhysicalCharacteristicType());
					
					person.getPhysicalCharacteristics().add(physic);
				}
				
				for(Component com:citizenships.getRows().getChildren())
				{
					Row rw = (Row)com;
					
					Citizenship citi = new Citizenship();
					citi.setEnd(RowUtils.sql(rw, 2));
					citi.setPerson(person);
					citi.setStart(RowUtils.sql(rw, 1));
					citi.setPassport(RowUtils.string(rw,3));
					
					person.getCitizenships().add(citi);
				}

				service.add(person);

				Flow.next(getParent(), new PersonEditContent(RowUtils.shield(person.getId())));
			}
		});
	}

	@Override
	public void initForm()
	{
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

		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
	}
	
	public void initTab()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab(lang.get("person.grid.column.address")));
		tabbox.getTabs().appendChild(new Tab(lang.get("person.grid.column.contacts")));
		tabbox.getTabs().appendChild(new Tab(lang.get("person.grid.column.roles")));
		tabbox.getTabs().appendChild(new Tab(lang.get("person.grid.column.skills")));
		tabbox.getTabs().appendChild(new Tab(lang.get("person.grid.column.classifications")));
		tabbox.getTabs().appendChild(new Tab(lang.get("person.grid.column.maritals")));
		tabbox.getTabs().appendChild(new Tab(lang.get("person.grid.column.physical")));
		tabbox.getTabs().appendChild(new Tab(lang.get("person.grid.column.citizenships")));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		
		appendChild(tabbox);
		
		initAddress();
		initContacts();
		initRoles();
		initSkills();
		initClassification();
		initMaritals();
		initPhysicals();
		initPassport();
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
	
	private void initRoles()
	{
		roles.setWidth("100%");
		roles.setEmptyMessage(lang.get("message.grid.empty"));
		roles.appendChild(new Columns());
		roles.appendChild(new Rows());
		roles.getColumns().appendChild(new Column(null,null,"25px"));
		roles.getColumns().appendChild(new Column(lang.get("person.grid.column.start"),null,"125px"));
		roles.getColumns().appendChild(new Column(lang.get("person.grid.column.end"),null,"125px"));
		roles.getColumns().appendChild(new Column(lang.get("person.grid.column.type"),null,"100px"));
		roles.setSpan("3");
		
		NRCToolbar nrc = new NRCToolbar(roles);
		nrc.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryDatebox());
				row.appendChild(Components.fullSpanDatebox(null));
				row.appendChild(new PartyRoleTypeList(true));
				
				roles.getRows().appendChild(row);
			}
		});
		
		tabbox.getTabpanels().getChildren().get(2).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(2).appendChild(roles);
	}
	
	private void initSkills()
	{
		skills.setWidth("100%");
		skills.setEmptyMessage(lang.get("message.grid.empty"));
		skills.appendChild(new Columns());
		skills.appendChild(new Rows());
		skills.getColumns().appendChild(new Column(null,null,"25px"));
		skills.getColumns().appendChild(new Column(lang.get("person.grid.column.start"),null,"125px"));
		skills.getColumns().appendChild(new Column(lang.get("person.grid.column.end"),null,"125px"));
		skills.getColumns().appendChild(new Column(lang.get("person.grid.column.skilltype"),null,"150px"));
		skills.setSpan("3");
		
		NRCToolbar nrc = new NRCToolbar(skills);
		nrc.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryDatebox());
				row.appendChild(Components.fullSpanDatebox(null));
				row.appendChild(new PartySkillTypeList(true));
				
				skills.getRows().appendChild(row);
			}
		});
		
		tabbox.getTabpanels().getChildren().get(3).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(3).appendChild(skills);
	}
	
	private void initClassification()
	{
		classifications.setWidth("100%");
		classifications.setEmptyMessage(lang.get("message.grid.empty"));
		classifications.appendChild(new Columns());
		classifications.appendChild(new Rows());
		classifications.getColumns().appendChild(new Column(null,null,"25px"));
		classifications.getColumns().appendChild(new Column(lang.get("person.grid.column.start"),null,"125px"));
		classifications.getColumns().appendChild(new Column(lang.get("person.grid.column.end"),null,"125px"));
		classifications.getColumns().appendChild(new Column(lang.get("person.grid.column.description"),null,"150px"));
		classifications.getColumns().appendChild(new Column(lang.get("person.grid.column.type"),null,"150px"));
		classifications.setSpan("3");
		
		NRCToolbar nrc = new NRCToolbar(classifications);
		nrc.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryDatebox());
				row.appendChild(Components.fullSpanDatebox(null));
				row.appendChild(Components.mandatoryTextBox(true));
				row.appendChild(new PartyClassificationTypeList(true));
				
				classifications.getRows().appendChild(row);
			}
		});
		
		tabbox.getTabpanels().getChildren().get(4).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(4).appendChild(classifications);
	}
	
	private void initMaritals()
	{
		maritals.setWidth("100%");
		maritals.setEmptyMessage(lang.get("message.grid.empty"));
		maritals.appendChild(new Columns());
		maritals.appendChild(new Rows());
		maritals.getColumns().appendChild(new Column(null,null,"25px"));
		maritals.getColumns().appendChild(new Column(lang.get("person.grid.column.start"),null,"125px"));
		maritals.getColumns().appendChild(new Column(lang.get("person.grid.column.end"),null,"125px"));
		maritals.getColumns().appendChild(new Column(lang.get("person.grid.column.type"),null,"150px"));
		maritals.setSpan("3");
		
		NRCToolbar nrc = new NRCToolbar(maritals);
		nrc.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryDatebox());
				row.appendChild(Components.fullSpanDatebox(null));
				row.appendChild(new MaritalStatusTypeList(true));
				
				maritals.getRows().appendChild(row);
			}
		});
		
		tabbox.getTabpanels().getChildren().get(5).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(5).appendChild(maritals);
	}
	
	private void initPhysicals()
	{
		physicals.setWidth("100%");
		physicals.setEmptyMessage(lang.get("message.grid.empty"));
		physicals.appendChild(new Columns());
		physicals.appendChild(new Rows());
		physicals.getColumns().appendChild(new Column(null,null,"25px"));
		physicals.getColumns().appendChild(new Column(lang.get("person.grid.column.start"),null,"125px"));
		physicals.getColumns().appendChild(new Column(lang.get("person.grid.column.end"),null,"125px"));
		physicals.getColumns().appendChild(new Column(lang.get("person.grid.column.description"),null,"125px"));
		physicals.getColumns().appendChild(new Column(lang.get("person.grid.column.type"),null,"150px"));
		physicals.setSpan("3");
		
		NRCToolbar nrc = new NRCToolbar(physicals);
		nrc.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryDatebox());
				row.appendChild(Components.fullSpanDatebox(null));
				row.appendChild(Components.mandatoryTextBox(true));
				row.appendChild(new PhysicalCharacteristicTypeList(true));
				
				physicals.getRows().appendChild(row);
			}
		});
		
		tabbox.getTabpanels().getChildren().get(6).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(6).appendChild(physicals);
	}
	
	private void initPassport()
	{
		citizenships.setWidth("100%");
		citizenships.setEmptyMessage(lang.get("message.grid.empty"));
		citizenships.appendChild(new Columns());
		citizenships.appendChild(new Rows());
		citizenships.getColumns().appendChild(new Column(null,null,"25px"));
		citizenships.getColumns().appendChild(new Column(lang.get("person.grid.column.start"),null,"125px"));
		citizenships.getColumns().appendChild(new Column(lang.get("person.grid.column.end"),null,"125px"));
		citizenships.getColumns().appendChild(new Column(lang.get("person.grid.column.description"),null,"125px"));
		citizenships.setSpan("3");
		
		NRCToolbar nrc = new NRCToolbar(citizenships);
		nrc.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryDatebox());
				row.appendChild(Components.fullSpanDatebox(null));
				row.appendChild(Components.mandatoryTextBox(true));
				
				citizenships.getRows().appendChild(row);
			}
		});
		
		tabbox.getTabpanels().getChildren().get(7).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(7).appendChild(citizenships);
	}
}
