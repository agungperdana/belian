/**
 * 
 */
package com.kratonsolution.belian.ui.payment.discount;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.payment.dm.Discount;
import com.kratonsolution.belian.ui.util.Numbers;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DiscountRowRenderer implements RowRenderer<Discount>
{

	@Override
	public void render(Row row, Discount data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(DateTimes.format(data.getStart())));
			row.appendChild(new Label(DateTimes.format(data.getEnd())));
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(Numbers.format(data.getAmount())+(data.isPercent()?"%":"")));
			row.appendChild(new Label(data.getId()));
		}
	}
}
