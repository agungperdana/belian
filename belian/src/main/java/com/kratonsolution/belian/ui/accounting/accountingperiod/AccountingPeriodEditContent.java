/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.accountingperiod;

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
import com.kratonsolution.belian.accounting.dm.Month;
import com.kratonsolution.belian.accounting.svc.AccountingPeriodService;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.Refreshable;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class AccountingPeriodEditContent extends AbstractWindow
{	
	private final AccountingPeriodService service = Springs.get(AccountingPeriodService.class);
	
private Textbox number = new Textbox();
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private Datebox from = Components.currentDatebox();
	
	private Datebox to = Components.mandatoryDatebox("150px");
	
	private Listbox months = Components.newSelect();
	
	private Listbox parents = Components.newSelect();
	
	private AccountingPeriod edited;
	
	private Vlayout layout = new Vlayout();
	
	public AccountingPeriodEditContent(AccountingPeriod edited)
	{
		super();
		this.edited = edited;
		
		setMode(Mode.POPUP);
		Caption caption = new Caption(lang.get("navbar.menu.accounting.period"));
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
					throw new WrongValueException(number,lang.get("message.field.empty"));
			
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,lang.get("message.field.empty"));
			
				edited.setNumber(number.getText());
				edited.setName(name.getText());
				edited.setFrom(DateTimes.sql(from.getValue()));
				edited.setTo(DateTimes.sql(to.getValue()));
				edited.setMonth(Month.valueOf(months.getSelectedItem().getValue().toString()));
				
				service.edit(edited);
				
				((Refreshable)getParent()).refresh();
				onClose();
			}
		});
	}

	public void initForm()
	{
		number.setText(edited.getNumber());
		name.setText(edited.getName());
		from.setValue(edited.getFrom());
		to.setValue(edited.getTo());

		if(edited.getParent() != null)
		{
			parents.appendChild(new Listitem(edited.getParent().getName(),edited.getParent().getId()));
			parents.setSelectedIndex(0);
		}
		
		for(Month month:Month.values())
		{
			Listitem listitem = new Listitem(month.name(),month.name());
			months.appendChild(listitem);
			months.setSelectedItem(listitem);
		}

		Grid grid = new Grid();
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		grid.appendChild(new Rows());
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("accountingperiod.grid.column.number")));
		row1.appendChild(number);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("accountingperiod.grid.column.name")));
		row2.appendChild(name);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("accountingperiod.grid.column.start")));
		row3.appendChild(from);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("accountingperiod.grid.column.end")));
		row4.appendChild(to);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("accountingperiod.grid.column.month")));
		row5.appendChild(months);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("accountingperiod.grid.column.parent")));
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
