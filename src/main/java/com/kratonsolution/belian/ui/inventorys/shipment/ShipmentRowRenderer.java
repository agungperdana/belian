
package com.kratonsolution.belian.ui.inventorys.shipment;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.shipment.dm.Shipment;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ShipmentRowRenderer implements RowRenderer<Shipment>
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	@Override
	public void render(Row row, Shipment data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(DateTimes.format(data.getEntryDate())));
			row.appendChild(new Label(data.getShipFromParty().getValue()));
			row.appendChild(new Label(data.getShipToParty().getValue()));
			row.appendChild(new Label(data.getType().display(utils.getLanguage())));
			row.appendChild(new Label(data.getId()));
		}
	}
}
