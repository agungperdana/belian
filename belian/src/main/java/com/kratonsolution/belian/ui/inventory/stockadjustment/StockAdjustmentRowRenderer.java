/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.stockadjustment;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.inventory.dm.StockAdjustment;
import com.kratonsolution.belian.ui.util.Dates;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StockAdjustmentRowRenderer implements RowRenderer<StockAdjustment>
{

	@Override
	public void render(Row row, StockAdjustment data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(Dates.format(data.getDate())));
			row.appendChild(new Label(data.getOrganization().getName()));
			row.appendChild(new Label(data.getFacility().getName()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
