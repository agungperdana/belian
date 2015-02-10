/**
 * 
 */
package com.kratonsolution.belian.ui.organization;

import java.util.Iterator;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treecol;
import org.zkoss.zul.Treecols;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.Treerow;

import com.google.common.base.Strings;
import com.kratonsolution.belian.general.dm.Address;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.view.OrganizationController;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.party.AddressAddWindow;
import com.kratonsolution.belian.ui.party.AddressEditWindow;
import com.kratonsolution.belian.ui.party.PartyToolbar;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class OrganizationEditContent extends FormContent
{	
	private final OrganizationController controller = Springs.get(OrganizationController.class);

	private Textbox name = new Textbox();

	private Datebox date = new Datebox();

	private Textbox tax = new Textbox();

	private Row row;

	private Tree tree;

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
				org.setId(RowUtils.rowValue(row, 2));
				org.setName(name.getText());
				org.setBirthDate(date.getValue());
				org.setTaxCode(tax.getText());

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
		Organization organization = controller.findOne(RowUtils.rowValue(row, 4));
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
	}
	
	protected void initTree()
	{
		tree = new Tree();
		tree.setWidth("100%");
		tree.setStyle("overflow:auto");
		
		Treecols cols = new Treecols();
		cols.appendChild(new Treecol("Organization Information"));
		cols.appendChild(new Treecol(null,null,"25px"));
		
		Treechildren treechildren = new Treechildren();
		
		Treeitem item1 = new Treeitem();
		Treeitem item2 = new Treeitem();
		Treeitem item3 = new Treeitem();
		Treeitem item4 = new Treeitem();

		Treecell address = new Treecell("Address");
		address.setImage("/icons/address.png");
		
		Treecell contact = new Treecell("Contacts");
		contact.setImage("/icons/roletypesmall.png");
		
		Treecell role = new Treecell("Role");
		role.setImage("/icons/contact.png");
		
		Treecell relation = new Treecell("Relationship");
		relation.setImage("/icons/relationshiptype.png");
		
		Treerow row1 = new Treerow();
		row1.appendChild(address);
		
		Treerow row2 = new Treerow();
		row2.appendChild(contact);
		
		Treerow row3 = new Treerow();
		row3.appendChild(role);
		
		Treerow row4 = new Treerow();
		row4.appendChild(relation);
		
		item1.appendChild(row1);
		item2.appendChild(row2);
		item3.appendChild(row3);
		item4.appendChild(row4);
		
		treechildren.appendChild(item1);
		treechildren.appendChild(item2);
		treechildren.appendChild(item3);
		treechildren.appendChild(item4);
		
		final Organization organization = controller.findOne(RowUtils.rowValue(row, 4));
		if(organization != null)
		{
			if(!organization.getAddresses().isEmpty())
			{
				Treechildren addresses = new Treechildren();
				for(final Address add:organization.getAddresses())
				{
					Treerow tr = new Treerow();
					Treecell tc = new Treecell(add.getDescription()+", "+add.getCity().getName()+", "+add.getProvince().getName()+", "+add.getCountry().getName());
					tc.setId(add.getId());
					tc.addEventListener(Events.ON_CLICK,new EventListener<Event>()
					{
						@Override
						public void onEvent(Event event) throws Exception
						{
							appendChild(new AddressEditWindow(organization, add));
						}
					});
					
					Image remove = new Image("/icons/deletesmall.png");
					Treecell delcell = new Treecell();
					delcell.appendChild(remove);
					delcell.addEventListener(Events.ON_CLICK,new EventListener<Event>()
					{
						@Override
						public void onEvent(Event event) throws Exception
						{
							Iterator<Address> iterator = organization.getAddresses().iterator();
							while (iterator.hasNext())
							{
								Address address2 = (Address) iterator.next();
								if(address2.getId().equals(add.getId()))
									iterator.remove();
							}
							
							controller.edit(organization);
							refreshTree();
						}
					});
					
					tr.appendChild(tc);
					tr.appendChild(delcell);
					
					Treeitem ti = new Treeitem();
					ti.appendChild(tr);
					
					addresses.appendChild(ti);
					
					item1.appendChild(addresses);
				}
			}
		}
		
		tree.appendChild(cols);
		tree.appendChild(treechildren);
		
		appendChild(tree);
	}
	
	public void refreshTree()
	{
		removeChild(tree);
		initTree();
	}
}
