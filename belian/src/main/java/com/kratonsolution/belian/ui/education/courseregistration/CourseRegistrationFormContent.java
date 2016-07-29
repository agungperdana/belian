/**
 * 
 */
package com.kratonsolution.belian.ui.education.courseregistration;

import java.math.BigDecimal;
import java.util.UUID;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.education.dm.CourseDiscount;
import com.kratonsolution.belian.education.dm.CourseInstallment;
import com.kratonsolution.belian.education.dm.CourseInstallmentItem;
import com.kratonsolution.belian.education.dm.CourseItem;
import com.kratonsolution.belian.education.dm.CourseRegistration;
import com.kratonsolution.belian.education.svc.CourseRegistrationService;
import com.kratonsolution.belian.education.svc.StudyDayService;
import com.kratonsolution.belian.education.svc.StudyPeriodService;
import com.kratonsolution.belian.education.svc.StudyTimeService;
import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.global.svc.CodeGenerator;
import com.kratonsolution.belian.payment.dm.Discount;
import com.kratonsolution.belian.payment.svc.DiscountService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.CurrencyList;
import com.kratonsolution.belian.ui.component.DisplayListener;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.component.ProductServiceRow;
import com.kratonsolution.belian.ui.component.TaxList;
import com.kratonsolution.belian.ui.education.student.StudentBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CourseRegistrationFormContent extends FormContent implements DisplayListener
{	
	private CourseRegistrationService service = Springs.get(CourseRegistrationService.class);
	
	private StudyPeriodService periodService = Springs.get(StudyPeriodService.class);
	
	private StudyDayService dayService = Springs.get(StudyDayService.class);
	
	private StudyTimeService timeService = Springs.get(StudyTimeService.class);
	
	private DiscountService discountService = Springs.get(DiscountService.class);
	
	private OrganizationList companys = new OrganizationList();
	
	private CodeGenerator generator = Springs.get(CodeGenerator.class);
	
	private CurrencyList currencys = new CurrencyList();
	
	private Datebox date = Components.currentDatebox();
	
	private StudentBox studentBox = new StudentBox(true);
	
	private TaxList taxs = new TaxList();
	
	private Listbox periods = Components.newSelect(periodService.findAll(),true);
	
	private Listbox days = Components.newSelect(dayService.findAll(),true);
	
	private Listbox times = Components.newSelect(timeService.findAll(),true);
	
	private Tabbox tabbox = new Tabbox();
	
	private Grid items = new Grid();
	
	private Grid discounts = new Grid();
	
	private Grid installments = new Grid();
	
	private Textbox billed = Components.readOnlyMoneyBox(BigDecimal.ZERO);
	
	private Textbox disc = Components.readOnlyMoneyBox(BigDecimal.ZERO);
		
	private Textbox total = Components.readOnlyMoneyBox(BigDecimal.ZERO);
	
	private Textbox paid = Components.readOnlyMoneyBox(BigDecimal.ZERO);
	
	private Textbox unpaid = Components.readOnlyMoneyBox(BigDecimal.ZERO);
	
	public CourseRegistrationFormContent()
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
				Flow.next(getParent(),new CourseRegistrationGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				CourseRegistration reg = new CourseRegistration();
				reg.setCurrency(currencys.getCurrency());
				reg.setDate(DateTimes.sql(date.getValue()));
				reg.setDay(dayService.findOne(Components.string(days)));
				reg.setOrganization(companys.getOrganization());
				reg.setPeriod(periodService.findOne(Components.string(periods)));
				reg.setStaff(utils.getEmployee());
				reg.setStudent(studentBox.getStudent());
				reg.setTax(taxs.getTax());
				reg.setTime(timeService.findOne(Components.string(times)));
				reg.setNumber(generator.generate(reg.getDate(),reg.getOrganization(),Code.CRS));
				
				for(Component com:items.getRows().getChildren())
				{
					ProductServiceRow row = (ProductServiceRow)com;
					
					CourseItem item = new CourseItem();
					item.setFeature(row.getFeature());
					item.setPrice(row.getPrice());
					item.setProduct(row.getProduct());
					item.setQuantity(row.getQuantity());
					item.setRegistration(reg);
					
					reg.getItems().add(item);
				}
				
				for(Component com:discounts.getRows().getChildren())
				{
					Row row = (Row)com;
					
					CourseDiscount discount = new CourseDiscount();
					discount.setAmount(RowUtils.decimal(row, 2));
					discount.setDiscount(discountService.findOne(RowUtils.string(row, 1)));
					discount.setRegistration(reg);
					
					reg.getDiscounts().add(discount);
				}
				
				BigDecimal iAmount = BigDecimal.ZERO;
				
				for(Component com:installments.getRows().getChildren())
				{
					Row row = (Row)com;
					
					CourseInstallment installment = new CourseInstallment();
					installment.setRegistration(reg);
					installment.setAmount(RowUtils.decimal(row, 3));
					installment.setCurrency(reg.getCurrency());
					installment.setCustomer(reg.getStudent());
					installment.setDate(RowUtils.sql(row, 2));
					installment.setName(RowUtils.string(row, 1));
					installment.setNumber(generator.generate(installment.getDate(), reg.getOrganization(), Code.INV));
					installment.setOrganization(reg.getOrganization());
					installment.setPaid(false);
					installment.setRegistration(reg);
					installment.setSales(reg.getStaff());
					installment.setTax(reg.getTax());
					
					CourseInstallmentItem item = new CourseInstallmentItem();
					item.setInstallment(installment);
					item.setPrice(installment.getAmount());
					item.setProduct(installment.getRegistration().getRoom().getCourse());
					
					installment.getItems().add(item);
					
					reg.getInstallments().add(installment);
				
					iAmount = iAmount.add(installment.getAmount());
				}
				
				if((reg.getBilledAmount().subtract(reg.getDiscountAmount())).compareTo(iAmount) != 0)
					throw new WrongValueException("Installment amount not equal billed amount");
				
				service.add(reg);
				
				Flow.next(getParent(),new CourseRegistrationGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().appendChild(new Column(null,null,"90px"));
		grid.getColumns().appendChild(new Column(null,null,"135px"));
		grid.setSpan("1");
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("generic.grid.column.company")));
		row1.appendChild(companys);
		row1.appendChild(new Label(lang.get("course.grid.billed")));
		row1.appendChild(billed);
		
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("generic.grid.column.student")));
		row2.appendChild(studentBox);
		row2.appendChild(new Label(lang.get("course.grid.discount")));
		row2.appendChild(disc);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("generic.grid.column.date")));
		row3.appendChild(date);
		row3.appendChild(new Label(lang.get("course.grid.total")));
		row3.appendChild(total);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("generic.grid.column.currency")));
		row4.appendChild(currencys);
