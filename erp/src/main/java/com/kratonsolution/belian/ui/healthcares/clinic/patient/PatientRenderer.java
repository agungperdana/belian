
package com.kratonsolution.belian.ui.healthcares.clinic.patient;

import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.util.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.healtcares.dm.PatientProviderRelationship;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PatientRenderer implements RowRenderer<PatientProviderRelationship>
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	@Override
	public void render(Row row, PatientProviderRelationship data, int index) throws Exception
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
