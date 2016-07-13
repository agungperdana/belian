/**
 * 
 */
package com.kratonsolution.belian.ui.education.courseattendance;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.education.dm.CourseAttendance;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CourseAttendanceRowRenderer implements RowRenderer<CourseAttendance>
{
	private Language lang = Springs.get(Language.class);
	
	@Override
	public void render(Row row, CourseAttendance data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(DateTimes.format(data.getDate())));
			row.appendChild(new Label(data.getSchedule().getRoom().getName()));
			row.appendChild(new Label(data.getSchedule().getRoom().getPeriod().getName()));
			row.appendChild(new Label(data.getSchedule().getDay()));
			row.appendChild(new Label(data.getSchedule().getRoom().getTime().getLabel()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
