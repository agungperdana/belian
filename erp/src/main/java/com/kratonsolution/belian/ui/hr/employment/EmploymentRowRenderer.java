
package com.kratonsolution.belian.ui.hr.employment;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.util.DateTimes;
import com.kratonsolution.belian.hr.dm.Employment;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class EmploymentRowRenderer implements RowRenderer<Employment>
{
	@Override
	public void render(Row row, Employment data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(DateTimes.format(data.getStart())));
			row.appendChild(new Label(DateTimes.format(data.getEnd())));
			row.appendChild(new Label(data.getFromParty().getName()));
			row.appendChild(new Label(data.getToParty().getName()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
