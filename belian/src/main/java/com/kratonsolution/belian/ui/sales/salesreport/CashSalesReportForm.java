/**
 * 
 */
package com.kratonsolution.belian.ui.sales.salesreport;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.zkoss.zk.ui.Component;
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
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.sales.dm.CashSales;
import com.kratonsolution.belian.sales.dm.CashSalesLine;
import com.kratonsolution.belian.sales.srv.CashSalesService;
import com.kratonsolution.belian.ui.ReportToolbar;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashSalesReportForm extends Window
{
	private Button generate = new Button("Create","/icons/generate-report.png");

	private Button close = new Button("Close","/icons/cancel.png");

	private Datebox start = Components.currentDatebox();

	private Datebox end = Components.currentDatebox();

	private Checkbox all = new Checkbox();

	private Grid grid = new Grid();

	private Vlayout layout = new Vlayout();

	private Vlayout canvas;

	private CashSalesService service = Springs.get(CashSalesService.class);

	private SessionUtils utils = Springs.get(SessionUtils.class);

	public CashSalesReportForm(Vlayout canvas)
	{
		this.canvas = canvas;

		setWidth("300px");
		setHeight("200px");
		setMode(Mode.OVERLAPPED);
		setClosable(true);
		setSizable(true);
		setMinimizable(true);
		setPosition("center");

		grid.setWidth("100%");
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		grid.appendChild(new Rows());

		Row row1 = new Row();
		row1.appendChild(new Label("Start Date"));
		row1.appendChild(start);

		Row row2 = new Row();
		row2.appendChild(new Label("End Date"));
		row2.appendChild(end);

		Row row3 = new Row();
		row3.appendChild(new Label("Show Detail"));
		row3.appendChild(all);

		Foot foot = new Foot();
		Footer footer = new Footer();
		footer.setSpan(2);
		footer.setStyle("padding:5px;");
		footer.setAlign("right");
		footer.appendChild(generate);
		footer.appendChild(close);
		foot.appendChild(footer);

		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
		grid.appendChild(foot);

		layout.appendChild(grid);

		appendChild(new Caption("Cash Sales Report","/icons/salesreport.png"));
		appendChild(layout);

		close.addEventListener(Events.ON_CLICK,new EventListener()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				onClose();
			}
		});
		
		generate.addEventListener(Events.ON_CLICK,new EventListener()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				for(Component com:CashSalesReportForm.this.canvas.getChildren())
				{
					if(com instanceof Grid)
					{
						CashSalesReportForm.this.canvas.removeChild(com);
						break;
					}
				}
				
				generate();
				
				for(Component com:CashSalesReportForm.this.canvas.getChildren())
				{
					if(com instanceof ReportToolbar)
					{
						ReportToolbar toolbar = (ReportToolbar)com;
						toolbar.getPdf().setDisabled(false);
						toolbar.getExcel().setDisabled(false);
						break;
					}
				}
				
				onClose();
			}
		});
	}

	@Override
	public void onClose()
	{
		setVisible(false);
		setParent(null);
		setPage(null);
	}

	private void generate()
	{
		DecimalFormat decimalFormat = new DecimalFormat(",###");
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

		Grid grid = new Grid();
		grid.setWidth("100%");

		Auxhead auxhead = new Auxhead();
		Auxheader auxheader = new Auxheader("Transaction for date ["+format.format(start.getValue())+" to "+format.format(end.getValue())+"]");
		auxheader.setColspan(6);

		auxhead.appendChild(auxheader);
		grid.appendChild(auxhead);

		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column("Resource Name",null,"175px"));
		grid.getColumns().appendChild(new Column("Item(s)",null,"50px"));
		grid.getColumns().appendChild(new Column("Unit Price",null,"90px"));
		grid.getColumns().appendChild(new Column("Amount",null,"90px"));
		grid.getColumns().appendChild(new Column("Tax",null,"90px"));
		grid.getColumns().appendChild(new Column("Total",null,"90px"));
		grid.setSpan("0");
		
		grid.appendChild(new Rows());

		BigDecimal totalIncome = BigDecimal.ZERO;
		BigDecimal totalTax = BigDecimal.ZERO;

		List<CashSales> saleses = service.findAllByDateBetween(new Date(start.getValue().getTime()),new Date(end.getValue().getTime()),utils.getOrganizationIds());
		for(CashSales cashSales:saleses)
		{
			if(all.isChecked())
			{
				for(CashSalesLine line:cashSales.getItems())
				{
					BigDecimal amount = line.getPrice().multiply(line.getQuantity());
					BigDecimal tax = line.getPrice().multiply(line.getQuantity()).multiply(cashSales.getTax().getAmount());
					
					Row row1 = new Row();
					row1.appendChild(new Label(line.getProduct().getName()));
					row1.appendChild(new Label(line.getQuantity().toString()));
					row1.appendChild(new Label(decimalFormat.format(line.getPrice())));
					row1.appendChild(new Label(decimalFormat.format(amount)));
					row1.appendChild(new Label(decimalFormat.format(tax)));
					row1.appendChild(new Label(decimalFormat.format(amount.add(tax))));
					
					grid.getRows().appendChild(row1);
				}
			}
			else
			{
				Row row = new Row();
				row.appendChild(new Label(DateTimes.format(cashSales.getDate())+" ["+cashSales.getNumber()+"]"));
				row.appendChild(new Label(cashSales.getItems().size()+""));
				row.appendChild(new Label(""));
				row.appendChild(new Label(decimalFormat.format(cashSales.getBillingAmount())));
				row.appendChild(new Label(decimalFormat.format(cashSales.getTaxAmount())));
				row.appendChild(new Label(decimalFormat.format(cashSales.getBillingAmount().add(cashSales.getTaxAmount()))));

				grid.getRows().appendChild(row);
			}

			totalIncome = totalIncome.add(cashSales.getBillingAmount());
			totalTax = totalTax.add(cashSales.getTaxAmount());
		}

		Foot totals = new Foot();
		totals.setStyle("font-weight:bold;");
		Footer headerTotals = new Footer("Total");
		headerTotals.setSpan(3);
		totals.appendChild(headerTotals);
		totals.appendChild(new Footer(decimalFormat.format(totalIncome)));
		totals.appendChild(new Footer(decimalFormat.format(totalTax)));
		totals.appendChild(new Footer(decimalFormat.format(totalIncome.add(totalTax))));

		grid.appendChild(totals);
		
		canvas.appendChild(grid);
	}
}
