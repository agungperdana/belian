/**
 * 
 */
package com.kratonsolution.belian.ui.payment.paycheck;

import java.math.BigDecimal;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.hr.svc.EmploymentService;
import com.kratonsolution.belian.payment.dm.Deduction;
import com.kratonsolution.belian.payment.dm.Paycheck;
import com.kratonsolution.belian.payment.dm.PaycheckItem;
import com.kratonsolution.belian.payment.svc.DeductionTypeService;
import com.kratonsolution.belian.payment.svc.PaycheckService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.PrintWindow;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PaycheckEditContent extends FormContent
{	
	private PaycheckService service = Springs.get(PaycheckService.class);

	private DeductionTypeService typeService = Springs.get(DeductionTypeService.class);

	private EmploymentService employmentService = Springs.get(EmploymentService.class);
	
	private OrganizationList companys = new OrganizationList();

	private Datebox date = Components.currentDatebox();

	private Datebox start = Components.mandatoryDatebox("150px");

	private Datebox end = Components.mandatoryDatebox("150px");

	private Textbox employees = Components.readOnlyTextBox(null,false);

	private Textbox note = Components.stdTextBox(null, false);

	private Textbox sGross = Components.readOnlyMoneyBox(BigDecimal.ZERO);

	private Textbox sDeduct = Components.readOnlyMoneyBox(BigDecimal.ZERO);

	private Textbox net = Components.readOnlyMoneyBox(BigDecimal.ZERO);

	private BigDecimal gross = BigDecimal.ZERO;

	private Tabbox tabbox = new Tabbox();

	private Grid deductions = new Grid();

	private Grid preferences = new Grid();

	private Row row;

	public PaycheckEditContent(Row row)
	{
		super();
		this.row = row;
		initToolbar();
		initForm();
		initTabbox();
		initDeductions();
		initPreferences();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new PaycheckGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new PaycheckGridContent());
			}
		});
		
		toolbar.attachPrint();
		toolbar.getPrint().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				PrintWindow window = new PrintWindow("/paycheckprint.htm?id="+RowUtils.id(row),false);
				window.setPage(getPage());
				window.doModal();
			}
		});
	}

	@Override
	public void initForm()
	{
		Paycheck paycheck = service.findOne(RowUtils.id(row));
		if(paycheck != null)
		{
			companys.setOrganization(paycheck.getOrganization());
			date.setValue(paycheck.getDate());
			start.setValue(DateTimes.firstDay(date.getValue()));
			end.setValue(DateTimes.lastDay(date.getValue()));
			employees.setText(paycheck.getEmployment().getLabel());
			note.setText(paycheck.getNote());
			
			this.gross = employmentService.getGross(paycheck.getEmployment(),paycheck.getDate(), paycheck.getStart(), paycheck.getEnd());
			
			sGross.setText(Numbers.format(this.gross));
			sDeduct.setText(Numbers.format(paycheck.getDeductionAmount()));
			net.setText(Numbers.format(paycheck.getNetAmount()));
		}
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"90px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().appendChild(new Column(null,null,"90px"));
		grid.getColumns().appendChild(new Column(null,null,"155px"));
		grid.setSpan("1");
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("paycheck.grid.column.company")));
		row1.appendChild(companys);
		row1.appendChild(new Label(lang.get("paycheck.grid.column.gross")));
		row1.appendChild(sGross);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("paycheck.grid.column.date")));
		row2.appendChild(date);
		row2.appendChild(new Label(lang.get("paycheck.grid.column.deduct")));
		row2.appendChild(sDeduct);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("paycheck.grid.column.start")));
		row3.appendChild(start);
		row3.appendChild(new Label(lang.get("paycheck.grid.column.net")));
		row3.appendChild(net);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("paycheck.grid.column.end")));
		row4.appendChild(end);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("paycheck.grid.column.employee")));
		row5.appendChild(employees);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("paycheck.grid.column.note")));
		row6.appendChild(note);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
	}
	
	private void initTabbox()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab(lang.get("paycheck.grid.column.deduct")));
		tabbox.getTabs().appendChild(new Tab(lang.get("paycheck.grid.column.preference")));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		
		appendChild(tabbox);
	}
	
	private void initDeductions()
	{
		NRCToolbar nrc = new NRCToolbar(deductions);
		
		deductions.setWidth("100%");
		deductions.setEmptyMessage(lang.get("message.grid.empty"));
		deductions.appendChild(new Rows());
		deductions.appendChild(new Columns());
		deductions.getColumns().appendChild(new Column(null,null,"25px"));
		deductions.getColumns().appendChild(new Column(lang.get("paycheck.grid.column.type"),null,"110px"));
		deductions.getColumns().appendChild(new Column(lang.get("paycheck.grid.column.amount"),null,"110px"));
		deductions.setSpan("1");
		
		Paycheck paycheck = service.findOne(RowUtils.id(row));
		if(paycheck != null)
		{
			for(Deduction deduction:paycheck.getDeductions())
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.fullSpanSelect(typeService.findAll(),deduction.getType()));
				row.appendChild(Components.readOnlyDoubleBox(deduction.getAmount().doubleValue()));

				deductions.getRows().appendChild(row);
			}
		}
		
		nrc.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Doublebox amt = Components.doubleBox(0);
				amt.addEventListener(Events.ON_CHANGING, new EventListener<InputEvent>()
				{
					@Override
					public void onEvent(InputEvent event) throws Exception
					{
						display();
					}
				});
				
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.fullSpanSelect(typeService.findAll(),true));
				row.appendChild(amt);

				deductions.getRows().appendChild(row);
			}
		});
		
		tabbox.getTabpanels().getFirstChild().appendChild(nrc);
		tabbox.getTabpanels().getFirstChild().appendChild(deductions);
	}
	
	private void initPreferences()
	{
		preferences.setWidth("100%");
		preferences.setEmptyMessage(lang.get("message.grid.empty"));
		preferences.appendChild(new Rows());
		preferences.appendChild(new Columns());
		preferences.getColumns().appendChild(new Column(lang.get("paycheck.grid.column.paymenttype"),null,"110px"));
		preferences.getColumns().appendChild(new Column(lang.get("paycheck.grid.column.amount"),null,"110px"));
		preferences.getColumns().appendChild(new Column(lang.get("paycheck.grid.column.number"),null,"110px"));
		preferences.getColumns().appendChild(new Column(lang.get("paycheck.grid.column.bank"),null,"110px"));
		preferences.setSpan("0");
		
		Paycheck paycheck = service.findOne(RowUtils.id(row));
		if(paycheck != null)
		{
			for(PaycheckItem item:paycheck.getItems())
			{
				Row row = new Row();
				row.appendChild(Components.label(item.getMethod()));
				row.appendChild(Components.label(item.getAmount()));
				row.appendChild(Components.label(item.getAccount()));
				row.appendChild(Components.label(item.getBank()));
			
				preferences.getRows().appendChild(row);
			}
		}
		
		tabbox.getTabpanels().getLastChild().appendChild(preferences);
	}

	private void display()
	{
		sGross.setText(Numbers.format(this.gross));
		
		BigDecimal dk = BigDecimal.ZERO;
		for(Component com:deductions.getRows().getChildren())
		{
			Row row = (Row)com;
			dk = dk.add(RowUtils.decimal(row, 2));
		}
		
		sDeduct.setText(Numbers.format(dk));
		net.setText(Numbers.format(this.gross.subtract(dk)));
	}
}
