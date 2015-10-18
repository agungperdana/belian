/**
 * 
 */
package com.kratonsolution.belian.ui.paygrade;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.hr.dm.PayGrade;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PayGradeRowRenderer implements RowRenderer<PayGrade>
{

	@Override
	public void render(Row row, PayGrade data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getComment()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
