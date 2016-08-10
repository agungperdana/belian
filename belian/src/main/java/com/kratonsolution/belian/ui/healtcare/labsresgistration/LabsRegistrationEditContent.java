/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.labsresgistration;

import java.util.Iterator;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.healtcare.dm.LaboratorySales;
import com.kratonsolution.belian.healtcare.dm.LaboratorySalesItem;
import com.kratonsolution.belian.healtcare.svc.DoctorService;
import com.kratonsolution.belian.healtcare.svc.LaboratorySalesService;
import com.kratonsolution.belian.healtcare.svc.PatientService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.MedicationRow;
import com.kratonsolution.belian.ui.healtcare.doctor.DoctorBox;
import com.kratonsolution.belian.ui.healtcare.patient.PatientBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class LabsRegistrationEditContent extends FormContent
{	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private LaboratorySalesService service = Springs.get(LaboratorySalesService.class);
	
	private DoctorService doctorService = Springs.get(DoctorService.class);
	
	private PatientService patientService = Springs.get(PatientService.class);

	private Listbox companys = Components.newSelect();

	private Datebox date = Components.datebox();

	private DoctorBox doctor = new DoctorBox(false);

	private PatientBox patient = new PatientBox(false);

	private Textbox note = new Textbox();
	
	private Textbox number = Components.readOnlyTextBox();

	private Grid details = new Grid();

	private NRCToolbar nrc = new NRCToolbar();

	private Row row;

	public LabsRegistrationEditContent(Row row)
	{
		super();
		this.row = row;
		initToolbar();
		initForm();
		initNRC();
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
				window.removeEditForm();
				window.insertGrid();
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				LaboratorySales laboratory = service.findOne(RowUtils.string(row, 6));
				if(laboratory != null && !laboratory.isPaid())
				{
					laboratory.getItems().clear();
					service.edit(laboratory);
					
					for(Component com:details.getRows().getChildren())
					{
						MedicationRow row = (MedicationRow)com;
						
						LaboratorySalesItem item = new LaboratorySalesItem();
						item.setCharge(row.getItem().getCharge());
						item.setDiscount(row.getItem().getDiscount());
						item.setLaboratory(laboratory);
						item.setService(row.getProduct());
						item.setNote(row.getItem().getNote());
						item.setPrice(row.getItem().getPrice());
						item.setQuantity(row.getItem().getQuantity());
						
						laboratory.getItems().add(item);
					}
					
					service.edit(laboratory);
				}

				LabsRegistrationWindow window = (LabsRegistrationWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		LaboratorySales lab = service.findOne(RowUtils.string(row, 6));
		if(lab != null)
		{
			number.setWidth("300px");
			number.setText(lab.getNumber());
			
			companys.appendItem(lab.getOrganization().getName(), lab.getOrganization().getId());
			companys.setSelectedIndex(0);
			
			date.setValue(lab.getDate());
			doctor.setDoctor(lab.getSales());
			patient.setPatient((Person)lab.getCustomer());
			
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"75px"));
			grid.getColumns().appendChild(new Column());
			
			Row row0 = new Row();
			row0.appendChild(new Label("Number"));
			row0.appendChild(number);
			
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
			
			rows.appendChild(row0);
			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
			rows.appendChild(row4);
		}
	}
	
	private void initNRC()
	{
		LaboratorySales lab = service.findOne(RowUtils.string(row, 6));
		if(lab != null && !lab.isPaid())
		{
			appendChild(nrc);
			nrc.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					if(utils.getLocation() == null || utils.getCurrency() == null)
					{
						Clients.showNotification("Default Location & Currency not exist,Please go to setting to set it up.");
						return;
					}
					
					if(patient.getPatient() == null)
					{
						Clients.showNotification("Patient cannot be empty.");
						return;
					}
						
					details.getRows().appendChild(new MedicationRow(patient.getPatient().isBpjs(),true));
				}
			});
			
			nrc.getRemove().addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					Iterator<Component> iterator = details.getRows().getChildren().iterator();
					while (iterator.hasNext())
					{
						Row row = (Row) iterator.next();
						if(RowUtils.isChecked(row, 0))
							iterator.remove();
					}
				}
			});
			
			nrc.getClear().addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					details.getRows().getChildren().clear();
				}
			});
		}
	}
	
	private void initDetails()
	{
		appendChild(details);
		details.appendChild(new Columns());
		details.appendChild(new Rows());
		details.getColumns().appendChild(new Column(null,null,"25px"));
		details.getColumns().appendChild(new Column("Product",null,"225px"));
		details.getColumns().appendChild(new Column("Quantity",null,"85px"));
		details.getColumns().appendChild(new Column("UoM",null,"85px"));
		details.getColumns().appendChild(new Column("Price",null,"135px"));
		details.getColumns().appendChild(new Column("Disc",null,"95px"));
		details.getColumns().appendChild(new Column("Charge",null,"95px"));
		details.getColumns().appendChild(new Column("Note",null));
		details.setSpan("1");
		
		LaboratorySales lab = service.findOne(RowUtils.string(row, 6));
		if(lab != null)
		{
			for(LaboratorySalesItem item:lab.getItems())
			{
				MedicationRow row = new MedicationRow(patient.getPatient().isBpjs(),true);
				row.setItem(item);
				
				details.getRows().appendChild(row);
			}
		}
	}
}
