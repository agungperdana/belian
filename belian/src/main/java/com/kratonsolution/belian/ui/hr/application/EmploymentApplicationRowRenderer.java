/**
 * 
 */
package com.kratonsolution.belian.ui.hr.application;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.hr.dm.EmploymentApplication;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class EmploymentApplicationRowRenderer implements RowRenderer<EmploymentApplication>
{
	@Override
	public void render(Row row, EmploymentApplication data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(DateTimes.format(data.getDate())));
			row.appendChild(new Label(data.getApplicant().getName()));
			row.appendChild(new Label(data.getPosition().getLabel()));
			row.appendChild(new Label(data.getStatusType().toString()));
			row.appendChild(new Label(data.getSourceType().toString()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
