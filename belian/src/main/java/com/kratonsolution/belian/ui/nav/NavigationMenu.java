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

		Listbox list = new Listbox();
		list.setStyle("border:none");
		
		list.appendChild(new GeographicItem());
		list.appendChild(new PartyRoleTypeItem());
		list.appendChild(new PartyRelationshipTypeItem());
		list.appendChild(new OrganizationItem());
		list.appendChild(new PersonItem());

		general.appendChild(list);
		panels.appendChild(general);
	}
	
	protected void initSecurity()
	{
		Tabpanel panel = new Tabpanel();
				
		Listbox list = new Listbox();
		list.setStyle("border:none");
		list.appendChild(new ModuleItem());
		list.appendChild(new RoleItem());
		list.appendChild(new UserItem());
	
		panel.appendChild(list);
		panels.appendChild(panel);
	}
	
	protected void initAccounting()
	{
		Tabpanel accounting = new Tabpanel();
		accounting.setStyle("overflow:auto");

		Listbox list = new Listbox();
		list.setStyle("border:none");
		
		list.appendChild(new CurrencyItem());
		list.appendChild(new TaxItem());
		list.appendChild(new BankAccountItem());
		list.appendChild(new CashAccountItem());
		list.appendChild(new CoAItem());
		list.appendChild(new AccountingPeriodItem());
		list.appendChild(new OrganizationAccountItem());
		
		accounting.appendChild(list);
		panels.appendChild(accounting);
	}
	
	protected void initInventory()
	{
		Tabpanel panel = new Tabpanel();
		panel.setParent(panels);

		Listbox list = new Listbox();
		list.setStyle("border:none");
		list.setParent(panel);
		
		Listitem invItem = new Listitem("Inventory Item");
		invItem.setImage("/icons/inventoryitem.png");
		
		list.appendChild(new UOMItem());
		list.appendChild(new FacilityItem());
		list.appendChild(new ProductCategoryItem());
		list.appendChild(new ProductItem());
		list.appendChild(invItem);
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
