
package com.kratonsolution.belian.ui.inventorys.inventoryitem;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.util.DateTimes;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.ui.util.Numbers;


/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class InventoryItemRowRenderer implements RowRenderer<InventoryItem>
{
	@Override
	public void render(Row row, InventoryItem data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getProduct().getValue()));
			row.appendChild(new Label(Numbers.format(data.getOnhand())));
			row.appendChild(new Label(Numbers.format(data.getOnorder())));
			row.appendChild(new Label(data.getFacility().getValue()));
			row.appendChild(new Label(data.getContainer().getValue()));
			row.appendChild(new Label(data.getSerialNumber()));
			row.appendChild(new Label(DateTimes.format(data.getExpiredDate())));
			row.appendChild(new Label(data.getId()));
		}
	}
}
