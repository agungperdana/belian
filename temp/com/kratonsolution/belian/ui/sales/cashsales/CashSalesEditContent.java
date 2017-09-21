/**
 * 
 */
package com.kratonsolution.belian.ui.sales.cashsales;

import java.math.BigDecimal;
import java.text.NumberFormat;

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

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.partys.dm.Person;
import com.kratonsolution.belian.sales.dm.CashSales;
import com.kratonsolution.belian.sales.dm.CashSalesLine;
import com.kratonsolution.belian.sales.srv.CashSalesService;
import com.kratonsolution.belian.sales.view.BillablePrint;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.PrintWindow;
import com.kratonsolution.belian.ui.component.CompanyList;
import com.kratonsolution.belian.ui.component.CurrencyList;
import com.kratonsolution.belian.ui.component.PersonBox;
import com.kratonsolution.belian.ui.component.ProductPriceSelectionListener;
import com.kratonsolution.belian.ui.component.ProductRow;
import com.kratonsolution.belian.ui.component.TaxList;
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
public class CashSalesEditContent extends FormContent implements ProductPriceSelectionListener
{	
	private CashSalesService service = Springs.get(CashSalesService.class);

	private GeographicService geographicService = Springs.get(GeographicService.class);

	private PersonService personService = Springs.get(PersonService.class);

	private Listbox tableNumber = Components.newSelect("175px");

	private Textbox number = Components.readOnlyTextBox();

	private Datebox date = Components.mandatoryDatebox();

	private Textbox bill = Components.moneyBox();

	private Textbox tax = Components.moneyBox();

	private Textbox totalBill = Components.moneyBox();

	private Textbox note = Components.stdTextBox(null, false);

	private PersonBox sellers = new PersonBox(false);

	private PersonBox customers = new PersonBox(false);

	private CurrencyList currencys = new CurrencyList();

	private CompanyList companys = new CompanyList();

	private Listbox locations = Components.fullSpanSelect(geographicService.findAll(),true);

