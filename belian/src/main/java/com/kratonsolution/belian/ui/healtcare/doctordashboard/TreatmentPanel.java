/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Toolbarbutton;

import com.google.common.base.Strings;
import com.kratonsolution.belian.general.dm.IndustrySegmentation;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment.Status;
import com.kratonsolution.belian.healtcare.dm.MedicalRecord;
import com.kratonsolution.belian.healtcare.dm.Treatment;
import com.kratonsolution.belian.healtcare.svc.MedicalRecordService;
import com.kratonsolution.belian.inventory.dm.Product.Type;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.MedicationProductBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class TreatmentPanel extends Tabpanel
{
	private MedicalRecordService service = Springs.get(MedicalRecordService.class);
	
	private ProductService productService = Springs.get(ProductService.class);
	
	private Grid grid = new Grid();
	
	private NRCToolbar toolbar = new NRCToolbar(grid);
	
	public TreatmentPanel(DoctorAppointment appointment)
	{
		appendChild(toolbar);
		appendChild(grid);
		
		initToolbar(appointment);
		initGrid(appointment);
	}
	
	private void initToolbar(DoctorAppointment appointment)
	{
		if(!appointment.getStatus().equals(Status.PROGRESS))
			toolbar.disabled();
		
		toolbar.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Row row = new Row();
				row.appendChild(new Checkbox());
				row.appendChild(MedicationProductBox.getInstance(IndustrySegmentation.MEDICAL,Type.SERVICE));
				row.appendChild(Components.doubleBox(1l));
				row.appendChild(Components.textBox(""));
				
				grid.getRows().appendChild(row);
			}
		});
	
		Toolbarbutton save = new Toolbarbutton("Save","/icons/save.png");
		if(appointment.getStatus().equals(Status.DONE) || appointment.getStatus().equals(Status.CANCELED))
			save.setDisabled(true);
		save.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				MedicalRecord record = service.findOneByAppointmentId(appointment.getId());
				if(record == null)
					record = new MedicalRecord();
				
				record.setAppointment(appointment);
				record.getTreatments().clear();
				
				service.edit(record);
				
				for(Component com:grid.getRows().getChildren())
				{
					Row row = (Row)com;
					
					MedicationProductBox box = (MedicationProductBox)row.getChildren().get(1);
					if(!Strings.isNullOrEmpty(box.getProductId()))
					{
						Treatment treatment = new Treatment();
						treatment.setDescription(RowUtils.string(row, 3));
						treatment.setMedical(record);
						treatment.setQuantity(RowUtils.decimal(row, 2));
						treatment.setService(productService.findOne(box.getProductId()));
						
						record.getTreatments().add(treatment);
					}
				}
				
				service.edit(record);
				
				Clients.showNotification("Data successfully saved", Clients.NOTIFICATION_TYPE_INFO, null, null, 15, true);
			}
		});
		
		toolbar.appendChild(save);
	}
	
	private void initGrid(DoctorAppointment appointment)
	{
		grid.appendChild(new Rows());
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"25px"));
		grid.getColumns().appendChild(new Column("Service",null,"300px"));
		grid.getColumns().appendChild(new Column("Quantity",null,"75px"));
		grid.getColumns().appendChild(new Column("Note",null,null));
		
		MedicalRecord record = service.findOneByAppointmentId(appointment.getId());
		if(record != null && !record.getMedications().isEmpty())
		{
			for(Treatment treatment:record.getTreatments())
			{
				MedicationProductBox box = MedicationProductBox.getInstance(IndustrySegmentation.MEDICAL,Type.SERVICE,treatment.isBilled());
				box.productSeledted(treatment.getService());

				Checkbox checkbox = new Checkbox();
				checkbox.setDisabled(treatment.isBilled());
				
				Doublebox quan = Components.doubleBox(treatment.getQuantity().doubleValue());
				quan.setDisabled(treatment.isBilled());
				
				Row row = new Row();
				row.appendChild(checkbox);
				row.appendChild(box);
				row.appendChild(quan);
				row.appendChild(Components.textBox(treatment.getDescription()));
				
				grid.getRows().appendChild(row);
			}
		}
	}
}
