/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import java.util.Iterator;

import org.zkoss.zk.ui.Component;
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
import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.global.svc.CodeGenerator;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.Medication;
import com.kratonsolution.belian.healtcare.dm.MedicationItem;
import com.kratonsolution.belian.healtcare.svc.MedicalRecordService;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.MedicalProductRow;
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
	
	private CodeGenerator generator = Springs.get(CodeGenerator.class);
	
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
					
				grid.getRows().appendChild(new MedicalProductRow(utils.getLocation().getId(),appointment.getPatient().getPerson().getId(),utils.getCurrency().getId(),appointment.getPatient().isBpjs()));
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
		grid.getColumns().appendChild(new Column("Product",null,"225px"));
		grid.getColumns().appendChild(new Column("Quantity",null,"85px"));
		grid.getColumns().appendChild(new Column("UoM",null,"85px"));
		grid.getColumns().appendChild(new Column("Price",null,"135px"));
		grid.getColumns().appendChild(new Column("Disc",null,"95px"));
		grid.getColumns().appendChild(new Column("Charge",null,"95px"));
		grid.getColumns().appendChild(new Column("Note",null));
		grid.setSpan("1");
	}
	
	public void store(DoctorAppointment appointment)
	{
		for(Component com:grid.getRows().getChildren())
		{
			MedicalProductRow row = (MedicalProductRow)com;
			
			Medication medication = new Medication();
			medication.setCurrency(utils.getCurrency());
			medication.setCustomer(appointment.getPatient().getPerson());
			medication.setDate(appointment.getDate());
			medication.setNumber(generator.generate(appointment.getDate(), appointment.getCompany(), Code.BLMED));
			medication.setOrganization(appointment.getCompany());
			medication.setPaid(false);
			medication.setSales(appointment.getDoctor().getPerson());
			medication.setTax(utils.getTax());
			
			MedicationItem item = new MedicationItem();
			item.setCharge(row.getCharge());
			item.setDiscount(row.getDiscount());
			item.setMedication(medication);
			item.setMedicine(row.getProduct());
			item.setNote(row.getNote());
			item.setPrice(row.getPrice());
			item.setQuantity(row.getQuantity());
			
			medication.getItems().add(item);
			
			appointment.getRecord().setMedication(medication);
		}
	}
}
