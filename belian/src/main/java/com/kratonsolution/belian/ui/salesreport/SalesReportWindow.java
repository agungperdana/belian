/**
 * 
 */
package com.kratonsolution.belian.ui.salesreport;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Auxhead;
import org.zkoss.zul.Auxheader;
import org.zkoss.zul.Button;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Foot;
import org.zkoss.zul.Footer;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.sales.dm.CashSales;
import com.kratonsolution.belian.sales.dm.CashSalesLine;
import com.kratonsolution.belian.sales.dm.CashSalesPayment;
import com.kratonsolution.belian.sales.srv.CashSalesService;
import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.nav.IconBar;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SalesReportWindow extends AbstractWindow
{
	private Language language = Springs.get(Language.class);
	
	private Caption caption = new Caption(language.get("navbar.menu.sales.salesreport"));

	private SalesReportButton status = new SalesReportButton();

	private CashSalesService service = Springs.get(CashSalesService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Vbox vbox = new Vbox();
	
	private Hbox hbox = new Hbox();
	
	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.currentDatebox();

	private Checkbox all = new Checkbox("All");
	
	private Button search = new Button("Generate");
	
	private Vlayout content = new Vlayout();
	
	public static SalesReportWindow injectInto(Page page)
	{
		SalesReportWindow window = new SalesReportWindow();
		window.setPage(page);
		window.init();

		return window;
	}

	private SalesReportWindow()
	{
		super();
	}
	
	private void init()
	{
		start.setHeight("40px");
		end.setHeight("40px");
		
		content.setWidth("100%");
		content.setStyle("overflow:auto;");
		
		hbox.setWidth("100%");
		hbox.appendChild(new Label("Start"));
		hbox.appendChild(start);
		hbox.appendChild(new Label("End"));
		hbox.appendChild(end);
		hbox.appendChild(all);
		hbox.appendChild(search);
		
		vbox.setStyle("overflow:auto");
		vbox.setWidth("100%");
		vbox.appendChild(hbox);
		vbox.appendChild(content);
		
		caption.setImage("/icons/salesreport.png");
		insertStatus();
		status.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(!isVisible())
					setVisible(true);
				else
					setTopmost();
			}
		});
		
		search.addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				content.getChildren().clear();
				generate();
			}
		});
		
		appendChild(caption);
		appendChild(vbox);
	}
	
	private void generate()
	{
		DecimalFormat decimalFormat = new DecimalFormat(",###");
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		
		Grid grid = new Grid();
		grid.setWidth("100%");
		
		Auxhead auxhead = new Auxhead();
		Auxheader auxheader = new Auxheader("Transaction for date ["+format.format(start.getValue())+" to "+format.format(end.getValue())+"]");
		auxheader.setColspan(4);
		
		auxhead.appendChild(auxheader);
		grid.appendChild(auxhead);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column("Resource Name",null,"175px"));
		grid.getColumns().appendChild(new Column("Item(s)",null,"85px"));
		grid.getColumns().appendChild(new Column("Unit Price",null,"100px"));
		grid.getColumns().appendChild(new Column("Amount",null,"100px"));
		
		grid.appendChild(new Rows());
		
		BigDecimal totalIncome = BigDecimal.ZERO;
		BigDecimal totalTax = BigDecimal.ZERO;
		
		List<CashSales> saleses = service.findAllByDateBetween(new Date(start.getValue().getTime()),new Date(end.getValue().getTime()),utils.getOrganizationIds());
		for(CashSales cashSales:saleses)
		{
			if(all.isChecked())
			{
				for(CashSalesLine line:cashSales.getDecrements())
				{
					Row row = new Row();
					row.appendChild(new Label(line.getProduct().getLabel()));
					row.appendChild(new Label(decimalFormat.format(line.getQuantity())));
					row.appendChild(new Label(decimalFormat.format(line.getPrice())));
					row.appendChild(new Label(decimalFormat.format(line.getQuantity().multiply(line.getPrice()))));
					
					grid.getRows().appendChild(row);
				}
			}
			else
			{
				for(CashSalesPayment payment:cashSales.getIncrements())
				{
					Row cash = new Row();
					cash.appendChild(new Label(payment.getCashEvent().getResource().getName()));
					cash.appendChild(new Label(cashSales.getDecrements().size()+""));
					cash.appendChild(new Label(""));
					cash.appendChild(new Label(decimalFormat.format(payment.getCashEvent().getAmount())));
					
					grid.getRows().appendChild(cash);
					
					if(payment.getTaxEvent().getAmount().compareTo(BigDecimal.ZERO) > 0)
					{
						Row tax = new Row();
						tax.appendChild(new Label(payment.getTaxEvent().getResource().getName()));
						tax.appendChild(new Label(cashSales.getDecrements().size()+""));
						tax.appendChild(new Label(""));
						tax.appendChild(new Label(decimalFormat.format(payment.getTaxEvent().getAmount())));
						
						grid.getRows().appendChild(tax);
					}
				}
			}
			
			totalIncome = totalIncome.add(cashSales.getBill());
			totalTax = totalTax.add(cashSales.getTaxAmount());
		}
		
		Foot totals = new Foot();
		Footer headerTotals = new Footer("Total");
		headerTotals.setSpan(3);
		Footer headerTotalsAmt = new Footer(decimalFormat.format(totalIncome));

		totals.appendChild(headerTotals);
		totals.appendChild(headerTotalsAmt);

		grid.appendChild(totals);
		content.appendChild(grid);
	}
	
	@Override
	public void onClose()
	{
		setVisible(false);
		removeStatus();
		setPage(null);
	}
	
	@Override
	public void insertStatus()
	{
		for(Component component:getPage().getRoots())
		{
			if(component instanceof IconBar)
				component.appendChild(status);
		}
	}

	@Override
	public void removeStatus()
	{
		for(Component component:getPage().getRoots())
		{
			if(component instanceof IconBar)
				component.removeChild(status);
		}
	}
}
