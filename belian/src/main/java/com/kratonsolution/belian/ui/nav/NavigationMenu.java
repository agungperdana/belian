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
		initPayment(modules);
		initInventory(modules);
		initAsset(modules);
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
		
		if(modules.containsKey("ROLE_GEOGRAPHIC_READ"))
			list.appendChild(new GeographicItem());
		if(modules.containsKey("ROLE_ORGANIZATION_READ"))
			list.appendChild(new OrganizationItem());
		if(modules.containsKey("ROLE_PERSON_READ"))
			list.appendChild(new PersonItem());
		if(modules.containsKey("ROLE_COMPANY_STRUCTURE_READ"))
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
		
		if(modules.containsKey("ROLE_MODULE_READ"))
			list.appendChild(new ModuleItem());
		if(modules.containsKey("ROLE_ACCESS_ROLE_READ"))
			list.appendChild(new RoleItem());
		if(modules.containsKey("ROLE_USER_READ"))
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
		
		if(modules.containsKey("ROLE_CURRENCY_READ"))
			list.appendChild(new CurrencyItem());
		if(modules.containsKey("ROLE_TAX_READ"))
			list.appendChild(new TaxItem());
		if(modules.containsKey("ROLE_COA_READ"))
			list.appendChild(new CoAItem());
		if(modules.containsKey("ROLE_ACCOUNTINGPERIOD_READ"))
			list.appendChild(new AccountingPeriodItem());
		if(modules.containsKey("ROLE_ORGANIZATIONACCOUNT_READ"))
			list.appendChild(new OrganizationAccountItem());
		if(modules.containsKey("ROLE_JOURNALSETTING_READ"))
			list.appendChild(new JournalSettingItem());
		if(modules.containsKey("ROLE_JOURNALENTRY_READ"))
			list.appendChild(new JournalEntryItem());
		if(modules.containsKey("ROLE_BUDGET_READ"))
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
		
		if(modules.containsKey("ROLE_UOM_READ"))
			list.appendChild(new UOMItem());
		if(modules.containsKey("ROLE_FACILITY_READ"))
			list.appendChild(new FacilityItem());
		if(modules.containsKey("ROLE_PRDCATEGORY_READ"))
			list.appendChild(new ProductCategoryItem());
		if(modules.containsKey("ROLE_PRODUCT_READ"))
			list.appendChild(new ProductItem());
		if(modules.containsKey("ROLE_INVITEM_READ"))
			list.appendChild(new InventoryItemItem());
		if(modules.containsKey("ROLE_TRN_ORDER_REQ_READ"))
			list.appendChild(new TransferOrderRequestItem());
		if(modules.containsKey("ROLE_GOODS_TRANSFER_READ"))
			list.appendChild(new GoodsTransferItem());
		if(modules.containsKey("ROLE_GOODS_ISSUE_READ"))
			list.appendChild(new GoodsIssueItem());
		if(modules.containsKey("ROLE_GOODS_RECEIVE_READ"))
			list.appendChild(new GoodsReceiveItem());
		if(modules.containsKey("ROLE_STOCK_ADJUSTMENT_READ"))
			list.appendChild(new StockAdjustmentMenu());
		if(modules.containsKey("ROLE_STOCK_OPNAME_READ"))
			list.appendChild(new StockOpnameMenu());
		
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
		
		if(modules.containsKey("ROLE_CASHIER_READ"))
			list.appendChild(new CashierItem());
		if(modules.containsKey("ROLE_CASHSALES_READ"))
			list.appendChild(new CashSalesItem());
		if(modules.containsKey("ROLE_SALES_REPORT_READ"))
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
		
		if(modules.containsKey("ROLE_PURCHASE_ORDER_REQUEST_READ"))
			list.appendChild(new PurchaseOrderRequestItem());
		if(modules.containsKey("ROLE_CASH_PURCHASE_ORDER_READ"))
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
		
		if(modules.containsKey("ROLE_DOCTORTYPE_READ"))
			list.appendChild(new DoctorTypeItem());
		
		if(modules.containsKey("ROLE_DOCTOR_READ"))
			list.appendChild(new DoctorItem());

		SessionUtils utils = Springs.get(SessionUtils.class);
		DoctorService service = Springs.get(DoctorService.class);
		if(utils != null && service != null && utils.getUser().getPerson() != null)
		{
			if(!service.findAllByPerson(utils.getUser().getPerson().getId()).isEmpty())
				list.appendChild(new DoctorDashboardItem());
		}
		
		if(modules.containsKey("ROLE_PATIENT"))
			list.appendChild(new PatientItem());
		
		if(modules.containsKey("ROLE_DOCTOR_APPOINTMENT_READ"))
			list.appendChild(new DoctorAppointmentItem());
		
		if(modules.containsKey("ROLE_LABS_REGISTRATION_READ"))
			list.appendChild(new LabScheduleItem());
		
		if(modules.containsKey("ROLE_LABS_REGISTRATION_READ"))
			list.appendChild(new LabsRegistrationItem());
		
		if(modules.containsKey("ROLE_MEDICATION_READ"))
			list.appendChild(new PharmacySalesItem());
		
		if(modules.containsKey("ROLE_MEDICATION_READ"))
			list.appendChild(new PharmacyOrderItem());
		
		if(modules.containsKey("ROLE_FAMILY_FOLDER_READ"))
			list.appendChild(new FamilyFolderItem());
		
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
		
		if(modules.containsKey("ROLE_POSITIONTYPE_READ"))
			list.appendChild(new PositionTypeItem());
		if(modules.containsKey("ROLE_POSITIONTYPERATE_READ"))
			list.appendChild(new PositionTypeRateItem());
		if(modules.containsKey("ROLE_POSITION_READ"))
			list.appendChild(new PositionItem());
		if(modules.containsKey("ROLE_BENEFIT_TYPE_READ"))
			list.appendChild(new BenefitTypeItem());
		if(modules.containsKey("ROLE_EMPYAPP_READ"))
			list.appendChild(new EmploymentApplicationItem());
		if(modules.containsKey("ROLE_EMPLOYMENT_READ"))
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
	
	protected void initAsset(Map<String,Boolean> modules)
	{
		Listbox list = new Listbox();
		list.setStyle("border:none");
		
		if(modules.containsKey("ROLE_ASSET_TYPE_READ"))
			list.appendChild(new AssetTypeItem());
		if(modules.containsKey("ROLE_ASSET_READ"))
			list.appendChild(new AssetItem());

		if(!list.getChildren().isEmpty())
		{
			tabs.appendChild(new Tab(language.get("navbar.menu.asset")));
			Tabpanel hr = new Tabpanel();
			hr.setStyle("overflow:auto");
			hr.appendChild(list);
			panels.appendChild(hr);
		}
	}
	
	protected void initPayment(Map<String,Boolean> modules)
	{
		Listbox list = new Listbox();
		list.setStyle("border:none");
		
		if(modules.containsKey("ROLE_DEDUCTION_TYPE_READ"))
			list.appendChild(new DeductionTypeItem());
		if(modules.containsKey("ROLE_PAYCHECK_READ"))
			list.appendChild(new PaycheckItem());

		if(!list.getChildren().isEmpty())
		{
			tabs.appendChild(new Tab(language.get("navbar.menu.payment")));
			Tabpanel hr = new Tabpanel();
			hr.setStyle("overflow:auto");
			hr.appendChild(list);
			panels.appendChild(hr);
		}
	}
}
