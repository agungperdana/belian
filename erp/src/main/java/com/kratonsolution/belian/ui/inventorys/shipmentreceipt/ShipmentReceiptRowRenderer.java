
package com.kratonsolution.belian.ui.inventorys.shipmentreceipt;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.shipment.dm.ShipmentReceipt;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ShipmentReceiptRowRenderer implements RowRenderer<ShipmentReceipt>
{
	@Override
	public void render(Row row, ShipmentReceipt data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(DateTimes.format(data.getDate())));
			row.appendChild(new Label(data.getSource().getValue()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
