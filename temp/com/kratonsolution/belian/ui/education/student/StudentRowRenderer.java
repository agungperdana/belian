/**
 * 
 */
package com.kratonsolution.belian.ui.education.student;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.education.dm.StudentRelationship;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StudentRowRenderer implements RowRenderer<StudentRelationship>
{
	private Language lang = Springs.get(Language.class);
	
	@Override
	public void render(Row row, StudentRelationship data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getStudent().getParty().getIdentity()));
			row.appendChild(new Label(data.getStudent().getParty().getName()));
			row.appendChild(new Label(data.getStudent().getParentName()));
			row.appendChild(new Label(data.getStudent().getSchoolName()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
