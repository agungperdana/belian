/**
 * 
 */
package com.kratonsolution.belian.ui.orders.pos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.A;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Button;
import org.zkoss.zul.Center;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.North;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.South;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Vbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.orders.dm.OrderAdjustment;
import com.kratonsolution.belian.orders.dm.OrderAdjustmentType;
import com.kratonsolution.belian.orders.dm.OrderItemType;
import com.kratonsolution.belian.orders.dm.SalesOrder;
import com.kratonsolution.belian.orders.dm.SalesOrderItem;
import com.kratonsolution.belian.partys.dm.Party;
import com.kratonsolution.belian.payments.dm.PaymentMethodInfo;
import com.kratonsolution.belian.payments.dm.PaymentMethodType;
import com.kratonsolution.belian.products.dm.PriceComponent;
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.ProductCategory;
import com.kratonsolution.belian.products.dm.SaleType;
import com.kratonsolution.belian.ui.PrintWindow;
import com.kratonsolution.belian.ui.component.GridLayout;
import com.kratonsolution.belian.ui.component.ToggleButton;
import com.kratonsolution.belian.ui.orders.POSOrder;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.RowUtils;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class POSContent extends POSOrder
{
	private Hbox adjustment = new Hbox();

	private Button standard = new Button(lang.get("order.pos.grid.column.new"),"/icons/standarorder48.png");

	private Tabbox tabbox = new Tabbox();

	private GridLayout categoryLayout = new GridLayout(5);

	private Grid info = new Grid();

	private Grid items = new Grid();

	private Grid result = new Grid();

	private Hbox category = new Hbox();

	private SaleType saleType = SaleType.STANDARD_RETAIL_SALES;

	private Label organizationDisplay = new Label();

	private Label currencyDisplay = new Label();

	private Label saleTypeDisplay = new Label();

	private Label locationDisplay = new Label();

	private Label customerDisplay = new Label("Anonymous");

	private Label doctorDisplay = new Label();

	private Label grandtotal = new Label("0");

	private IDValueRef customer = utils.getAnonymouseCustomer();
	
	private IDValueRef shipto = utils.getAnonymouseCustomer();

	private IDValueRef location;
	
	public POSContent()
	{
		setHflex("1");
		setVflex("1");

		appendChild(left);
		appendChild(right);

		initLeft();
		initRight();

		initDisplay();
	}

	private void initDisplay()
	{
		saleTypeDisplay.setValue(saleType.display(utils.getLanguage()));

		if(utils.getOrganization() != null)
			organizationDisplay.setValue(utils.getOrganization().getName());

		if(utils.getLocation() != null)
		{
			locationDisplay.setValue(utils.getLocation().getName());
			location = utils.getLocation().toRef();
		}

		if(utils.getCurrency() != null)
			currencyDisplay.setValue(utils.getCurrency().getName());
	}

	private void initLeft()
	{
		standard.setOrient("vertical");
		standard.setWidth("110px");
		standard.addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				items.getRows().getChildren().clear();
				calculateResult();
				saleType = SaleType.STANDARD_RETAIL_SALES;
				initDisplay();
			}
		});

		grandtotal.setStyle("color:red;font-size:60px;font-weight:bolder;");

		Hbox display = new Hbox();
		display.setHflex("1");
		display.setVflex("1");
		display.setPack("end");
		display.appendChild(grandtotal);

		Hbox topcontent = new Hbox();
		topcontent.setHflex("1");
		topcontent.setHeight("55px");
		topcontent.appendChild(standard);
		topcontent.appendChild(display);

		info.setHflex("1");
		info.setVflex("1");
		info.appendChild(new Columns());
		info.appendChild(new Rows());
		info.getColumns().appendChild(new Column(null,null,"135px"));
		info.getColumns().appendChild(new Column(null,null,"165px"));
		info.getColumns().appendChild(new Column(null,null,"135px"));
		info.getColumns().appendChild(new Column(null,null,"165px"));
		info.setSpan("1");

		Vbox topbox = new Vbox();
		topbox.appendChild(topcontent);
		topbox.appendChild(info);

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("order.pos.grid.column.organization")));
		row1.appendChild(organizationDisplay);
		row1.appendChild(new Label(lang.get("order.pos.grid.column.location")));
		row1.appendChild(locationDisplay);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("order.pos.grid.column.currency")));
		row2.appendChild(currencyDisplay);
		row2.appendChild(new Label(lang.get("order.pos.grid.column.customer")));
		row2.appendChild(customerDisplay);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("order.pos.grid.column.saletype")));
		row3.appendChild(saleTypeDisplay);
		row3.appendChild(new Label(lang.get("order.pos.grid.column.doctor")));
		row3.appendChild(doctorDisplay);

		info.getRows().appendChild(row1);
		info.getRows().appendChild(row2);
		info.getRows().appendChild(row3);

		items.setWidth("100%");
		items.setVflex("1");
		items.appendChild(new Columns());
		items.appendChild(new Rows());
		items.getColumns().appendChild(new Column(lang.get("order.pos.grid.column.product"),null,"200px"));
		items.getColumns().appendChild(new Column(null,null,"35px"));
		items.getColumns().appendChild(new Column(lang.get("order.pos.grid.column.quantity"),null,"70px"));
		items.getColumns().appendChild(new Column(null,null,"35px"));
		items.getColumns().appendChild(new Column(lang.get("order.pos.grid.column.price"),null,"100px"));
		items.getColumns().appendChild(new Column(lang.get("order.pos.grid.column.total"),null,"100px"));
		items.getColumns().appendChild(new Column(null,null,"35px"));
		items.getColumns().appendChild(new Column());
		items.getColumns().getLastChild().setVisible(false);
		items.setSpan("0");
		items.setEmptyMessage("no items");

		result.setWidth("100%");
		result.setHeight("85%");
		result.appendChild(new Columns());
		result.appendChild(new Rows());
		result.getColumns().appendChild(new Column());
		result.getColumns().appendChild(new Column(null,null,"135px"));
		result.getColumns().appendChild(new Column());
		result.getColumns().appendChild(new Column(null,null,"135px"));
		result.setSpan("1");

		Row rw1 = new Row();
		rw1.appendChild(new Label(lang.get("order.pos.grid.column.sub")));
		rw1.appendChild(Components.fullspanReadonlyDecimalbox(BigDecimal.ZERO));
		rw1.appendChild(new Label(lang.get("order.pos.grid.column.fee")));
		rw1.appendChild(Components.fullspanReadonlyDecimalbox(BigDecimal.ZERO));

		Row rw2 = new Row();
		rw2.appendChild(new Label(lang.get("order.pos.grid.column.discount")));
		rw2.appendChild(Components.fullspanReadonlyDecimalbox(BigDecimal.ZERO));
		rw2.appendChild(new Label(lang.get("order.pos.grid.column.tax")));
		rw2.appendChild(Components.fullspanReadonlyDecimalbox(BigDecimal.ZERO));		

		Row rw3 = new Row();
		rw3.appendChild(new Label());
		rw3.appendChild(new Label());
		rw3.appendChild(new Label(lang.get("order.pos.grid.column.total")));
		rw3.appendChild(Components.fullspanReadonlyDecimalbox(BigDecimal.ZERO));

		result.getRows().appendChild(rw1);
		result.getRows().appendChild(rw2);
		result.getRows().appendChild(rw3);
		result.getRows().getChildren().get(2).setVisible(false);

		adjustment.setVflex("1");
		adjustment.setHflex("1");

		for(OrderAdjustmentType type:OrderAdjustmentType.values())
		{
			if(!type.equals(OrderAdjustmentType.FEE))
			{
				Button button = new Button(type.display(utils.getLanguage()));
				button.setMold("trendy");
				button.setIconSclass("z-icon-plus-circle");
				button.addEventListener(Events.ON_CLICK, new EventListener<Event>()
				{
					@Override
					public void onEvent(Event arg0) throws Exception
					{
						POSAdjustment poa = new POSAdjustment();
						poa.getOk().addEventListener(Events.ON_CLICK, new EventListener<Event>()
						{
							@Override
							public void onEvent(Event arg0) throws Exception
							{
								poa.getWinTitle().setValue(type.display(utils.getLanguage()));
								
								if((poa.getPercent().getValue() == null && poa.getNominal().getValue() == null) || 
									(poa.getNominal().getValue().compareTo(BigDecimal.ZERO) <= 0 && poa.getPercent().getValue().compareTo(BigDecimal.ZERO) <= 0))
									throw new WrongValueException(poa.getNominal(),lang.get("message.field.empty"));
								
								Decimalbox quan = Components.fullspanReadonlyDecimalbox(BigDecimal.ONE);
								Decimalbox up = Components.fullspanReadonlyDecimalbox(BigDecimal.ZERO);
								Decimalbox tot = Components.fullspanReadonlyDecimalbox(BigDecimal.ZERO);

								if(poa.getNominal().getValue() != null && poa.getNominal().getValue().compareTo(BigDecimal.ZERO) > 0)
								{
									up.setValue(poa.getNominal().getValue());
									tot.setValue(quan.getValue().multiply(up.getValue()));
								}
								else
								{
									up.setValue(poa.getPercent().getValue());
									tot.setValue(quan.getValue().multiply(getSubtotal().multiply(up.getValue()).divide(BigDecimal.valueOf(100),RoundingMode.HALF_UP)));
								}
								
								A min = new A();
								min.setIconSclass("z-icon-minus-circle z-icon-2x");
								min.addEventListener(Events.ON_CLICK, new EventListener<Event>()
								{
									@Override
									public void onEvent(Event arg0) throws Exception
									{
										if(quan.getValue().compareTo(BigDecimal.ZERO) > 0)
											quan.setValue(quan.getValue().subtract(BigDecimal.ONE));

										tot.setValue(up.getValue().multiply(quan.getValue()));
										calculateResult();
									}
								});

								A plus = new A();
								plus.setIconSclass("z-icon-plus-circle z-icon-2x");
								plus.addEventListener(Events.ON_CLICK, new EventListener<Event>()
								{
									@Override
									public void onEvent(Event arg0) throws Exception
									{
										quan.setValue(quan.getValue().add(BigDecimal.ONE));
										tot.setValue(up.getValue().multiply(quan.getValue()));
										calculateResult();
									}
								});

								Row row = new Row();

								A close = new A();
								close.setIconSclass("z-icon-remove z-icon-2x");
								close.addEventListener(Events.ON_CLICK, new EventListener<Event>()
								{
									@Override
									public void onEvent(Event arg0) throws Exception
									{
										getItems().getRows().removeChild(row);
										calculateResult();
									}
								});

								row.appendChild(new Label(type.display(utils.getLanguage())));
								row.appendChild(min);
								row.appendChild(quan);
								row.appendChild(plus);
								row.appendChild(up);
								row.appendChild(tot);
								row.appendChild(close);
								row.appendChild(new Label(type.toString()));

								getItems().getRows().appendChild(row);

								calculateResult();
								
								poa.detach();
							}
						});
						
						poa.setPage(getPage());
						poa.doModal();
					}
				});

				adjustment.appendChild(button);
			}
		}

		Vbox southcontent = new Vbox();
		southcontent.setHflex("1");
		southcontent.setVflex("1");
		southcontent.appendChild(result);
		southcontent.appendChild(adjustment);

		North north = new North();
		north.appendChild(topbox);
		north.setBorder("none");
		north.setSize("27%");
		north.setMargins("2,2,2,2");

		Center center = new Center();
		center.appendChild(items);
		center.setBorder("none");
		center.setMargins("2,2,2,2");

		South south = new South();
		south.setSize("15%");
		south.appendChild(southcontent);
		south.setBorder("none");
		south.setMargins("2,2,2,2");

		Borderlayout layout = new Borderlayout();
		layout.setHflex("1");
		layout.setVflex("1");
		layout.appendChild(north);
		layout.appendChild(center);
		layout.appendChild(south);

		left.setSize("55%");
		left.setMargins("2,2,2,2");
		left.setBorder("none");
		left.appendChild(layout);
	}

	private void initRight()
	{
		final TabListener listener = new TabListener();

		tabbox.setHflex("1");
		tabbox.setVflex("1");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());

		categoryLayout.setHflex("1");
		categoryLayout.setVflex("1");

		for(ProductCategory out:categoryService.findAll())
		{
			ToggleButton button = new ToggleButton(out.toRef(),"/icons/drugcategory.png");
			button.setHflex("1");
			button.setHeight("60px");
			button.setOrient("vertical");
			button.addEventListener(Events.ON_CLICK, listener);

			categoryLayout.add(button);
		}

		tabbox.getTabs().appendChild(new Tab("A"));
		tabbox.getTabs().appendChild(new Tab("B"));
		tabbox.getTabs().appendChild(new Tab("C"));
		tabbox.getTabs().appendChild(new Tab("D"));
		tabbox.getTabs().appendChild(new Tab("E"));
		tabbox.getTabs().appendChild(new Tab("F"));
		tabbox.getTabs().appendChild(new Tab("G"));
		tabbox.getTabs().appendChild(new Tab("H"));
		tabbox.getTabs().appendChild(new Tab("I"));
		tabbox.getTabs().appendChild(new Tab("J"));
		tabbox.getTabs().appendChild(new Tab("K"));
		tabbox.getTabs().appendChild(new Tab("L"));
		tabbox.getTabs().appendChild(new Tab("M"));
		tabbox.getTabs().appendChild(new Tab("N"));
		tabbox.getTabs().appendChild(new Tab("O"));
		tabbox.getTabs().appendChild(new Tab("P"));
		tabbox.getTabs().appendChild(new Tab("Q"));
		tabbox.getTabs().appendChild(new Tab("R"));
		tabbox.getTabs().appendChild(new Tab("S"));
		tabbox.getTabs().appendChild(new Tab("T"));
		tabbox.getTabs().appendChild(new Tab("U"));
		tabbox.getTabs().appendChild(new Tab("V"));
		tabbox.getTabs().appendChild(new Tab("W"));
		tabbox.getTabs().appendChild(new Tab("X"));
		tabbox.getTabs().appendChild(new Tab("Y"));
		tabbox.getTabs().appendChild(new Tab("Z"));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());

		for(Component com:tabbox.getTabs().getChildren())
			com.addEventListener(Events.ON_SELECT, listener);

		showProducts();

		pay.setWidth("100px");
		pay.setOrient("vertical");
		pay.addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row rw2 = (Row)result.getRows().getChildren().get(2);
				Decimalbox tot = (Decimalbox)rw2.getChildren().get(3);

				POSPayment payment = new POSPayment(tot.getValue(),false);
				payment.getOk().addEventListener(Events.ON_CLICK,new EventListener<Event>()
				{
					@Override
					public void onEvent(Event arg0) throws Exception
					{
						if((payment.getMethod().getSelectedIndex() == 1 || payment.getMethod().getSelectedIndex() == 2) && Strings.isNullOrEmpty(payment.getCardNumber().getText()))
							throw new WrongValueException(payment.getCardNumber(),lang.get("message.field.empty"));
						
						if(payment.getPaid().getValue() == null || payment.getPaid().getValue().compareTo(BigDecimal.ZERO) <= 0)
							throw new WrongValueException(payment.getPaid(),lang.get("message.field.empty"));
						
						if(payment.getChange().getValue() == null || payment.getChange().getValue().compareTo(BigDecimal.ZERO) < 0)
							throw new WrongValueException(payment.getChange(),lang.get("message.field.empty"));

						PaymentMethodInfo info = PaymentMethodInfo.createInfo(null, null);
						
						if(payment.isDebit())
						{
							info.setPaymentMethod(PaymentMethodType.TRANSFER);
							info.setReference(payment.getReference());
						}
						else if(payment.isCreditCard())
						{
							info.setPaymentMethod(PaymentMethodType.CREDITCARD);
							info.setReference(payment.getReference());
						}
							
						String receiptId = createOrder(info);
						
						payment.detach();
						
						PrintWindow print = new PrintWindow("/receiptprint?id="+receiptId);
						print.setPage(getPage());
						print.doModal();
						print.getPrint().setFocus(true);
					}
				});
				
				payment.setPage(getPage());
				payment.doModal();
				payment.getPaid().setFocus(true);
			}
		});

		Hbox hbox = new Hbox();
		hbox.setHflex("1");
		hbox.setPack("end");
		hbox.setHeight("20%");
		hbox.appendChild(pay);

		North n = new North();
		n.setSize("22%");
		n.appendChild(categoryLayout);
		n.setBorder("none");
		n.setMargins("2,2,2,2");

		Center c = new Center();
		c.appendChild(tabbox);
		c.setBorder("none");
		c.setMargins("2,2,2,2");

		South s = new South();
		s.setSize("12%");
		s.appendChild(hbox);
		s.setBorder("none");
		s.setMargins("2,2,2,2");

		Borderlayout vlayout = new Borderlayout();
		vlayout.setHflex("1");
		vlayout.setVflex("1");
		vlayout.appendChild(n);
		vlayout.appendChild(c);
		vlayout.appendChild(s);

		right.setMargins("5,5,5,5");
		right.setBorder("none");
		right.appendChild(vlayout);
	}

	private class TabListener implements EventListener<Event>
	{
		@Override
		public void onEvent(Event event) throws Exception
		{
			showProducts();
		}
	}

	private void showProducts()
	{
		Tab tab = tabbox.getSelectedTab();
		Tabpanel tabpanel = tabbox.getSelectedPanel();
		tabpanel.getChildren().clear();

		Listbox listbox = new Listbox();
		listbox.setHflex("1");
		listbox.setVflex("1");

		Vector<Product> products = new Vector<>();

		if(categoryLayout.getSelectedModelIds().isEmpty())
			products.addAll(productService.findAll());
		else
			products.addAll(productService.byCategory(categoryLayout.getSelectedModelIds()));

		for(Product product:products)
		{
			if(product.getName().startsWith(tab.getLabel()))
			{
				Listitem listitem = new Listitem(product.getName(),product.getId());
				listitem.setImage("/icons/drug.png");
				listitem.addEventListener(Events.ON_CLICK, new EventListener<Event>()
				{
					@Override
					public void onEvent(Event arg0) throws Exception
					{
						Decimalbox quan = Components.fullspanReadonlyDecimalbox(BigDecimal.ONE);
						Decimalbox up = Components.fullspanReadonlyDecimalbox(BigDecimal.ZERO);
						Decimalbox tot = Components.fullspanReadonlyDecimalbox(BigDecimal.ZERO);

						A min = new A();
						min.setIconSclass("z-icon-minus-circle z-icon-2x");
						min.addEventListener(Events.ON_CLICK, new EventListener<Event>()
						{
							@Override
							public void onEvent(Event arg0) throws Exception
							{
								if(quan.getValue().compareTo(BigDecimal.ZERO) > 0)
									quan.setValue(quan.getValue().subtract(BigDecimal.ONE));

								tot.setValue(up.getValue().multiply(quan.getValue()));
								calculateResult();
							}
						});

						A plus = new A();
						plus.setIconSclass("z-icon-plus-circle z-icon-2x");
						plus.addEventListener(Events.ON_CLICK, new EventListener<Event>()
						{
							@Override
							public void onEvent(Event arg0) throws Exception
							{
								quan.setValue(quan.getValue().add(BigDecimal.ONE));
								tot.setValue(up.getValue().multiply(quan.getValue()));
								calculateResult();
							}
						});

						Row row = new Row();

						A close = new A();
						close.setIconSclass("z-icon-remove z-icon-2x");
						close.addEventListener(Events.ON_CLICK, new EventListener<Event>()
						{
							@Override
							public void onEvent(Event arg0) throws Exception
							{
								items.getRows().removeChild(row);
								calculateResult();
							}
						});

						row.appendChild(new Label(product.getName()));
						row.appendChild(min);
						row.appendChild(quan);
						row.appendChild(plus);
						row.appendChild(up);
						row.appendChild(tot);
						row.appendChild(close);
						row.appendChild(new Label(product.getId()));

						items.getRows().appendChild(row);

						Product fresh = productService.findOne(product.getId());
						if(fresh != null && utils.getOrganization() != null)
						{
							for(PriceComponent price:fresh.getPrices())
							{
								if(DateTimes.inRange(DateTimes.currentDate(),price.getStart(), price.getEnd()) && 
										price.getSaleType().equals(saleType) && 
										price.getCustomer().getId().equals(customer.getId()) &&
										price.getOrganization().getId().equals(utils.getOrganization().getId()))
								{
									up.setValue(price.getPrice());
									tot.setValue(quan.getValue().multiply(price.getPrice()));
									calculateResult();
								}
							}
						}

					}
				});

				listbox.appendChild(listitem);
			}
		}

		tabpanel.appendChild(listbox);
	}

	public void calculateResult()
	{
		BigDecimal subtotal = BigDecimal.ZERO;
		BigDecimal discount = BigDecimal.ZERO;
		BigDecimal fee = BigDecimal.ZERO;
		BigDecimal tax = BigDecimal.ZERO;

		//calculate subtotal
		for(Component com:items.getRows().getChildren())
		{
			Row row = (Row)com;

			Product product = productService.findOne(RowUtils.id(row));
			if(product != null)
				subtotal = subtotal.add(RowUtils.decimal(row, 5));
		}

		//calculate adjustment
		for(Component com:items.getRows().getChildren())
		{
			Row row = (Row)com;

			Product product = productService.findOne(RowUtils.id(row));
			if(product == null)
			{
				try
				{
					OrderAdjustmentType adjustmentType = OrderAdjustmentType.valueOf(RowUtils.id(row));
					if(adjustmentType != null)
					{
						switch (adjustmentType)
						{
							case DISCOUNT:
								discount = discount.add(RowUtils.decimal(row, 5));
								break;
							case TAX:
								tax = tax.add(RowUtils.decimal(row, 5));
								break;
							default:
								fee = fee.add(RowUtils.decimal(row, 5));
								break;
						}
					}
				} 
				catch (Exception e){}
			}
		}

		Row rw0 = (Row)result.getRows().getChildren().get(0);
		Row rw1 = (Row)result.getRows().getChildren().get(1);
		Row rw2 = (Row)result.getRows().getChildren().get(2);

		Decimalbox sub = (Decimalbox)rw0.getChildren().get(1);
		Decimalbox tfee = (Decimalbox)rw0.getChildren().get(3);
		Decimalbox tdis = (Decimalbox)rw1.getChildren().get(1);
		Decimalbox ttax = (Decimalbox)rw1.getChildren().get(3);
		Decimalbox tot = (Decimalbox)rw2.getChildren().get(3);

		sub.setValue(subtotal);
		tfee.setValue(fee);
		tdis.setValue(discount);
		ttax.setValue(tax);
		tot.setValue(subtotal.add(fee).add(tax).subtract(discount));

		grandtotal.setValue(Numbers.format(tot.getValue()));
	}

	public Grid getItems()
	{
		return this.items;
	}

	public BigDecimal getSubtotal()
	{
		Row rw0 = (Row)result.getRows().getChildren().get(0);
		return RowUtils.decimal(rw0, 1);
	}
	
	private String createOrder(PaymentMethodInfo info)
	{
		SalesOrder order = SalesOrder.pos();
		order.setCurrency(utils.getCurrency().toRef());
		order.setEntryDate(DateTimes.currentDate());
		order.setOrderDate(order.getEntryDate());
		order.addSalesPerson(utils.getPerson().toRef());
		order.setPartyTakingOrder(utils.getOrganization().toRef());
		order.setPartyPlacingOrder(customer);
		order.addCashTerm();
		
		/**
		 * Payer Information
		 */
		Party payer = partyService.findOne(customer.getId());
		if(payer != null)
		{
			order.setBillToParty(payer.toRef());
			order.setBillToAddress(payer.getFirstAddress());
			order.setBillToContact(payer.getFirstContact());
		}

		/**
		 * Receiver Information
		 */
		Party receiver = partyService.findOne(shipto.getId());
		if(receiver != null)
		{
			order.setShipToParty(receiver.toRef());
			order.setShipToAddress(receiver.getFirstAddress());
			order.setShipToContact(receiver.getFirstContact());
		}
		
		for(Component com:items.getRows().getChildren())
		{
			Row rw = (Row)com;

			Product product = productService.findOne(RowUtils.id(rw));
			if(product != null)
			{
				SalesOrderItem orderItem = new SalesOrderItem();
				orderItem.setOrder(order);
				orderItem.setQuantity(RowUtils.decimal(rw, 2));
				orderItem.setType(OrderItemType.PRODUCT);
				orderItem.setUntitPrice(RowUtils.decimal(rw, 4));
				orderItem.setProduct(product.toRef());
				orderItem.setUom(product.getUom());

				order.getItems().add(orderItem);
			}
			else
			{
				OrderAdjustmentType type = OrderAdjustmentType.valueOf(RowUtils.id(rw));
				if(type != null)
				{
					OrderAdjustment adjustment = new OrderAdjustment();
					adjustment.setAmount(RowUtils.decimal(rw, 5));
					adjustment.setOrder(order);
					adjustment.setType(type);

					order.getAdjustments().add(adjustment);
				}
			}
		}
		
		return salesOrderService.pos(order,info);
	}
}
