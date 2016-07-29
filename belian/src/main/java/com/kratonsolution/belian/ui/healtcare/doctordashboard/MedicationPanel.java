/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import java.math.BigDecimal;
import java.util.Iterator;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tabpanel;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointmentStatus;
import com.kratonsolution.belian.healtcare.dm.ClinicSales;
import com.kratonsolution.belian.healtcare.dm.ClinicSalesItem;
import com.kratonsolution.belian.healtcare.svc.MedicalRecordService;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.MedicalSalesRow;
import com.kratonsolution.belian.ui.component.MedicationRow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class MedicationPanel extends Tabpanel
{
	private SessionUtils utils = Springs.get(SessionUtils.class);

	private MedicalRecordService service = Springs.get(MedicalRecordService.class);

	private ProductService productService = Springs.get(ProductService.class);

	private NRCToolbar toolbar = new NRCToolbar();

	private Grid grid = new Grid();

	public MedicationPanel(DoctorAppointment appointment)
	{
		appendChild(toolbar);
		appendChild(grid);

		initToolbar(appointment);
		initGrid(appointment);
	}

	private void initToolbar(DoctorAppointment appointment)
	{
		if(appointment.getStatus().equals(DoctorAppointmentStatus.DONE))
			toolbar.disabled();
		
		toolbar.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(utils.getLocation() == null || utils.getCurrency() == null)
				{
					Clients.showNotification("Default Location & Currency not exist,Please go to setting to set it up.");
					return;
				}

				grid.getRows().appendChild(new MedicationRow(appointment.getPatient().isBpjs(),true));
			}
		});

		toolbar.getRemove().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Iterator<Component> iterator = grid.getRows().getChildren().iterator();
				while (iterator.hasNext())
				{
					Row row = (Row) iterator.next();
					if(RowUtils.isChecked(row, 0))
						iterator.remove();
				}
			}
		});

		toolbar.getClear().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				grid.getRows().getChildren().clear();
			}
		});
	}

	private void initGrid(DoctorAppointment appointment)
	{
		grid.appendChild(new Columns());
		grid.appendChild(new Rows());
		grid.getColumns().appendChild(new Column(null,null,"25px"));
		grid.getColumns().appendChild(new Column("Product",null,"200px"));
		grid.getColumns().appendChild(new Column("Quantity",null,"70px"));
		grid.getColumns().appendChild(new Column("UoM",null,"75px"));
		grid.getColumns().appendChild(new Column("Note",null));
		grid.setSpan("4");

		if(appointment.getRecord() != null && appointment.getRecord().getMedication() != null)
		{
			for(ClinicSalesItem item:appointment.getRecord().getMedication().getItems())
			{
				MedicalSalesRow row = new MedicalSalesRow(appointment.getPatient().isBpjs(), true);
				row.setItem(item);
				grid.getRows().appendChild(row);
			}
		}
	}

	public void store(DoctorAppointment appointment)
	{
		if(!grid.getRows().getChildren().isEmpty())
		{
			ClinicSales medication = new ClinicSales();
			medication.setCurrency(utils.getCurrency());
			medication.setCustomer(appointment.getPatient().getPerson());
			medication.setDate(appointment.getDate());
			medication.setOrganization(appointment.getCompany());
			medication.setPaid(false);
			medication.setSales(appointment.getDoctor().getPerson());
			medication.setTax(utils.getTax());
			medication.setBpjs(appointment.getPatient().isBpjs());
			medication.setPaid(medication.isBpjs());

			for(Component com:grid.getRows().getChildren())
			{
				MedicationRow row = (MedicationRow)com;

				if(row.getProduct() == null)
					throw new WrongValueException(com,"Product cannot be empty.");

				if(row.getItem().getQuantity().compareTo(BigDecimal.ZERO) <= 0)
					throw new WrongValueException(com,"Quantity cannot be 0 or less.");

				productService.checkStock(row.getProduct(), row.getItem().getQuantity());

				ClinicSalesItem item = new ClinicSalesItem();
				item.setCharge(row.getItem().getCharge());
				item.setDiscount(row.getItem().getDiscount());
				item.setMedication(medication);
				item.setMedicine(row.getProduct());
				item.setNote(row.getItem().getNote());
				item.setPrice(row.getItem().getPrice());
				item.setQuantity(row.getItem().getQuantity());

				medication.getItems().add(item);
			}

			appointment.getRecord().setMedication(medication);
		}
	}
}
