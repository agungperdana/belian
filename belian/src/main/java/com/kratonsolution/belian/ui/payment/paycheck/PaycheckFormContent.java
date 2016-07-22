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
import com.kratonsolution.belian.hr.dm.Employment;
import com.kratonsolution.belian.hr.dm.PayrollPreference;
import com.kratonsolution.belian.hr.svc.EmploymentService;
import com.kratonsolution.belian.payment.dm.Deduction;
import com.kratonsolution.belian.payment.dm.Paycheck;
import com.kratonsolution.belian.payment.dm.PaycheckItem;
import com.kratonsolution.belian.payment.svc.DeductionTypeService;
import com.kratonsolution.belian.payment.svc.PaycheckService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.EmployeeBox;
import com.kratonsolution.belian.ui.component.ModelListener;
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
public class PaycheckFormContent extends FormContent implements ModelListener<Employment>
{	
	private PaycheckService service = Springs.get(PaycheckService.class);
	
	private DeductionTypeService typeService = Springs.get(DeductionTypeService.class);
	
	private EmploymentService employmentService = Springs.get(EmploymentService.class);
	
	private OrganizationList companys = new OrganizationList();
	
	private Datebox date = Components.currentDatebox();
	
	private Datebox start = Components.mandatoryDatebox("150px");
	
	private Datebox end = Components.mandatoryDatebox("150px");
	
	private EmployeeBox employees = new EmployeeBox(false);
	
	private Textbox note = Components.stdTextBox(null, false);
	
	private Textbox sGross = Components.readOnlyMoneyBox(BigDecimal.ZERO);
	
	private Textbox sDeduct = Components.readOnlyMoneyBox(BigDecimal.ZERO);
	
	private Textbox net = Components.readOnlyMoneyBox(BigDecimal.ZERO);
	
	private BigDecimal gross = BigDecimal.ZERO;
	
	private Tabbox tabbox = new Tabbox();
	
	private Grid deductions = new Grid();
	
	private Grid preferences = new Grid();
	
	public PaycheckFormContent()
	{
		super();
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
				Paycheck paycheck = new Paycheck();
				paycheck.setDate(DateTimes.sql(date.getValue()));
				paycheck.setStart(DateTimes.sql(start.getValue()));
				paycheck.setEnd(DateTimes.sql(end.getValue()));
				paycheck.setEmployment(employees.getEmployment());
				paycheck.setOrganization(companys.getOrganization());
				paycheck.setNote(note.getText());
				paycheck.setAmount(gross);
				paycheck.setStaff(utils.getEmployee());
				
				for(Component com:deductions.getRows().getChildren())
				{
					Row row = (Row)com;
					
					if(RowUtils.decimal(row, 2).compareTo(BigDecimal.ZERO) > 0)
					{
						Deduction deduction = new Deduction();
						deduction.setAmount(RowUtils.decimal(row, 2));
						deduction.setType(typeService.findOne(RowUtils.string(row, 1)));
						deduction.setPaycheck(paycheck);
						
						paycheck.getDeductions().add(deduction);
					}
				}
				
				for(Component com:preferences.getRows().getChildren())
				{
					Row row = (Row)com;
					
					PaycheckItem item = new PaycheckItem();
					item.setMethod(RowUtils.string(row, 1));
					item.setAmount(RowUtils.decimal(row, 2));
					item.setAccount(RowUtils.string(row, 3));
					item.setBank(RowUtils.string(row, 4));
					item.setPaycheck(paycheck);
					
					paycheck.getItems().add(item);
				}
				
				service.add(paycheck);
				
				Flow.next(getParent(), new PaycheckGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		start.setValue(DateTimes.firstDay(date.getValue()));
		end.setValue(DateTimes.lastDay(date.getValue()));
		employees.addListener(PaycheckFormContent.this);
		
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
		
		nrc.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Doublebox amt = Components.doubleBox(0);
				amt.addEventListener(Events.ON_CHANGE, new EventListener<InputEvent>()
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
		preferences.getColumns().appendChild(new Column(null,null,"25px"));
		preferences.getColumns().appendChild(new Column(lang.get("paycheck.grid.column.paymenttype"),null,"110px"));
		preferences.getColumns().appendChild(new Column(lang.get("paycheck.grid.column.amount"),null,"110px"));
		preferences.getColumns().appendChild(new Column(lang.get("paycheck.grid.column.number"),null,"110px"));
		preferences.getColumns().appendChild(new Column(lang.get("paycheck.grid.column.bank"),null,"110px"));
	
		tabbox.getTabpanels().getLastChild().appendChild(preferences);
	}
	
	@Override
	public void fireEvent(Employment model)
	{
		this.gross = employmentService.getGross(model,DateTimes.sql(date.getValue()), DateTimes.sql(start.getValue()), DateTimes.sql(end.getValue()));
		
		preferences.getRows().getChildren().clear();
		for(PayrollPreference preference:model.getPreferences())
		{
			BigDecimal amount = preference.getAmount();
			if(amount == null || amount.intValue() <= 0)
				amount = this.gross.multiply(preference.getPercent().divide(BigDecimal.valueOf(100)));
			
			Row row = new Row();
			row.appendChild(Components.checkbox(false));
			row.appendChild(Components.label(preference.getPaymentType().getName()));
			row.appendChild(Components.readOnlyDoubleBox(amount.doubleValue()));
			row.appendChild(Components.label(preference.getBankNumber()));
			row.appendChild(Components.label(preference.getBankName()));
			
			preferences.getRows().appendChild(row);
		}
		
		display();
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
