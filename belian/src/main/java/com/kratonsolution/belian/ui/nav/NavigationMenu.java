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
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class NavigationMenu extends Window
{	
	private Tabbox accordion = new Tabbox();

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
		initFinancial(modules);
		initPayment(modules);
		initInventory(modules);
		initAsset(modules);
		initHR(modules);
		initProcurement(modules);
		initSales(modules);
//		initPharmacy(modules);
//		initClinic(modules);
//		initMedicalLab(modules);
		initEducation(modules);
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
			list.appendChild(new GeographicMenu());
		if(modules.containsKey("ROLE_ORGANIZATION_READ"))
			list.appendChild(new OrganizationMenu());
		if(modules.containsKey("ROLE_PERSON_READ"))
			list.appendChild(new PersonMenu());
		if(modules.containsKey("ROLE_COMPANY_STRUCTURE_READ"))
			list.appendChild(new CompanyStructureMenu());
		
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
			list.appendChild(new ModuleMenu());
		if(modules.containsKey("ROLE_ACCESS_ROLE_READ"))
			list.appendChild(new RoleMenu());
		if(modules.containsKey("ROLE_USER_READ"))
			list.appendChild(new UserMenu());
		
		SessionUtils utils = Springs.get(SessionUtils.class);
		if(utils.isSysAdmin())
			list.appendChild(new ImportToolMenu());
		
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
			list.appendChild(new CurrencyMenu());
		if(modules.containsKey("ROLE_TAX_READ"))
			list.appendChild(new TaxMenu());
		if(modules.containsKey("ROLE_COA_READ"))
			list.appendChild(new CoAMenu());
		if(modules.containsKey("ROLE_ACCOUNTINGPERIOD_READ"))
			list.appendChild(new AccountingPeriodMenu());
		if(modules.containsKey("ROLE_ORGANIZATIONACCOUNT_READ"))
			list.appendChild(new OrganizationAccountMenu());
		if(modules.containsKey("ROLE_JOURNALSETTING_READ"))
			list.appendChild(new JournalSettingMenu());
		if(modules.containsKey("ROLE_JOURNALENTRY_READ"))
			list.appendChild(new JournalEntryMenu());
		if(modules.containsKey("ROLE_BUDGET_READ"))
			list.appendChild(new BudgetMenu());
		
		if(!list.getChildren().isEmpty())
		{
			tabs.appendChild(new Tab(language.get("navbar.menu.accounting")));
			Tabpanel accounting = new Tabpanel();
			accounting.setStyle("overflow:auto");
			accounting.appendChild(list);
			panels.appendChild(accounting);
		}
	}
	
	protected void initFinancial(Map<String,Boolean> modules)
	{
		Listbox list = new Listbox();
		list.setStyle("border:none");
		
		if(modules.containsKey("ROLE_PROFIT_LOSS_READ"))
			list.appendChild(new ProfitLossReportMenu());
		
		if(!list.getChildren().isEmpty())
		{
			tabs.appendChild(new Tab(language.get("navbar.menu.finance")));
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
			list.appendChild(new UOMMenu());
		if(modules.containsKey("ROLE_FACILITY_READ"))
			list.appendChild(new FacilityMenu());
		if(modules.containsKey("ROLE_PRDCATEGORY_READ"))
			list.appendChild(new ProductCategoryMenu());
		if(modules.containsKey("ROLE_PRODUCT_READ"))
			list.appendChild(new ProductMenu());
		if(modules.containsKey("ROLE_INVITEM_READ"))
			list.appendChild(new InventoryItemMenu());
		if(modules.containsKey("ROLE_TRN_ORDER_REQ_READ"))
			list.appendChild(new TransferOrderRequestMenu());
		if(modules.containsKey("ROLE_GOODS_TRANSFER_READ"))
			list.appendChild(new GoodsTransferMenu());
		if(modules.containsKey("ROLE_GOODS_ISSUE_READ"))
			list.appendChild(new GoodsIssueMenu());
		if(modules.containsKey("ROLE_GOODS_RECEIVE_READ"))
			list.appendChild(new GoodsReceiveMenu());
		if(modules.containsKey("ROLE_STOCK_ADJUSTMENT_READ"))
			list.appendChild(new StockAdjustmentMenu());
		if(modules.containsKey("ROLE_STOCK_OPNAME_READ"))
			list.appendChild(new StockOpnameMenu());
		if(modules.containsKey("ROLE_STOCK_ADMIN_READ"))
			list.appendChild(new StockAdminMenu());
		if(modules.containsKey("ROLE_PRODUCT_RETUR_READ"))
			list.appendChild(new ProductReturMenu());
		
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
			list.appendChild(new CashierMenu());
		if(modules.containsKey("ROLE_CASHSALES_READ"))
			list.appendChild(new CashSalesMenu());
		if(modules.containsKey("ROLE_SALES_REPORT_READ"))
			list.appendChild(new SalesReportMenu());
		
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
		
		if(modules.containsKey("ROLE_SUPPLIER_READ"))
			list.appendChild(new SupplierMenu());
		if(modules.containsKey("ROLE_PURCHASE_ORDER_REQUEST_READ"))
			list.appendChild(new PurchaseOrderRequestMenu());
		if(modules.containsKey("ROLE_CASH_PURCHASE_ORDER_READ"))
			list.appendChild(new CashPurchaseOrderMenu());
		
		if(!list.getChildren().isEmpty())
		{
			tabs.appendChild(new Tab(language.get("navbar.menu.procurement")));
			Tabpanel panel = new Tabpanel();
			panel.appendChild(list);
			panels.appendChild(panel);
		}
	}
	
	protected void initMedicalLab(Map<String,Boolean> modules)
	{
		Listbox list = new Listbox();
		list.setStyle("border:none");

		if(modules.containsKey("ROLE_LABS_REGISTRATION_READ"))
			list.appendChild(new LabsRegistrationMenu());
		
		if(modules.containsKey("ROLE_LABS_REGISTRATION_READ"))
			list.appendChild(new LabScheduleMenu());
		
		if(!list.getChildren().isEmpty())
		{
			Tabpanel healtcare = new Tabpanel();
			healtcare.setStyle("overflow:auto");
			healtcare.appendChild(list);

			tabs.appendChild(new Tab(language.get("navbar.menu.medicallab")));
			panels.appendChild(healtcare);
		}
	}
	
	protected void initPharmacy(Map<String,Boolean> modules)
	{
		Listbox list = new Listbox();
		list.setStyle("border:none");
		
		if(modules.containsKey("ROLE_PHARMACY_SALES_READ"))
			list.appendChild(new PharmacySalesMenu());
		
		if(modules.containsKey("ROLE_PHARMACY_ORDER_READ"))
			list.appendChild(new PharmacyOrderMenu());
		
		if(!list.getChildren().isEmpty())
		{
			Tabpanel healtcare = new Tabpanel();
			healtcare.setStyle("overflow:auto");
			healtcare.appendChild(list);

			tabs.appendChild(new Tab(language.get("navbar.menu.pharmacy")));
			panels.appendChild(healtcare);
		}
	}
	
	protected void initClinic(Map<String,Boolean> modules)
	{
		Listbox list = new Listbox();
		list.setStyle("border:none");
		
		if(modules.containsKey("ROLE_DOCTORTYPE_READ"))
			list.appendChild(new DoctorTypeMenu());
		
		if(modules.containsKey("ROLE_DOCTOR_READ"))
			list.appendChild(new DoctorMenu());

		if(modules.containsKey("ROLE_PATIENT_READ"))
			list.appendChild(new PatientMenu());

		if(modules.containsKey("ROLE_DOCTOR_APPOINTMENT_READ"))
			list.appendChild(new DoctorAppointmentMenu());
		
		SessionUtils utils = Springs.get(SessionUtils.class);
		if(utils.isDoctor())
			list.appendChild(new DoctorDashboardMenu());
				
		if(modules.containsKey("ROLE_FAMILY_FOLDER_READ"))
			list.appendChild(new FamilyFolderMenu());
		
		if(modules.containsKey("ROLE_CLINIC_SALES_READ"))
			list.appendChild(new ClinicSalesMenu());
		
		if(!list.getChildren().isEmpty())
		{
			Tabpanel healtcare = new Tabpanel();
			healtcare.setStyle("overflow:auto");
			healtcare.appendChild(list);

			tabs.appendChild(new Tab(language.get("navbar.menu.clinic")));
			panels.appendChild(healtcare);
		}
	}
	
	protected void initHR(Map<String,Boolean> modules)
	{
		Listbox list = new Listbox();
		list.setStyle("border:none");
		
		if(modules.containsKey("ROLE_POSITIONTYPE_READ"))
			list.appendChild(new PositionTypeMenu());
		if(modules.containsKey("ROLE_POSITIONTYPERATE_READ"))
			list.appendChild(new PositionTypeRateMenu());
		if(modules.containsKey("ROLE_POSITION_READ"))
			list.appendChild(new PositionMenu());
		if(modules.containsKey("ROLE_BENEFIT_TYPE_READ"))
			list.appendChild(new BenefitTypeMenu());
		if(modules.containsKey("ROLE_EMPYAPP_READ"))
			list.appendChild(new EmploymentApplicationMenu());
		if(modules.containsKey("ROLE_EMPLOYMENT_READ"))
			list.appendChild(new EmploymentMenu());

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
			list.appendChild(new AssetTypeMenu());
		if(modules.containsKey("ROLE_ASSET_READ"))
			list.appendChild(new AssetMenu());

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
		
		if(modules.containsKey("ROLE_DISCOUNT_READ"))
			list.appendChild(new DiscountMenu());
		if(modules.containsKey("ROLE_PAYMENT_METHOD_TYPE_READ"))
			list.appendChild(new PaymentMethodTypeMenu());
		if(modules.containsKey("ROLE_DEDUCTION_TYPE_READ"))
			list.appendChild(new DeductionTypeMenu());
		if(modules.containsKey("ROLE_PAYCHECK_READ"))
			list.appendChild(new PaycheckMenu());

		if(!list.getChildren().isEmpty())
		{
			tabs.appendChild(new Tab(language.get("navbar.menu.payment")));
			Tabpanel hr = new Tabpanel();
			hr.setStyle("overflow:auto");
			hr.appendChild(list);
			panels.appendChild(hr);
		}
	}
	
	protected void initEducation(Map<String,Boolean> modules)
	{
		Listbox list = new Listbox();
		list.setStyle("border:none");

		if(modules.containsKey("ROLE_STUDY_PERIOD_READ"))
			list.appendChild(new StudyPeriodMenu());
		if(modules.containsKey("ROLE_STUDY_DAY_READ"))
			list.appendChild(new StudyDayMenu());
		if(modules.containsKey("ROLE_STUDY_TIME_READ"))
			list.appendChild(new StudyTimeMenu());
		if(modules.containsKey("ROLE_STUDENT_READ"))
			list.appendChild(new StudentMenu());
		if(modules.containsKey("ROLE_COURSE_REGISTRATION_READ"))
			list.appendChild(new CourseRegistrationMenu());
		if(modules.containsKey("ROLE_STUDY_ROOM_READ"))
			list.appendChild(new StudyRoomMenu());
		if(modules.containsKey("ROLE_COURSE_ATTENDANCE_READ"))
			list.appendChild(new CourseAttendanceMenu());

		if(!list.getChildren().isEmpty())
		{
			tabs.appendChild(new Tab(language.get("navbar.menu.education")));
			Tabpanel hr = new Tabpanel();
			hr.setStyle("overflow:auto");
			hr.appendChild(list);
			panels.appendChild(hr);
		}
	}
}
