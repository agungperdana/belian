/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.pharmacysales;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.Iterator;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
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
import com.kratonsolution.belian.accounting.dm.Tax;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.global.svc.CodeGenerator;
import com.kratonsolution.belian.healtcare.dm.PharmacySales;
import com.kratonsolution.belian.healtcare.dm.PharmacySalesItem;
import com.kratonsolution.belian.healtcare.svc.PharmacySalesService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.CurrencyList;
import com.kratonsolution.belian.ui.component.MedicalSalesRow;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.component.PersonBox;
import com.kratonsolution.belian.ui.component.ProductPriceSelectionListener;
import com.kratonsolution.belian.ui.component.TaxList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PharmacySalesFormContent extends FormContent implements ProductPriceSelectionListener
{	
	private CodeGenerator generator = Springs.get(CodeGenerator.class);
	
	private PersonService personService = Springs.get(PersonService.class);
	
	private PharmacySalesService service = Springs.get(PharmacySalesService.class);
	
	private Textbox number = Components.readOnlyTextBox();
	
	private Datebox date = Components.mandatoryDatebox();
	
	private Checkbox ref = new Checkbox();
	
	private Doublebox term = Components.readOnlyDoubleBox(0);
	
	private Doublebox tuslah = Components.doubleBox(4000);
	
	private Doublebox rounding = Components.doubleBox(0);
	
	private Textbox bill = Components.moneyBox();
	
	private Textbox tax = Components.moneyBox();
	
	private Textbox totalBill = Components.moneyBox();
	
	private Textbox note = new Textbox();
	
	private Listbox saleses = Components.fullSpanSelect(utils.getUser().getPerson());
	
	private PersonBox customers = new PersonBox(false);
	
	private CurrencyList currencys = new CurrencyList();
	
	private OrganizationList companys = new OrganizationList();
	
	private Listbox locations = Components.fullSpanSelect(utils.getLocation());
	
	private TaxList taxes = new TaxList();
	
	private Tabbox tabbox = new Tabbox();
	
	private Grid saleItems = new Grid();
	
	public PharmacySalesFormContent()
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
				Flow.next(getParent(),new PharmacySalesGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PharmacySales pharmacy = new PharmacySales();
				pharmacy.setCurrency(currencys.getCurrency());
				pharmacy.setCustomer(customers.getPerson());
				pharmacy.setDate(new Date(date.getValue().getTime()));
				pharmacy.setNumber(number.getText());
				pharmacy.setOrganization(companys.getOrganization());
				pharmacy.setSales(utils.getUser().getPerson());
				pharmacy.setTax(taxes.getTax());
				pharmacy.setReference(ref.isChecked());
				pharmacy.setRounding(BigDecimal.valueOf(rounding.doubleValue()));
				pharmacy.setTuslah(BigDecimal.valueOf(tuslah.doubleValue()));
				
				for(Component com:saleItems.getRows().getChildren())
				{
					MedicalSalesRow row = (MedicalSalesRow)com;
					PharmacySalesItem item = row.getItem();
					item.setPharmacySales(pharmacy);
					pharmacy.getItems().add(item);
				}
				
				service.add(pharmacy);
				
				Flow.next(getParent(),new PharmacySalesGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		companys.setWidth("100%");
		taxes.setWidth("100%");
		currencys.setWidth("100%");
		
		rounding.addEventListener(Events.ON_CHANGE, new EventListener<InputEvent>()
		{
			@Override
			public void onEvent(InputEvent input) throws Exception
			{
				if(!Strings.isNullOrEmpty(input.getValue()))
					display();
			}
		});
		
		tuslah.addEventListener(Events.ON_CHANGE, new EventListener<InputEvent>()
		{
			@Override
			public void onEvent(InputEvent input) throws Exception
			{
				if(!Strings.isNullOrEmpty(input.getValue()))
					display();
			}
		});
		
		customers.setPerson(personService.anonymous());
		
		number.setText(generator.generate(new Date(System.currentTimeMillis()), companys.getOrganization(), Code.BLMED));
		date.setConstraint("no empty");
		note.setWidth("100%");
		
		if(utils.getUser().getPerson() != null)
		{
			saleses.appendChild(new Listitem(utils.getUser().getPerson().getLabel(), utils.getUser().getPerson().getValue()));
			saleses.setSelectedIndex(0);
		}
		
		if(companys.getOrganization() != null)
		{
			String code = generator.generate(DateTimes.currentDate(), companys.getOrganization(),Code.PHS);
			number.setText(code);
		}
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("pharmacysales.grid.column.company")));
		row1.appendChild(companys);
		row1.appendChild(new Label(lang.get("pharmacysales.grid.column.billing")));
		row1.appendChild(bill);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("pharmacysales.grid.column.number")));
		row2.appendChild(number);
		row2.appendChild(new Label(lang.get("pharmacysales.grid.column.tuslah")));
		row2.appendChild(tuslah);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("pharmacysales.grid.column.date")));
		row3.appendChild(date);
		row3.appendChild(new Label(lang.get("pharmacysales.grid.column.taxbill")));
		row3.appendChild(tax);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("pharmacysales.grid.column.tax")));
		row4.appendChild(taxes);
		row4.appendChild(new Label(lang.get("pharmacysales.grid.column.rounding")));
		row4.appendChild(rounding);

		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("pharmacysales.grid.column.currency")));
		row5.appendChild(currencys);
		row5.appendChild(new Label(lang.get("pharmacysales.grid.column.totbil")));
		row5.appendChild(totalBill);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("pharmacysales.grid.column.sales")));
		row6.appendChild(saleses);
		row6.appendChild(new Label(lang.get("pharmacysales.grid.column.customer")));
		row6.appendChild(customers);
		
		Row row8 = new Row();
		row8.appendChild(new Label(lang.get("pharmacysales.grid.column.location")));
		row8.appendChild(locations);
		row8.appendChild(new Label(lang.get("pharmacysales.grid.column.note")));
		row8.appendChild(note);
		
		Row row9 = new Row();
		row9.appendChild(new Label(lang.get("pharmacysales.grid.column.reference")));
		row9.appendChild(ref);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		rows.appendChild(row8);
		rows.appendChild(row9);
	}
	
	private void initItems()
	{
		this.tabbox.getTabs().appendChild(new Tab("Sales Item(s)"));
		this.tabbox.getTabpanels().appendChild(new Tabpanel());
		
		saleItems.appendChild(new Columns());
		saleItems.getColumns().appendChild(new Column(null,null,"25px"));
		saleItems.getColumns().appendChild(new Column(lang.get("pharmacysales.grid.column.product"),null,"225px"));
		saleItems.getColumns().appendChild(new Column(lang.get("pharmacysales.grid.column.quantity"),null,"85px"));
		saleItems.getColumns().appendChild(new Column(lang.get("pharmacysales.grid.column.uom"),null,"85px"));
		saleItems.getColumns().appendChild(new Column(lang.get("pharmacysales.grid.column.price"),null,"95px"));
		saleItems.getColumns().appendChild(new Column(lang.get("pharmacysales.grid.column.discount"),null,"95px"));
		saleItems.getColumns().appendChild(new Column(lang.get("pharmacysales.grid.column.charge"),null,"95px"));
		saleItems.getColumns().appendChild(new Column(lang.get("pharmacysales.grid.column.note"),null));
		saleItems.appendChild(new Rows());
		saleItems.setSpan("4");
		
		Toolbar toolbar = new Toolbar();
		toolbar.setHeight("40px");
		toolbar.appendChild(new Toolbarbutton(lang.get("label.component.button.new"),"/icons/new.png"));
		toolbar.appendChild(new Toolbarbutton(lang.get("label.component.button.delete"),"/icons/delete.png"));
		toolbar.appendChild(new Toolbarbutton(lang.get("label.component.button.clear"),"/icons/refresh.png"));
		toolbar.getChildren().get(0).addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				MedicalSalesRow row = new MedicalSalesRow(false,false,ref.isChecked());
				row.addProductPriceListener(PharmacySalesFormContent.this);
				saleItems.getRows().appendChild(row);
			}
		});
		
		toolbar.getChildren().get(1).addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Iterator<Component> iterator = saleItems.getRows().getChildren().iterator();
				while (iterator.hasNext())
				{
					Row row = (Row) iterator.next();
					if(RowUtils.isChecked(row, 0))
						iterator.remove();
				}
				
				display();
			}
		});
		
		toolbar.getChildren().get(2).addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				saleItems.getRows().getChildren().clear();
				display();
			}
		});
		
		this.tabbox.getTabpanels().getChildren().get(0).appendChild(toolbar);
		this.tabbox.getTabpanels().getChildren().get(0).appendChild(saleItems);
	}

	@Override
	public void fireSelectedPrice(BigDecimal quantity, BigDecimal price,BigDecimal discount, BigDecimal charge)
	{
		display();
	}

	private void display()
	{
		BigDecimal billAmount = BigDecimal.ZERO;
		BigDecimal taxAmount = BigDecimal.ZERO;
		BigDecimal totalAmount = BigDecimal.ZERO;
		
		for(Component com:saleItems.getRows().getChildren())
		{
			MedicalSalesRow row = (MedicalSalesRow)com;
			billAmount = billAmount.add(row.getAmount());
		}
		
		Tax tx = taxes.getTax();
		if(tx != null)
			taxAmount = billAmount.multiply(tx.getAmount()).divide(BigDecimal.valueOf(100));
		
		totalAmount = billAmount.add(taxAmount).add(BigDecimal.valueOf(tuslah.doubleValue()));
		
		NumberFormat format = NumberFormat.getNumberInstance();
		format.setGroupingUsed(true);
		
		bill.setText(format.format(billAmount));
		tax.setText(format.format(taxAmount));
		totalBill.setText(format.format(totalAmount.add(BigDecimal.valueOf(rounding.doubleValue()))));
	}
}