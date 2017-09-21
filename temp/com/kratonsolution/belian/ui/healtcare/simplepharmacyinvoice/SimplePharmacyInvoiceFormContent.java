/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.simplepharmacyinvoice;

import java.math.BigDecimal;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
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

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.global.svc.CodeGenerator;
import com.kratonsolution.belian.healtcare.dm.SimplePharmacyInvoice;
import com.kratonsolution.belian.healtcare.dm.SimplePharmacyInvoiceItem;
import com.kratonsolution.belian.healtcare.svc.SimplePharmacyInvoiceService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.CurrencyList;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SimplePharmacyInvoiceFormContent extends FormContent
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
	
	public SimplePharmacyInvoiceFormContent()
	{
		super();
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
				Flow.next(getParent(),new SimplePharmacyInvoiceGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(companys.getOrganization() == null)
					throw new WrongValueException(companys,lang.get("message.field.empty"));
				
				if(customers.getOrganization() == null)
					throw new WrongValueException(customers,lang.get("message.field.empty"));
				
				if(currencys.getCurrency() == null)
					throw new WrongValueException(currencys,lang.get("message.field.empty"));
				
				if(date.getValue() == null)
					throw new WrongValueException(date,lang.get("message.field.empty"));
				
				SimplePharmacyInvoice invoice = new SimplePharmacyInvoice();
				invoice.setCurrency(currencys.getCurrency());
				invoice.setCustomer(customers.getOrganization());
				invoice.setDate(DateTimes.sql(date.getValue()));
				invoice.setEmployee(utils.getEmployee());
				invoice.setNote(note.getText());
				invoice.setNumber(generator.generate(invoice.getDate(),companys.getOrganization(),Code.SPIN));
				invoice.setOrganization(companys.getOrganization());
				
				for(Component com:saleItems.getRows().getChildren())
				{
					Row _row = (Row)com;
					
					SimplePharmacyInvoiceItem item = new SimplePharmacyInvoiceItem();
					item.setAmount(RowUtils.decimal(_row, 2));
					item.setInvoice(invoice);
					item.setNote(RowUtils.string(_row, 1));
					
					invoice.getItems().add(item);
				}
				
				service.add(invoice);
				
				Flow.next(getParent(),new SimplePharmacyInvoiceGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
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
	
		NRCToolbar nrc = new NRCToolbar(saleItems);
		
		saleItems.setWidth("100%");
		saleItems.setEmptyMessage(lang.get("message.grid.empty"));
		saleItems.appendChild(new Columns());
		saleItems.getColumns().appendChild(new Column(null,null,"25px"));
		saleItems.getColumns().appendChild(new Column(lang.get("simplepharmacyinvoice.grid.column.note"),null,"225px"));
		saleItems.getColumns().appendChild(new Column(lang.get("simplepharmacyinvoice.grid.column.amount"),null,"100px"));
		saleItems.appendChild(new Rows());
		saleItems.setSpan("1");
		
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Doublebox amount = Components.doubleBox(0);
				amount.addEventListener(Events.ON_CHANGING, new EventListener<InputEvent>()
				{
					@Override
					public void onEvent(InputEvent input) throws Exception
					{
						display();
					}
				});
				amount.addEventListener(Events.ON_BLUR, new EventListener<Event>()
				{
					@Override
					public void onEvent(Event arg0) throws Exception
					{
						display();
					}
				});
				
				Row _row = new Row();
				_row.appendChild(Components.checkbox(false));
				_row.appendChild(Components.mandatoryTextBox(true));
				_row.appendChild(amount);
				
				saleItems.getRows().appendChild(_row);
			}
		});
		
		
		this.tabbox.getTabpanels().getChildren().get(0).appendChild(nrc);
		this.tabbox.getTabpanels().getChildren().get(0).appendChild(saleItems);
	}

	private void display()
	{
		BigDecimal totalAmount = BigDecimal.ZERO;
		
		for(Component com:saleItems.getRows().getChildren())
		{
			Row _row = (Row)com;
			totalAmount = totalAmount.add(RowUtils.decimal(_row, 2));
		}
		
		totalBill.setText(Numbers.format(totalAmount));
	}
}