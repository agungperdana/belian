/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctortype;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.healtcare.dm.DoctorType;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorTypeRowRenderer implements RowRenderer<DoctorType>
{
	@Override
	public void render(Row row, DoctorType data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getCode()));
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getDescription()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
