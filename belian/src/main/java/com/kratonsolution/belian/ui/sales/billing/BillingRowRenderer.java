/**
 * 
 */
package com.kratonsolution.belian.ui.sales.billing;

import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.sales.dm.Billable;
import com.kratonsolution.belian.ui.util.Numbers;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BillingRowRenderer implements RowRenderer<Billable>
{
	@Override
	public void render(Row row, Billable data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(data.getCustomer().getName()));
			row.appendChild(new Label(Numbers.format(data.getBillingAmount())));
			row.appendChild(new Label(data.getCurrency().getCode()));
			row.appendChild(new Label(data.isPaid()?"PAID":"UNPAID"));
			row.appendChild(new Label(data.getBillingType()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
