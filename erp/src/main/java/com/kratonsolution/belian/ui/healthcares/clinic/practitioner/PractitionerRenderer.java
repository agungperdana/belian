
package com.kratonsolution.belian.ui.healthcares.clinic.practitioner;

import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.healtcares.dm.PractitionerProviderRelationship;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PractitionerRenderer implements RowRenderer<PractitionerProviderRelationship>
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	@Override
	public void render(Row row, PractitionerProviderRelationship data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(Components.checkbox(false));
			row.appendChild(new Label(DateTimes.format(data.getStart())));
			row.appendChild(new Label(data.getFromParty().getCode()));
			row.appendChild(new Label(data.getFromParty().getName()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
