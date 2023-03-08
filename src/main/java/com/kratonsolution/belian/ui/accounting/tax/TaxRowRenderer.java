/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.tax;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.accounting.dm.Tax;
import com.kratonsolution.belian.ui.util.Numbers;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class TaxRowRenderer implements RowRenderer<Tax>
{

	@Override
	public void render(Row row, Tax data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getCode()));
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(Numbers.format(data.getAmount())));
			row.appendChild(new Label(data.getId()));
		}
	}
}
