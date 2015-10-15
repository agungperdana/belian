/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Page;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Listbox;
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
		initHR();
	}

	protected void init()
	{
		setLeft("10px");
		setTop("65px");
		setWidth("200px");
		setHeight("600px");
		setMode(Mode.OVERLAPPED);
		
		caption.setImage("/icons/menu.png");
		caption.setParent(this);
		
		accordion.setMold("accordion");
		accordion.setParent(this);
		accordion.setHeight("97%");
		
		accordion.appendChild(tabs);
		accordion.appendChild(panels);
	}

	protected void initHeaders()
	{
		tabs.appendChild(new Tab("General"));
		tabs.appendChild(new Tab("Security"));
		tabs.appendChild(new Tab("Accounting"));
		tabs.appendChild(new Tab("Inventory"));
		tabs.appendChild(new Tab("Sales"));
		tabs.appendChild(new Tab("Human Resource"));
	}

	protected void initGeneral()
	{
		Tabpanel general = new Tabpanel();

		Listbox list = new Listbox();
		list.setStyle("border:none");
		
		list.appendChild(new GeographicItem());
		list.appendChild(new OrganizationItem());
		list.appendChild(new PersonItem());
		list.appendChild(new CompanyStructureItem());

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
//		list.appendChild(new BankAccountItem());
//		list.appendChild(new CashAccountItem());
		list.appendChild(new CoAItem());
		list.appendChild(new AccountingPeriodItem());
		list.appendChild(new OrganizationAccountItem());
		list.appendChild(new JournalEntryItem());
		list.appendChild(new BudgetItem());
		
		accounting.appendChild(list);
		panels.appendChild(accounting);
	}
	
	protected void initInventory()
	{
		Tabpanel panel = new Tabpanel();
		panel.setParent(panels);

		Listbox list = new Listbox();
		list.setStyle("border:none");

		panel.appendChild(list);
		panels.appendChild(panel);
		
		list.appendChild(new UOMItem());
		list.appendChild(new FacilityItem());
		list.appendChild(new ProductCategoryItem());
		list.appendChild(new ProductItem());
		list.appendChild(new InventoryItemItem());
	}
	
	protected void initHR()
	{
		Tabpanel hr = new Tabpanel();
		hr.setStyle("overflow:auto");

		Listbox list = new Listbox();
		list.setStyle("border:none");

		list.appendChild(new PositionTypeItem());
		list.appendChild(new PositionItem());
		list.appendChild(new EmploymentApplicationItem());
		list.appendChild(new EmploymentItem());
		
		hr.appendChild(list);

		panels.appendChild(hr);	
	}
	
	protected void initSales()
	{
		Tabpanel panel = new Tabpanel();

		Listbox list = new Listbox();
		list.setStyle("border:none");
		list.appendChild(new DirectSalesItem());
		
		panel.appendChild(list);
		panels.appendChild(panel);
	}
}
