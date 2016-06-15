/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import java.util.Iterator;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
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
import com.kratonsolution.belian.healtcare.dm.Treatment;
import com.kratonsolution.belian.healtcare.dm.TreatmentItem;
import com.kratonsolution.belian.healtcare.svc.MedicalRecordService;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.MedicalServiceRow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class TreatmentPanel extends Tabpanel
{
	private CodeGenerator generator = Springs.get(CodeGenerator.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
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
		toolbar.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				grid.getRows().appendChild(new MedicalServiceRow());
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
		if(!grid.getRows().getChildren().isEmpty())
		{
			Treatment treatment = new Treatment();
			treatment.setCurrency(utils.getCurrency());
			treatment.setCustomer(appointment.getPatient().getPerson());
			treatment.setDate(appointment.getDate());
			treatment.setNumber(generator.generate(appointment.getDate(), appointment.getCompany(), Code.BLTRE));
			treatment.setOrganization(appointment.getCompany());
			treatment.setPaid(false);
			treatment.setSales(appointment.getDoctor().getPerson());
			treatment.setTax(utils.getTax());
			treatment.setBpjs(appointment.getPatient().isBpjs());
			treatment.setPaid(treatment.isBpjs());
			
			for(Component com:grid.getRows().getChildren())
			{
				MedicalServiceRow row = (MedicalServiceRow)com;
				
				TreatmentItem item = new TreatmentItem();
				item.setService(row.getProduct());
				item.setCharge(row.getCharge());
				item.setDiscount(row.getDiscount());
				item.setTreatment(treatment);
				item.setNote(row.getNote());
				item.setPrice(row.getPrice(appointment.getPatient().isBpjs(),true));
				item.setQuantity(row.getQuantity());
				
				treatment.getItems().add(item);
			}
			
			appointment.getRecord().setTreatment(treatment);
		}
	}
}
