/**
 * 
 */
package com.kratonsolution.belian.ui.education.studyperiod;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.education.dm.StudyPeriod;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StudyPeriodRowRenderer implements RowRenderer<StudyPeriod>
{

	@Override
	public void render(Row row, StudyPeriod data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getNote()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