//		row4.appendChild(new Label(lang.get("course.grid.paid")));
//		row4.appendChild(paid);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("generic.grid.column.tax")));
		row5.appendChild(taxs);
//		row5.appendChild(new Label(lang.get("course.grid.unpaid")));
//		row5.appendChild(unpaid);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("navbar.menu.education.period")));
		row6.appendChild(periods);
		
		Row row7 = new Row();
		row7.appendChild(new Label(lang.get("navbar.menu.education.day")));
		row7.appendChild(days);
		
		Row row8 = new Row();
		row8.appendChild(new Label(lang.get("navbar.menu.education.time")));
		row8.appendChild(times);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		rows.appendChild(row7);
		rows.appendChild(row8);
	}
	
	private void initTab()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab(lang.get("label.component.generic.items")));
		tabbox.getTabs().appendChild(new Tab(lang.get("label.component.generic.discounts")));
		tabbox.getTabs().appendChild(new Tab(lang.get("label.component.generic.installments")));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		
		items.setWidth("100%");
		items.appendChild(new Rows());
		items.appendChild(new Columns());
		items.getColumns().appendChild(new Column(null,null,"25px"));
		items.getColumns().appendChild(new Column(lang.get("course.grid.product"),null,"150px"));
		items.getColumns().appendChild(new Column(lang.get("course.grid.feature"),null,"100px"));
		items.getColumns().appendChild(new Column(lang.get("course.grid.quantity"),null,"85px"));
		items.getColumns().appendChild(new Column(lang.get("course.grid.price"),null,"120px"));
		items.getColumns().appendChild(new Column());
		items.setSpan("1");
		items.getColumns().getLastChild().setVisible(false);
		
		discounts.setWidth("100%");
		discounts.appendChild(new Rows());
		discounts.appendChild(new Columns());
		discounts.getColumns().appendChild(new Column(null,null,"25px"));
		discounts.getColumns().appendChild(new Column(lang.get("discount.grid.type"),null,"150px"));
		discounts.getColumns().appendChild(new Column(lang.get("discount.grid.amount"),null,"125px"));
		discounts.getColumns().appendChild(new Column());
		discounts.setSpan("1");
		discounts.getColumns().getLastChild().setVisible(false);
		
		installments.setWidth("100%");
		installments.appendChild(new Rows());
		installments.appendChild(new Columns());
		installments.getColumns().appendChild(new Column(null,null,"25px"));
		installments.getColumns().appendChild(new Column(lang.get("installment.grid.name"),null,"150px"));
		installments.getColumns().appendChild(new Column(lang.get("installment.grid.duedate"),null,"135px"));
		installments.getColumns().appendChild(new Column(lang.get("installment.grid.amount"),null,"125px"));
		installments.getColumns().appendChild(new Column());
		installments.setSpan("1");
		installments.getColumns().getLastChild().setVisible(false);
		
		appendChild(tabbox);
		
		initItems();
		initDiscounts();
		initInstallments();
	}
	
	private void initItems()
	{
		NRCToolbar nrc = new NRCToolbar(items);
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				ProductServiceRow row = new ProductServiceRow();
				row.addDisplayListener(CourseRegistrationFormContent.this);
				
				items.getRows().appendChild(row);
			}
		});
	
		tabbox.getTabpanels().getFirstChild().appendChild(nrc);
		tabbox.getTabpanels().getFirstChild().appendChild(items);
		
	}
	
	private void initDiscounts()
	{
		NRCToolbar nrc = new NRCToolbar(discounts);
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Doublebox amount = Components.readOnlyDoubleBox();
				
				Listbox discs = Components.fullSpanSelect(discountService.findAll(),true);
				discs.setSelectedItem(discs.appendItem("","000"));
				discs.addEventListener(Events.ON_SELECT, new EventListener<Event>()
				{
					@Override
					public void onEvent(Event arg0) throws Exception
					{
						amount.setText(null);
						Discount discount = discountService.findOne(Components.string(discs));
						if(discount != null)
						{
							if(discount.isPercent())
							{
								BigDecimal amt = discount.getAmount().divide(BigDecimal.valueOf(100)).multiply(getCost());
								amount.setText(Numbers.format(amt));
							}
							else
								amount.setText(Numbers.format(discount.getAmount()));
							
							display();
						}
					}
				});
			
				Row row = new Row();
				row.appendChild(new Checkbox());
				row.appendChild(discs);
				row.appendChild(amount);
				row.appendChild(new Label(UUID.randomUUID().toString()));
				discounts.getRows().appendChild(row);
			}
		});
		
		tabbox.getTabpanels().getChildren().get(1).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(1).appendChild(discounts);
	}
	
	private void initInstallments()
	{
		NRCToolbar nrc = new NRCToolbar(items);
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(new Checkbox());
				row.appendChild(Components.mandatoryTextBox(true));
				row.appendChild(Components.mandatoryDatebox());
				row.appendChild(Components.doubleBox(0));
				row.appendChild(new Label(UUID.randomUUID().toString()));
				
				installments.getRows().appendChild(row);
			}
		});
	
		tabbox.getTabpanels().getLastChild().appendChild(nrc);
		tabbox.getTabpanels().getLastChild().appendChild(installments);
		
	}
	
	private BigDecimal getCost()
	{
		BigDecimal cost = BigDecimal.ZERO;
		
		for(Component com:items.getRows().getChildren())
		{
			ProductServiceRow row = (ProductServiceRow)com;
			cost = cost.add(row.getPrice().multiply(row.getQuantity()));
		}
		
		return cost;
	}
	
	public void display()
	{
		BigDecimal bAmt = BigDecimal.ZERO;
		BigDecimal dAmt = BigDecimal.ZERO;
		
		for(Component com:items.getRows().getChildren())
		{
			ProductServiceRow row = (ProductServiceRow)com;
			bAmt = bAmt.add(row.getPrice().multiply(row.getQuantity()));
		}
		
		for(Component com:discounts.getRows().getChildren())
		{
			Row row = (Row)com;
			dAmt = dAmt.add(RowUtils.decimal(row, 2));
		}
		
		billed.setText(Numbers.format(bAmt));
		disc.setText(Numbers.format(dAmt));
		total.setText(Numbers.format(bAmt.subtract(dAmt)));
	}
}
