/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.pharmacyorder;

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
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.healtcare.dm.Medication;
import com.kratonsolution.belian.healtcare.dm.MedicationItem;
import com.kratonsolution.belian.healtcare.dm.MedicationStatus;
import com.kratonsolution.belian.healtcare.dm.Patient;
import com.kratonsolution.belian.healtcare.svc.MedicationService;
import com.kratonsolution.belian.healtcare.svc.PatientService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.MedicalProductRow;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PharmacyOrderEditContent extends FormContent
{	
	private PatientService patientService = Springs.get(PatientService.class);

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

	private Listbox customers = Components.fullSpanSelect();

	private Listbox currencys = Components.fullSpanSelect(sessionUtils.getCurrency());

	private Listbox organizations = Components.fullSpanSelect(sessionUtils.getOrganization());

	private Listbox locations = Components.fullSpanSelect(sessionUtils.getLocation());

	private Listbox taxes = Components.fullSpanSelect(sessionUtils.getTax());

	

	private Row row;

	public PharmacyOrderEditContent(Row row)
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
				PharmacyOrderWindow window = (PharmacyOrderWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
		
		Medication medication = service.findOne(RowUtils.string(row, 6));
		if(medication != null && medication.isPaid())
		{
			if(medication.getStatus().equals(MedicationStatus.Registered))
				toolbar.getSave().setLabel("Prepared");
			else if(medication.getStatus().equals(MedicationStatus.Prepared))
				toolbar.getSave().setLabel("Finish");
			else 
				toolbar.removeChild(toolbar.getSave());
			
			toolbar.getSave().setImage("/icons/handled.png");
			toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					if(medication.getStatus().equals(MedicationStatus.Registered))
						medication.setStatus(MedicationStatus.Prepared);
					else if(medication.getStatus().equals(MedicationStatus.Prepared))
						medication.setStatus(MedicationStatus.Finished);

					service.finish(medication);
					
					PharmacyOrderWindow window = (PharmacyOrderWindow)getParent();
					window.removeEditForm();
					window.insertGrid();
				}
			});
		}
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

			if(medication.getTax() != null)
			{
				taxes.appendChild(new Listitem(medication.getTax().getLabel(),medication.getTax().getValue()));
				taxes.setSelectedIndex(0);
			}

			customers.appendChild(new Listitem(medication.getCustomer().getLabel(),medication.getCustomer().getValue()));
			customers.setSelectedIndex(0);

			locations.appendChild(new Listitem(sessionUtils.getLocation().getLabel(),sessionUtils.getLocation().getValue()));

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
			row1.appendChild(new Label("Currency"));
			row1.appendChild(currencys);
			
			Row row2 = new Row();
			row2.appendChild(new Label("Document Number"));
			row2.appendChild(number);
			row2.appendChild(new Label("Customer"));
			row2.appendChild(customers);

			Row row3 = new Row();
			row3.appendChild(new Label("Date"));
			row3.appendChild(date);
			row3.appendChild(new Label("Note"));
			row3.appendChild(note);
			
			Row row5 = new Row();
			row5.appendChild(new Label("Tax"));
			row5.appendChild(taxes);
			row5.appendChild(new Label("Sales"));
			row5.appendChild(saleses);

			Row row8 = new Row();
			row8.appendChild(new Label("Sales Location"));
			row8.appendChild(locations);

			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
			rows.appendChild(row5);
			rows.appendChild(row8);
		}
	}

	private void initItems()
	{
		Grid saleItems = new Grid();
		saleItems.appendChild(new Columns());
		saleItems.appendChild(new Rows());
		saleItems.getColumns().appendChild(new Column(null,null,"25px"));
		saleItems.getColumns().appendChild(new Column("Product",null,"200px"));
		saleItems.getColumns().appendChild(new Column("Quantity",null,"70px"));
		saleItems.getColumns().appendChild(new Column("UoM",null,"75px"));
		saleItems.getColumns().appendChild(new Column("Note",null));
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
				MedicalProductRow row = new MedicalProductRow(sessionUtils.getLocation().getId(),medication.getCustomer().getId(), medication.getCurrency().getId(), bpjs);
				row.setCharge(item.getCharge());
				row.setDiscount(item.getDiscount());
				row.setNote(item.getNote());
				row.setPrice(item.getPrice());
				row.setProduct(item.getMedicine());
				row.setQuantity(item.getQuantity());
				
				saleItems.getRows().appendChild(row);
			}
		}
		
		appendChild(saleItems);
	}
}
