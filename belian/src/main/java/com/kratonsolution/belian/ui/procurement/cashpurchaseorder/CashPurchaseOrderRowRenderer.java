package com.kratonsolution.belian.ui.procurement.cashpurchaseorder;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.procurement.dm.CashPurchaseOrder;
import com.kratonsolution.belian.ui.util.Dates;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashPurchaseOrderRowRenderer implements RowRenderer<CashPurchaseOrder>
{
	@Override
	public void render(Row row, CashPurchaseOrder data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(Dates.format(data.getDate())));
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(data.getOrganization().getName()));
			row.appendChild(new Label(data.getSupplier().getName()));
			row.appendChild(new Label(data.getPurchaser().getName()));
			row.appendChild(new Label(data.getRequest().getNumber()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
