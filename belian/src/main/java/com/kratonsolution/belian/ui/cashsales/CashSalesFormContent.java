/**
 * 
 */
package com.kratonsolution.belian.ui.cashsales;

import java.math.BigDecimal;
import java.util.Iterator;
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
import com.kratonsolution.belian.accounting.svc.CashAccountService;
import com.kratonsolution.belian.accounting.svc.CurrencyService;
import com.kratonsolution.belian.common.Dates;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Address;
import com.kratonsolution.belian.general.dm.AddressRepository;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.OrganizationUnit;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.general.svc.OrganizationUnitService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.global.dm.EconomicEvent;
import com.kratonsolution.belian.global.dm.EconomicEvent.EconomicalType;
import com.kratonsolution.belian.global.dm.EconomicEvent.Type;
import com.kratonsolution.belian.global.svc.EconomicAgentService;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductPrice;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.inventory.svc.UnitOfMeasureService;
import com.kratonsolution.belian.sales.dm.CashSales;
import com.kratonsolution.belian.sales.dm.CashSalesLine;
import com.kratonsolution.belian.sales.dm.CashSalesLineEvent;
import com.kratonsolution.belian.sales.dm.CashSalesPayment;
import com.kratonsolution.belian.sales.dm.CashSalesPaymentEvent;
import com.kratonsolution.belian.sales.dm.PaymentType;
import com.kratonsolution.belian.sales.srv.CashSalesService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
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
	
	private EconomicAgentService agentService = Springs.get(EconomicAgentService.class);
	
	private OrganizationUnitService unitService = Springs.get(OrganizationUnitService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private CurrencyService currencyService = Springs.get(CurrencyService.class);
	
	private ProductService productService = Springs.get(ProductService.class);
	
	private UnitOfMeasureService unitOfMeasureService = Springs.get(UnitOfMeasureService.class);
	
	private AddressRepository addressService = Springs.get(AddressRepository.class);
	
	private CashAccountService cashAccountService = Springs.get(CashAccountService.class);
	
	private PersonService personService = Springs.get(PersonService.class);
	
	private Listbox tableNumber = Components.newSelect();
	
	private Textbox number = Components.readOnlyTextBox("BLN"+System.currentTimeMillis());
	
	private Datebox date = Components.mandatoryDatebox();
	
	private Doublebox term = Components.readOnlyDoubleBox(0);
	
	private Doublebox bill = Components.doubleBox(0);
	
	private Textbox note = new Textbox();
	
	private Listbox producers = Components.fullSpanSelect();
	
	private Listbox consumers = Components.fullSpanSelect();
	
	private Listbox currencys = Components.fullSpanSelect();
	
	private Listbox organizations = Components.fullSpanSelect();
	
	private Listbox locations = Components.fullSpanSelect();
	
	private Tabbox tabbox = new Tabbox();
	
	private Grid saleItems = new Grid();
	
	private Grid payments = new Grid();
	
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
		initPayments();
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
				sales.setOrganization(organizationService.findOne(Components.string(organizations)));
				sales.setProducer(agentService.findOne(Components.string(producers)));
				sales.setLocation(addressService.findOne(Components.string(locations)));
				
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
					line.setValue(BigDecimal.valueOf(quantity.doubleValue()));
					line.setResource(productService.findOne(Components.string(products)));
					line.setUom(line.getResource().getUom());
					line.setNote(note.getText());
					
					CashSalesLineEvent events = new CashSalesLineEvent();
					events.setConsumer(sales.getConsumer());
					events.setDate(sales.getDate());
					events.setProducer(sales.getProducer());
					events.setResource(line.getResource());
					events.setType(EconomicEvent.Type.GIVE);
					events.setValue(line.getValue());
					events.setEconomicType(EconomicalType.NONECONOMIC);

					line.setEvent(events);
					sales.getDecrements().add(line);
				}
				
				for(Object object:payments.getRows().getChildren())
				{
					Row row = (Row)object;
					
					Listbox types = (Listbox)row.getChildren().get(1);
					Textbox cardno = (Textbox)row.getChildren().get(2);
					Doublebox amount = (Doublebox)row.getChildren().get(3);
					Textbox note = (Textbox)row.getChildren().get(4);
				
					CashSalesPayment line = new CashSalesPayment();
					line.setId(UUID.randomUUID().toString());
					line.setDate(sales.getDate());
					line.setCashSales(sales);
					line.setType(PaymentType.valueOf(Components.string(types)));
					line.setValue(Components.decimal(amount));
					line.setCardNumber(cardno.getText());
					line.setNote(note.getText());
					
					CashSalesPaymentEvent events = new CashSalesPaymentEvent();
					events.setId(UUID.randomUUID().toString());
					events.setConsumer(sales.getConsumer());
					events.setDate(sales.getDate());
					events.setEconomicType(EconomicalType.ECONOMIC);
					events.setProducer(sales.getProducer());
					events.setType(Type.GET);
					events.setValue(line.getValue());
					
					line.setEvent(events);
					
					sales.getIncrements().add(line);
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
		
		note.setWidth("100%");
		
		for(int idx=1;idx<=20;idx++)
			tableNumber.appendChild(new Listitem(idx+"", idx));
		
		Components.setDefault(tableNumber);
		
		for(OrganizationUnit unit:unitService.findAll())
		{
			Listitem listitem = new Listitem(unit.getParty().getName(),unit.getParty().getId());
			organizations.appendChild(listitem);
			if(sessionUtils.getOrganization() != null && sessionUtils.getOrganization().getId().equals(unit.getParty().getId()))
			{
				organizations.setSelectedItem(listitem);
				for(Address address:unit.getParty().getAddresses())
				{
					Listitem listitem2 = new Listitem(address.getLabel(), address.getValue());
					locations.appendChild(listitem2);
					if(sessionUtils.getLocation() != null && sessionUtils.getLocation().getId().equals(address.getValue()))
						locations.setSelectedItem(listitem2);
				}
			
				if(locations.getSelectedCount() == 0)
					Components.setDefault(locations);
			}
		}
			
		for(Currency currency:currencyService.findAll())
		{
			Listitem listitem = new Listitem(currency.getCode(), currency.getId());
			currencys.appendChild(listitem);
			if(sessionUtils.getCurrency() != null && currency.getId().equals(sessionUtils.getCurrency().getId()))
				currencys.setSelectedItem(listitem);
		}
		
		organizations.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Organization organization = organizationService.findOne(Components.string(organizations));
				if(organization != null)
				{
					for(Address address:organization.getAddresses())
					{
						Listitem listitem = new Listitem(address.getLabel(), address.getValue());
						locations.appendChild(listitem);
						if(sessionUtils.getLocation() != null && sessionUtils.getLocation().getId().equals(address.getValue()))
							locations.setSelectedItem(listitem);
					}
				}

				if(locations.getSelectedCount() == 0)
					Components.setDefault(locations);
				Components.setDefault(consumers);
			}
		});
		
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
		
		Row row1 = new Row();
		row1.appendChild(new Label("Table Number"));
		row1.appendChild(tableNumber);
		row1.appendChild(new Label("Document Owner"));
		row1.appendChild(organizations);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Document Number"));
		row2.appendChild(number);
		row2.appendChild(new Label("Date"));
		row2.appendChild(date);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Credit Term"));
		row4.appendChild(term);
		row4.appendChild(new Label("Currency"));
		row4.appendChild(currencys);
		
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
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row4);
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
							for(ProductPrice price:product.getPrices())
							{
								if(Dates.inRange(date.getValue(), price.getFrom(), price.getTo()) && 
								   price.getCurrency().getId().equals(currencys.getSelectedItem().getValue()) &&
								   (price.getGeographic() == null || price.getGeographic().getId().equals(locations.getSelectedItem().getValue())) &&
								   (price.getParty() == null || price.getParty().getId().equals(consumers.getSelectedItem().getValue())))
								{
									if(price.getType().equals(ProductPrice.Type.BASE))
										prices.appendChild(new Listitem(price.getPrice().toEngineeringString(), price.getPrice().toEngineeringString()));
									else if(price.getType().equals(ProductPrice.Type.DISCOUNT))
										discs.appendChild(new Listitem(price.getPrice().toEngineeringString(), price.getPrice().toEngineeringString()));
									else if(price.getType().equals(ProductPrice.Type.CHARGE))
										charges.appendChild(new Listitem(price.getPrice().toEngineeringString(), price.getPrice().toEngineeringString()));
								}
							}
							
							uoms.appendChild(new Listitem(product.getUom().getCode(),product.getUom().getId()));
						}
					}
				});
				
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
				Iterator<Component> iterator = grid.getRows().getChildren().iterator();
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
	
	private void initPayments()
	{
		this.tabbox.getTabs().appendChild(new Tab("Payment(s)"));
		this.tabbox.getTabpanels().appendChild(new Tabpanel());
		
		payments.appendChild(new Columns());
		payments.getColumns().appendChild(new Column("Type",null,"125px"));
		payments.getColumns().appendChild(new Column("Card Number",null,"200px"));
		payments.getColumns().appendChild(new Column("Amount",null,"125px"));
		payments.getColumns().appendChild(new Column("Note",null));
		payments.appendChild(new Rows());
		payments.setSpan("3");
		
		Listbox types = Components.fullSpanSelect();
		types.appendChild(new Listitem(PaymentType.CASH.name(), PaymentType.CASH.name()));
		types.setSelectedIndex(0);
		
		Textbox note = new Textbox();
		note.setWidth("100%");

		Row row = new Row();
		row.appendChild(types);
		row.appendChild(Components.readOnlyTextBox());
		row.appendChild(bill);
		row.appendChild(note);
		
		payments.getRows().appendChild(row);
		
		this.tabbox.getTabpanels().getChildren().get(1).appendChild(payments);
	}
}
