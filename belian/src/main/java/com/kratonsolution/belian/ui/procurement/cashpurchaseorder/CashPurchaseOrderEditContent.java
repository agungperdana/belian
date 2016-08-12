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

import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.procurement.dm.CashPurchaseOrder;
import com.kratonsolution.belian.procurement.dm.CashPurchaseOrderItem;
import com.kratonsolution.belian.procurement.svc.CashPurchaseOrderService;
import com.kratonsolution.belian.procurement.svc.PurchaseOrderRequestService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.FacilityList;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.component.SupplierBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
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

	private Textbox number = Components.readOnlyTextBox();

	private OrganizationList companys = new OrganizationList();

	private Datebox date = Components.currentDatebox();

	private Listbox purchaser = Components.newSelect(utils.getUser().getPerson());

	private Listbox requests = Components.newSelect(requestService.findAllIncomplete(),true);

	private FacilityList facilitys = new FacilityList();
	
	private SupplierBox suppliers = new SupplierBox(false);

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
				Flow.next(getParent(), new CashPurchaseOrderGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new CashPurchaseOrderGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		CashPurchaseOrder order = service.findOne(RowUtils.id(row));
		if(order != null)
		{
			date.setValue(order.getDate());
			number.setText(order.getNumber());
			companys.appendChild(new Listitem(order.getOrganization().getName(), order.getOrganization().getId()));
			suppliers.setSupplier(order.getSupplier());
			purchaser.appendChild(new Listitem(order.getPurchaser().getName(), order.getPurchaser().getId()));
			requests.appendChild(new Listitem(order.getRequest().getNumber(), order.getRequest().getId()));

			Components.setDefault(companys);
			Components.setDefault(purchaser);
			Components.setDefault(requests);
			
			
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
			grid.getColumns().appendChild(new Column());
			
			Row row0 = new Row();
			row0.appendChild(new Label(lang.get("cpo.grid.column.number")));
			row0.appendChild(number);

			Row row1 = new Row();
			row1.appendChild(new Label(lang.get("cpo.grid.column.date")));
			row1.appendChild(date);

			Row row2 = new Row();
			row2.appendChild(new Label(lang.get("cpo.grid.column.company")));
			row2.appendChild(companys);

			Row row3 = new Row();
			row3.appendChild(new Label(lang.get("cpo.grid.column.purchaser")));
			row3.appendChild(purchaser);

			Row row4 = new Row();
			row4.appendChild(new Label(lang.get("cpo.grid.column.supplier")));
			row4.appendChild(suppliers);

			Row row5 = new Row();
			row5.appendChild(new Label(lang.get("cpo.grid.column.request")));
			row5.appendChild(requests);

			Row row6 = new Row();
			row6.appendChild(new Label(lang.get("cpo.grid.column.facility")));
			row6.appendChild(facilitys);
			
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
		items.setEmptyMessage(lang.get("message.grid.empty"));
		items.getColumns().appendChild(new Column(lang.get("cpo.grid.column.product"),null,"150px"));
		items.getColumns().appendChild(new Column(lang.get("cpo.grid.column.requested"),null,"80px"));
		items.getColumns().appendChild(new Column(lang.get("cpo.grid.column.buying"),null,"80px"));
		items.getColumns().appendChild(new Column(lang.get("cpo.grid.column.uom"),null,"100px"));
		items.getColumns().appendChild(new Column(lang.get("cpo.grid.column.expired"),null,"125px"));
		items.setSpan("0");
		
		CashPurchaseOrder order = service.findOne(RowUtils.id(row));
		if(order != null)
		{
			for(CashPurchaseOrderItem item:order.getItems())
				items.getRows().appendChild(new PurchaseOrderRequestItemRow(item));
		}
		
		
		appendChild(items);
	}
}
