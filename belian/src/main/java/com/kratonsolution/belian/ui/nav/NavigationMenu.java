/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Page;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Window;

/**
 * @author agungdodiperdana
 *
 */
public class NavigationMenu extends Window
{	
	private final Tabbox accordion = new Tabbox();

	private Tabs tabs = new Tabs();

	private Tabpanels panels = new Tabpanels();

	private Caption caption = new Caption("Navigation Menu");
	
	public static final void injectInto(Page page)
	{
		new NavigationMenu().setPage(page);
	}
	
	private NavigationMenu()
	{
		init();
		initHeaders();
		initGeneral();
		initSecurity();
		initAccounting();
		initInventory();
		initSales();
	}

	protected void init()
	{
		setLeft("10px");
		setTop("100px");
		setWidth("200px");
		setHeight("500px");
		setMode(Mode.OVERLAPPED);
		
		caption.setImage("/icons/menu.png");
		caption.setParent(this);
		
		accordion.setMold("accordion");
		accordion.setParent(this);
		accordion.setHeight("97%");
		
		tabs.setParent(accordion);
		panels.setParent(accordion);
	}

	protected void initHeaders()
	{
		Tab generalTab = new Tab("General");
		Tab securityTab = new Tab("Security");
		Tab accountingTab = new Tab("Accounting");
		Tab inventoryTab = new Tab("Inventory");
		Tab salesTab = new Tab("Sales");

		generalTab.setParent(tabs);
		securityTab.setParent(tabs);
		accountingTab.setParent(tabs);
		inventoryTab.setParent(tabs);
		salesTab.setParent(tabs);
	}

	protected void initGeneral()
	{
		Tabpanel general = new Tabpanel();
		general.setParent(panels);

		Listbox list = new Listbox();
		list.setStyle("border:none");
		list.setParent(general);
		
		Listitem role = new Listitem("Role Type");
		role.setImage("/icons/roletype.png");
		
		Listitem relationship = new Listitem("Relationship Type");
		relationship.setImage("/icons/relationship.png");
		
		Listitem organization = new Listitem("Organization");
		organization.setImage("/icons/organization.png");
		
		Listitem person = new Listitem("Person");
		person.setImage("/icons/person.png");
		
		list.appendChild(new GeographicItem());
		list.appendChild(role);
		list.appendChild(relationship);
		list.appendChild(organization);
		list.appendChild(person);
	}
	
	protected void initSecurity()
	{
		Tabpanel panel = new Tabpanel();
		panel.setParent(panels);

		Listbox list = new Listbox();
		list.setStyle("border:none");
		list.setParent(panel);
		
		Listitem role = new Listitem("Role");
		role.setImage("/icons/role.png");
		
		Listitem user = new Listitem("User");
		user.setImage("/icons/user.png");
		
		list.appendChild(new ModuleItem());
		list.appendChild(new RoleItem());
		list.appendChild(user);
	}
	
	protected void initAccounting()
	{
		Tabpanel panel = new Tabpanel();
		panel.setStyle("overflow:auto");
		panel.setParent(panels);

		Listbox list = new Listbox();
		list.setStyle("border:none");
		list.setParent(panel);

		Listitem currency = new Listitem("Currency");
		currency.setImage("/icons/currency.png");
		
		Listitem tax = new Listitem("Tax");
		tax.setImage("/icons/tax.png");
		
		Listitem bank = new Listitem("Bank Account");
		bank.setImage("/icons/bank.png");
		
		Listitem cash = new Listitem("Cash Account");
		cash.setImage("/icons/cash.png");
		
		Listitem coa = new Listitem("Chart of account");
		coa.setImage("/icons/coa.png");
		
		Listitem period = new Listitem("Accounting Period");
		period.setImage("/icons/period.png");
		
		Listitem organization = new Listitem("Organization account");
		organization.setImage("/icons/orgacc.png");
		
		currency.setParent(list);
		tax.setParent(list);
		bank.setParent(list);
		cash.setParent(list);
		coa.setParent(list);
		period.setParent(list);
		organization.setParent(list);
	}
	
	protected void initInventory()
	{
		Tabpanel panel = new Tabpanel();
		panel.setParent(panels);

		Listbox list = new Listbox();
		list.setStyle("border:none");
		list.setParent(panel);

		Listitem uom = new Listitem("Unit of Measure");
		uom.setImage("/icons/measure.png");
		
		Listitem facility = new Listitem("Facility");
		facility.setImage("/icons/facility.png");
		
		Listitem prodCat = new Listitem("Product Category");
		prodCat.setImage("/icons/category.png");
		
		Listitem product = new Listitem("Product");
		product.setImage("/icons/product.png");
		
		Listitem invItem = new Listitem("Inventory Item");
		invItem.setImage("/icons/inventoryitem.png");
		
		uom.setParent(list);
		facility.setParent(list);
		prodCat.setParent(list);
		product.setParent(list);
		invItem.setParent(list);
	}
	
	protected void initSales()
	{
		Tabpanel panel = new Tabpanel();
		panel.setParent(panels);

		Listbox list = new Listbox();
		list.setStyle("border:none");
		list.setParent(panel);

		Listitem cash = new Listitem("Cash Sales");
		cash.setImage("/icons/cashsales.png");
		
		cash.setParent(list);
	}
}
