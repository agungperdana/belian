/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.goodstransfer;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.inventory.dm.GoodsTransfer;
import com.kratonsolution.belian.ui.util.Dates;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GoodsTransferRowRenderer implements RowRenderer<GoodsTransfer>
{

	@Override
	public void render(Row row, GoodsTransfer data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(Dates.format(data.getDate())));
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(data.getSource().getName()));
			row.appendChild(new Label(data.getFacilityFrom().getName()));
			row.appendChild(new Label(data.getDestination().getName()));
			row.appendChild(new Label(data.getFacilityTo().getName()));
			row.appendChild(new Label(data.getRequest().getNumber()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
