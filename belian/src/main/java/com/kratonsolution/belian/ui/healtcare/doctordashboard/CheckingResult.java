/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import java.sql.Date;

import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.MedicalRecord;
import com.kratonsolution.belian.healtcare.svc.MedicalRecordService;
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
	
	private Grid grid = new Grid();
	
	private Datebox datebox = Components.currentDatebox();
	
	private Textbox anamnesis = new Textbox();
	
	private Textbox checkingResult = new Textbox();
	
	private Textbox diagnosis = new Textbox();
	
	public CheckingResult(DoctorAppointment appointment)
	{
		appendChild(grid);
		initGrid(appointment);
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
		if(appointment.getRecord() != null)
		{
			datebox.setValue(appointment.getRecord().getDate());
			anamnesis.setText(appointment.getRecord().getAnamnesis());
			checkingResult.setText(appointment.getRecord().getCheckingResult());
			diagnosis.setText(appointment.getRecord().getDiagnosis());
		}
	}
	
	public void store(DoctorAppointment appointment)
	{
		if(appointment.getRecord() == null)
			appointment.setRecord(new MedicalRecord());
		
		appointment.getRecord().setDate(new Date(datebox.getValue().getTime()));
		appointment.getRecord().setAnamnesis(anamnesis.getText());
		appointment.getRecord().setCheckingResult(checkingResult.getText());
		appointment.getRecord().setDiagnosis(diagnosis.getText());
	}
}
