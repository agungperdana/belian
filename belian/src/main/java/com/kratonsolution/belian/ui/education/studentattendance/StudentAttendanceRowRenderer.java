/**
 * 
 */
package com.kratonsolution.belian.ui.education.studentattendance;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.education.dm.CourseAttendance;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StudentAttendanceRowRenderer implements RowRenderer<CourseAttendance>
{
	private Language lang = Springs.get(Language.class);
	
	@Override
	public void render(Row row, CourseAttendance data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
//			row.appendChild(new Label(data.getPeriod().getName()));
//			row.appendChild(new Label(data.getDay().getLabel()));
//			row.appendChild(new Label(data.getTime().getLabel()));
//			row.appendChild(new Label(data.getProduct().getName()));
//			row.appendChild(new Label(data.getRoom().getName()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
