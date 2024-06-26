
package com.kratonsolution.belian.ui.healthcares.clinic.visit;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.healtcares.dm.Visit;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class VisitRenderer implements RowRenderer<Visit>
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	@Override
	public void render(Row row, Visit data, int index) throws Exception
	{
		if(data != null)
		{
			Checkbox checkbox = Components.checkbox(false);
			checkbox.setDisabled(!data.isEditable());
			
			row.appendChild(checkbox);
			row.appendChild(new Label(DateTimes.format(data.getDate())));
			row.appendChild(new Label(data.getPatient().getValue()));
			row.appendChild(new Label(data.getDoctor().getValue()));
			row.appendChild(new Label(data.getReason()));
			row.appendChild(new Label(data.getNote()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
