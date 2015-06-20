/**
 * 
 */
package com.kratonsolution.belian.ui.hr.position;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.hr.dm.Position;
import com.kratonsolution.belian.ui.util.Dates;

/**
 * @author agungdodiperdana
 *
 */
public class PositionRowRenderer implements RowRenderer<Position>
{
	@Override
	public void render(Row row, Position data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(Dates.format(data.getStart())));
			row.appendChild(new Label(Dates.format(data.getEnd())));
			row.appendChild(new Label(Dates.format(data.getActualStart())));
			row.appendChild(new Label(Dates.format(data.getActualEnd())));
			row.appendChild(new Label(data.getType().getTitle()));
			row.appendChild(new Label(data.getWorktimeStatus().name()));
			row.appendChild(new Label(data.getTemporaryStatus().name()));
			row.appendChild(new Label(data.getSalaryStatus().name()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
