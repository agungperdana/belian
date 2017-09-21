/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.goodreceive;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.inventory.dm.GoodsReceive;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GoodsReceiveRowRenderer implements RowRenderer<GoodsReceive>
{

	@Override
	public void render(Row row, GoodsReceive data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(DateTimes.format(data.getDate())));
			row.appendChild(new Label(data.getOrganization().getName()));
			row.appendChild(new Label(data.getDestination().getName()));
			row.appendChild(new Label(data.getReceiver().getName()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
