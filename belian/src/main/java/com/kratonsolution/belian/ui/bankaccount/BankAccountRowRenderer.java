/**
 * 
 */
package com.kratonsolution.belian.ui.bankaccount;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.accounting.dm.BankAccount;

/**
 * @author agungdodiperdana
 *
 */
public class BankAccountRowRenderer implements RowRenderer<BankAccount>
{

	@Override
	public void render(Row row, BankAccount data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(data.getBank().getName()));
			row.appendChild(new Label(data.getHolder()));
			row.appendChild(new Label(data.isActive()?"Active":"Inactive"));
			row.appendChild(new Label(data.getId()));
		}
	}
}
