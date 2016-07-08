/**
 * 
 */
package com.kratonsolution.belian.ui.education.studytime;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.education.dm.StudyDay;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StudyDayRowRenderer implements RowRenderer<StudyDay>
{
	private Language lang = Springs.get(Language.class);
	
	@Override
	public void render(Row row, StudyDay data, int index) throws Exception
	{
		if(data != null)
		{
			StringBuilder builder = new StringBuilder();
			
			if(data.isMonday())
				builder.append(lang.get("generic.grid.column.monday")+",");
			if(data.isTuesday())
				builder.append(lang.get("generic.grid.column.tuesday")+",");
			if(data.isWednesday())
				builder.append(lang.get("generic.grid.column.wednesday")+",");
			if(data.isThursday())
				builder.append(lang.get("generic.grid.column.thursday")+",");
			if(data.isFriday())
				builder.append(lang.get("generic.grid.column.friday")+",");
			if(data.isSaturday())
				builder.append(lang.get("generic.grid.column.saturday")+",");
			
			row.appendChild(new Checkbox());
			row.appendChild(new Label(builder.toString()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
