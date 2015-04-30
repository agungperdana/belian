/**
 * 
 */
package com.kratonsolution.belian.ui.cashsales;

import java.util.Date;
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
import com.kratonsolution.belian.accounting.svc.CurrencyService;
import com.kratonsolution.belian.common.Dates;
import com.kratonsolution.belian.general.dm.Geographic;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.global.dm.EconomicAgent;
import com.kratonsolution.belian.global.svc.EconomicAgentService;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductPrice;
import com.kratonsolution.belian.inventory.dm.UnitOfMeasure;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.inventory.svc.UnitOfMeasureService;
import com.kratonsolution.belian.sales.dm.CashLine;
import com.kratonsolution.belian.sales.dm.CashSales;
import com.kratonsolution.belian.sales.dm.PaymentType;
import com.kratonsolution.belian.sales.srv.CashSalesService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class CashSalesFormContent extends FormContent
{	
	private CashSalesService service = Springs.get(CashSalesService.class);
	
	private EconomicAgentService agentService = Springs.get(EconomicAgentService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private CurrencyService currencyService = Springs.get(CurrencyService.class);
	
	private ProductService productService = Springs.get(ProductService.class);
	
	private UnitOfMeasureService unitOfMeasureService = Springs.get(UnitOfMeasureService.class);
	
	private GeographicService geographicService = Springs.get(GeographicService.class);
	
	private Textbox number = new Textbox();
	
	private Datebox date = new Datebox(new Date());
	
	private Doublebox term = new Doublebox();
	
	private Textbox note = new Textbox();
	
	private Listbox producers = new Listbox();
	
	private Listbox consumers = new Listbox();
	
	private Listbox currencys = new Listbox();
	
	private Listbox organizations = new Listbox();
	
	private Listbox locations = new Listbox();
	
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
				sales.setConsumer(agentService.findOne(Components.string(consumers)));
				sales.setCreditTerm(term.getValue().intValue());
				sales.setCurrency(currencyService.findOne(Components.string(currencys)));
				sales.setDate(date.getValue());
				sales.setNote(note.getText());
				sales.setNumber(number.getText());
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
					Listbox uom = (Listbox)row.getChildren().get(6);
					Textbox note = (Textbox)row.getChildren().get(7);

					CashLine line = new CashLine();
					line.setId(UUID.randomUUID().toString());
					line.setCashSales(sales);
					line.setPrice(Components.decimal(prices));
					line.setDiscount(Components.decimal(discs));
					line.setCharge(Components.decimal(charges));
					line.setAmounts();
				}
				
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
		
		number.setConstraint("no empty");
		number.setWidth("300px");
		
		term.setConstraint("no empty");
		term.setWidth("65px");
		
		producers.setMold("select");
		consumers.setMold("select");
		organizations.setMold("select");
		currencys.setMold("select");
		locations.setMold("select");
		
		for(Organization organization :organizationService.findAllByRolesTypeName("Internal Organization"))
			organizations.appendChild(new Listitem(organization.getName(),organization.getId()));
			
		for(Currency currency:currencyService.findAll())
			currencys.appendChild(new Listitem(currency.getCode(), currency.getId()));
		
		if(!currencys.getChildren().isEmpty())
			currencys.setSelectedIndex(0);

		organizations.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				producers.getChildren().clear();
				for(EconomicAgent agent:agentService.findByRoleAndParty("Sales Person",organizations.getSelectedItem().getValue().toString()))
					producers.appendChild(new Listitem(agent.getName(),agent.getId()));
				
				consumers.getChildren().clear();
				for(EconomicAgent agent:agentService.findByRoleAndParty("Customer",organizations.getSelectedItem().getValue().toString()))
					consumers.appendChild(new Listitem(agent.getName(),agent.getId()));
			
				if(!producers.getChildren().isEmpty())
					producers.setSelectedIndex(0);
				
				if(!consumers.getChildren().isEmpty())
					consumers.setSelectedIndex(0);
			}
		});
		
		for(Geographic geographic:geographicService.findAll())
		{
			if(geographic.getType().equals(Geographic.Type.COUNTRY) || geographic.getType().equals(Geographic.Type.PROVINCE) || geographic.getType().equals(Geographic.Type.CITY))
				locations.appendChild(new Listitem(geographic.getName(), geographic.getId()));
		}
		
		if(!locations.getChildren().isEmpty())
			locations.setSelectedIndex(0);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"135px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Document Owner"));
		row1.appendChild(organizations);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Document Number"));
		row2.appendChild(number);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Date"));
		row3.appendChild(date);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Credit Term"));
		row4.appendChild(term);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Currency"));
		row5.appendChild(currencys);
		
		Row row6 = new Row();
		row6.appendChild(new Label("Sales Person"));
		row6.appendChild(producers);
		
		Row row7 = new Row();
		row7.appendChild(new Label("Customer"));
		row7.appendChild(consumers);
		
		Row row8 = new Row();
		row8.appendChild(new Label("Sales Location"));
		row8.appendChild(locations);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		rows.appendChild(row7);
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
										prices.appendChild(new Listitem(price.getPrice().toEngineeringString(), price.getId()));
									else if(price.getType().equals(ProductPrice.Type.DISCOUNT))
										discs.appendChild(new Listitem(price.getPrice().toEngineeringString(), price.getId()));
									else if(price.getType().equals(ProductPrice.Type.CHARGE))
										charges.appendChild(new Listitem(price.getPrice().toEngineeringString(), price.getId()));
								}
							}
						}
					}
				});
				
				Listbox uoms = new Listbox();
				uoms.setMold("select");
				uoms.setWidth("100%");
				
				for(UnitOfMeasure uom:unitOfMeasureService.findAll())
					uoms.appendChild(new Listitem(uom.getName(), uom.getId()));
				
				Doublebox quantity = new Doublebox(0d);
				quantity.setWidth("100%");
				
				Textbox note = new Textbox();
				note.setWidth("100%");
				
				Row row = new Row();
				row.appendChild(new Checkbox());
				row.appendChild(products);
				row.appendChild(prices);
				row.appendChild(discs);
				row.appendChild(charges);
				row.appendChild(quantity);
				row.appendChild(uoms);
				row.appendChild(note);
				
				grid.getRows().appendChild(row);
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
				grid.getRows().getChildren().clear();
			}
		});
		
		this.tabbox.getTabpanels().getChildren().get(0).appendChild(toolbar);
		this.tabbox.getTabpanels().getChildren().get(0).appendChild(grid);
	}
	
	private void initPayments()
	{
		this.tabbox.getTabs().appendChild(new Tab("Payment(s)"));
		this.tabbox.getTabpanels().appendChild(new Tabpanel());
		
		payments.appendChild(new Columns());
		payments.getColumns().appendChild(new Column(null,null,"25px"));
		payments.getColumns().appendChild(new Column("Type",null,"125px"));
		payments.getColumns().appendChild(new Column("Amount",null,"125px"));
		payments.getColumns().appendChild(new Column("Note",null));
		payments.appendChild(new Rows());
		payments.setSpan("3");
		
		Toolbar toolbar = new Toolbar();
		toolbar.setHeight("40px");
		toolbar.appendChild(new Toolbarbutton("New","/icons/new.png"));
		toolbar.appendChild(new Toolbarbutton("Remove","/icons/delete.png"));
		toolbar.appendChild(new Toolbarbutton("Clear","/icons/refresh.png"));
		toolbar.getChildren().get(0).addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Row row = new Row();
				row.appendChild(new Checkbox());
				
				Listbox types = new Listbox();
				types.setMold("select");
				types.setWidth("100%");
				
				for(PaymentType type:PaymentType.values())
					types.appendChild(new Listitem(type.toString(), type.toString()));
				
				types.setSelectedIndex(0);
				
				Doublebox amount = new Doublebox(0d);
				amount.setConstraint("no empty");
				amount.setWidth("100%");
				
				Textbox note = new Textbox();
				note.setWidth("100%");
				
				row.appendChild(types);
				row.appendChild(amount);
				row.appendChild(note);
				
				grid.getRows().appendChild(row);
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
				grid.getRows().getChildren().clear();
			}
		});
		
		this.tabbox.getTabpanels().getChildren().get(1).appendChild(toolbar);
		this.tabbox.getTabpanels().getChildren().get(1).appendChild(grid);
	}
}
