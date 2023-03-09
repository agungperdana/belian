
package com.kratonsolution.belian.ui.orders.salesorder;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.orders.dm.SalesOrder;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SalesOrderRowRenderer implements RowRenderer<SalesOrder>
{
	@Override
	public void render(Row row, SalesOrder data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(DateTimes.format(data.getOrderDate())));
			row.appendChild(new Label(DateTimes.format(data.getEntryDate())));
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(data.getPartyTakingOrder().getValue()));
			row.appendChild(new Label(data.getPartyPlacingOrder()!=null?data.getPartyPlacingOrder().getValue():""));
			row.appendChild(new Label(data.getBillToParty()!=null?data.getBillToParty().getValue():""));
			row.appendChild(new Label(data.getId()));
		}
	}
}
