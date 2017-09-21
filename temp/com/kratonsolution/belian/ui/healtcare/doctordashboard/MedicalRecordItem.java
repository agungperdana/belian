/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.MedicalRecord;
import com.kratonsolution.belian.healtcare.dm.Patient;
import com.kratonsolution.belian.healtcare.svc.MedicalRecordService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class MedicalRecordItem extends Treeitem
{
	private Language lang = Springs.get(Language.class);
	
	private MedicalRecordService service = Springs.get(MedicalRecordService.class);
	
	private Treechildren treechildren = new Treechildren();

	public MedicalRecordItem(DoctorAppointment appointment,Component layout)
	{
		super("Medical Record Information");
		setImage("/icons/medical-record-info.png");
		appendChild(new Treechildren());
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				initHistorys(appointment.getPatient(),layout);
			}
		});
	}

	private void initHistorys(Patient patient,Component layout)
	{
		layout.getChildren().clear();
		layout.appendChild(initGrid(patient));
	}
	
	private Component initGrid(Patient patient)
	{
		Vlayout vlayout = new Vlayout();
		vlayout.setStyle("overflow:auto");
		
		Grid grid = new Grid();
		grid.setWidth("100%");
		grid.appendChild(new Columns());
		grid.appendChild(new Rows());
		grid.getColumns().appendChild(new Column(lang.get("doctordashboard.grid.column.date"),null,"85px"));
		grid.getColumns().appendChild(new Column(lang.get("doctordashboard.grid.column.doctor"),null,"150px"));
		grid.getColumns().appendChild(new Column(lang.get("doctordashboard.grid.column.anamnesis"),null,"150px"));
		grid.getColumns().appendChild(new Column(lang.get("doctordashboard.grid.column.checkresult"),null,"150px"));
		grid.getColumns().appendChild(new Column(lang.get("doctordashboard.grid.column.diagnosis"),null,"150px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().getLastChild().setVisible(false);
		grid.setSpan("4");
		grid.setEmptyMessage(lang.get("message.grid.empty"));
		
		for(MedicalRecord record:service.findAllByPatientId(patient.getId()))
		{
			Row row = new Row();
			row.appendChild(new Label(DateTimes.format(record.getDate())));
			row.appendChild(new Label(record.getAppointment().getDoctor().getPerson().getName()));
			row.appendChild(new Label(record.getAnamnesis()));
			row.appendChild(new Label(record.getCheckingResult()));
			row.appendChild(new Label(record.getDiagnosis()));
			row.appendChild(new Label(record.getId()));
			
			grid.getRows().appendChild(row);
		}
		
		vlayout.appendChild(grid);
		
		return vlayout;
	}
}
