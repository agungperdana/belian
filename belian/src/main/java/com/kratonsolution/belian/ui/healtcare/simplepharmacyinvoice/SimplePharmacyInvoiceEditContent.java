/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.simplepharmacyinvoice;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
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

import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.global.svc.CodeGenerator;
import com.kratonsolution.belian.healtcare.dm.SimplePharmacyInvoice;
import com.kratonsolution.belian.healtcare.dm.SimplePharmacyInvoiceItem;
import com.kratonsolution.belian.healtcare.svc.SimplePharmacyInvoiceService;
import com.kratonsolution.belian.sales.view.BillablePrint;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.PrintWindow;
import com.kratonsolution.belian.ui.component.CurrencyList;
import com.kratonsolution.belian.ui.component.OrganizationList;
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
public class SimplePharmacyInvoiceEditContent extends FormContent
{	
	private CodeGenerator generator = Springs.get(CodeGenerator.class);

	private SimplePharmacyInvoiceService service = Springs.get(SimplePharmacyInvoiceService.class);

	private Textbox number = Components.readOnlyTextBox();

	private Datebox date = Components.mandatoryDatebox();

	private Textbox totalBill = Components.moneyBox();

	private Textbox note = new Textbox();

	private CurrencyList currencys = new CurrencyList();

	private OrganizationList companys = new OrganizationList();

	private OrganizationList customers = new OrganizationList();

	private Tabbox tabbox = new Tabbox();

	private Grid saleItems = new Grid();

	private Row row;

	public SimplePharmacyInvoiceEditContent(Row row)
	{
		super();
		this.row = row;
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
				Flow.next(getParent(), new SimplePharmacyInvoiceGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new SimplePharmacyInvoiceGridContent());
			}
		});

		toolbar.attachPrint();
		toolbar.getPrint().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PrintWindow window = new PrintWindow(BillablePrint.GEN(RowUtils.id(row),utils.isPos()),utils.isPos());
				window.setPage(getPage());
				window.setVisible(true);
			}
		});
	}

	@Override
	public void initForm()
	{
		SimplePharmacyInvoice invoice = service.findOne(RowUtils.id(row));
		if(invoice != null)
		{
			companys.setOrganization(invoice.getOrganization());
			customers.setOrganization((Organization)invoice.getCustomer());
			currencys.setCurrency(invoice.getCurrency());
			date.setValue(invoice.getDate());
			note.setText(invoice.getNote());
			number.setText(invoice.getNumber());
			totalBill.setText(Numbers.format(invoice.getAmount()));
		}

		companys.setWidth("100%");
		customers.setWidth("100%");

		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("simplepharmacyinvoice.grid.column.company")));
		row1.appendChild(companys);
		row1.appendChild(new Label(lang.get("simplepharmacyinvoice.grid.column.amount")));
		row1.appendChild(totalBill);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("simplepharmacyinvoice.grid.column.number")));
		row2.appendChild(number);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("simplepharmacyinvoice.grid.column.date")));
		row3.appendChild(date);

		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("simplepharmacyinvoice.grid.column.customer")));
		row4.appendChild(customers);

		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("simplepharmacyinvoice.grid.column.currency")));
		row5.appendChild(currencys);

		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("simplepharmacyinvoice.grid.column.note")));
		row6.appendChild(note);

		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
	}

	private void initItems()
	{
		this.tabbox.getTabs().appendChild(new Tab(lang.get("simplepharmacyinvoice.grid.column.items")));
		this.tabbox.getTabpanels().appendChild(new Tabpanel());

		saleItems.setWidth("100%");
		saleItems.setEmptyMessage(lang.get("message.grid.empty"));
		saleItems.appendChild(new Columns());
		saleItems.getColumns().appendChild(new Column(lang.get("simplepharmacyinvoice.grid.column.note"),null,"225px"));
		saleItems.getColumns().appendChild(new Column(lang.get("simplepharmacyinvoice.grid.column.amount"),null,"100px"));
		saleItems.appendChild(new Rows());
		saleItems.setSpan("0");

		SimplePharmacyInvoice invoice = service.findOne(RowUtils.id(row));
		if(invoice != null)
		{
			for(SimplePharmacyInvoiceItem item:invoice.getItems())
			{
				Row _row = new Row();
				_row.appendChild(Components.mandatoryTextBox(item.getNote()));
				_row.appendChild(Components.doubleBox(item.getAmount()));
				
				saleItems.getRows().appendChild(_row);
			}
		}

		this.tabbox.getTabpanels().getChildren().get(0).appendChild(saleItems);
	}
}
