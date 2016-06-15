/**
 * 
 */
package com.kratonsolution.belian.ui.procurement.cashpurchaseorder;

import java.sql.Date;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
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

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.global.svc.CodeGenerator;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.procurement.dm.CashPurchaseOrder;
import com.kratonsolution.belian.procurement.dm.CashPurchaseOrderItem;
import com.kratonsolution.belian.procurement.dm.PurchaseOrderRequestItem;
import com.kratonsolution.belian.procurement.svc.CashPurchaseOrderService;
import com.kratonsolution.belian.procurement.svc.PurchaseOrderRequestService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.FacilityList;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.component.SupplierBox;
import com.kratonsolution.belian.ui.procurement.purchaseorderrequest.PurchaseOrderRequestList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
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

	private CodeGenerator gen = Springs.get(CodeGenerator.class);

	private SessionUtils utils = Springs.get(SessionUtils.class);

	private Textbox number = Components.readOnlyTextBox();

	private OrganizationList companys = new OrganizationList();

	private Datebox date = Components.currentDatebox();

	private Listbox purchaser = Components.newSelect(utils.getUser().getPerson());

	private PurchaseOrderRequestList requests = new PurchaseOrderRequestList();

	private SupplierBox suppliers = new SupplierBox(true);

	private FacilityList facilitys = new FacilityList();

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
				Flow.next(getParent(), new CashPurchaseOrderGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(suppliers.getSupplier() == null)
					throw new WrongValueException(suppliers,"Supplier cannot be empty.");
				
				if(requests.getRequest() == null)
					throw new WrongValueException(requests,"Purchase Order Request cannot be empty.");
				
				CashPurchaseOrder order = new CashPurchaseOrder();
				order.setDate(new Date(date.getValue().getTime()));
				order.setDueDate(DateTimes.currentDate());
				order.setNumber(number.getText());
				order.setOrganization(utils.getOrganization());
				order.setPurchaser(utils.getUser().getPerson());
				order.setRequest(requests.getRequest());
				order.setSupplier(suppliers.getSupplier());
				order.setCurrency(utils.getCurrency());
				order.setTax(utils.getTax());
				order.setFacility(facilitys.getFacility());

				for(Component com:items.getRows().getChildren())
				{
					PurchaseOrderRequestItemRow row = (PurchaseOrderRequestItemRow)com;
					
					if(row.getItem() != null && row.isBuyed())
					{
						CashPurchaseOrderItem item = new CashPurchaseOrderItem();
						item.setProduct(row.getItem().getProduct());
						item.setExpiredDate(row.getExpired());
						item.setPurchaseOrder(order);
						item.setQuantity(row.getBuyed());
						item.setRequestItem(row.getItem());

						order.getItems().add(item);
					}
				}

				service.add(order);

				Flow.next(getParent(), new CashPurchaseOrderGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		requests.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				initItemsRow();
			}
		});

		number.setText(gen.generate(Code.CsPO));

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
		row4.appendChild(new Label("Supplier"));
		row4.appendChild(suppliers);

		Row row5 = new Row();
		row5.appendChild(new Label("Request"));
		row5.appendChild(requests);

		Row row6 = new Row();
		row6.appendChild(new Label("Warehouse"));
		row6.appendChild(facilitys);

		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
	}

	private void initItems()
	{
		items.setWidth("100%");
		items.appendChild(new Rows());
		items.appendChild(new Columns());
		items.getColumns().appendChild(new Column("Product",null,"150px"));
		items.getColumns().appendChild(new Column("Requested",null,"80px"));
		items.getColumns().appendChild(new Column("Buying",null,"80px"));
		items.getColumns().appendChild(new Column("UoM",null,"100px"));
		items.getColumns().appendChild(new Column("Expired",null,"125px"));
		items.setSpan("0");

		initItemsRow();

		appendChild(items);
	}

	private void initItemsRow()
	{
		items.getRows().getChildren().clear();

		if(requests.getRequest() != null)
		{
			for(PurchaseOrderRequestItem item:requests.getRequest().getItems())
				items.getRows().appendChild(new PurchaseOrderRequestItemRow(item));
		}
	}
}