/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctor;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.healtcare.dm.Doctor;
import com.kratonsolution.belian.ui.util.Dates;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorRowRenderer implements RowRenderer<Doctor>
{
	@Override
	public void render(Row row, Doctor data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(Dates.format(data.getFrom())));
			row.appendChild(new Label(data.getPerson().getIdentity()));
			row.appendChild(new Label(data.getCategory().getCode()));
			row.appendChild(new Label(data.getPerson().getName()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
