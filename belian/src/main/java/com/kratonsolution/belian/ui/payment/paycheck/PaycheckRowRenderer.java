/**
 * 
 */
package com.kratonsolution.belian.ui.payment.paycheck;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.payment.dm.Paycheck;
import com.kratonsolution.belian.ui.util.Numbers;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PaycheckRowRenderer implements RowRenderer<Paycheck>
{

	@Override
	public void render(Row row, Paycheck data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(DateTimes.format(data.getDate())));
			row.appendChild(new Label(DateTimes.format(data.getStart())));
			row.appendChild(new Label(DateTimes.format(data.getEnd())));
			row.appendChild(new Label(data.getEmployment().getLabel()));
			row.appendChild(new Label(Numbers.format(data.getNetAmount())));
			row.appendChild(new Label(data.getId()));
		}
	}
}
