/**
 * 
 */
package com.kratonsolution.belian.ui.education.studyroom;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.education.dm.StudyRoom;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StudyRoomRowRenderer implements RowRenderer<StudyRoom>
{
	private Language lang = Springs.get(Language.class);
	
	@Override
	public void render(Row row, StudyRoom data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(""));
			row.appendChild(new Label(data.getRoom().getLabel()));
			row.appendChild(new Label(data.getCourse().getLabel()));
			row.appendChild(new Label(data.getPeriod().getLabel()));
			row.appendChild(new Label(data.getDay().getLabel()));
			row.appendChild(new Label(data.getTime().getLabel()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
