/**
 * 
 */
package com.kratonsolution.belian.ui.education.courseregistration;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.education.dm.CourseRegistration;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CourseRegistrationRowRenderer implements RowRenderer<CourseRegistration>
{
	private Language lang = Springs.get(Language.class);
	
	@Override
	public void render(Row row, CourseRegistration data, int index) throws Exception
	{
		if(data != null)
		{
			StringBuilder builder = new StringBuilder();

			if(data.getDay().isMonday())
				builder.append(lang.get("generic.grid.column.monday")+",");
			if(data.getDay().isTuesday())
				builder.append(lang.get("generic.grid.column.tuesday")+",");
			if(data.getDay().isWednesday())
				builder.append(lang.get("generic.grid.column.wednesday")+",");
			if(data.getDay().isThursday())
				builder.append(lang.get("generic.grid.column.thursday")+",");
			if(data.getDay().isFriday())
				builder.append(lang.get("generic.grid.column.friday")+",");
			if(data.getDay().isSaturday())
				builder.append(lang.get("generic.grid.column.saturday")+",");

			row.appendChild(new Checkbox());
			row.appendChild(new Label(DateTimes.format(data.getDate())));
			row.appendChild(new Label(data.getCustomer().getName()));
			row.appendChild(new Label(data.getPeriod().getName()));
			row.appendChild(new Label(builder.toString()));
			row.appendChild(new Label(DateTimes.format(data.getTime().getStart())+"-"+DateTimes.format(data.getTime().getEnd())));
			row.appendChild(new Label(data.getId()));
		}
	}
}
