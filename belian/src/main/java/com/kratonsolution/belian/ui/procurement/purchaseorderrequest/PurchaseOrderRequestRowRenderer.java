package com.kratonsolution.belian.ui.procurement.purchaseorderrequest;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.global.dm.RoledType;
import com.kratonsolution.belian.procurement.dm.PORRole;
import com.kratonsolution.belian.procurement.dm.PurchaseOrderRequest;

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
			String requester = "Unknown";
			
			for(PORRole role:data.getRoles())
			{
				if(role.getType().equals(RoledType.Initiator))
				{
					requester = role.getParty().getName();
					break;
				}
			}
			
			row.appendChild(new Checkbox());
			row.appendChild(new Label(DateTimes.format(data.getDate())));
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(requester));
			row.appendChild(new Label(data.getLastStatus().getType().name()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
