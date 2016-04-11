/**
 * 
 */
package com.kratonsolution.belian.ui.procurement.cashpurchaseorder;

import java.math.BigDecimal;
import java.sql.Date;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.global.dm.RequestStatus;
import com.kratonsolution.belian.inventory.dm.ProductSupplier;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.procurement.dm.CashPurchaseOrder;
import com.kratonsolution.belian.procurement.dm.CashPurchaseOrderItem;
import com.kratonsolution.belian.procurement.dm.PurchaseOrderRequest;
import com.kratonsolution.belian.procurement.dm.PurchaseOrderRequestItem;
import com.kratonsolution.belian.procurement.svc.CashPurchaseOrderService;
import com.kratonsolution.belian.procurement.svc.PurchaseOrderRequestService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.PartyBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashPurchaseOrderFormContent extends FormContent
{	
	private CashPurchaseOrderService service = Springs.get(CashPurchaseOrderService.class);
	
	private PurchaseOrderRequestService requestService = Springs.get(PurchaseOrderRequestService.class);
	
	private ProductService productService = Springs.get(ProductService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Textbox number = Components.readOnlyTextBox();
	
	private Listbox companys = Components.newSelect(utils.getOrganization());
	
	private Datebox date = Components.currentDatebox();
	
	private Listbox purchaser = Components.newSelect(utils.getUser().getPerson());
	
	private Listbox requests = Components.newSelect(requestService.findAllIncomplete(),true);
	
	private PartyBox suppliers = new PartyBox();
	
	private Grid items = new Grid();
	
	public CashPurchaseOrderFormContent()
	{
		super();
		initToolbar();
		initForm();
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
				CashPurchaseOrderWindow window = (CashPurchaseOrderWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				CashPurchaseOrder order = new CashPurchaseOrder();
				order.setDate(new Date(date.getValue().getTime()));
				order.setNumber(number.getText());
				order.setOrganization(utils.getOrganization());
				order.setPurchaser(utils.getUser().getPerson());
				order.setRequest(requestService.findOne(Components.string(requests)));
				order.setSupplier(suppliers.getParty());
				
				for(Component com:items.getRows().getChildren())
				{
					Row row = (Row)com;
					
					if(RowUtils.decimal(row, 2).compareTo(BigDecimal.ZERO) > 0)
					{
						CashPurchaseOrderItem item = new CashPurchaseOrderItem();
						item.setProduct(productService.findOne(RowUtils.string(row, 5)));
						item.setNote(RowUtils.string(row, 4));
						item.setPurchaseOrder(order);
						item.setQuantity(RowUtils.decimal(row, 2));
						
						order.getItems().add(item);
					}
				}
				
				service.add(order);
				
				order.getRequest().setRequestStatus(RequestStatus.COMPLETE);
				requestService.edit(order.getRequest());
				
				
				CashPurchaseOrderWindow window = (CashPurchaseOrderWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		suppliers.addEventListener(Events.ON_BLUR,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				initItemsRow();
			}
		});
		
		suppliers.addEventListener(Events.ON_SELECT,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				initItemsRow();
			}
		});
		
		requests.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				initItemsRow();
			}
		});
		
		number.setText(CashPurchaseOrder.NCODE+System.currentTimeMillis());
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row0 = new Row();
		row0.appendChild(new Label("Number"));
		row0.appendChild(number);
		
		Row row1 = new Row();
		row1.appendChild(new Label("Date"));
		row1.appendChild(date);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Company"));
		row2.appendChild(companys);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Purchaser"));
		row3.appendChild(purchaser);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Request"));
		row4.appendChild(requests);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Supplier"));
		row5.appendChild(suppliers);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}
	
	private void initItems()
	{
		items.setWidth("100%");
		items.appendChild(new Rows());
		items.appendChild(new Columns());
		items.getColumns().appendChild(new Column("Product",null,"150px"));
		items.getColumns().appendChild(new Column("Requested",null,"100px"));
		items.getColumns().appendChild(new Column("Buying",null,"100px"));
		items.getColumns().appendChild(new Column("UoM",null,"100px"));
		items.getColumns().appendChild(new Column("Note",null,"150px"));
		items.getColumns().appendChild(new Column(null,null,"0px"));
		items.getColumns().getChildren().get(5).setVisible(false);
		items.setSpan("0");
		
		initItemsRow();
		
		appendChild(items);
	}
	
	private void initItemsRow()
	{
		try
		{
			items.getRows().getChildren().clear();
			
			PurchaseOrderRequest request = requestService.findOne(Components.string(requests));
			if(request != null && suppliers.getParty() != null)
			{
				for(PurchaseOrderRequestItem item:request.getItems())
				{
					boolean exist = false;
					for(ProductSupplier supplier:item.getProduct().getSuppliers())
					{
						if(supplier.getSupplier().getId().equals(suppliers.getParty().getId()))
						{
							exist = true;
							break;
						}
					}
					
					if(exist)
					{
						Row row = new Row();
						row.appendChild(new Label(item.getResource()));
						row.appendChild(Components.label(item.getQuantity()));
						row.appendChild(Components.doubleBox(item.getQuantity().doubleValue()));
						row.appendChild(new Label(item.getResource()));
						row.appendChild(Components.textBox(null));
						row.appendChild(new Label(item.getProduct().getId()));
						
						items.getRows().appendChild(row);
					}
				}
			}
		}
		catch (Exception e){}
	}
}