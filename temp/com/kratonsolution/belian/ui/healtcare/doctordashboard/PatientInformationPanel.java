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

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.healtcare.dm.Patient;
import com.kratonsolution.belian.healtcare.svc.PatientService;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PatientInformationPanel extends Grid
{
	private PatientService service = Springs.get(PatientService.class);
	
	private Language lang = Springs.get(Language.class);
	
	public PatientInformationPanel(Patient patient)
	{
		setWidth("100%");
		
		Auxhead auxhead = new Auxhead();
		Auxheader auxheader = new Auxheader(lang.get("doctordashboard.grid.column.patientinfo"));
		auxheader.setColspan(2);
		auxheader.setRowspan(1);
		auxhead.appendChild(auxheader);
		
		appendChild(new Rows());
		appendChild(new Columns());
		appendChild(auxhead);
		
		init(patient);
	}
	
	private void init(Patient patient)
	{
		if(patient != null)
		{
			getColumns().appendChild(new Column(null,null,"125px"));
			getColumns().appendChild(new Column());
			setSpan("1");
			getRows().appendChild(RowUtils.row(lang.get("doctordashboard.grid.column.identity"),patient.getPerson().getIdentity()));
			getRows().appendChild(RowUtils.row(lang.get("doctordashboard.grid.column.name"),patient.getPerson().getName()));
			getRows().appendChild(RowUtils.row(lang.get("doctordashboard.grid.column.age"),DateTimes.getAge(patient.getPerson().getBirthDate())));
			getRows().appendChild(RowUtils.row(lang.get("doctordashboard.grid.column.birthplace"),patient.getPerson().getBirthPlace()!=null?patient.getPerson().getBirthPlace().getName():""));
			getRows().appendChild(RowUtils.row(lang.get("doctordashboard.grid.column.birthdate"),DateTimes.format(patient.getPerson().getBirthDate())));
			getRows().appendChild(RowUtils.row(lang.get("doctordashboard.grid.column.gender"),patient.getPerson().getGender().toString()));
			getRows().appendChild(RowUtils.row(lang.get("doctordashboard.grid.column.status"),patient.getPerson().getMaritalStatus().toString()));
			getRows().appendChild(RowUtils.row(lang.get("doctordashboard.grid.column.bpjsinfo"),""));
			getRows().appendChild(RowUtils.row(lang.get("doctordashboard.grid.column.number"),patient.getBpjs().getCard()));
			getRows().appendChild(RowUtils.row(lang.get("doctordashboard.grid.column.status"),patient.getBpjs().isActive()?"Active":"Inactive"));
		}
	}
}
