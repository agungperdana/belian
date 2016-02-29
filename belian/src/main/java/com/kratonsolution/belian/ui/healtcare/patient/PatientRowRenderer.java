/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.patient;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.healtcare.dm.Patient;
import com.kratonsolution.belian.ui.util.Dates;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PatientRowRenderer implements RowRenderer<Patient>
{
	@Override
	public void render(Row row, Patient data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(Dates.format(data.getStart())));
			row.appendChild(new Label(data.getFrom().getIdentity()));
			row.appendChild(new Label(data.getFrom().getName()));
			row.appendChild(new Label(data.getBpjs().getCard()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
