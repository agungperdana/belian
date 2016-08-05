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
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tabpanel;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointmentStatus;
import com.kratonsolution.belian.healtcare.dm.LaboratorySales;
import com.kratonsolution.belian.healtcare.dm.LaboratorySalesItem;
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
public class LaboratoriumPanel extends Tabpanel
{
	private Language lang = Springs.get(Language.class);
	
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
		if(appointment.getStatus().equals(DoctorAppointmentStatus.DONE))
			toolbar.disabled();
		
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
		grid.getColumns().appendChild(new Column(lang.get("doctordashboard.grid.column.product"),null,"200px"));
		grid.getColumns().appendChild(new Column(lang.get("doctordashboard.grid.column.quantity"),null,"70px"));
		grid.getColumns().appendChild(new Column(lang.get("doctordashboard.grid.column.uom"),null,"75px"));
		grid.getColumns().appendChild(new Column(lang.get("doctordashboard.grid.column.note"),null));
		grid.setSpan("4");
		
		if(appointment.getRecord() != null && appointment.getRecord().getLaboratory() != null)
		{
			for(LaboratorySalesItem item:appointment.getRecord().getLaboratory().getItems())
			{
				MedicalServiceRow row = new MedicalServiceRow();
				row.setItem(item);
				grid.getRows().appendChild(row);
			}
		}
	}
	
	public void store(DoctorAppointment appointment)
	{
		if(!grid.getRows().getChildren().isEmpty())
		{
			LaboratorySales laboratory = new LaboratorySales();
			laboratory.setPersonal(false);
			laboratory.setCurrency(utils.getCurrency());
			laboratory.setCustomer(appointment.getPatient().getPerson());
			laboratory.setDate(appointment.getDate());
			laboratory.setOrganization(appointment.getCompany());
			laboratory.setPaid(false);
			laboratory.setSales(appointment.getDoctor().getPerson());
			laboratory.setTax(utils.getTax());
			laboratory.setBpjs(appointment.getPatient().isBpjs());
			laboratory.setPaid(laboratory.isBpjs());
			
			for(Component com:grid.getRows().getChildren())
			{
				MedicalServiceRow row = (MedicalServiceRow)com;
				
				if(row.getProduct() == null)
					throw new WrongValueException(com,lang.get("message.field.empty"));
				
				if(row.getQuantity().compareTo(BigDecimal.ZERO) <= 0)
					throw new WrongValueException(com,lang.get("message.field.empty"));
				
				productService.checkStock(row.getProduct(), row.getQuantity());
				
				LaboratorySalesItem item = new LaboratorySalesItem();
				item.setService(row.getProduct());
				item.setCharge(row.getCharge());
				item.setDiscount(row.getDiscount());
				item.setLaboratory(laboratory);
				item.setNote(row.getNote());
				item.setPrice(row.getPrice(appointment.getPatient().isBpjs(),true,false));
				item.setQuantity(row.getQuantity());
				
				laboratory.getItems().add(item);
			}
			
			appointment.getRecord().setLaboratory(laboratory);
		}
	}
}
