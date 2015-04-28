/**
 * 
 */
package com.kratonsolution.belian.ui.cashsales;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.sales.dm.CashSales;
import com.kratonsolution.belian.ui.util.Dates;

/**
 * @author agungdodiperdana
 *
 */
public class CashSalesRowRenderer implements RowRenderer<CashSales>
{

	@Override
	public void render(Row row, CashSales data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(Dates.format(data.getDate())));
			row.appendChild(new Label(data.getOrganization().getName()));
			row.appendChild(new Label(data.getProducer().getName()));
			row.appendChild(new Label(data.getConsumer().getName()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
