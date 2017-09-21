/**
 * 
 */
package com.kratonsolution.belian.ui.inventorys.stockadjustment;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.inventory.dm.StockAdjustment;

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
			row.appendChild(new Label(DateTimes.format(data.getDate())));
			row.appendChild(new Label(DateTimes.format(data.getTime())));
			row.appendChild(new Label(data.getOrganization().getValue()));
			row.appendChild(new Label(data.getFacility().getValue()));
			row.appendChild(new Label(data.getNote()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