	private TaxList taxes = new TaxList();

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
				Flow.next(getParent(), new CashSalesGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				CashSales sales = service.findOne(RowUtils.id(row));
				if(sales != null && !sales.isPaid())
				{
					sales.setTable(Integer.parseInt(Components.string(tableNumber)));
					sales.setCustomer(customers.getPerson());
					sales.setCurrency(currencys.getCurrency());
					sales.setDate(DateTimes.sql(date.getValue()));
					sales.setNote(note.getText());
					sales.setNumber(number.getText());
					sales.setTax(taxes.getTax());
					sales.setOrganization(companys.getOrganization());
					sales.setSales(sellers.getPerson());
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
				PrintWindow print = new PrintWindow(BillablePrint.GEN(RowUtils.string(row, 6),utils.isPos()),utils.isPos());
				print.setPage(getPage());
				print.setVisible(true);

			}
		});
	}

	@Override
	public void initForm()
	{
		companys.setWidth("100%");
		taxes.setWidth("100%");
		currencys.setWidth("100%");

		CashSales cash = service.findOne(RowUtils.id(row));
		if(cash != null)
		{
			number.setText(cash.getNumber());
			companys.setOrganization(cash.getOrganization());
			taxes.setTax(cash.getTax());
			currencys.setCurrency(cash.getCurrency());

			date.setValue(cash.getDate());
			bill.setText(Numbers.format(cash.getBillingAmount()));
			tax.setText(Numbers.format(cash.getTaxAmount()));
			totalBill.setText(Numbers.format(cash.getBillingAmount().add(cash.getTaxAmount())));
			note.setText(cash.getNote());
			
			sellers.setPerson(cash.getSales());
			customers.setPerson((Person)cash.getCustomer());

			for(int idx=1;idx<=20;idx++)
			{
				Listitem listitem = new Listitem(idx+"", idx);
				tableNumber.appendChild(listitem);
				if(idx == cash.getTable())
					tableNumber.setSelectedItem(listitem);
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

			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
			grid.getColumns().appendChild(new Column());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
			grid.getColumns().appendChild(new Column());

			Row row0 = new Row();
			row0.appendChild(new Label(lang.get("cashsales.grid.column.seq")));
			row0.appendChild(tableNumber);

			Row row1 = new Row();
			row1.appendChild(new Label(lang.get("cashsales.grid.column.company")));
			row1.appendChild(companys);
			row1.appendChild(new Label(lang.get("cashsales.grid.column.billing")));
			row1.appendChild(bill);

			Row row2 = new Row();
			row2.appendChild(new Label(lang.get("cashsales.grid.column.number")));
			row2.appendChild(number);
			row2.appendChild(new Label(lang.get("cashsales.grid.column.tax")));
			row2.appendChild(tax);

			Row row3 = new Row();
			row3.appendChild(new Label(lang.get("cashsales.grid.column.date")));
			row3.appendChild(date);
			row3.appendChild(new Label(lang.get("cashsales.grid.column.totbilling")));
			row3.appendChild(totalBill);

			Row row5 = new Row();
			row5.appendChild(new Label(lang.get("cashsales.grid.column.tax")));
			row5.appendChild(taxes);
			row5.appendChild(new Label(lang.get("cashsales.grid.column.currency")));
			row5.appendChild(currencys);

			Row row6 = new Row();
			row6.appendChild(new Label(lang.get("cashsales.grid.column.seller")));
			row6.appendChild(sellers);
			row6.appendChild(new Label(lang.get("cashsales.grid.column.customer")));
			row6.appendChild(customers);

			Row row8 = new Row();
			row8.appendChild(new Label(lang.get("cashsales.grid.column.location")));
			row8.appendChild(locations);
			row8.appendChild(new Label(lang.get("cashsales.grid.column.note")));
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
		CashSales cash = service.findOne(RowUtils.id(row));
		if(cash != null)
		{
			this.tabbox.getTabs().appendChild(new Tab(lang.get("cashsales.grid.column.items")));
			this.tabbox.getTabpanels().appendChild(new Tabpanel());

			NRCToolbar nrc = new NRCToolbar(saleItems);

			saleItems.appendChild(new Columns());
			saleItems.getColumns().appendChild(new Column(null,null,"25px"));
			saleItems.getColumns().appendChild(new Column(lang.get("cashsales.grid.column.product"),null,"225px"));
			saleItems.getColumns().appendChild(new Column(lang.get("cashsales.grid.column.quantity"),null,"85px"));
			saleItems.getColumns().appendChild(new Column(lang.get("cashsales.grid.column.uom"),null,"85px"));
			saleItems.getColumns().appendChild(new Column(lang.get("cashsales.grid.column.price"),null,"95px"));
			saleItems.getColumns().appendChild(new Column(lang.get("cashsales.grid.column.discount"),null,"95px"));
			saleItems.getColumns().appendChild(new Column(lang.get("cashsales.grid.column.charge"),null,"95px"));
			saleItems.getColumns().appendChild(new Column(lang.get("cashsales.grid.column.note"),null));
			saleItems.appendChild(new Rows());
			saleItems.setSpan("4");

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

			nrc.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					if(customers.getPerson() == null)
						throw new WrongValueException(customers,lang.get("message.field.empty"));
					
					ProductRow row = new ProductRow(Components.string(locations),customers.getPersonId(),Components.string(currencys));
					row.addProductPriceListener(CashSalesEditContent.this);
					saleItems.getRows().appendChild(row);
				}
			});

			this.tabbox.getTabpanels().getChildren().get(0).appendChild(nrc);
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

		if(taxes.getTax() != null)
			taxAmount = billAmount.multiply(taxes.getTax().getAmount()).divide(BigDecimal.valueOf(100));

		totalAmount = billAmount.add(taxAmount);

		NumberFormat format = NumberFormat.getNumberInstance();
		format.setGroupingUsed(true);

		bill.setText(format.format(billAmount));
		tax.setText(format.format(taxAmount));
		totalBill.setText(format.format(totalAmount));
	}
}
