/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.labsresgistration;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.healtcare.dm.LaboratoryRegistration;
import com.kratonsolution.belian.ui.util.Dates;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class LabsRegistrationRowRenderer implements RowRenderer<LaboratoryRegistration>
{
	@Override
	public void render(Row row, LaboratoryRegistration data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(Dates.format(data.getDate())));
			row.appendChild(new Label(data.getPatient().getPerson().getName()));
			row.appendChild(new Label(data.getDoctor()!=null?data.getDoctor().getPerson().getName():""));
			row.appendChild(new Label((data.getBilling()!=null)?data.getBilling().getStatus().name():""));
			row.appendChild(new Label(data.getId()));
		}
	}
}
