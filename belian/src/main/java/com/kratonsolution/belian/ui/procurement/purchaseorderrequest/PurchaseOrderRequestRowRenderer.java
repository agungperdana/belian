package com.kratonsolution.belian.ui.procurement.purchaseorderrequest;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.procurement.dm.PurchaseOrderRequest;
import com.kratonsolution.belian.ui.util.Dates;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PurchaseOrderRequestRowRenderer implements RowRenderer<PurchaseOrderRequest>
{
	@Override
	public void render(Row row, PurchaseOrderRequest data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(Dates.format(data.getDate())));
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(data.getRequester().getName()));
			row.appendChild(new Label(data.getApprover().getName()));
			row.appendChild(new Label(data.getApproverStatus().name()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
