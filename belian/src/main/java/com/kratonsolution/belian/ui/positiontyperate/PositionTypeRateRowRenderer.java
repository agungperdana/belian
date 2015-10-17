/**
 * 
 */
package com.kratonsolution.belian.ui.positiontyperate;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.hr.dm.PositionTypeRate;
import com.kratonsolution.belian.ui.util.Dates;

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
			row.appendChild(new Label(Dates.format(data.getStart())));
			row.appendChild(new Label(Dates.format(data.getEnd())));
			row.appendChild(new Label(data.getPositionType().getLabel()));
			row.appendChild(new Label(data.getRateType().name()));
			row.appendChild(new Label(data.getPeriodType().name()));
			row.appendChild(new Label(data.getCurrency().getCode()+" "+data.getAmount()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
