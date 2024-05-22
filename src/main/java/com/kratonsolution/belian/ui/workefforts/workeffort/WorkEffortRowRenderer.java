
package com.kratonsolution.belian.ui.workefforts.workeffort;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.util.Springs;
import com.kratonsolution.belian.workefforts.dm.WorkEffort;


/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class WorkEffortRowRenderer implements RowRenderer<WorkEffort>
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	@Override
	public void render(Row row, WorkEffort data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(DateTimes.format(data.getCreationDate())));
			row.appendChild(new Label(DateTimes.format(data.getScheduledStart())));
			row.appendChild(new Label(DateTimes.format(data.getActualStart())));
			row.appendChild(new Label(DateTimes.format(data.getScheduledEnd())));
			row.appendChild(new Label(DateTimes.format(data.getActualEnd())));
			row.appendChild(new Label(data.getType().display(utils.getLanguage())));
			row.appendChild(new Label(data.getPurpose().display(utils.getLanguage())));
			row.appendChild(new Label(data.getId()));
		}
	}
}
