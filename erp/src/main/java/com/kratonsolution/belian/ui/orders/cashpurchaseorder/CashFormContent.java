
package com.kratonsolution.belian.ui.orders.cashpurchaseorder;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.persistence.IDValueRef;
import com.kratonsolution.belian.common.persistence.Observer;
import com.kratonsolution.belian.common.util.DateTimes;
import com.kratonsolution.belian.orders.dm.OrderAdjustment;
import com.kratonsolution.belian.orders.dm.PurchaseOrder;
import com.kratonsolution.belian.orders.dm.PurchaseOrderItem;
import com.kratonsolution.belian.orders.svc.PurchaseOrderService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.accounting.currency.CurrencyList;
import com.kratonsolution.belian.ui.general.party.PartyAddressList;
import com.kratonsolution.belian.ui.general.party.PartyBox;
import com.kratonsolution.belian.ui.general.party.PartyContactList;
import com.kratonsolution.belian.ui.orders.OrderAdjustmentTypeList;
import com.kratonsolution.belian.ui.products.product.ProductBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashFormContent extends AbstractForm
{	
	private PurchaseOrderService service = Springs.get(PurchaseOrderService.class);

	private Datebox orderDate = Components.currentDatebox();

	private Datebox entryDate = Components.currentDatebox();

	private CurrencyList currencys = new CurrencyList(false);

	private PartyBox partyPlacingOrder = new PartyBox(false,false,utils.getOrganization());

	private PartyBox partyTakingOrders = new PartyBox(true,false);

	private PartyBox payToParty = new PartyBox(true,false);

	private PartyAddressList payToAddress = new PartyAddressList(false, null);

	private PartyContactList payToContacts = new PartyContactList(false, null);

	private PartyBox shipToParty = new PartyBox(true,false);

	private PartyAddressList shipToAddress = new PartyAddressList(false, null);

	private PartyContactList shipToContacts = new PartyContactList(false, null);

	private Textbox note = Components.stdTextBox(null, false);

	private Decimalbox amount = Components.fullspanReadonlyDecimalbox(BigDecimal.ZERO);

	private Decimalbox adjust = Components.fullspanReadonlyDecimalbox(BigDecimal.ZERO);

	private Decimalbox total = Components.fullspanReadonlyDecimalbox(BigDecimal.ZERO);

	private Grid items = new Grid();

	private Grid adjustments = new Grid();

	private Tabbox tabbox = new Tabbox();

	public CashFormContent()
	{
		super();
		initToolbar();
		initForm();
		initTabbox();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(orderDate.getValue() == null)
					throw new WrongValueException(orderDate,lang.get("message.field.empty"));

				if(entryDate.getValue() == null)
					throw new WrongValueException(entryDate,lang.get("message.field.empty"));

				if(partyPlacingOrder.getDomain() == null)
					throw new WrongValueException(partyPlacingOrder,lang.get("message.field.empty"));

				if(payToParty.getDomain() == null)
					throw new WrongValueException(payToParty,lang.get("message.field.empty"));

				if(payToAddress.getDomain() == null)
					throw new WrongValueException(payToAddress,lang.get("message.field.empty"));

				if(payToContacts.getDomain() == null)
					throw new WrongValueException(payToContacts,lang.get("message.field.empty"));

				if(shipToParty.getDomain() == null)
					throw new WrongValueException(shipToParty,lang.get("message.field.empty"));

				if(shipToAddress.getDomain() == null)
					throw new WrongValueException(shipToAddress,lang.get("message.field.empty"));

				if(shipToContacts.getDomain() == null)
					throw new WrongValueException(shipToContacts,lang.get("message.field.empty"));

				PurchaseOrder order = new PurchaseOrder();

				order.setCurrency(currencys.getDomainAsRef());
				order.setEntryDate(DateTimes.sql(entryDate.getValue()));
				order.setOrderDate(DateTimes.sql(orderDate.getValue()));

				order.setBillToParty(payToParty.getDomainAsRef());
				order.setBillToAddress(payToAddress.getDomainAsRef());
				order.setBillToContact(payToContacts.getDomainAsRef());

				order.setShipToAddress(shipToAddress.getDomainAsRef());
				order.setShipToContact(shipToContacts.getDomainAsRef());
				order.setShipToParty(shipToParty.getDomainAsRef());

				order.setPartyPlacingOrder(partyPlacingOrder.getDomainAsRef());
				order.setPartyTakingOrder(partyTakingOrders.getDomainAsRef());

				BigDecimal purchased = BigDecimal.ZERO;
				
				for(Component com:items.getRows().getChildren())
				{
					Row iRow = (Row)com;
					
					ProductBox product = (ProductBox)iRow.getChildren().get(1);
					
					PurchaseOrderItem item = new PurchaseOrderItem();
					item.setOrder(order);
					item.setProduct(product.getDomainAsRef());
					item.setQuantity(RowUtils.decimal(iRow, 2));
					item.setUntitPrice(RowUtils.decimal(iRow, 3));
					item.setUom(product.getDomain().getUom());
					
					purchased = purchased.add(item.getQuantity().multiply(item.getUntitPrice()));
					
					order.getItems().add(item);
				}
				
				for(Component com:adjustments.getRows().getChildren())
				{
					Row iRow = (Row)com;

					OrderAdjustmentTypeList adjustmentTypeList = (OrderAdjustmentTypeList)iRow.getChildren().get(1);

					OrderAdjustment adjustment = new OrderAdjustment();
					adjustment.setAmount(RowUtils.decimal(iRow, 2));
					adjustment.setOrder(order);
					adjustment.setPercent(RowUtils.decimal(iRow, 3));
					adjustment.setType(adjustmentTypeList.getOrderAdjustmentType());
					
					if(adjustment.getAmount() == null || adjustment.getAmount().compareTo(BigDecimal.ZERO) == 0)
						adjustment.setAmount(purchased.multiply(adjustment.getPercent()).divide(BigDecimal.valueOf(100),RoundingMode.HALF_UP));
										
					order.getAdjustments().add(adjustment);
				}

				service.cash(order);
				
				items.getRows().getChildren().clear();
				adjustments.getRows().getChildren().clear();
				
				calculate();
				
				Clients.showNotification(lang.get("message.savedata"));
			
			}
		});
	}

	@Override
	public void initForm()
	{
		partyPlacingOrder.setDomain(utils.getOrganization());

		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"150px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column(null,null,"165px"));
		grid.setSpan("1");

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("order.grid.column.placingorder")));
		row1.appendChild(partyPlacingOrder);
		row1.appendChild(new Label(lang.get("order.grid.column.amount")));
		row1.appendChild(amount);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("order.grid.column.orderdate")));
		row2.appendChild(orderDate);
		row2.appendChild(new Label(lang.get("order.grid.column.adjustments")));
		row2.appendChild(adjust);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("order.grid.column.entrydate")));
		row3.appendChild(entryDate);
		row3.appendChild(new Label(lang.get("order.grid.column.total")));
		row3.appendChild(total);

		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("order.grid.column.takingorder")));
		row4.appendChild(partyTakingOrders);

		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("order.grid.column.currency")));
		row5.appendChild(currencys);

		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
		grid.getRows().appendChild(row4);
		grid.getRows().appendChild(row5);
	}

	private void initTabbox()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabpanels());
		tabbox.appendChild(new Tabs());
		tabbox.getTabs().appendChild(new Tab(lang.get("order.grid.column.paymentinfo")));
		tabbox.getTabs().appendChild(new Tab(lang.get("order.grid.column.shippings")));
		tabbox.getTabs().appendChild(new Tab(lang.get("order.grid.column.items")));
		tabbox.getTabs().appendChild(new Tab(lang.get("order.grid.column.adjustments")));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());

		appendChild(tabbox);

		initSupplier();
		initShippings();
		initItems();
		initAdjustments();
	}

	private void initSupplier()
	{
		payToParty.addObserver(payToAddress);
		payToParty.addObserver(payToContacts);

		Grid layout = new Grid();
		layout.setWidth("100%");
		layout.appendChild(new Columns());
		layout.getColumns().appendChild(new Column(null,null,"125px"));
		layout.getColumns().appendChild(new Column());
		layout.appendChild(new Rows());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("order.grid.column.payto")));
		row1.appendChild(payToParty);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("order.grid.column.paytoaddress")));
		row2.appendChild(payToAddress);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("order.grid.column.paytocontact")));
		row3.appendChild(payToContacts);

		layout.getRows().appendChild(row1);
		layout.getRows().appendChild(row2);
		layout.getRows().appendChild(row3);

		tabbox.getTabpanels().getFirstChild().appendChild(layout);
	}

	private void initShippings()
	{
		shipToParty.addObserver(shipToAddress);
		shipToParty.addObserver(shipToContacts);

		Grid layout = new Grid();
		layout.setWidth("100%");
		layout.appendChild(new Columns());
		layout.getColumns().appendChild(new Column(null,null,"125px"));
		layout.getColumns().appendChild(new Column());
		layout.appendChild(new Rows());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("order.grid.column.shipto")));
		row1.appendChild(shipToParty);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("order.grid.column.shippingaddress")));
		row2.appendChild(shipToAddress);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("order.grid.column.shippingcontact")));
		row3.appendChild(shipToContacts);

		layout.getRows().appendChild(row1);
		layout.getRows().appendChild(row2);
		layout.getRows().appendChild(row3);

		tabbox.getTabpanels().getChildren().get(1).appendChild(layout);
	}

	private void initAdjustments()
	{
		NRCToolbar nrc = new NRCToolbar(adjustments);
		nrc.addObserver(new Handler());

		adjustments.setWidth("100%");
		adjustments.setEmptyMessage(lang.get("message.grid.empty"));
		adjustments.appendChild(new Rows());
		adjustments.appendChild(new Columns());
		adjustments.getColumns().appendChild(new Column(null,null,"25px"));
		adjustments.getColumns().appendChild(new Column(lang.get("order.adjustments.grid.column.type"),null,"150px"));
		adjustments.getColumns().appendChild(new Column(lang.get("order.adjustments.grid.column.amount"),null,"150px"));
		adjustments.getColumns().appendChild(new Column(lang.get("order.adjustments.grid.column.percent"),null,"150px"));
		adjustments.setSpan("1");

		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Handler handler = new Handler();
				
				Decimalbox amt = Components.fullspanDecimalbox(BigDecimal.ZERO);
				Decimalbox percent = Components.fullspanDecimalbox(BigDecimal.ZERO);
				
				amt.addEventListener(Events.ON_CHANGING, handler);
				amt.addEventListener(Events.ON_BLUR, handler);

				percent.addEventListener(Events.ON_CHANGING, handler);
				percent.addEventListener(Events.ON_BLUR, handler);
				
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(new OrderAdjustmentTypeList(true));
				row.appendChild(amt);
				row.appendChild(percent);

				adjustments.getRows().appendChild(row);
			}
		});

		tabbox.getTabpanels().getChildren().get(3).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(3).appendChild(adjustments);
	}

	private void initItems()
	{
		NRCToolbar nrc = new NRCToolbar(items);
		nrc.getClear().setDisabled(true);
		nrc.addObserver(new Handler());

		items.setWidth("100%");
		items.setEmptyMessage(lang.get("message.grid.empty"));
		items.appendChild(new Rows());
		items.appendChild(new Columns());
		items.getColumns().appendChild(new Column(null,null,"25px"));
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.product"),null,"200px"));
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.quantity"),null,"80px"));
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.unitprice"),null,"135px"));
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.amount"),null,"135px"));
		items.getColumns().appendChild(new Column());
		items.getColumns().getLastChild().setVisible(false);
		items.setSpan("1");

		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Handler handler = new Handler();

				Decimalbox quan = Components.fullspanDecimalbox(BigDecimal.ONE);
				Decimalbox price = Components.fullspanDecimalbox(BigDecimal.ZERO);
				Decimalbox amt = Components.fullspanReadonlyDecimalbox(BigDecimal.ZERO);

				quan.addEventListener(Events.ON_CHANGING, handler);
				quan.addEventListener(Events.ON_BLUR, handler);

				price.addEventListener(Events.ON_CHANGING, handler);
				price.addEventListener(Events.ON_BLUR, handler);

				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(new ProductBox(false,true));
				row.appendChild(quan);
				row.appendChild(price);
				row.appendChild(amt);

				items.getRows().appendChild(row);
			}
		});

		tabbox.getTabpanels().getChildren().get(2).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(2).appendChild(items);
	}

	private void calculate()
	{
		BigDecimal sum = BigDecimal.ZERO;
		
		for(Component com:items.getRows().getChildren())
		{
			Row row = (Row)com;

			Decimalbox quan = (Decimalbox)row.getChildren().get(2);
			Decimalbox price = (Decimalbox)row.getChildren().get(3);
			Decimalbox amt = (Decimalbox)row.getChildren().get(4);

			if(quan.getValue() != null && price.getValue() != null)
			{
				amt.setValue(quan.getValue().multiply(price.getValue()));
				sum = sum.add(amt.getValue());
			}
		}
		
		amount.setValue(sum);
		
		BigDecimal sumadj = BigDecimal.ZERO;
		
		for(Component com:adjustments.getRows().getChildren())
		{
			Row row = (Row)com;

			Decimalbox amt = (Decimalbox)row.getChildren().get(2);
			Decimalbox prct = (Decimalbox)row.getChildren().get(3);

			if(amt.getValue() != null && !amt.getValue().equals(BigDecimal.ZERO))
				sumadj = sumadj.add(amt.getValue());
			else if(prct.getValue() != null && !prct.getValue().equals(BigDecimal.ZERO))
				sumadj = sumadj.add(sum.multiply(prct.getValue()).divide(BigDecimal.valueOf(100),RoundingMode.HALF_UP));
		}
		
		adjust.setValue(sumadj);
		
		total.setValue(amount.getValue().add(adjust.getValue()));
	}

	private class Handler implements EventListener<Event>,Observer
	{
		@Override
		public void onEvent(Event arg0) throws Exception
		{
			calculate();
		}

		@Override
		public void valueChange(IDValueRef value)
		{
			calculate();
		}
	}
}
