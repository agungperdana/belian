
package com.kratonsolution.belian.ui.general.organization;

import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
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
import com.kratonsolution.belian.general.dm.GeographicType;
import com.kratonsolution.belian.partys.dm.Address;
import com.kratonsolution.belian.partys.dm.Contact;
import com.kratonsolution.belian.partys.dm.Organization;
import com.kratonsolution.belian.party.impl.orm.PartyClassification;
import com.kratonsolution.belian.party.impl.orm.PartyRelationship;
import com.kratonsolution.belian.party.impl.orm.PartyRole;
import com.kratonsolution.belian.party.impl.orm.PartySkill;
import com.kratonsolution.belian.partys.svc.OrganizationService;
import com.kratonsolution.belian.partys.svc.PartyService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.general.country.CountryList;
import com.kratonsolution.belian.ui.general.geographic.GeographicList;
import com.kratonsolution.belian.ui.general.party.AddressTypeList;
import com.kratonsolution.belian.ui.general.party.ContactTypeList;
import com.kratonsolution.belian.ui.general.party.PartyBox;
import com.kratonsolution.belian.ui.general.party.PartyClassificationTypeList;
import com.kratonsolution.belian.ui.general.party.PartyRelationshipTypeList;
import com.kratonsolution.belian.ui.general.party.PartyRoleList;
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
public class OrganizationEditContent extends AbstractForm
{	
	private PartyService partyService = Springs.get(PartyService.class);

	private OrganizationService service = Springs.get(OrganizationService.class);

	private Textbox code = Components.stdTextBox(null,false);

	private Textbox name = Components.mandatoryTextBox(false);

	private GeographicList birthPlace = new GeographicList(false,GeographicType.CITY);

	private Datebox birthDate = Components.currentDatebox();

	private Textbox taxCode = Components.stdTextBox(null, false);

	private Tabbox tabbox = new Tabbox();

	private Grid address = new Grid();

	private Grid contacts = new Grid();

	private Grid roles = new Grid();

	private Grid relationships = new Grid();

	private Grid skills = new Grid();

	private Grid classifications = new Grid();

	private Row row;

