/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.pharmacysales;

import java.math.BigDecimal;
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
import com.kratonsolution.belian.healtcare.dm.Medication;
import com.kratonsolution.belian.healtcare.dm.MedicationItem;
import com.kratonsolution.belian.healtcare.dm.Patient;
import com.kratonsolution.belian.healtcare.svc.MedicationService;
import com.kratonsolution.belian.healtcare.svc.PatientService;
import com.kratonsolution.belian.sales.view.BillablePrint;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.PrintWindow;
import com.kratonsolution.belian.ui.component.MedicalProductRow;
import com.kratonsolution.belian.ui.component.ProductPriceSelectionListener;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PharmacySalesEditContent extends FormContent implements ProductPriceSelectionListener
{	
	private PatientService patientService = Springs.get(PatientService.class);

	private SessionUtils utils = Springs.get(SessionUtils.class);

	private MedicationService service = Springs.get(MedicationService.class);

	private Textbox number = Components.readOnlyTextBox();

	private Datebox date = Components.mandatoryDatebox();

	private Doublebox term = Components.readOnlyDoubleBox(0);

	private Textbox bill = Components.moneyBox();

	private Textbox tax = Components.moneyBox();

	private Textbox totalBill = Components.moneyBox();

	private Textbox note = new Textbox();

	private Listbox saleses = Components.fullSpanSelect(utils.getUser().getPerson());

	private Listbox customers = Components.fullSpanSelect();

	private Listbox currencys = Components.fullSpanSelect(utils.getCurrency());

	private Listbox organizations = Components.fullSpanSelect(utils.getOrganization());

	private Listbox locations = Components.fullSpanSelect(utils.getLocation());

	private Listbox taxes = Components.fullSpanSelect(utils.getTax());

	private Tabbox tabbox = new Tabbox();

	private Grid saleItems = new Grid();

	private Row row;

	public PharmacySalesEditContent(Row row)
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
				PharmacySalesWindow window = (PharmacySalesWindow)getParent();
				window.removeEditForm();
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

				if(taxes.getSelectedItem() == null)
					throw new WrongValueException(taxes,"Tax cannot be empty");

				Medication medication = service.findOne(RowUtils.string(row, 6));
				if(medication != null && !medication.isPaid())
				{
					medication.getItems().clear();
					service.edit(medication);

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

					service.edit(medication);
				}

				PharmacySalesWindow window = (PharmacySalesWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
		
		toolbar.attachPrint();
		toolbar.getPrint().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PrintWindow window = new PrintWindow(BillablePrint.GEN(RowUtils.string(row, 6),utils.isPos()),utils.isPos());
				window.setPage(getPage());
				window.setVisible(true);
			}
		});
	}

	@Override
	public void initForm()
	{
		Medication medication = service.findOne(RowUtils.string(row, 6));
		if(medication != null)
		{
			number.setText(medication.getNumber());
			date.setValue(medication.getDate());

			organizations.appendChild(new Listitem(medication.getOrganization().getLabel(),medication.getOrganization().getValue()));
			organizations.setSelectedIndex(0);

			saleses.appendChild(new Listitem(medication.getSales().getLabel(),medication.getSales().getValue()));
			saleses.setSelectedIndex(0);

			taxes.appendChild(new Listitem(medication.getTax().getLabel(),medication.getTax().getValue()));
			taxes.setSelectedIndex(0);

			customers.appendChild(new Listitem(medication.getCustomer().getLabel(),medication.getCustomer().getValue()));
			customers.setSelectedIndex(0);

			locations.appendChild(new Listitem(utils.getLocation().getLabel(),utils.getLocation().getValue()));

			bill.setText(Numbers.format(medication.getBillingAmount()));
			tax.setText(Numbers.format(medication.getTaxAmount()));
			totalBill.setText(Numbers.format(medication.getBillingAmount().add(medication.getTaxAmount())));

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

		Medication medication = service.findOne(RowUtils.string(row, 6));
		if(medication != null)
		{
			boolean bpjs = false;
			Patient patient = patientService.findOne(medication.getCustomer().getId(), medication.getOrganization().getId());
			if(patient != null)
				bpjs = patient.isBpjs();
			
			for(MedicationItem item:medication.getItems())
			{
				MedicalProductRow row = new MedicalProductRow(utils.getLocation().getId(),medication.getCustomer().getId(), medication.getCurrency().getId(), bpjs);
				row.setCharge(item.getCharge());
				row.setDiscount(item.getDiscount());
				row.setNote(item.getNote());
				row.setPrice(item.getPrice());
				row.setProduct(item.getMedicine());
				row.setQuantity(item.getQuantity());
				
				saleItems.getRows().appendChild(row);
			}
		}

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
				boolean bpjs = false;
				Patient patient = patientService.findOne(medication.getCustomer().getId(), medication.getOrganization().getId());
				if(patient != null)
					bpjs = patient.isBpjs();
				
				MedicalProductRow row = new MedicalProductRow(Components.string(locations),Components.string(customers),Components.string(currencys),bpjs);
				row.addProductPriceListener(PharmacySalesEditContent.this);
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

		Tax tx = utils.getTax();
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
