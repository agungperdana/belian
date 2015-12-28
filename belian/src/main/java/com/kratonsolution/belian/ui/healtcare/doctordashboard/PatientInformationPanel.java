/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import org.zkoss.zul.Auxhead;
import org.zkoss.zul.Auxheader;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Rows;

import com.google.common.base.Strings;
import com.kratonsolution.belian.healtcare.dm.Patient;
import com.kratonsolution.belian.healtcare.svc.PatientService;
import com.kratonsolution.belian.ui.util.Dates;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PatientInformationPanel extends Grid
{
	private PatientService service = Springs.get(PatientService.class);
	
	private Patient patient;
	
	public PatientInformationPanel(String patientId)
	{
		if(!Strings.isNullOrEmpty(patientId))
			this.patient = service.findOne(patientId);
		
		setWidth("100%");
		
		Auxhead auxhead = new Auxhead();
		Auxheader auxheader = new Auxheader("Patient Information");
		auxheader.setColspan(2);
		auxheader.setRowspan(1);
		auxhead.appendChild(auxheader);
		
		appendChild(new Rows());
		appendChild(new Columns());
		appendChild(auxhead);
		
		init();
	}
	
	private void init()
	{
		if(this.patient != null)
		{
			getColumns().appendChild(new Column(null,null,"125px"));
			getColumns().appendChild(new Column());
			setSpan("1");
			getRows().appendChild(RowUtils.row("Identity",patient.getPerson().getIdentity()));
			getRows().appendChild(RowUtils.row("Name",patient.getPerson().getName()));
			getRows().appendChild(RowUtils.row("Age",Dates.getAge(patient.getPerson().getBirthDate())));
			getRows().appendChild(RowUtils.row("Birth Place",patient.getPerson().getBirthPlace().getName()));
			getRows().appendChild(RowUtils.row("Birth Date",Dates.format(patient.getPerson().getBirthDate())));
			getRows().appendChild(RowUtils.row("Gender",patient.getPerson().getGender().toString()));
			getRows().appendChild(RowUtils.row("Status",patient.getPerson().getMaritalStatus().toString()));
			getRows().appendChild(RowUtils.row("BPJS Information",""));
			getRows().appendChild(RowUtils.row("Number",patient.getBpjs().getCard()));
		}
	}
}
