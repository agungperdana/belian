/**
 * 
 */
package com.kratonsolution.belian.ui.budgettype;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.accounting.dm.BudgetType;

/**
 * @author agungdodiperdana
 *
 */
public class BudgetTypeRowRenderer implements RowRenderer<BudgetType>
{

	@Override
	public void render(Row row, BudgetType data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getDescription()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
