/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import java.util.Map;

import org.zkoss.zk.ui.Page;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.healtcare.svc.DoctorService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class NavigationMenu extends Window
{	
	private final Tabbox accordion = new Tabbox();

	private Tabs tabs = new Tabs();

	private Tabpanels panels = new Tabpanels();

	private Caption caption = new Caption();
	
	private Language language = Springs.get(Language.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	public static final void injectInto(Page page)
	{
		new NavigationMenu().setPage(page);
	}
	
	private NavigationMenu()
	{
		Map<String,Boolean> modules = utils.getAccessibleModules();
		
		init();
		initGeneral(modules);
		initSecurity(modules);
		initAccounting(modules);
		initInventory(modules);
		initSales(modules);
		initProcurement(modules);
		initHealtcare(modules);
		initHR(modules);
	}

	protected void init()
	{
		setLeft("10px");
		setTop("65px");
		setWidth("200px");
		setHeight("600px");
		setMode(Mode.OVERLAPPED);
		
		caption.setLabel(language.get("navbar.title"));
		caption.setImage("/icons/menu.png");
		caption.setParent(this);
		
		accordion.setMold("accordion");
		accordion.setParent(this);
		accordion.setHeight("97%");
		
		accordion.appendChild(tabs);
		accordion.appendChild(panels);
	}

	protected void initGeneral(Map<String,Boolean> modules)
	{
		Listbox list = new Listbox();
		list.setStyle("border:none");
		
		if(modules.get("GEOGRAPHIC"))
			list.appendChild(new GeographicItem());
		if(modules.get("ORGANIZATION"))
			list.appendChild(new OrganizationItem());
		if(modules.get("PERSON"))
			list.appendChild(new PersonItem());
		if(modules.get("COMPANY_STRUCTURE"))
			list.appendChild(new CompanyStructureItem());
		
		if(!list.getChildren().isEmpty())
		{
			tabs.appendChild(new Tab(language.get("navbar.menu.general")));
			
			Tabpanel general = new Tabpanel();
			general.appendChild(list);

			panels.appendChild(general);
		}
	}
	
	protected void initSecurity(Map<String,Boolean> modules)
	{
		Listbox list = new Listbox();
		list.setStyle("border:none");
		
		if(modules.get("MODULE"))
			list.appendChild(new ModuleItem());
		if(modules.get("RLE"))
			list.appendChild(new RoleItem());
		if(modules.get("USERMENU"))
			list.appendChild(new UserItem());
		
		if(!list.getChildren().isEmpty())
		{
			tabs.appendChild(new Tab(language.get("navbar.menu.security")));
			Tabpanel panel = new Tabpanel();
			panel.appendChild(list);
			panels.appendChild(panel);
		}
	}
	
	protected void initAccounting(Map<String,Boolean> modules)
	{
		Listbox list = new Listbox();
		list.setStyle("border:none");
		
		if(modules.get("CURRENCY"))
			list.appendChild(new CurrencyItem());
		if(modules.get("TAX"))
			list.appendChild(new TaxItem());
		if(modules.get("COA"))
			list.appendChild(new CoAItem());
		if(modules.get("ACCOUNTINGPERIOD"))
			list.appendChild(new AccountingPeriodItem());
		if(modules.get("ORGANIZATIONACCOUNT"))
			list.appendChild(new OrganizationAccountItem());
		if(modules.get("JOURNALSETTING"))
			list.appendChild(new JournalSettingItem());
		if(modules.get("JOURNALENTRY"))
			list.appendChild(new JournalEntryItem());
		if(modules.get("BUDGET"))
			list.appendChild(new BudgetItem());
		
		if(!list.getChildren().isEmpty())
		{
			tabs.appendChild(new Tab(language.get("navbar.menu.accounting")));
			Tabpanel accounting = new Tabpanel();
			accounting.setStyle("overflow:auto");
			accounting.appendChild(list);
			panels.appendChild(accounting);
		}
	}
	
	protected void initInventory(Map<String,Boolean> modules)
	{
		Listbox list = new Listbox();
		list.setStyle("border:none");
		
		if(modules.containsKey("UOM") && modules.get("UOM"))
			list.appendChild(new UOMItem());
		if(modules.containsKey("FACILITY") && modules.get("FACILITY"))
			list.appendChild(new FacilityItem());
		if(modules.containsKey("PRDCATEGORY") && modules.get("PRDCATEGORY"))
			list.appendChild(new ProductCategoryItem());
		if(modules.containsKey("PRODUCT") && modules.get("PRODUCT"))
			list.appendChild(new ProductItem());
		if(modules.containsKey("INVITEM") && modules.get("INVITEM"))
			list.appendChild(new InventoryItemItem());
		if(modules.containsKey("TRN_ORDER_REQ") && modules.get("TRN_ORDER_REQ"))
			list.appendChild(new TransferOrderRequestItem());
		if(modules.containsKey("GOODS_TRANSFER") && modules.get("GOODS_TRANSFER"))
			list.appendChild(new GoodsTransferItem());
		if(modules.containsKey("GOODS_ISSUE") && modules.get("GOODS_ISSUE"))
			list.appendChild(new GoodsIssueItem());
		if(modules.containsKey("GOODS_RECEIVE") && modules.get("GOODS_RECEIVE"))
			list.appendChild(new GoodsReceiveItem());
		
		if(!list.getChildren().isEmpty())
		{
			tabs.appendChild(new Tab(language.get("navbar.menu.inventory")));
			Tabpanel panel = new Tabpanel();
			panel.setStyle("overflow:auto");
			panel.setParent(panels);
			panel.appendChild(list);
			panels.appendChild(panel);
		}
	}
	
	protected void initSales(Map<String,Boolean> modules)
	{
		Listbox list = new Listbox();
		list.setStyle("border:none");
		
		if(modules.get("CASHIER"))
			list.appendChild(new CashierItem());
		if(modules.get("CASHSALES"))
			list.appendChild(new CashSalesItem());
		if(modules.get("SALES_REPORT"))
			list.appendChild(new SalesReportItem());
		
		if(!list.getChildren().isEmpty())
		{
			tabs.appendChild(new Tab(language.get("navbar.menu.sales")));
			Tabpanel panel = new Tabpanel();
			panel.appendChild(list);
			panels.appendChild(panel);
		}
	}
	
	protected void initProcurement(Map<String,Boolean> modules)
	{
		Listbox list = new Listbox();
		list.setStyle("border:none");
		
		if(modules.containsKey("PURCHASE_ORDER_REQUEST") && modules.get("PURCHASE_ORDER_REQUEST"))
			list.appendChild(new PurchaseOrderRequestItem());
		if(modules.containsKey("CASH_PURCHASE_ORDER") && modules.get("CASH_PURCHASE_ORDER"))
			list.appendChild(new CashPurchaseOrderItem());
		
		if(!list.getChildren().isEmpty())
		{
			tabs.appendChild(new Tab(language.get("navbar.menu.procurement")));
			Tabpanel panel = new Tabpanel();
			panel.appendChild(list);
			panels.appendChild(panel);
		}
	}
	
	protected void initHealtcare(Map<String,Boolean> modules)
	{
		Listbox list = new Listbox();
		list.setStyle("border:none");
		
		if(modules.get("DOCTORTYPE"))
			list.appendChild(new DoctorTypeItem());
		
		if(modules.get("DOCTOR"))
			list.appendChild(new DoctorItem());

		SessionUtils utils = Springs.get(SessionUtils.class);
		DoctorService service = Springs.get(DoctorService.class);
		if(utils != null && service != null && utils.getUser().getPerson() != null)
		{
			if(!service.findAllByPerson(utils.getUser().getPerson().getId()).isEmpty())
				list.appendChild(new DoctorDashboardItem());
		}
		
		if(modules.get("PATIENT"))
			list.appendChild(new PatientItem());
		
		if(modules.get("DOCTOR_APPOINTMENT"))
			list.appendChild(new DoctorAppointmentItem());
		
		list.appendChild(new LabScheduleItem());
		
		if(modules.get("LABS_REGISTRATION"))
			list.appendChild(new LabsRegistrationItem());
		
		if(modules.containsKey("MEDICATION") && modules.get("MEDICATION"))
			list.appendChild(new PharmacySalesItem());
		
		list.appendChild(new PharmacyOrderItem());
		
		if(!list.getChildren().isEmpty())
		{
			Tabpanel healtcare = new Tabpanel();
			healtcare.setStyle("overflow:auto");
			healtcare.appendChild(list);

			tabs.appendChild(new Tab(language.get("navbar.menu.healtcare")));
			panels.appendChild(healtcare);
		}
	}
	
	protected void initHR(Map<String,Boolean> modules)
	{
		Listbox list = new Listbox();
		list.setStyle("border:none");
		
		if(modules.get("POSITIONTYPE"))
			list.appendChild(new PositionTypeItem());
		if(modules.get("POSITIONTYPERATE"))
			list.appendChild(new PositionTypeRateItem());
		if(modules.get("PAY_GRADE"))
			list.appendChild(new PayGradeItem());
		if(modules.get("POSITION"))
			list.appendChild(new PositionItem());
		if(modules.get("EMPYAPP"))
			list.appendChild(new EmploymentApplicationItem());
		if(modules.get("EMPLOYMENT"))
			list.appendChild(new EmploymentItem());

		if(!list.getChildren().isEmpty())
		{
			tabs.appendChild(new Tab(language.get("navbar.menu.hr")));
			Tabpanel hr = new Tabpanel();
			hr.setStyle("overflow:auto");
			hr.appendChild(list);
			panels.appendChild(hr);
		}
	}
}
