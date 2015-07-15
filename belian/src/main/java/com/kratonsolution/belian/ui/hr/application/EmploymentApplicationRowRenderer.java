/**
 * 
 */
package com.kratonsolution.belian.ui.hr.application;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.hr.dm.EmploymentApplication;
import com.kratonsolution.belian.ui.util.Dates;

/**
 * @author agungdodiperdana
 *
 */
public class EmploymentApplicationRowRenderer implements RowRenderer<EmploymentApplication>
{
	@Override
	public void render(Row row, EmploymentApplication data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(Dates.format(data.getDate())));
			row.appendChild(new Label(data.getApplicant().getName()));
			row.appendChild(new Label(data.getPosition().getValue()));
			row.appendChild(new Label(data.getStatusType().toString()));
			row.appendChild(new Label(data.getSourceType().toString()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
