package com.kratonsolution.belian.ui.sales.cashsales;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.sales.dm.CashSales;
import com.kratonsolution.belian.sales.srv.CashSalesService;
import com.kratonsolution.belian.ui.GridContent;
import com.kratonsolution.belian.ui.PrintWindow;
import com.kratonsolution.belian.ui.util.Dates;
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
			Label status = new Label(data.getStatus().name());
			
			if(data.getStatus().equals(CashSales.Status.UNPAID))
				status.setStyle("font-weight:bold;color:red");
			else
				status.setStyle("font-weight:bold;color:green");
			
			Button paid = new Button(null,"/icons/paid.png");
			paid.addEventListener(Events.ON_CLICK,new EventListener()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					service.addPayment(data);
					
					PrintWindow print = new PrintWindow("/cashsalesprint.htm?id="+data.getId());
					print.setPage(row.getPage());
					print.setVisible(true);
					
					if(row.getParent().getParent().getParent() instanceof GridContent)
						((GridContent)row.getParent().getParent().getParent()).refresh(new CashSalesModel(utils.getRowPerPage()));
				}
			});
			
			Image print = new Image("/icons/print.png");
			print.setStyle("cursor:pointer;");
			print.addEventListener(Events.ON_CLICK,new EventListener()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					PrintWindow print = new PrintWindow("/cashsalesprint.htm?id="+data.getId());
					print.setPage(row.getPage());
					print.setVisible(true);
				}
			});
			
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(Dates.format(data.getDate())));
			row.appendChild(new Label(data.getTable()+""));
			row.appendChild(new Label(Numbers.format(data.getBill().add(data.getTaxAmount()))));
			row.appendChild(status);
			
			if(data.getStatus().equals(CashSales.Status.UNPAID))
				row.appendChild(paid);
			else
				row.appendChild(print);
			
			row.appendChild(new Label(data.getId()));
		}
	}
}
