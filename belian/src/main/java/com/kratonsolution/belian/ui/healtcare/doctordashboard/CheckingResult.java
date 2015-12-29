/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import java.sql.Date;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.MedicalRecord;
import com.kratonsolution.belian.healtcare.svc.MedicalRecordService;
import com.kratonsolution.belian.ui.FormToolbar;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CheckingResult extends Tabpanel
{
	private MedicalRecordService service = Springs.get(MedicalRecordService.class);
	
	private FormToolbar toolbar = new FormToolbar();
	
	private Grid grid = new Grid();
	
	private Datebox datebox = Components.currentDatebox();
	
	private Textbox anamnesis = new Textbox();
	
	private Textbox checkingResult = new Textbox();
	
	private Textbox diagnosis = new Textbox();
	
	public CheckingResult(DoctorAppointment appointment)
	{
		appendChild(toolbar);
		appendChild(grid);
	
		initToolbar(appointment);
		initGrid(appointment);
	}
	
	private void initToolbar(DoctorAppointment appointment)
	{
		toolbar.removeChild(toolbar.getCancel());
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				if(Strings.isNullOrEmpty(anamnesis.getText()))
					throw new WrongValueException(anamnesis,"Anamnesis cannot be empty.");
				
				if(Strings.isNullOrEmpty(checkingResult.getText()))
					throw new WrongValueException(checkingResult,"Checking Result cannot be empty.");
				
				if(Strings.isNullOrEmpty(diagnosis.getText()))
					throw new WrongValueException(diagnosis,"Diagnonis cannot be empty.");
				
				MedicalRecord record = service.findOneByAppointmentId(appointment.getId());
				if(record == null)
					record = new MedicalRecord();
				
				record.setDate(new Date(datebox.getValue().getTime()));
				record.setAnamnesis(anamnesis.getText());
				record.setAppointment(appointment);
				record.setCheckingResult(checkingResult.getText());
				record.setDiagnosis(diagnosis.getText());
				
				service.edit(record);
				
				Clients.showNotification("Data successfully saved", Clients.NOTIFICATION_TYPE_INFO, null, null, 15, true);
			}
		});
	}
	
	private void initGrid(DoctorAppointment appointment)
	{
		anamnesis.setRows(6);
		anamnesis.setCols(65);
		
		checkingResult.setRows(6);
		checkingResult.setCols(65);
		
		diagnosis.setRows(6);
		diagnosis.setCols(65);
		
		setValues(appointment);
		
		grid.setWidth("100%");
		grid.appendChild(new Rows());
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null, "125px"));
		grid.getColumns().appendChild(new Column());
		grid.getRows().appendChild(RowUtils.row("Date", datebox));
		grid.getRows().appendChild(RowUtils.row("Anamnesis", anamnesis));
		grid.getRows().appendChild(RowUtils.row("Checking Result", checkingResult));
		grid.getRows().appendChild(RowUtils.row("Diagnosis", diagnosis));
	}
	
	private void setValues(DoctorAppointment appointment)
	{
		MedicalRecord record = service.findOneByAppointmentId(appointment.getId());
		if(record != null)
		{
			datebox.setValue(record.getDate());
			anamnesis.setText(record.getAnamnesis());
			checkingResult.setText(record.getCheckingResult());
			diagnosis.setText(record.getDiagnosis());
		}
	}
}
