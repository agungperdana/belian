/**
 * 
 */
package com.kratonsolution.belian.ui.cashsales;

import java.math.BigDecimal;
import java.util.Iterator;

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
import com.kratonsolution.belian.general.dm.AddressRepository;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.svc.CompanyStructureService;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.global.svc.EconomicAgentService;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductPrice;
import com.kratonsolution.belian.inventory.dm.ProductPriceRepository;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.inventory.svc.UnitOfMeasureService;
import com.kratonsolution.belian.sales.dm.CashSales;
import com.kratonsolution.belian.sales.dm.CashSalesLine;
import com.kratonsolution.belian.sales.srv.CashSalesService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashSalesFormContent extends FormContent
{	
	private SessionUtils sessionUtils = Springs.get(SessionUtils.class);
	
	private CashSalesService service = Springs.get(CashSalesService.class);
	
	private GeographicService geographicService = Springs.get(GeographicService.class);
	
	private ProductPriceRepository priceRepository = Springs.get(ProductPriceRepository.class);
	
	private EconomicAgentService agentService = Springs.get(EconomicAgentService.class);
	
	private CompanyStructureService unitService = Springs.get(CompanyStructureService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private CurrencyService currencyService = Springs.get(CurrencyService.class);
	
	private ProductService productService = Springs.get(ProductService.class);
	
	private UnitOfMeasureService unitOfMeasureService = Springs.get(UnitOfMeasureService.class);
	
	private AddressRepository addressService = Springs.get(AddressRepository.class);
	
	private PersonService personService = Springs.get(PersonService.class);
	
	private TaxService taxService = Springs.get(TaxService.class);
	
	private Listbox tableNumber = Components.newSelect();
	
	private Textbox number = Components.readOnlyTextBox("BLG"+System.currentTimeMillis());
	
	private Datebox date = Components.mandatoryDatebox();
	
	private Doublebox term = Components.readOnlyDoubleBox(0);
	
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
				CashSalesWindow window = (CashSalesWindow)getParent();
				window.removeCreateForm();
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
			
				if(Strings.isNullOrEmpty(term.getText()))
					throw new WrongValueException(term,"Holder cannot be empty");
				
				CashSales sales = new CashSales();
				sales.setTable(Integer.parseInt(Components.string(tableNumber)));
				sales.setConsumer(agentService.findOne(Components.string(consumers)));
				sales.setCreditTerm(term.getValue().intValue());
				sales.setCurrency(currencyService.findOne(Components.string(currencys)));
				sales.setDate(date.getValue());
				sales.setNote(note.getText());
				sales.setNumber(number.getText());
				sales.setTax(taxService.findOne(Components.string(taxes)));
				sales.setOrganization(organizationService.findOne(Components.string(organizations)));
				sales.setProducer(agentService.findOne(Components.string(producers)));
				sales.setLocation(geographicService.findOne(Components.string(locations)));
				
				for(Object object:saleItems.getRows().getChildren())
				{
					Row row = (Row)object;
					
					Listbox products = (Listbox)row.getChildren().get(1);
					Listbox prices = (Listbox)row.getChildren().get(2);
					Listbox discs = (Listbox)row.getChildren().get(3);
					Listbox charges = (Listbox)row.getChildren().get(4);
					Doublebox quantity = (Doublebox)row.getChildren().get(5);
					Textbox note = (Textbox)row.getChildren().get(7);

					CashSalesLine line = new CashSalesLine();
					line.setCashSales(sales);
					line.setPrice(Components.decimal(prices));
					line.setDiscount(Components.decimal(discs));
					line.setCharge(Components.decimal(charges));
					line.setQuantity(BigDecimal.valueOf(quantity.doubleValue()));
					line.setProduct(productService.findOne(Components.string(products)));
					line.setUom(line.getProduct().getUom());
					line.setNote(note.getText());
					
					sales.getDecrements().add(line);
				}
				
				service.add(sales);
				
				CashSalesWindow window = (CashSalesWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		date.setConstraint("no empty");
				
		term.setConstraint("no empty");
		term.setWidth("65px");
		
		bill.setStyle("text-align:right;");
		
		note.setWidth("100%");
		
		for(int idx=1;idx<=20;idx++)
			tableNumber.appendChild(new Listitem(idx+"", idx));
		
		for(Object object:taxes.getChildren())
		{
			Listitem listitem = (Listitem)object;
			if(listitem.getLabel().equals("None"))
				taxes.setSelectedItem(listitem);
		}
		
		Components.setDefault(tableNumber);
		
		for(Organization organization:sessionUtils.getOrganizations())
		{
			Listitem listitem = new Listitem(organization.getName(),organization.getId());
			organizations.appendChild(listitem);
			if(sessionUtils.getOrganization() != null && sessionUtils.getOrganization().getId().equals(organization.getId()))
				organizations.setSelectedItem(listitem);
		}
			
		for(Currency currency:currencyService.findAll())
		{
			Listitem listitem = new Listitem(currency.getCode(), currency.getId());
			currencys.appendChild(listitem);
			if(sessionUtils.getCurrency() != null && currency.getId().equals(sessionUtils.getCurrency().getId()))
				currencys.setSelectedItem(listitem);
		}
		
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
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row0 = new Row();
		row0.appendChild(new Label("Table Number"));
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
		
		Row row4 = new Row();
		row4.appendChild(new Label("Credit Term"));
		row4.appendChild(term);
		
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
		rows.appendChild(row4);
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
		saleItems.getColumns().appendChild(new Column("Price",null,"95px"));
		saleItems.getColumns().appendChild(new Column("Disc",null,"95px"));
		saleItems.getColumns().appendChild(new Column("Charge",null,"95px"));
		saleItems.getColumns().appendChild(new Column("Quantity",null,"85px"));
		saleItems.getColumns().appendChild(new Column("UoM",null,"85px"));
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
				Listbox products = new Listbox();
				products.setMold("select");
				products.setWidth("100%");
				
				for(Product product:productService.findAll())
					products.appendChild(new Listitem(product.getName(), product.getId()));

				Listbox prices = new Listbox();
				prices.setMold("select");
				prices.setWidth("100%");
				
				Listbox discs = new Listbox();
				discs.setMold("select");
				discs.setWidth("100%");
				
				Listbox charges = new Listbox();
				charges.setMold("select");
				charges.setWidth("100%");
				
				Listbox uoms = new Listbox();
				uoms.setMold("select");
				uoms.setWidth("100%");
				
				Doublebox quantity = new Doublebox(0d);
				quantity.setWidth("100%");
				quantity.addEventListener(Events.ON_CHANGE, new EventListener<Event>()
				{
					@Override
					public void onEvent(Event event) throws Exception
					{
						setBill();
					}
				});
				
				Textbox note = new Textbox();
				note.setWidth("100%");
				
				products.addEventListener(Events.ON_SELECT, new EventListener<Event>()
				{
					@Override
					public void onEvent(Event event) throws Exception
					{
						Product product = productService.findOne(products.getSelectedItem().getValue().toString());
						if(product != null)
						{
							for(ProductPrice price:priceRepository.load(date.getValue(), Components.string(currencys), Components.string(locations), Components.string(consumers), product.getId(),ProductPrice.Type.BASE))
								prices.appendChild(new Listitem(Numbers.format(price.getPrice()), price.getPrice()));
							
							for(ProductPrice price:priceRepository.load(date.getValue(), Components.string(currencys), Components.string(locations), Components.string(consumers), product.getId(),ProductPrice.Type.DISCOUNT))
								discs.appendChild(new Listitem(Numbers.format(price.getPrice()), price.getPrice()));
							
							for(ProductPrice price:priceRepository.load(date.getValue(), Components.string(currencys), Components.string(locations), Components.string(consumers), product.getId(),ProductPrice.Type.CHARGE))
								charges.appendChild(new Listitem(Numbers.format(price.getPrice()), price.getPrice()));
							
							uoms.appendChild(new Listitem(product.getUom().getCode(),product.getUom().getId()));
							
							Components.setDefault(prices);
							Components.setDefault(discs);
							Components.setDefault(charges);
							Components.setDefault(uoms);
						}
					}
				});
				
				prices.addEventListener(Events.ON_SELECT,new BillEventListener());
				discs.addEventListener(Events.ON_SELECT,new BillEventListener());
				charges.addEventListener(Events.ON_SELECT,new BillEventListener());
				
				Row row = new Row();
				row.appendChild(new Checkbox());
				row.appendChild(products);
				row.appendChild(prices);
				row.appendChild(discs);
				row.appendChild(charges);
				row.appendChild(quantity);
				row.appendChild(uoms);
				row.appendChild(note);
				
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
			}
		});
		
		toolbar.getChildren().get(2).addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				saleItems.getRows().getChildren().clear();
			}
		});
		
		this.tabbox.getTabpanels().getChildren().get(0).appendChild(toolbar);
		this.tabbox.getTabpanels().getChildren().get(0).appendChild(saleItems);
	}
	
	private void setBill()
	{
		BigDecimal tBill = BigDecimal.ZERO;
		BigDecimal taxAmt = BigDecimal.ZERO;
		
		for(Object object:saleItems.getRows().getChildren())
		{
			Row row = (Row)object;
			
			BigDecimal price = RowUtils.decimal(row, 2).multiply(RowUtils.decimal(row, 5));
			price = price.add(RowUtils.decimal(row, 4)).subtract(RowUtils.decimal(row, 3));
		
			tBill = tBill.add(price);
		}


		
		Tax out = taxService.findOne(Components.string(taxes));
		if(out != null)
			taxAmt = tBill.multiply(out.getAmount().divide(BigDecimal.valueOf(100)));


		bill.setText(Numbers.format(tBill));
		tax.setText(Numbers.format(taxAmt));
		totalBill.setText(Numbers.format(tBill.add(taxAmt)));
	}
	
	private class BillEventListener implements EventListener<Event>
	{
		@Override
		public void onEvent(Event event) throws Exception
		{
			setBill();
		}
	}
}