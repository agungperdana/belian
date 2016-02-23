/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.transferrequest;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.inventory.dm.TransferOrderRequest;
import com.kratonsolution.belian.ui.util.Dates;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class TransferOrderRequestRowRenderer implements RowRenderer<TransferOrderRequest>
{
	@Override
	public void render(Row row, TransferOrderRequest data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(Dates.format(data.getDate())));
			row.appendChild(new Label(data.getRequester().getName()));
			row.appendChild(new Label(data.getRequestStatus().name()));
			row.appendChild(new Label(data.getApproverStatus().name()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
