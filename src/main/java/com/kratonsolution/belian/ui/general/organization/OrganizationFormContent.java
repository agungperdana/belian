
package com.kratonsolution.belian.ui.general.organization;

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
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.dm.GeographicType;
import com.kratonsolution.belian.partys.dm.Address;
import com.kratonsolution.belian.partys.dm.Contact;
import com.kratonsolution.belian.partys.dm.Organization;
import com.kratonsolution.belian.partys.dm.Party;
import com.kratonsolution.belian.partys.dm.PartyClassification;
import com.kratonsolution.belian.partys.dm.PartyRole;
import com.kratonsolution.belian.partys.dm.PartySkill;
import com.kratonsolution.belian.partys.svc.OrganizationService;
import com.kratonsolution.belian.partys.svc.PartyService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.general.country.CountryList;
import com.kratonsolution.belian.ui.general.geographic.GeographicList;
import com.kratonsolution.belian.ui.general.party.AddressTypeList;
import com.kratonsolution.belian.ui.general.party.ContactTypeList;
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
public class OrganizationFormContent extends AbstractForm
{	
	private PartyService partyService = Springs.get(PartyService.class);
	
	private OrganizationService service = Springs.get(OrganizationService.class);
		
	private Textbox code = Components.mandatoryTextBox(false);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private GeographicList birthPlace = new GeographicList(false,GeographicType.CITY);
	
	private Datebox birthDate = Components.currentDatebox();
	
	private Textbox taxCode = Components.stdTextBox(null, false);
	
	private Tabbox tabbox = new Tabbox();
	
	private Grid address = new Grid();
	
	private Grid contacts = new Grid();
	
	private Grid roles = new Grid();
	
	private Grid skills = new Grid();
	
	private Grid classifications = new Grid();
	
