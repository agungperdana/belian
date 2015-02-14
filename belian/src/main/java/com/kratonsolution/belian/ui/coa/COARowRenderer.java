/**
 * 
 */
package com.kratonsolution.belian.ui.coa;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.accounting.dm.GLAccount;

/**
 * @author agungdodiperdana
 *
 */
public class COARowRenderer implements RowRenderer<GLAccount>
{

	@Override
	public void render(Row row, GLAccount data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getNote()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
