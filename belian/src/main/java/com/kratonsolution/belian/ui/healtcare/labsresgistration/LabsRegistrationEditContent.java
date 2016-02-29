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
import com.kratonsolution.belian.healtcare.dm.Laboratory;
import com.kratonsolution.belian.healtcare.dm.LaboratoryItem;
import com.kratonsolution.belian.healtcare.svc.DoctorService;
import com.kratonsolution.belian.healtcare.svc.LaboratoryRegistrationService;
import com.kratonsolution.belian.healtcare.svc.PatientService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.DoctorBox;
import com.kratonsolution.belian.ui.component.DoctorComboItem;
import com.kratonsolution.belian.ui.component.MedicalProductRow;
import com.kratonsolution.belian.ui.component.PatientBox;
import com.kratonsolution.belian.ui.component.PatientComboItem;
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
	
	private LaboratoryRegistrationService service = Springs.get(LaboratoryRegistrationService.class);
	
	private DoctorService doctorService = Springs.get(DoctorService.class);
	
	private PatientService patientService = Springs.get(PatientService.class);

	private Listbox companys = Components.newSelect();

	private Datebox date = Components.datebox();

	private DoctorBox doctor = new DoctorBox();

	private PatientBox patient = new PatientBox();

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
				Laboratory laboratory = service.findOne(RowUtils.string(row, 6));
				if(laboratory != null && !laboratory.isPaid())
				{
					laboratory.getItems().clear();
					service.edit(laboratory);
					
					for(Component com:details.getRows().getChildren())
					{
						MedicalProductRow row = (MedicalProductRow)com;
						
						LaboratoryItem item = new LaboratoryItem();
						item.setCharge(row.getCharge());
						item.setDiscount(row.getDiscount());
						item.setLaboratory(laboratory);
						item.setService(row.getProduct());
						item.setNote(row.getNote());
						item.setPrice(row.getPrice());
						item.setQuantity(row.getQuantity());
						
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
		Laboratory lab = service.findOne(RowUtils.string(row, 6));
		if(lab != null)
		{
			number.setWidth("300px");
			number.setText(lab.getNumber());
			
			companys.appendItem(lab.getOrganization().getName(), lab.getOrganization().getId());
			companys.setSelectedIndex(0);
			
			date.setValue(lab.getDate());
			
			doctor.appendChild(new DoctorComboItem(doctorService.findOne(lab.getSales().getId(), lab.getOrganization().getId())));
			doctor.setSelectedIndex(0);

			patient.appendChild(new PatientComboItem(patientService.findOne(lab.getCustomer().getId(), lab.getOrganization().getId())));
			patient.setSelectedIndex(0);
			
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
		Laboratory lab = service.findOne(RowUtils.string(row, 6));
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
						
					details.getRows().appendChild(new MedicalProductRow(utils.getLocation().getId(),patient.getPatient().getFrom().getId(),utils.getCurrency().getId(),patient.getPatient().isBpjs()));
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
		
		Laboratory lab = service.findOne(RowUtils.string(row, 6));
		if(lab != null)
		{
			for(LaboratoryItem item:lab.getItems())
			{
				MedicalProductRow row = new MedicalProductRow(utils.getLocation().getId(), lab.getCustomer().getId(), utils.getCurrency().getId(), patient.getPatient().isBpjs());
				row.setCharge(item.getCharge());
				row.setDiscount(item.getDiscount());
				row.setPrice(item.getPrice());
				row.setQuantity(item.getQuantity());
				row.setProduct(item.getService());
				row.setNote(item.getNote());
				
				details.getRows().appendChild(row);
			}
		}
	}
}
