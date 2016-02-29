/**
 * 
 */
package com.kratonsolution.belian.ui.hr.employment;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.general.dm.Employment;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class EmploymentRowRenderer implements RowRenderer<Employment>
{
	@Override
	public void render(Row row, Employment data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
//			row.appendChild(new Label(Dates.format(data.getFrom())));
//			row.appendChild(new Label(Dates.format(data.getTo())));
//			row.appendChild(new Label(data.getChild().getParty().getLabel()));
//			row.appendChild(new Label(data.getParent().getParty().getLabel()));
//			row.appendChild(new Label(data.getId()));
		}
	}
}
