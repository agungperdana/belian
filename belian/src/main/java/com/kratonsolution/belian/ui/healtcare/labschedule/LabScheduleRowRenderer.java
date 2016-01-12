/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.labschedule;

import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.healtcare.dm.LaboratoryBilling;
import com.kratonsolution.belian.ui.util.Dates;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class LabScheduleRowRenderer implements RowRenderer<LaboratoryBilling>
{
	@Override
	public void render(Row row, LaboratoryBilling data, int index) throws Exception
	{
		if(data != null)
		{
			Language language = Springs.get(Language.class);
			
			Label status = new Label();
			if(data.isFinish())
			{
				status.setValue(language.get("label.component.generic.done"));
				status.setStyle("font-weight:bolder;color:red;");
			}
			else
			{
				status.setValue(language.get("label.component.generic.wait"));
				status.setStyle("font-weight:bolder;color:green;");
			}
			
			row.appendChild(new Label(""));
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(Dates.format(data.getDate())));
			row.appendChild(new Label(data.getCustomer().getName()));
			row.appendChild(new Label(data.getSales().getName()));
			row.appendChild(status);
			row.appendChild(new Label(data.getId()));
		}
	}
}
