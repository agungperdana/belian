/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.budget;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.accounting.dm.Budget;
import com.kratonsolution.belian.common.Dates;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BudgetRowRenderer implements RowRenderer<Budget>
{

	@Override
	public void render(Row row, Budget data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getType().name()));
			row.appendChild(new Label(data.getOrganization().getName()));
			row.appendChild(new Label(Dates.format(data.getStart())));
			row.appendChild(new Label(Dates.format(data.getEnd())));
			row.appendChild(new Label(data.getComment()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
