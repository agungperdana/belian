/**
 * 
 */
package com.kratonsolution.belian.ui.organization;

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
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.PartyRelationship;
import com.kratonsolution.belian.general.dm.PartyRole;
import com.kratonsolution.belian.general.dm.Organization.IndustryType;
import com.kratonsolution.belian.general.svc.OrganizationService;
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
public class OrganizationEditContent extends FormContent implements Refreshable
{	
	private final OrganizationService controller = Springs.get(OrganizationService.class);

	private Textbox name = new Textbox();

	private Datebox date = new Datebox();

	private Textbox tax = new Textbox();
	
	private Listbox types = new Listbox();

	private Row row;

	private PartyInformation information;

	private PartyToolbar partyToolbar = new PartyToolbar();

	public OrganizationEditContent(Row row)
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
				OrganizationWindow window = (OrganizationWindow)getParent();
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

				Organization org = new Organization();
				org.setId(RowUtils.rowValue(row, 5));
				org.setName(name.getText());
				org.setBirthDate(date.getValue());
				org.setTaxCode(tax.getText());
				org.setType(IndustryType.valueOf(types.getSelectedItem().getValue().toString()));

				controller.edit(org);

				OrganizationWindow window = (OrganizationWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		Organization organization = controller.findOne(RowUtils.rowValue(row, 5));
		if(organization != null)
		{
			name.setConstraint("no empty");
			name.setText(organization.getName());
			name.setWidth("300px");

			date.setConstraint("no empty");
			date.setValue(organization.getBirthDate());
			date.setWidth("250px");

			tax.setText(organization.getTaxCode());
			tax.setWidth("300px");
			
			types.setMold("select");
			
			for(IndustryType type:IndustryType.values())
			{
				Listitem listitem = new Listitem(type.name(),type.name());
				types.appendChild(listitem);
				if(type.name().equals(RowUtils.rowValue(row, 4)))
					types.setSelectedItem(listitem);
			}

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
			row4.appendChild(new Label("Industry"));
			row4.appendChild(types);

			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
			rows.appendChild(row4);
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
		information = new PartyInformation("Organization Information");

		final Organization organization = controller.findOne(RowUtils.rowValue(row, 4));
		if(organization != null)
		{
			if(!organization.getAddresses().isEmpty())
			{
				for(final Address address:organization.getAddresses())
					information.addAddress(new AddressInformation(address, organization));
			}
		
			if(!organization.getContacts().isEmpty())
			{
				for(final Contact contact:organization.getContacts())
					information.addContact(new ContactInformation(contact, organization));
			}
			
			if(!organization.getRoles().isEmpty())
			{
				for(final PartyRole role:organization.getRoles())
					information.addRole(new RoleInformation(role, organization));
			}
			
			if(!organization.getRelationships().isEmpty())
			{
				for(final PartyRelationship relation:organization.getRelationships())
					information.addRelationship(new RelationshipInformation(relation, organization));
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