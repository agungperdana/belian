/**
 * 
 */
package com.kratonsolution.belian.ui.sales.cashsales;

import java.math.BigDecimal;
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
import org.zkoss.zul.Doublebox;
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
import com.kratonsolution.belian.accounting.dm.Tax;
import com.kratonsolution.belian.accounting.svc.CurrencyService;
import com.kratonsolution.belian.accounting.svc.TaxService;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.sales.dm.CashSales;
import com.kratonsolution.belian.sales.dm.CashSalesLine;
import com.kratonsolution.belian.sales.srv.CashSalesService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.CurrencyList;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.component.ProductPriceSelectionListener;
import com.kratonsolution.belian.ui.component.ProductRow;
import com.kratonsolution.belian.ui.component.TaxList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashSalesFormContent extends FormContent implements ProductPriceSelectionListener
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
	
	private Doublebox term = Components.readOnlyDoubleBox(0);
	
	private Textbox bill = Components.moneyBox();
	
	private Textbox tax = Components.moneyBox();
	
	private Textbox totalBill = Components.moneyBox();
	
	private Textbox note = new Textbox();
	
	private Listbox producers = Components.fullSpanSelect();
	
	private Listbox consumers = Components.fullSpanSelect();
	
	private CurrencyList currencys = new CurrencyList();
	
	private OrganizationList companys = new OrganizationList();
	
	private Listbox locations = Components.fullSpanSelect(geographicService.findAll(),true);
	
	private TaxList taxes = new TaxList();
	
	private Tabbox tabbox = new Tabbox();
	
	private Grid saleItems = new Grid();
	
	public CashSalesFormContent()
	{
		super();
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
				if(Strings.isNullOrEmpty(number.getText()))
					throw new WrongValueException(number,"Code cannot be empty");
			
				if(Strings.isNullOrEmpty(term.getText()))
					throw new WrongValueException(term,"Holder cannot be empty");
				
				CashSales sales = new CashSales();
				sales.setTable(Integer.parseInt(Components.string(tableNumber)));
				sales.setCustomer(personService.findOne(Components.string(consumers)));
				sales.setCurrency(currencys.getCurrency());
				sales.setDate(DateTimes.sql(date.getValue()));
				sales.setNote(note.getText());
				sales.setNumber(number.getText());
				sales.setTax(taxes.getTax());
				sales.setOrganization(companys.getOrganization());
				sales.setSales(personService.findOne(Components.string(producers)));
				sales.setLocation(geographicService.findOne(Components.string(locations)));
				
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
				
				service.add(sales);
				
				Flow.next(getParent(), new CashSalesGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{		
		companys.setWidth("100%");
		currencys.setWidth("100%");
		taxes.setWidth("100%");
		
		bill.setStyle("text-align:right;");
		
		note.setWidth("100%");
		
		for(int idx=1;idx<=20;idx++)
			tableNumber.appendChild(new Listitem(idx+"", idx));
		
		Components.setDefault(tableNumber);
		
		for(Object object:locations.getChildren())
		{
			Listitem listitem = (Listitem)object;
			if(sessionUtils.getLocation() != null && listitem.getValue().equals(sessionUtils.getLocation().getValue()))
			{
				locations.setSelectedItem(listitem);
				break;
			}
		}
		
		if(sessionUtils.getUser().getPerson() != null)
		{
			producers.appendChild(new Listitem(sessionUtils.getUser().getPerson().getLabel(), sessionUtils.getUser().getPerson().getValue()));
			producers.setSelectedIndex(0);
		}
		
		consumers.appendChild(new Listitem(personService.anonymous().getLabel(), personService.anonymous().getValue()));
		consumers.setSelectedIndex(0);
		
		taxes.addEventListener(Events.ON_SELECT,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				display();
			}
		});
		
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
		row1.appendChild(companys);
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
	
	private void initItems()
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
		saleItems.setSpan("4");
		
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
				row.addProductPriceListener(CashSalesFormContent.this);
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