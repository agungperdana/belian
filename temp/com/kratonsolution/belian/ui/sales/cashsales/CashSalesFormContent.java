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

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.sales.dm.CashSales;
import com.kratonsolution.belian.sales.dm.CashSalesLine;
import com.kratonsolution.belian.sales.srv.CashSalesService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.CurrencyList;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.component.PersonBox;
import com.kratonsolution.belian.ui.component.ProductPriceSelectionListener;
import com.kratonsolution.belian.ui.component.ProductRow;
import com.kratonsolution.belian.ui.component.TaxList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashSalesFormContent extends FormContent implements ProductPriceSelectionListener
{	
	private CashSalesService service = Springs.get(CashSalesService.class);
	
	private GeographicService geographicService = Springs.get(GeographicService.class);
	
	private PersonService personService = Springs.get(PersonService.class);
	
	private Listbox tableNumber = Components.newSelect("175px");
	
	private Textbox number = Components.readOnlyTextBox("BLG"+System.currentTimeMillis());
	
	private Datebox date = Components.mandatoryDatebox();
	
	private Doublebox term = Components.readOnlyDoubleBox(0);
	
	private Textbox bill = Components.moneyBox();
	
	private Textbox tax = Components.moneyBox();
	
	private Textbox totalBill = Components.moneyBox();
	
	private Textbox note = Components.stdTextBox(null, false);
	
	private PersonBox seller = new PersonBox(false);
	
	private PersonBox customers = new PersonBox(false);
	
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
					throw new WrongValueException(number,lang.get("message.field.empty"));
			
				if(Strings.isNullOrEmpty(term.getText()))
					throw new WrongValueException(term,lang.get("message.field.empty"));
				
				CashSales sales = new CashSales();
				sales.setTable(Integer.parseInt(Components.string(tableNumber)));
				sales.setCustomer(personService.anonymous());
				sales.setCurrency(currencys.getCurrency());
				sales.setDate(DateTimes.sql(date.getValue()));
				sales.setNote(note.getText());
				sales.setNumber(number.getText());
				sales.setTax(taxes.getTax());
				sales.setOrganization(companys.getOrganization());
				sales.setSales(utils.getEmployee());
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
		taxes.setWidth("100%");
		currencys.setWidth("100%");
		seller.setPerson(utils.getEmployee());
		customers.setPerson(personService.anonymous());
		
		bill.setStyle("text-align:right;");
		
		for(int idx=1;idx<=20;idx++)
			tableNumber.appendChild(new Listitem(idx+"", idx));
		
		Components.setDefault(tableNumber);
		
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
		row6.appendChild(seller);
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
	
	private void initItems()
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
		
		nrc.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(customers.getPerson() == null)
					throw new WrongValueException(customers,lang.get("message.field.empty"));
				
				ProductRow row = new ProductRow(Components.string(locations),customers.getPersonId(),Components.string(currencys));
				row.addProductPriceListener(CashSalesFormContent.this);
				saleItems.getRows().appendChild(row);
			}
		});

		this.tabbox.getTabpanels().getChildren().get(0).appendChild(nrc);
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