	public OrganizationFormContent()
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
				Flow.next(getParent(), new OrganizationGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(code.getText()))
					throw new WrongValueException(code,lang.get("message.field.empty"));
				
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,lang.get("message.field.empty"));
			
				Organization org = new Organization();
				org.setCode(code.getText());
				org.setName(name.getText());
				org.setBirthPlace(birthPlace.getDomain());
				org.setBirthDate(DateTimes.sql(birthDate.getValue()));
				org.setTaxCode(taxCode.getText());
				
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
					add.setParty(org);
					add.setPostal(RowUtils.string(rw, 2));
					add.setProvince(province.getDomain());
					add.setType(type.getAddressType());
					
					org.getAddresses().add(add);
				}
				
				for(Component com:contacts.getRows().getChildren())
				{
					Row rw = (Row)com;
					
					ContactTypeList type = (ContactTypeList)rw.getChildren().get(2);

					Contact contact = new Contact();
					contact.setActive(RowUtils.isChecked(rw, 3));
					contact.setContact(RowUtils.string(rw, 1));
					contact.setParty(org);
					contact.setType(type.getContactType());
					
					org.getContacts().add(contact);
				}
				
				for(Component com:roles.getRows().getChildren())
				{
					Row rw = (Row)com;
					
					PartyRoleTypeList type = (PartyRoleTypeList)rw.getChildren().get(3);

					PartyRole role = new PartyRole();
					role.setEnd(RowUtils.sql(rw, 2));
					role.setParty(org);
					role.setStart(RowUtils.sql(rw, 1));
					role.setType(type.getPartyRoleType());
					
					org.getPartyRoles().add(role);
				}
				
				for(Component com:skills.getRows().getChildren())
				{
					Row rw = (Row)com;
					
					PartySkillTypeList type = (PartySkillTypeList)rw.getChildren().get(3);
					
					PartySkill skill = new PartySkill();
					skill.setEnd(RowUtils.sql(rw, 2));
					skill.setParty(org);
					skill.setStart(RowUtils.sql(rw, 1));
					skill.setType(type.getPartySkillType());
					
					org.getSkills().add(skill);
				}
				
				for(Component com:classifications.getRows().getChildren())
				{
					Row rw = (Row)com;
					
					PartyClassificationTypeList type = (PartyClassificationTypeList)rw.getChildren().get(4);
					
					PartyClassification classification = new PartyClassification();
					classification.setEnd(RowUtils.sql(rw, 2));
					classification.setParty(org);
					classification.setStart(RowUtils.sql(rw, 1));
					classification.setValue(RowUtils.string(rw,3));
					classification.setType(type.getPartyClassificationType());
					
					org.getClassifications().add(classification);
				}
				
				service.add(org);
				
				Flow.next(getParent(), new OrganizationEditContent(RowUtils.shield(org.getId())));
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
		
		Row row0 = new Row();
		row0.appendChild(new Label(lang.get("organization.grid.column.code")));
		row0.appendChild(code);
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("organization.grid.column.name")));
		row1.appendChild(name);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("organization.grid.column.birthplace")));
		row2.appendChild(birthPlace);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("organization.grid.column.birthdate")));
		row3.appendChild(birthDate);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("organization.grid.column.tax")));
		row4.appendChild(taxCode);
		
		rows.appendChild(row0);
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
	}
	
	public void initTab()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab(lang.get("organization.grid.column.address")));
		tabbox.getTabs().appendChild(new Tab(lang.get("organization.grid.column.contacts")));
		tabbox.getTabs().appendChild(new Tab(lang.get("organization.grid.column.roles")));
		tabbox.getTabs().appendChild(new Tab(lang.get("organization.grid.column.skills")));
		tabbox.getTabs().appendChild(new Tab(lang.get("organization.grid.column.classifications")));
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
	}
	
	private void initAddress()
	{
		address.setWidth("100%");
		address.setEmptyMessage(lang.get("message.grid.empty"));
		address.appendChild(new Columns());
		address.appendChild(new Rows());
		address.getColumns().appendChild(new Column(null,null,"25px"));
		address.getColumns().appendChild(new Column(lang.get("organization.grid.column.description")));
		address.getColumns().appendChild(new Column(lang.get("organization.grid.column.postal"),null,"80px"));
		address.getColumns().appendChild(new Column(lang.get("organization.grid.column.city"),null,"100px"));
		address.getColumns().appendChild(new Column(lang.get("organization.grid.column.province"),null,"100px"));
		address.getColumns().appendChild(new Column(lang.get("organization.grid.column.country"),null,"100px"));
		address.getColumns().appendChild(new Column(lang.get("organization.grid.column.type"),null,"100px"));
		address.getColumns().appendChild(new Column(lang.get("organization.grid.column.status"),null,"70px"));
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
		contacts.getColumns().appendChild(new Column(lang.get("organization.grid.column.description")));
		contacts.getColumns().appendChild(new Column(lang.get("organization.grid.column.type"),null,"100px"));
		contacts.getColumns().appendChild(new Column(lang.get("organization.grid.column.status"),null,"80px"));
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
		roles.getColumns().appendChild(new Column(lang.get("organization.grid.column.start"),null,"125px"));
		roles.getColumns().appendChild(new Column(lang.get("organization.grid.column.end"),null,"125px"));
		roles.getColumns().appendChild(new Column(lang.get("organization.grid.column.type"),null,"100px"));
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
		skills.getColumns().appendChild(new Column(lang.get("organization.grid.column.start"),null,"125px"));
		skills.getColumns().appendChild(new Column(lang.get("organization.grid.column.end"),null,"125px"));
		skills.getColumns().appendChild(new Column(lang.get("organization.grid.column.skilltype"),null,"150px"));
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
		classifications.getColumns().appendChild(new Column(lang.get("organization.grid.column.start"),null,"125px"));
		classifications.getColumns().appendChild(new Column(lang.get("organization.grid.column.end"),null,"125px"));
		classifications.getColumns().appendChild(new Column(lang.get("organization.grid.column.description"),null,"150px"));
		classifications.getColumns().appendChild(new Column(lang.get("organization.grid.column.type"),null,"150px"));
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
}
