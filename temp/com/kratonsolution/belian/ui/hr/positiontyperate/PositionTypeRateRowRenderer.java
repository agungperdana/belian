/**
 * 
 */
package com.kratonsolution.belian.ui.hr.positiontyperate;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.hr.dm.PositionTypeRate;
import com.kratonsolution.belian.ui.util.Numbers;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PositionTypeRateRowRenderer implements RowRenderer<PositionTypeRate>
{

	@Override
	public void render(Row row, PositionTypeRate data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(DateTimes.format(data.getStart())));
			row.appendChild(new Label(DateTimes.format(data.getEnd())));
			row.appendChild(new Label(data.getPositionType().getLabel()));
			row.appendChild(new Label(data.getRateType().display()));
			row.appendChild(new Label(data.getPeriodType().display()));
			row.appendChild(new Label(data.getCurrency().getCode()+" "+Numbers.format(data.getAmount())));
			row.appendChild(new Label(data.getId()));
		}
	}
}
