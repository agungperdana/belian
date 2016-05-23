package com.kratonsolution.belian.ui.sales.cashsales;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.Dates;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.sales.dm.CashSales;
import com.kratonsolution.belian.sales.srv.CashSalesService;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashSalesRowRenderer implements RowRenderer<CashSales>
{
	private CashSalesService service = Springs.get(CashSalesService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	@Override
	public void render(Row row, CashSales data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(Dates.format(data.getDate())));
			row.appendChild(new Label(data.getTable()+""));
			row.appendChild(new Label(Numbers.format(data.getBillingAmount().add(data.getTaxAmount()))));
			row.appendChild(new Label(data.isPaid()?"PAID":"UNPAID"));
			row.appendChild(new Label(data.getId()));
		}
	}
}
