
package com.kratonsolution.belian.ui.inventorys.shipmentissuance;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.util.DateTimes;
import com.kratonsolution.belian.shipment.dm.ShipmentIssuance;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ShipmentIssuanceRowRenderer implements RowRenderer<ShipmentIssuance>
{
	@Override
	public void render(Row row, ShipmentIssuance data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(DateTimes.format(data.getDate())));
			row.appendChild(new Label(data.getDestination().getValue()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
