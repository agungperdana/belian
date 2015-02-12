/**
 * 
 */
package com.kratonsolution.belian.ui.cashaccount;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.accounting.dm.CashAccount;

/**
 * @author agungdodiperdana
 *
 */
public class CashAccountRowRenderer implements RowRenderer<CashAccount>
{

	@Override
	public void render(Row row, CashAccount data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getCurrency().getCode()));
			row.appendChild(new Label(data.getOwner().getName()));
			row.appendChild(new Label(data.isActive()?"Active":"Inactive"));
			row.appendChild(new Label(data.getId()));
		}
	}
}
