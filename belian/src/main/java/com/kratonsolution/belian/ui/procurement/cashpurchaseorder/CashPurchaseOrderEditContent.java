/**
 * 
 */
package com.kratonsolution.belian.ui.procurement.cashpurchaseorder;

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
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.procurement.dm.CashPurchaseOrder;
import com.kratonsolution.belian.procurement.dm.CashPurchaseOrderItem;
import com.kratonsolution.belian.procurement.svc.CashPurchaseOrderService;
import com.kratonsolution.belian.procurement.svc.PurchaseOrderRequestService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.PartyBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashPurchaseOrderEditContent extends FormContent
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

	private Row row;

	public CashPurchaseOrderEditContent(Row row)
	{
		super();
		
		this.row = row;
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
				window.removeEditForm();
				window.insertGrid();
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				CashPurchaseOrderWindow window = (CashPurchaseOrderWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		CashPurchaseOrder order = service.findOne(RowUtils.string(row, 7));
		if(order != null)
		{
			date.setValue(order.getDate());
			number.setText(order.getNumber());
			companys.appendChild(new Listitem(order.getOrganization().getName(), order.getOrganization().getId()));
			suppliers.setParty(order.getSupplier());
			purchaser.appendChild(new Listitem(order.getPurchaser().getName(), order.getPurchaser().getId()));
			requests.appendChild(new Listitem(order.getRequest().getNumber(), order.getRequest().getId()));

			Components.setDefault(companys);
			Components.setDefault(purchaser);
			Components.setDefault(requests);
			
			
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
	}
	
	private void initItems()
	{
		items.setWidth("100%");
		items.appendChild(new Rows());
		items.appendChild(new Columns());
		items.getColumns().appendChild(new Column("Product",null,"150px"));
		items.getColumns().appendChild(new Column("Buying",null,"100px"));
		items.getColumns().appendChild(new Column("UoM",null,"100px"));
		items.getColumns().appendChild(new Column("Note",null,"150px"));
		items.setSpan("0");
		
		CashPurchaseOrder order = service.findOne(RowUtils.string(row, 7));
		if(order != null)
		{
			for(CashPurchaseOrderItem item:order.getItems())
			{
				Row row = new Row();
				row.appendChild(new Label(item.getProduct().getName()));
				row.appendChild(Components.label(item.getQuantity()));
				row.appendChild(new Label(item.getProduct().getUom().getName()));
				row.appendChild(new Label(item.getNote()));
				
				items.getRows().appendChild(row);
			}
		}
		
		
		appendChild(items);
	}
}
