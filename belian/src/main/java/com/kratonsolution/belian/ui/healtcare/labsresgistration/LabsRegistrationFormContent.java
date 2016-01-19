/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.labsresgistration;

import java.sql.Date;
import java.util.Iterator;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.Dates;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.IndustrySegmentation;
import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.global.svc.CodeGenerator;
import com.kratonsolution.belian.healtcare.dm.LaboratoryBilling;
import com.kratonsolution.belian.healtcare.dm.LaboratoryBilling.Status;
import com.kratonsolution.belian.healtcare.dm.LaboratoryBillingItem;
import com.kratonsolution.belian.healtcare.dm.LaboratoryRegistration;
import com.kratonsolution.belian.healtcare.dm.LaboratoryRegistrationItem;
import com.kratonsolution.belian.healtcare.svc.LaboratoryRegistrationService;
import com.kratonsolution.belian.inventory.dm.Product.Type;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.DoctorBox;
import com.kratonsolution.belian.ui.component.PatientBox;
import com.kratonsolution.belian.ui.component.ProductBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class LabsRegistrationFormContent extends FormContent
{	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private CodeGenerator generator = Springs.get(CodeGenerator.class);
	
	private LaboratoryRegistrationService service = Springs.get(LaboratoryRegistrationService.class);
	
	private Listbox companys = Components.newSelect(utils.getOrganization());
	
	private Datebox date = Components.currentDatebox();
	
	private DoctorBox doctor = new DoctorBox();
	
	private PatientBox patient = new PatientBox();
	
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
				LabsRegistrationWindow window = (LabsRegistrationWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(patient.getPatient() == null)
					throw new WrongValueException(doctor,"Doctor cannot be empty");
				
				LaboratoryRegistration registration = new LaboratoryRegistration();
				registration.setDate(new Date(date.getValue().getTime()));
				registration.setDoctor(doctor.getDoctor());
				registration.setPatient(patient.getPatient());
				registration.setOrganization(utils.getOrganization());
				registration.setNumber(generator.generate(Dates.now(), utils.getOrganization(), Code.LABREG));
				
				LaboratoryBilling billing = new LaboratoryBilling();
				billing.setNumber(registration.getNumber());
				billing.setCurrency(utils.getCurrency());
				billing.setCustomer(registration.getPatient().getPerson());
				billing.setDate(registration.getDate());
				billing.setOrganization(utils.getOrganization());
				billing.setSales(registration.getDoctor()!=null?registration.getDoctor().getPerson():null);
				billing.setStatus(Status.REGISTERED);
				
				registration.setBilling(billing);
				
				for(Component com:details.getRows().getChildren())
				{
					Row row = (Row)com;
					
					LaboratoryRegistrationItem item = new LaboratoryRegistrationItem();
					item.setNote(RowUtils.string(row, 3));
					item.setQuantity(RowUtils.decimal(row, 2));
					item.setRegistration(registration);
					
					ProductBox box = (ProductBox)row.getChildren().get(1);
					item.setService(box.getProduct());
				
					LaboratoryBillingItem billingItem = new LaboratoryBillingItem();
					billingItem.setBilling(billing);
					billingItem.setCategory("Laboratory");
					billingItem.setHandled(false);
					billingItem.setNote(item.getNote());
					billingItem.setQuantity(item.getQuantity());
					billingItem.setResource(item.getService().getName());
					
					billing.getItems().add(billingItem);
				}
				
				service.add(registration);
				
				LabsRegistrationWindow window = (LabsRegistrationWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
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
	
	public void initDetails()
	{
		NRCToolbar toolbar = new NRCToolbar();
		
		details.appendChild(new Columns());
		details.appendChild(new Rows());
		details.setWidth("100%");
		details.getColumns().appendChild(new Column(null,null,"25px"));
		details.getColumns().appendChild(new Column("Service",null,"25px"));
		details.getColumns().appendChild(new Column("Quantity",null,"85px"));
		details.getColumns().appendChild(new Column("note",null,"160px"));
		details.setSpan("1");
		
		toolbar.getClear().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				details.getRows().getChildren().clear();
			}
		});
		
		toolbar.getRemove().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Iterator<Component> iterator = details.getChildren().iterator();
				while (iterator.hasNext())
				{
					Row row = (Row) iterator.next();
					if(RowUtils.isChecked(row, 0))
						iterator.remove();
				}
			}
		});

		toolbar.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Row row = new Row();
				row.appendChild(new Checkbox());
				row.appendChild(new ProductBox("MDC02", IndustrySegmentation.MEDICAL, Type.SERVICE));
				row.appendChild(Components.doubleBox(1));
				row.appendChild(Components.textBox(null));
				
				details.getRows().appendChild(row);
			}
		});
		
		appendChild(toolbar);
		appendChild(details);
	}
}
