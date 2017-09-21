/**
 * 
 */
package com.kratonsolution.belian.ui.finance.invoices.purchase;

import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.invoice.dm.PurchaseInvoice;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PurchaseInvoiceRenderer implements RowRenderer<PurchaseInvoice>
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	@Override
	public void render(Row row, PurchaseInvoice data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(Components.checkbox(data.isPaid(),false));
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(DateTimes.format(data.getDate())));
			row.appendChild(new Label(data.getBilledFromParty().getValue()));
			row.appendChild(new Label(data.getBilledToParty().getValue()));
			row.appendChild(new Label(data.getMessage()));
			row.appendChild(new Label(data.getNote()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
