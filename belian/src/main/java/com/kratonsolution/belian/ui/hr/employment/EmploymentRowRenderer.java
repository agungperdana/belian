/**
 * 
 */
package com.kratonsolution.belian.ui.hr.employment;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.general.dm.Employment;
import com.kratonsolution.belian.ui.util.Dates;

/**
 * @author agungdodiperdana
 *
 */
public class EmploymentRowRenderer implements RowRenderer<Employment>
{
	@Override
	public void render(Row row, Employment data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(Dates.format(data.getFrom())));
			row.appendChild(new Label(Dates.format(data.getTo())));
//			row.appendChild(new Label(data.getEmployee()));
//			row.appendChild(new Label(data.getEmployer()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
