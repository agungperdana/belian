/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.labsresgistration;

import java.sql.Date;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.healtcare.dm.Laboratory;
import com.kratonsolution.belian.healtcare.dm.LaboratoryItem;
import com.kratonsolution.belian.healtcare.svc.LaboratoryRegistrationService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.MedicalServiceRow;
import com.kratonsolution.belian.ui.healtcare.doctor.DoctorBox;
import com.kratonsolution.belian.ui.healtcare.patient.PatientBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class LabsRegistrationFormContent extends FormContent
{	
	private LaboratoryRegistrationService service = Springs.get(LaboratoryRegistrationService.class);
	
	private Listbox companys = Components.newSelect(utils.getOrganization());
	
	private Datebox date = Components.currentDatebox();
	
	private DoctorBox doctor = new DoctorBox(true);
	
	private PatientBox patient = new PatientBox(true);
	
	private Textbox note = new Textbox();
	
	private Grid details = new Grid();
	
	public LabsRegistrationFormContent()
	{
		super();
		initToolbar();
		initForm();
		initDetails();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new LabsRegistrationGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(patient.getPatient() == null)
					throw new WrongValueException(patient,"Patient cannot be empty");
				
				Laboratory laboratory = new Laboratory();
				laboratory.setPersonal(true);
				laboratory.setCurrency(utils.getCurrency());
				laboratory.setCustomer(patient.getPatient().getPerson());
				laboratory.setDate(new Date(date.getValue().getTime()));
				laboratory.setNumber(generator.generate(laboratory.getDate(), utils.getOrganization(), Code.BLLAB));
				laboratory.setOrganization(utils.getOrganization());
				laboratory.setSales(doctor.getDoctor().getPerson());
				laboratory.setTax(utils.getTax());

				for(Component com:details.getRows().getChildren())
				{
					MedicalServiceRow row = (MedicalServiceRow)com;
					
					LaboratoryItem item = new LaboratoryItem();
					item.setCharge(row.getCharge());
					item.setDiscount(row.getDiscount());
					item.setLaboratory(laboratory);
					item.setService(row.getProduct());
					item.setNote(row.getNote());
					item.setPrice(row.getPrice(false,false));
					item.setQuantity(row.getQuantity());
					
					laboratory.getItems().add(item);
				}
				
				service.add(laboratory);
				
				Flow.next(getParent(), new LabsRegistrationGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Company"));
		row1.appendChild(companys);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Date"));
		row2.appendChild(date);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Doctor"));
		row3.appendChild(doctor);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Patient"));
		row4.appendChild(patient);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
	}
	
	private void initDetails()
	{
		NRCToolbar nrc = new NRCToolbar(details);
		
		details.appendChild(new Columns());
		details.appendChild(new Rows());
		details.getColumns().appendChild(new Column(null,null,"25px"));
		details.getColumns().appendChild(new Column("Product",null,"225px"));
		details.getColumns().appendChild(new Column("Quantity",null,"85px"));
		details.getColumns().appendChild(new Column("UoM",null,"85px"));
		details.getColumns().appendChild(new Column("Note",null));
		details.setSpan("1");
	
		nrc.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				details.getRows().appendChild(new MedicalServiceRow());
			}
		});
		
		appendChild(nrc);
		appendChild(details);
	}
}
