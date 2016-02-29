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
import com.kratonsolution.belian.healtcare.dm.Laboratory;
import com.kratonsolution.belian.healtcare.dm.LaboratoryItem;
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
public class LaboratoriumPanel extends Tabpanel
{
	private CodeGenerator generator = Springs.get(CodeGenerator.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
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
				if(utils.getLocation() == null || utils.getCurrency() == null)
				{
					Clients.showNotification("Default Location & Currency not exist,Please go to setting to set it up.");
					return;
				}
					
				grid.getRows().appendChild(new MedicalProductRow(utils.getLocation().getId(),appointment.getPatient().getFrom().getId(),utils.getCurrency().getId(),appointment.getPatient().isBpjs()));
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
	}
	
	public void store(DoctorAppointment appointment)
	{
		for(Component com:grid.getRows().getChildren())
		{
			MedicalProductRow row = (MedicalProductRow)com;
			
			Laboratory laboratory = new Laboratory();
			laboratory.setCurrency(utils.getCurrency());
			laboratory.setCustomer(appointment.getPatient().getFrom());
			laboratory.setDate(appointment.getDate());
			laboratory.setNumber(generator.generate(appointment.getDate(), appointment.getCompany(), Code.BLLAB));
			laboratory.setOrganization(appointment.getCompany());
			laboratory.setPaid(false);
			laboratory.setSales(appointment.getDoctor().getFrom());
			laboratory.setTax(utils.getTax());
			laboratory.setBpjs(appointment.getPatient().isBpjs());
			laboratory.setPaid(laboratory.isBpjs());
			
			LaboratoryItem item = new LaboratoryItem();
			item.setCharge(row.getCharge());
			item.setDiscount(row.getDiscount());
			item.setLaboratory(laboratory);
			item.setService(row.getProduct());
			item.setNote(row.getNote());
			item.setPrice(row.getPrice());
			item.setQuantity(row.getQuantity());
			
			laboratory.getItems().add(item);
			
			appointment.getRecord().setLaboratory(laboratory);
		}
	}
}
