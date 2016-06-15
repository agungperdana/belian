/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctor;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.healtcare.dm.DoctorRelationship;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorRowRenderer implements RowRenderer<DoctorRelationship>
{
	@Override
	public void render(Row row, DoctorRelationship data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(DateTimes.format(data.getStart())));
			row.appendChild(new Label(DateTimes.format(data.getEnd())));
			row.appendChild(new Label(data.getDoctor().getPerson().getIdentity()));
			row.appendChild(new Label(data.getDoctor().getPerson().getName()));
			row.appendChild(new Label(data.getCategory()!=null?data.getCategory().getName():""));
			row.appendChild(new Label(data.getId()));
		}
	}
}
