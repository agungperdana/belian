/**
 * 
 */
package com.kratonsolution.belian.ui.production.workingtimesheet;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.effort.dm.Timesheet;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class WorkingTimesheetRowRenderer implements RowRenderer<Timesheet>
{

	@Override
	public void render(Row row, Timesheet data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(DateTimes.format(data.getStart())));
			row.appendChild(new Label(DateTimes.format(data.getEnd())));
			row.appendChild(new Label(data.getWorker().getParty().getName()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
