/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.labschedule;

import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.healtcare.dm.Laboratory;
import com.kratonsolution.belian.ui.util.Dates;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class LabScheduleRowRenderer implements RowRenderer<Laboratory>
{
	@Override
	public void render(Row row, Laboratory data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(Dates.format(data.getDate())));
			row.appendChild(new Label(data.getCustomer().getName()));
			row.appendChild(new Label(data.getSales().getName()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
