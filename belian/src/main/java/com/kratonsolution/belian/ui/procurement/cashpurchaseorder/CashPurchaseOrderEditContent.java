/**
 * 
 */
package com.kratonsolution.belian.ui.procurement.cashpurchaseorder;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

import com.kratonsolution.belian.global.svc.CodeGenerator;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.procurement.dm.CashPurchaseOrder;
import com.kratonsolution.belian.procurement.dm.CashPurchaseOrderItem;
import com.kratonsolution.belian.procurement.svc.CashPurchaseOrderService;
import com.kratonsolution.belian.procurement.svc.PurchaseOrderRequestService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.FacilityList;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.component.SupplierBox;
import com.kratonsolution.belian.ui.component.TaxList;
import com.kratonsolution.belian.ui.procurement.purchaseorderrequest.PurchaseOrderRequestList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Numbers;
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

	private CodeGenerator gen = Springs.get(CodeGenerator.class);

	private Textbox number = Components.readOnlyTextBox();

	private OrganizationList companys = new OrganizationList();

	private Datebox date = Components.currentDatebox();

	private Listbox purchaser = Components.newSelect();

	private PurchaseOrderRequestList requests = new PurchaseOrderRequestList();

	private SupplierBox suppliers = new SupplierBox(true);

	private FacilityList facilitys = new FacilityList();

	private TaxList taxes = new TaxList();

	private Textbox price = Components.readOnlyMoneyBox(null);

	private Textbox tax = Components.readOnlyMoneyBox(null);

	private Textbox total = Components.readOnlyMoneyBox(null);

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
			companys.setOrganization(order.getOrganization());
			number.setText(order.getNumber());
			date.setValue(order.getDate());
			taxes.setTax(order.getTax());
			purchaser.setSelectedItem(purchaser.appendItem(order.getPurchaser().getLabel(), order.getPurchaser().getValue()));
			suppliers.setSupplier(order.getSupplier());
			facilitys.setFacility(order.getFacility());
			requests.setSelectedItem(requests.appendItem(order.getRequest().getLabel(), order.getRequest().getValue()));
			
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"100px"));
			grid.getColumns().appendChild(new Column());
			grid.getColumns().appendChild(new Column(null,null,"100px"));
			grid.getColumns().appendChild(new Column(null,null,"150px"));
			grid.setSpan("0");

			Row row0 = new Row();
			row0.appendChild(new Label(lang.get("cpo.grid.column.company")));
			row0.appendChild(companys);
			row0.appendChild(new Label(lang.get("cpo.grid.column.price")));
			row0.appendChild(price);

			Row row1 = new Row();
			row1.appendChild(new Label(lang.get("cpo.grid.column.number")));
			row1.appendChild(number);
			row1.appendChild(new Label(lang.get("cpo.grid.column.tax")));
			row1.appendChild(tax);

			Row row2 = new Row();
			row2.appendChild(new Label(lang.get("cpo.grid.column.date")));
			row2.appendChild(date);
			row2.appendChild(new Label(lang.get("cpo.grid.column.total")));
			row2.appendChild(total);

			Row row3 = new Row();
			row3.appendChild(new Label(lang.get("cpo.grid.column.tax")));
			row3.appendChild(taxes);

			Row row4 = new Row();
			row4.appendChild(new Label(lang.get("cpo.grid.column.purchaser")));
			row4.appendChild(purchaser);

			Row row5 = new Row();
			row5.appendChild(new Label(lang.get("cpo.grid.column.supplier")));
			row5.appendChild(suppliers);

			Row row6 = new Row();
			row6.appendChild(new Label(lang.get("cpo.grid.column.request")));
			row6.appendChild(requests);

			Row row7 = new Row();
			row7.appendChild(new Label(lang.get("cpo.grid.column.facility")));
			row7.appendChild(facilitys);

			rows.appendChild(row0);
			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
			rows.appendChild(row4);
			rows.appendChild(row5);
			rows.appendChild(row6);
			rows.appendChild(row7);
		}
	}

	private void initItems()
	{
		items.setWidth("100%");
		items.appendChild(new Rows());
		items.appendChild(new Columns());
		items.setEmptyMessage(lang.get("message.grid.empty"));
		items.getColumns().appendChild(new Column(lang.get("cpo.grid.column.product"),null,"250px"));
		items.getColumns().appendChild(new Column(lang.get("cpo.grid.column.requested"),null,"55px"));
		items.getColumns().appendChild(new Column(lang.get("cpo.grid.column.buying"),null,"55px"));
		items.getColumns().appendChild(new Column(lang.get("cpo.grid.column.uom"),null,"80px"));
		items.getColumns().appendChild(new Column(lang.get("cpo.grid.column.expired"),null,"125px"));
		items.getColumns().appendChild(new Column(lang.get("cpo.grid.column.price"),null,"85px"));
		items.getColumns().appendChild(new Column(lang.get("cpo.grid.column.total"),null,"85px"));
		items.getColumns().appendChild(new Column());
		items.getColumns().getLastChild().setVisible(false);
		items.setSpan("0");

		CashPurchaseOrder order = service.findOne(RowUtils.id(row));
		if(order != null)
		{
			BigDecimal prc = BigDecimal.ZERO;

			for(CashPurchaseOrderItem item:order.getItems())
			{
				items.getRows().appendChild(new PurchaseOrderItemRow(item));
				prc = prc.add(item.getQuantity().multiply(item.getUnitPrice()));
			}
			
			BigDecimal txt = BigDecimal.ZERO;

			if(taxes.getTax() != null)
				txt = prc.multiply(taxes.getTax().getAmount()).divide(BigDecimal.valueOf(100),RoundingMode.CEILING);

			price.setValue(Numbers.format(prc));
			tax.setValue(Numbers.format(txt));
			total.setValue(Numbers.format(prc.add(txt)));
		}
		
		appendChild(items);
	}
}