	public OrganizationEditContent(Row row)
	{
		super();
		this.row = row;
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

				Organization org = service.getOne(RowUtils.id(row));
				if(org != null)
				{
					org.setCode(code.getText());
					org.setName(name.getText());
					org.setBirthPlace(birthPlace.getDomain());
					org.setBirthDate(DateTimes.sql(birthDate.getValue()));
					org.setTaxCode(taxCode.getText());

					Vector<Address> vAddress = new Vector<>(org.getAddresses());
					Vector<Contact> vContacts = new Vector<>(org.getContacts());
					Vector<PartyRole> vRoles = new Vector<>(org.getPartyRoles());
					Vector<PartyRelationship> vRelations = new Vector<>(org.getRelationships());
					Vector<PartySkill> vSkills = new Vector<>(org.getSkills());
					Vector<PartyClassification> vClass = new Vector<>(org.getClassifications());

					org.getAddresses().clear();
					org.getContacts().clear();
					org.getPartyRoles().clear();
					org.getRelationships().clear();
					org.getSkills().clear();
					org.getClassifications().clear();

					for(Component com:address.getRows().getChildren())
					{
						Row rw = (Row)com;

						Address add = new Address();

						for(Address _add:vAddress)
						{
							if(_add.getId().equals(RowUtils.id(rw)))
							{
								add = _add;
								break;
							}
						}

						GeographicList city = (GeographicList)rw.getChildren().get(3);
						GeographicList province = (GeographicList)rw.getChildren().get(4);
						CountryList country = (CountryList)rw.getChildren().get(5);
						AddressTypeList type = (AddressTypeList)rw.getChildren().get(6);

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
						
						Contact contact = new Contact();

						for(Contact _add:vContacts)
						{
							if(_add.getId().equals(RowUtils.id(rw)))
							{
								contact = _add;
								break;
							}
						}
						
						ContactTypeList type = (ContactTypeList)rw.getChildren().get(2);
						
						contact.setActive(RowUtils.isChecked(rw, 3));
						contact.setContact(RowUtils.string(rw, 1));
						contact.setParty(org);
						contact.setType(type.getContactType());
						
						org.getContacts().add(contact);
					}
					
					for(Component com:roles.getRows().getChildren())
					{
						Row rw = (Row)com;
						
						PartyRole role = new PartyRole();
						for(PartyRole _add:vRoles)
						{
							if(_add.getId().equals(RowUtils.id(rw)))
							{
								role = _add;
								break;
							}
						}
						
						PartyRoleTypeList type = (PartyRoleTypeList)rw.getChildren().get(3);

						role.setEnd(RowUtils.sql(rw, 2));
						role.setParty(org);
						role.setStart(RowUtils.sql(rw, 1));
						role.setType(type.getPartyRoleType());
						
						org.getPartyRoles().add(role);
					}
					
					for(Component com:relationships.getRows().getChildren())
					{
						Row rw = (Row)com;
						
						PartyRelationship role = new PartyRelationship();
						for(PartyRelationship _add:vRelations)
						{
							if(_add.getId().equals(RowUtils.id(rw)))
							{
								role = _add;
								break;
							}
						}
						
						PartyBox box = (PartyBox)rw.getChildren().get(3);
						PartyRoleList fromrole = (PartyRoleList)rw.getChildren().get(4);
						PartyRoleList torole = (PartyRoleList)rw.getChildren().get(5);
						PartyRelationshipTypeList type = (PartyRelationshipTypeList)rw.getChildren().get(6);

						role.setEnd(RowUtils.sql(rw, 2));
						role.setFromParty(org);
						role.setStart(RowUtils.sql(rw, 1));
						role.setToParty(box.getDomain());
						role.setFromRole(fromrole.getDomain());
						role.setToRole(torole.getDomain());
						role.setType(type.getPartyRelationshipType());
						
						org.getRelationships().add(role);
					}
					
					for(Component com:skills.getRows().getChildren())
					{
						Row rw = (Row)com;
						
						PartySkill skill = new PartySkill();
						for(PartySkill _add:vSkills)
						{
							if(_add.getId().equals(RowUtils.id(rw)))
							{
								skill = _add;
								break;
							}
						}
						
						PartySkillTypeList type = (PartySkillTypeList)rw.getChildren().get(3);
						
						skill.setEnd(RowUtils.sql(rw, 2));
						skill.setParty(org);
						skill.setStart(RowUtils.sql(rw, 1));
						skill.setType(type.getPartySkillType());
						
						org.getSkills().add(skill);
					}
					
					for(Component com:classifications.getRows().getChildren())
					{
						Row rw = (Row)com;
						
						PartyClassification classification = new PartyClassification();
						for(PartyClassification _add:vClass)
						{
							if(_add.getId().equals(RowUtils.id(rw)))
							{
								classification = _add;
								break;
							}
						}
						
						PartyClassificationTypeList type = (PartyClassificationTypeList)rw.getChildren().get(4);
						
						classification.setEnd(RowUtils.sql(rw, 2));
						classification.setParty(org);
						classification.setStart(RowUtils.sql(rw, 1));
						classification.setValue(RowUtils.string(rw, 3));
						classification.setType(type.getPartyClassificationType());
						
						org.getClassifications().add(classification);
					}
					
					service.edit(org);
				}

				Flow.next(getParent(), new OrganizationGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		Organization organization = service.getOne(RowUtils.id(row));
		if(organization != null)
		{
			code.setText(organization.getCode());
			name.setText(organization.getName());
			birthPlace.setDomain(organization.getBirthPlace());
			birthDate.setValue(organization.getBirthDate());
			taxCode.setValue(organization.getTaxCode());

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
	}

	public void initTab()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab(lang.get("organization.grid.column.address")));
		tabbox.getTabs().appendChild(new Tab(lang.get("organization.grid.column.contacts")));
		tabbox.getTabs().appendChild(new Tab(lang.get("organization.grid.column.roles")));
		tabbox.getTabs().appendChild(new Tab(lang.get("organization.grid.column.relationships")));
		tabbox.getTabs().appendChild(new Tab(lang.get("organization.grid.column.skills")));
		tabbox.getTabs().appendChild(new Tab(lang.get("organization.grid.column.classifications")));
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
		initRelationships();
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
		address.getColumns().appendChild(new Column());
		address.getColumns().getLastChild().setVisible(false);
		address.setSpan("1");

		Organization organization = service.getOne(RowUtils.id(row));
		if(organization != null)
		{
			for(Address add:organization.getAddresses())
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryTextBox(add.getAddress()));
				row.appendChild(Components.textBox(add.getPostal()));
				row.appendChild(new GeographicList(true,GeographicType.CITY,add.getCity()));
				row.appendChild(new GeographicList(true,GeographicType.PROVINCE,add.getProvince()));
				row.appendChild(new CountryList(true,add.getCountry()));
				row.appendChild(new AddressTypeList(true,add.getType()));
				row.appendChild(Components.status(add.isActive()));
				row.appendChild(new Label(address.getId()));

				address.getRows().appendChild(row);
			}
		}

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
				row.appendChild(new Label());

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
		contacts.getColumns().appendChild(new Column());
		contacts.getColumns().getLastChild().setVisible(false);
		contacts.setSpan("1");

		Organization organization = service.getOne(RowUtils.id(row));
		if(organization != null)
		{
			for(Contact con:organization.getContacts())
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryTextBox(con.getContact()));
				row.appendChild(new ContactTypeList(true,con.getType()));
				row.appendChild(Components.status(con.isActive()));
				row.appendChild(new Label(con.getId()));

				contacts.getRows().appendChild(row);
			}
		}

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
				row.appendChild(new Label());

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
		roles.getColumns().appendChild(new Column());
		roles.getColumns().getLastChild().setVisible(false);
		roles.setSpan("3");

		Organization organization = service.getOne(RowUtils.id(row));
		if(organization != null)
		{
			for(PartyRole role:organization.getPartyRoles())
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryDatebox(role.getStart()));
				row.appendChild(Components.fullSpanDatebox(role.getEnd()));
				row.appendChild(new PartyRoleTypeList(true,role.getType()));
				row.appendChild(new Label(role.getId()));

				roles.getRows().appendChild(row);
			}
		}

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
				row.appendChild(new Label());

				roles.getRows().appendChild(row);
			}
		});

		tabbox.getTabpanels().getChildren().get(2).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(2).appendChild(roles);
	}

	private void initRelationships()
	{
		relationships.setWidth("100%");
		relationships.setEmptyMessage(lang.get("message.grid.empty"));
		relationships.appendChild(new Columns());
		relationships.appendChild(new Rows());
		relationships.getColumns().appendChild(new Column(null,null,"25px"));
		relationships.getColumns().appendChild(new Column(lang.get("organization.grid.column.start"),null,"125px"));
		relationships.getColumns().appendChild(new Column(lang.get("organization.grid.column.end"),null,"125px"));
		relationships.getColumns().appendChild(new Column(lang.get("organization.grid.column.toparty"),null,"125px"));
		relationships.getColumns().appendChild(new Column(lang.get("organization.grid.column.fromrole"),null,"125px"));
		relationships.getColumns().appendChild(new Column(lang.get("organization.grid.column.torole"),null,"125px"));
		relationships.getColumns().appendChild(new Column(lang.get("organization.grid.column.type"),null,"100px"));
		relationships.getColumns().appendChild(new Column());
		relationships.getColumns().getLastChild().setVisible(false);
		relationships.setSpan("3");

		Organization organization = service.getOne(RowUtils.id(row));
		if(organization != null)
		{
			for(PartyRelationship role:organization.getRelationships())
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryDatebox(role.getStart()));
				row.appendChild(Components.fullSpanDatebox(role.getEnd()));
				row.appendChild(new PartyBox(false,true,role.getToParty()));
				row.appendChild(new PartyRoleList(true, role.getFromParty(),role.getFromRole()));
				row.appendChild(new PartyRoleList(true, role.getToParty(),role.getToRole()));
				row.appendChild(new PartyRelationshipTypeList(true,role.getType()));
				row.appendChild(new Label(role.getId()));

				relationships.getRows().appendChild(row);
			}
		}

		NRCToolbar nrc = new NRCToolbar(relationships);
		nrc.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				PartyRoleList torole = new PartyRoleList(true, organization);

				PartyBox toparty = new PartyBox(false,true);
				toparty.addListSelectionListener(torole);

				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryDatebox());
				row.appendChild(Components.fullSpanDatebox(null));
				row.appendChild(toparty);
				row.appendChild(new PartyRoleList(true, organization));
				row.appendChild(torole);
				row.appendChild(new PartyRelationshipTypeList(true));
				row.appendChild(new Label());

				relationships.getRows().appendChild(row);
			}
		});

		tabbox.getTabpanels().getChildren().get(3).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(3).appendChild(relationships);
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
		skills.getColumns().appendChild(new Column());
		skills.getColumns().getLastChild().setVisible(false);
		skills.setSpan("3");

		Organization organization = service.getOne(RowUtils.id(row));
		if(organization != null)
		{
			for(PartySkill sk:organization.getSkills())
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryDatebox(sk.getStart()));
				row.appendChild(Components.fullSpanDatebox(sk.getEnd()));
				row.appendChild(new PartySkillTypeList(true,sk.getType()));
				row.appendChild(new Label(sk.getId()));

				skills.getRows().appendChild(row);
			}
		}

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
				row.appendChild(new Label());

				skills.getRows().appendChild(row);
			}
		});

		tabbox.getTabpanels().getChildren().get(4).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(4).appendChild(skills);
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
		classifications.getColumns().appendChild(new Column());
		classifications.getColumns().getLastChild().setVisible(false);
		classifications.setSpan("3");

		Organization organization = service.getOne(RowUtils.id(row));
		if(organization != null)
		{
			for(PartyClassification cls:organization.getClassifications())
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryDatebox(cls.getStart()));
				row.appendChild(Components.fullSpanDatebox(cls.getEnd()));
				row.appendChild(Components.mandatoryTextBox(cls.getValue()));
				row.appendChild(new PartyClassificationTypeList(true,cls.getType()));
				row.appendChild(new Label(cls.getId()));
				
				classifications.getRows().appendChild(row);
			}
		}

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
				row.appendChild(new Label());

				classifications.getRows().appendChild(row);
			}
		});

		tabbox.getTabpanels().getChildren().get(5).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(5).appendChild(classifications);
	}
}
