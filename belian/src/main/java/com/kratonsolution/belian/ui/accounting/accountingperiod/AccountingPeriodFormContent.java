/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.accountingperiod;

import java.util.Date;
import java.util.UUID;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Vlayout;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.AccountingPeriod;
import com.kratonsolution.belian.accounting.svc.AccountingPeriodService;
import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.Refreshable;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class AccountingPeriodFormContent extends AbstractWindow
{	
	private final AccountingPeriodService service = Springs.get(AccountingPeriodService.class);
	
	private Textbox number = new Textbox();
	
	private Textbox name = new Textbox();
	
	private Datebox from = new Datebox();
	
	private Datebox to = new Datebox();
	
	private Listbox months = new Listbox();
	
	private Listbox parents = new Listbox();
	
	private AccountingPeriod parent;
	
	private Vlayout layout = new Vlayout();
	
	public AccountingPeriodFormContent(AccountingPeriod parent)
	{
		super();
		this.parent = parent;
		
		setMode(Mode.POPUP);
		Caption caption = new Caption("Accounting Period");
		caption.setImage("/icons/period.png");

		layout.setWidth("100%");
		layout.setHeight("97%");
		layout.setStyle("overflow:auto");
		
		appendChild(caption);
		appendChild(layout);
		
		initToolbar();
		initForm();
	}

	public void initToolbar()
	{
		Toolbar toolbar = new Toolbar();
		
		Toolbarbutton back = new Toolbarbutton("Back","/icons/back.png");
		Toolbarbutton save = new Toolbarbutton("Save","/icons/save.png");
		
		toolbar.appendChild(back);
		toolbar.appendChild(save);
		
		layout.appendChild(toolbar);
		
		back.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				((Refreshable)getParent()).refresh();
				onClose();
			}
		});
		
		save.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(number.getText()))
					throw new WrongValueException(number,"Number cannot be empty");
			
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,"Name cannot be empty");
			
				AccountingPeriod period = new AccountingPeriod();
				period.setId(UUID.randomUUID().toString());
				period.setNumber(number.getText());
				period.setName(name.getText());
				period.setFrom(from.getValue());
				period.setTo(to.getValue());
				period.setMonth(AccountingPeriod.Month.valueOf(months.getSelectedItem().getValue().toString()));
				period.setParent(parent);
				
				service.add(period);
				
				((Refreshable)getParent()).refresh();
				onClose();
			}
		});
	}

	public void initForm()
	{
		number.setConstraint("no empty");
		number.setWidth("250px");
		
		name.setConstraint("no empty");
		name.setWidth("300px");
		
		from.setValue(new Date());
		parents.setMold("select");
		
		if(this.parent != null)
		{
			parents.appendChild(new Listitem(parent.getName(),parent.getId()));
			parents.setSelectedIndex(0);
		}
		
		for(AccountingPeriod.Month month:AccountingPeriod.Month.values())
			months.appendChild(new Listitem(month.name(),month.name()));
		
		months.setMold("select");
		months.setSelectedIndex(0);

		Grid grid = new Grid();
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		grid.appendChild(new Rows());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Number"));
		row1.appendChild(number);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Name"));
		row2.appendChild(name);
		
		Row row3 = new Row();
		row3.appendChild(new Label("From"));
		row3.appendChild(from);
		
		Row row4 = new Row();
		row4.appendChild(new Label("To"));
		row4.appendChild(to);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Month"));
		row5.appendChild(months);
		
		Row row6 = new Row();
		row6.appendChild(new Label("Parent"));
		row6.appendChild(parents);
		
		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
		grid.getRows().appendChild(row4);
		grid.getRows().appendChild(row5);
		grid.getRows().appendChild(row6);
		
		layout.appendChild(grid);
	}
	
	@Override
	public void onClose()
	{
		setVisible(false);
		setParent(null);
	}

	@Override
	public void insertStatus()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeStatus()
	{
		// TODO Auto-generated method stub
		
	}
}
