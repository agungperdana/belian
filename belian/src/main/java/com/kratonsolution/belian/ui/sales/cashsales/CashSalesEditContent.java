/**
 * 
 */
package com.kratonsolution.belian.ui.sales.cashsales;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.Iterator;

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
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.dm.Tax;
import com.kratonsolution.belian.accounting.svc.CurrencyService;
import com.kratonsolution.belian.accounting.svc.TaxService;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.sales.dm.CashSales;
import com.kratonsolution.belian.sales.dm.CashSalesLine;
import com.kratonsolution.belian.sales.srv.CashSalesService;
import com.kratonsolution.belian.sales.view.BillablePrint;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.PrintWindow;
import com.kratonsolution.belian.ui.component.ProductPriceSelectionListener;
import com.kratonsolution.belian.ui.component.ProductRow;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashSalesEditContent extends FormContent implements ProductPriceSelectionListener
{	
	private SessionUtils sessionUtils = Springs.get(SessionUtils.class);

	private CashSalesService service = Springs.get(CashSalesService.class);

	private GeographicService geographicService = Springs.get(GeographicService.class);

	private OrganizationService organizationService = Springs.get(OrganizationService.class);

	private CurrencyService currencyService = Springs.get(CurrencyService.class);

	private PersonService personService = Springs.get(PersonService.class);

	private TaxService taxService = Springs.get(TaxService.class);

	private Listbox tableNumber = Components.newSelect("175px");

	private Textbox number = Components.readOnlyTextBox("BLG"+System.currentTimeMillis());

	private Datebox date = Components.mandatoryDatebox();

	private Textbox bill = Components.moneyBox();

	private Textbox tax = Components.moneyBox();

	private Textbox totalBill = Components.moneyBox();

	private Textbox note = new Textbox();

	private Listbox producers = Components.fullSpanSelect();

	private Listbox consumers = Components.fullSpanSelect();

	private Listbox currencys = Components.fullSpanSelect();

	private Listbox organizations = Components.fullSpanSelect();

	private Listbox locations = Components.fullSpanSelect(geographicService.findAll(),true);

	private Listbox taxes = Components.fullSpanSelect(taxService.findAll(),true);

	private Tabbox tabbox = new Tabbox();

	private Grid saleItems = new Grid();

	private Row row;

	public CashSalesEditContent(Row row)
	{
		super();
		this.row = row;
		initToolbar();
		initForm();
		

		this.tabbox.setWidth("100%");
		this.tabbox.appendChild(new Tabpanels());
		this.tabbox.appendChild(new Tabs());

		appendChild(tabbox);

		initItems();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				CashSalesWindow window = (CashSalesWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{

				if(Strings.isNullOrEmpty(number.getText()))
					throw new WrongValueException(number,"Code cannot be empty");

				CashSales sales = service.findOne(RowUtils.string(row, 6));
				if(sales != null && !sales.isPaid())
				{
					sales.setTable(Integer.parseInt(Components.string(tableNumber)));
					sales.setCustomer(personService.findOne(Components.string(consumers)));
					sales.setCurrency(currencyService.findOne(Components.string(currencys)));
					sales.setDate(new Date(date.getValue().getTime()));
					sales.setNote(note.getText());
					sales.setNumber(number.getText());
					sales.setTax(taxService.findOne(Components.string(taxes)));
					sales.setOrganization(organizationService.findOne(Components.string(organizations)));
					sales.setSales(personService.findOne(Components.string(producers)));
					sales.setLocation(geographicService.findOne(Components.string(locations)));
					sales.getItems().clear();
					
					service.edit(sales);

					for(Component com:saleItems.getRows().getChildren())
					{
						ProductRow row = (ProductRow)com;

						CashSalesLine line = new CashSalesLine();
						line.setCashSales(sales);
						line.setCharge(row.getCharge());
						line.setDiscount(row.getDiscount());
						line.setNote(row.getNote());
						line.setPrice(row.getPrice());
						line.setProduct(row.getProduct());
						line.setQuantity(row.getQuantity());
						line.setUom(line.getProduct().getUom());
						
						sales.getItems().add(line);
					}

					service.edit(sales);
				}

				CashSalesWindow window = (CashSalesWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
		
		toolbar.attachPrint();
		toolbar.getPrint().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PrintWindow print = new PrintWindow(BillablePrint.GEN(RowUtils.string(row, 6),sessionUtils.isPos()),sessionUtils.isPos());
				print.setPage(getPage());
				print.setVisible(true);
				
			}
		});
	}

	@Override
	public void initForm()
	{
		CashSales cash = service.findOne(RowUtils.string(row, 6));
		if(cash != null)
		{
			date.setConstraint("no empty");
			date.setValue(cash.getDate());

			bill.setText(Numbers.format(cash.getBillingAmount()));
			tax.setText(Numbers.format(cash.getTaxAmount()));
			totalBill.setText(Numbers.format(cash.getBillingAmount().add(cash.getTaxAmount())));

			note.setWidth("100%");
			note.setText(cash.getNote());

			for(int idx=1;idx<=20;idx++)
			{
				Listitem listitem = new Listitem(idx+"", idx);
				tableNumber.appendChild(listitem);
				if(idx == cash.getTable())
					tableNumber.setSelectedItem(listitem);
			}

			for(Object object:taxes.getChildren())
			{
				Listitem listitem = (Listitem)object;
				if(cash.getTax() != null && listitem.getLabel().equals(cash.getTax().getLabel()))
					taxes.setSelectedItem(listitem);
			}

			organizations.appendChild(new Listitem(cash.getOrganization().getLabel(), cash.getOrganization().getId()));
			organizations.setSelectedIndex(0);

			for(Currency currency:currencyService.findAll())
			{
				Listitem listitem = new Listitem(currency.getCode(), currency.getId());
				currencys.appendChild(listitem);
				if(currency.getId().equals(cash.getCurrency().getId()))
					currencys.setSelectedItem(listitem);
			}

			for(Object object:locations.getChildren())
			{
				Listitem listitem = (Listitem)object;
				if(listitem.getValue().equals(cash.getLocation().getId()))
				{
					locations.setSelectedItem(listitem);
					break;
				}
			}

			producers.appendChild(new Listitem(cash.getSales().getLabel(), cash.getSales().getValue()));
			producers.setSelectedIndex(0);

			consumers.appendChild(new Listitem(personService.anonymous().getLabel(), personService.anonymous().getValue()));
			consumers.setSelectedIndex(0);

			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
			grid.getColumns().appendChild(new Column());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
			grid.getColumns().appendChild(new Column());

			Row row0 = new Row();
			row0.appendChild(new Label("Sequence Number"));
			row0.appendChild(tableNumber);
			
			Row row1 = new Row();
			row1.appendChild(new Label("Document Owner"));
			row1.appendChild(organizations);
			row1.appendChild(new Label("Billing"));
			row1.appendChild(bill);
			
			Row row2 = new Row();
			row2.appendChild(new Label("Document Number"));
			row2.appendChild(number);
			row2.appendChild(new Label("Tax"));
			row2.appendChild(tax);
			
			Row row3 = new Row();
			row3.appendChild(new Label("Date"));
			row3.appendChild(date);
			row3.appendChild(new Label("Total Billing"));
			row3.appendChild(totalBill);
			
			Row row5 = new Row();
			row5.appendChild(new Label("Tax"));
			row5.appendChild(taxes);
			row5.appendChild(new Label("Currency"));
			row5.appendChild(currencys);
			
			Row row6 = new Row();
			row6.appendChild(new Label("Sales Person"));
			row6.appendChild(producers);
			row6.appendChild(new Label("Customer"));
			row6.appendChild(consumers);
			
			Row row8 = new Row();
			row8.appendChild(new Label("Sales Location"));
			row8.appendChild(locations);
			row8.appendChild(new Label("Note"));
			row8.appendChild(note);
			
			rows.appendChild(row0);
			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
			rows.appendChild(row5);
			rows.appendChild(row6);
			rows.appendChild(row8);
		}
	}

	private void initItems()
	{
		CashSales cash = service.findOne(RowUtils.string(row, 6));
		if(cash != null)
		{
			this.tabbox.getTabs().appendChild(new Tab("Sales Item(s)"));
			this.tabbox.getTabpanels().appendChild(new Tabpanel());

			saleItems.appendChild(new Columns());
			saleItems.getColumns().appendChild(new Column(null,null,"25px"));
			saleItems.getColumns().appendChild(new Column("Product",null,"225px"));
			saleItems.getColumns().appendChild(new Column("Quantity",null,"85px"));
			saleItems.getColumns().appendChild(new Column("UoM",null,"85px"));
			saleItems.getColumns().appendChild(new Column("Price",null,"95px"));
			saleItems.getColumns().appendChild(new Column("Disc",null,"95px"));
			saleItems.getColumns().appendChild(new Column("Charge",null,"95px"));
			saleItems.getColumns().appendChild(new Column("Note",null));
			saleItems.appendChild(new Rows());
			saleItems.setSpan("1");

			for(CashSalesLine line:cash.getItems())
			{
				ProductRow row = new ProductRow(cash.getLocation().getId(),cash.getCustomer().getId(),cash.getCurrency().getId());
				row.setProduct(line.getProduct());
				row.setQuantity(line.getQuantity());
				row.setPrice(line.getPrice());
				row.setDiscount(line.getDiscount());
				row.setCharge(line.getCharge());
				row.setNote(line.getNote());

				saleItems.getRows().appendChild(row);
			}

			Toolbar toolbar = new Toolbar();
			toolbar.setHeight("40px");
			toolbar.appendChild(new Toolbarbutton("New","/icons/new.png"));
			toolbar.appendChild(new Toolbarbutton("Remove","/icons/delete.png"));
			toolbar.appendChild(new Toolbarbutton("Clear","/icons/refresh.png"));
			toolbar.getChildren().get(0).addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					ProductRow row = new ProductRow(Components.string(locations),Components.string(consumers),Components.string(currencys));
					row.addProductPriceListener(CashSalesEditContent.this);
					saleItems.getRows().appendChild(row);
				}
			});

			toolbar.getChildren().get(1).addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					Iterator<Component> iterator = saleItems.getRows().getChildren().iterator();
					while (iterator.hasNext())
					{
						Row row = (Row) iterator.next();
						if(RowUtils.isChecked(row, 0))
							iterator.remove();
					}
					
					display();
				}
			});
			
			toolbar.getChildren().get(2).addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					saleItems.getRows().getChildren().clear();
					display();
				}
			});

			this.tabbox.getTabpanels().getChildren().get(0).appendChild(toolbar);
			this.tabbox.getTabpanels().getChildren().get(0).appendChild(saleItems);
		}
	}

	@Override
	public void fireSelectedPrice(BigDecimal quantity, BigDecimal price,BigDecimal discount, BigDecimal charge)
	{
		display();
	}

	private void display()
	{
		BigDecimal billAmount = BigDecimal.ZERO;
		BigDecimal taxAmount = BigDecimal.ZERO;
		BigDecimal totalAmount = BigDecimal.ZERO;
		
		for(Component com:saleItems.getRows().getChildren())
		{
			ProductRow row = (ProductRow)com;
			billAmount = billAmount.add(row.getQuantity().multiply(row.getPrice().subtract(row.getDiscount()).add(row.getCharge())));
		}
		
		Tax tx = taxService.findOne(Components.string(taxes));
		if(tx != null)
			taxAmount = billAmount.multiply(tx.getAmount()).divide(BigDecimal.valueOf(100));
		
		totalAmount = billAmount.add(taxAmount);
		
		NumberFormat format = NumberFormat.getNumberInstance();
		format.setGroupingUsed(true);
		
		bill.setText(format.format(billAmount));
		tax.setText(format.format(taxAmount));
		totalBill.setText(format.format(totalAmount));
	}
}
