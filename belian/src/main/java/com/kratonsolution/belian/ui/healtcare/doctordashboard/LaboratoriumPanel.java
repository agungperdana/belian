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
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.Laboratory;
import com.kratonsolution.belian.healtcare.dm.MedicalRecord;
import com.kratonsolution.belian.healtcare.svc.MedicalRecordService;
import com.kratonsolution.belian.inventory.dm.IndustrySegmentation;
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
public class LaboratoriumPanel extends Tabpanel
{
	private MedicalRecordService service = Springs.get(MedicalRecordService.class);
	
	private ProductService productService = Springs.get(ProductService.class);
	
	private Grid grid = new Grid();
	
	private NRCToolbar toolbar = new NRCToolbar(grid);
	
	public LaboratoriumPanel(DoctorAppointment appointment)
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
				Row row = new Row();
				row.appendChild(new Checkbox());
				row.appendChild(MedicationProductBox.getInstance(IndustrySegmentation.MEDICAL,Type.SERVICE));
				row.appendChild(Components.doubleBox(1l));
				row.appendChild(Components.textBox(""));
				
				grid.getRows().appendChild(row);
			}
		});
	
		Toolbarbutton save = new Toolbarbutton("Save","/icons/save.png");
		save.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				MedicalRecord record = service.findOneByAppointmentId(appointment.getId());
				if(record == null)
					record = new MedicalRecord();
				
				record.setAppointment(appointment);
				record.getLaboratorys().clear();
				
				service.edit(record);
				
				for(Component com:grid.getRows().getChildren())
				{
					Row row = (Row)com;
					
					MedicationProductBox box = (MedicationProductBox)row.getChildren().get(1);
					if(!Strings.isNullOrEmpty(box.getProductId()))
					{
						Laboratory lab = new Laboratory();
						lab.setDescription(RowUtils.string(row, 3));
						lab.setMedical(record);
						lab.setQuantity(RowUtils.decimal(row, 2));
						lab.setService(productService.findOne(box.getProductId()));
						
						record.getLaboratorys().add(lab);
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
			for(Laboratory laboratory:record.getLaboratorys())
			{
				MedicationProductBox box = MedicationProductBox.getInstance(IndustrySegmentation.MEDICAL,Type.SERVICE,laboratory.isBilled());
				box.productSeledted(laboratory.getService());

				Checkbox checkbox = new Checkbox();
				checkbox.setDisabled(laboratory.isBilled());
				
				Doublebox quan = Components.doubleBox(laboratory.getQuantity().doubleValue());
				quan.setDisabled(laboratory.isBilled());
					
				Row row = new Row();
				row.appendChild(checkbox);
				row.appendChild(box);
				row.appendChild(quan);
				row.appendChild(Components.textBox(laboratory.getDescription()));
				
				grid.getRows().appendChild(row);
			}
		}
	}
}
