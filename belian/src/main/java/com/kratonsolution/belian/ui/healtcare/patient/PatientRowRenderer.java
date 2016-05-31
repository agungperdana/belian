/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.patient;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.healtcare.dm.PatientRelationship;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PatientRowRenderer implements RowRenderer<PatientRelationship>
{
	@Override
	public void render(Row row, PatientRelationship data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(DateTimes.format(data.getStart())));
			row.appendChild(new Label(DateTimes.format(data.getEnd())));
			row.appendChild(new Label(data.getPatient().getPerson().getIdentity()));
			row.appendChild(new Label(data.getPatient().getPerson().getName()));
			row.appendChild(new Label(data.getPatient().getBpjs().getCard()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
