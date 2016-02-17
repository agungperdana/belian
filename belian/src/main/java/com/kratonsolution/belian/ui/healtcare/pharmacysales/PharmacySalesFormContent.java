/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.pharmacysales;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.Iterator;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
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
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.global.svc.CodeGenerator;
import com.kratonsolution.belian.healtcare.dm.Medication;
import com.kratonsolution.belian.healtcare.dm.MedicationItem;
import com.kratonsolution.belian.healtcare.svc.MedicationService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.MedicalProductRow;
import com.kratonsolution.belian.ui.component.PatientBox;
import com.kratonsolution.belian.ui.component.ProductPriceSelectionListener;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PharmacySalesFormContent extends FormContent implements ProductPriceSelectionListener
{	
	private CodeGenerator generator = Springs.get(CodeGenerator.class);
	
	private SessionUtils sessionUtils = Springs.get(SessionUtils.class);
	
	private MedicationService service = Springs.get(MedicationService.class);
	
	private Textbox number = Components.readOnlyTextBox();
	
	private Datebox date = Components.mandatoryDatebox();
	
	private Doublebox term = Components.readOnlyDoubleBox(0);
	
	private Textbox bill = Components.moneyBox();
	
	private Textbox tax = Components.moneyBox();
	
	private Textbox totalBill = Components.moneyBox();
	
	private Textbox note = new Textbox();
	
	private Listbox saleses = Components.fullSpanSelect(sessionUtils.getUser().getPerson());
	
	private PatientBox customers = new PatientBox();
	
	private Listbox currencys = Components.fullSpanSelect(sessionUtils.getCurrency());
	
	private Listbox organizations = Components.fullSpanSelect(sessionUtils.getOrganization());
	
	private Listbox locations = Components.fullSpanSelect(sessionUtils.getLocation());
	
	private Listbox taxes = Components.fullSpanSelect(sessionUtils.getTax());
	
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
				PharmacySalesWindow window = (PharmacySalesWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(number.getText()))
					throw new WrongValueException(number,"Code cannot be empty");
			
				if(customers.getPatient() == null)
					throw new WrongValueException(customers,"Customer cannot be empty");

				if(taxes.getSelectedItem() == null)
					throw new WrongValueException(taxes,"Tax cannot be empty");
				
				Medication medication = new Medication();
				medication.setCurrency(sessionUtils.getCurrency());
				medication.setCustomer(customers.getPatient().getPerson());
				medication.setDate(new Date(date.getValue().getTime()));
				medication.setNumber(number.getText());
				medication.setOrganization(sessionUtils.getOrganization());
				medication.setSales(sessionUtils.getUser().getPerson());
				medication.setTax(sessionUtils.getTax());
				
				for(Component com:saleItems.getRows().getChildren())
				{
					MedicalProductRow row = (MedicalProductRow)com;
					
					MedicationItem item = new MedicationItem();
					item.setCharge(row.getCharge());
					item.setDiscount(row.getDiscount());
					item.setMedication(medication);
					item.setMedicine(row.getProduct());
					item.setNote(row.getNote());
					item.setPrice(row.getPrice());
					item.setQuantity(row.getQuantity());
					
					medication.getItems().add(item);
				}
				
				service.add(medication);
				
				PharmacySalesWindow window = (PharmacySalesWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		number.setText(generator.generate(new Date(System.currentTimeMillis()), sessionUtils.getOrganization(), Code.BLMED));
		date.setConstraint("no empty");
		note.setWidth("100%");
		
		if(sessionUtils.getUser().getPerson() != null)
		{
			saleses.appendChild(new Listitem(sessionUtils.getUser().getPerson().getLabel(), sessionUtils.getUser().getPerson().getValue()));
			saleses.setSelectedIndex(0);
		}
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Company"));
		row1.appendChild(organizations);
		row1.appendChild(new Label("Billing"));
		row1.appendChild(bill);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Document Number"));
		row2.appendChild(number);
		row2.appendChild(new Label("Tax"));
		row2.appendChild(tax);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Date"));
		row3.appendChild(date);
		row3.appendChild(new Label("Total Billing"));
		row3.appendChild(totalBill);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Tax"));
		row5.appendChild(taxes);
		row5.appendChild(new Label("Currency"));
		row5.appendChild(currencys);
		
		Row row6 = new Row();
		row6.appendChild(new Label("Sales"));
		row6.appendChild(saleses);
		row6.appendChild(new Label("Customer"));
		row6.appendChild(customers);
		
		Row row8 = new Row();
		row8.appendChild(new Label("Sales Location"));
		row8.appendChild(locations);
		row8.appendChild(new Label("Note"));
		row8.appendChild(note);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row5);
		rows.appendChild(row6);
		rows.appendChild(row8);
	}
	
	private void initItems()
	{
		this.tabbox.getTabs().appendChild(new Tab("Sales Item(s)"));
		this.tabbox.getTabpanels().appendChild(new Tabpanel());
		
		saleItems.appendChild(new Columns());
		saleItems.getColumns().appendChild(new Column(null,null,"25px"));
		saleItems.getColumns().appendChild(new Column("Product",null,"225px"));
		saleItems.getColumns().appendChild(new Column("Quantity",null,"85px"));
		saleItems.getColumns().appendChild(new Column("UoM",null,"85px"));
		saleItems.getColumns().appendChild(new Column("Price",null,"95px"));
		saleItems.getColumns().appendChild(new Column("Disc",null,"95px"));
		saleItems.getColumns().appendChild(new Column("Charge",null,"95px"));
		saleItems.getColumns().appendChild(new Column("Note",null));
		saleItems.appendChild(new Rows());
		saleItems.setSpan("4");
		
		Toolbar toolbar = new Toolbar();
		toolbar.setHeight("40px");
		toolbar.appendChild(new Toolbarbutton("New","/icons/new.png"));
		toolbar.appendChild(new Toolbarbutton("Remove","/icons/delete.png"));
		toolbar.appendChild(new Toolbarbutton("Clear","/icons/refresh.png"));
		toolbar.getChildren().get(0).addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				MedicalProductRow row = new MedicalProductRow(Components.string(locations),customers.getPatient().getPerson().getId(),Components.string(currencys),customers.getPatient().isBpjs());
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
			MedicalProductRow row = (MedicalProductRow)com;
			billAmount = billAmount.add(row.getQuantity().multiply(row.getPrice().subtract(row.getDiscount()).add(row.getCharge())));
		}
		
		Tax tx = sessionUtils.getTax();
		if(tx != null)
			taxAmount = billAmount.multiply(tx.getAmount()).divide(BigDecimal.valueOf(100));
		
		totalAmount = billAmount.add(taxAmount);
		
		NumberFormat format = NumberFormat.getNumberInstance();
		format.setGroupingUsed(true);
		
		bill.setText(format.format(billAmount));
		tax.setText(format.format(taxAmount));
		totalBill.setText(format.format(totalAmount));
	}
}