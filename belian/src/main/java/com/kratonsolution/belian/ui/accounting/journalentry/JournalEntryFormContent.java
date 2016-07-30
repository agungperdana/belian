/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.journalentry;

import java.math.BigDecimal;
import java.util.Iterator;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.accounting.dm.AccountingPeriod;
import com.kratonsolution.belian.accounting.dm.JournalEntry;
import com.kratonsolution.belian.accounting.dm.JournalEntryDetail;
import com.kratonsolution.belian.accounting.dm.JournalEntryDetailType;
import com.kratonsolution.belian.accounting.dm.OrganizationAccount;
import com.kratonsolution.belian.accounting.svc.AccountingPeriodService;
import com.kratonsolution.belian.accounting.svc.JournalEntryService;
import com.kratonsolution.belian.accounting.svc.OrganizationAccountService;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.accounting.organizationaccount.OGLAccountList;
import com.kratonsolution.belian.ui.component.CurrencyList;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class JournalEntryFormContent extends FormContent
{	
	private JournalEntryService service = Springs.get(JournalEntryService.class);

	private OrganizationAccountService accountService = Springs.get(OrganizationAccountService.class);
	
	private AccountingPeriodService accountingPeriodService = Springs.get(AccountingPeriodService.class);
	
	private Datebox date = Components.currentDatebox();
	
	private OrganizationList companys = new OrganizationList();
	
	private Listbox coas = Components.fullSpanSelect();
	
	private Listbox periods = Components.fullSpanSelect();
	
	private CurrencyList currencys = new CurrencyList();
	
	private Textbox note = Components.stdTextBox(null, false);
	
	private Doublebox debet = Components.readOnlyDoubleBox();
	
	private Doublebox credit = Components.readOnlyDoubleBox();
	
	private Grid transactions = new Grid();
	
	public JournalEntryFormContent()
	{
		super();
		initToolbar();
		initForm();
		initTransaction();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new JournalEntryGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(credit.doubleValue() <= 0 || debet.doubleValue() <= 0 || (debet.doubleValue() != credit.doubleValue()))
				{
					Clients.showNotification(lang.get("journalentry.message.amount"), true);
					return;
				}
				
				JournalEntry entry = new JournalEntry();
				entry.setCoa(accountService.findOne(Components.string(coas)));
				entry.setCredit(BigDecimal.valueOf(credit.doubleValue()));
				entry.setCurrency(currencys.getCurrency());
				entry.setDate(DateTimes.sql(date.getValue()));
				entry.setDebet(BigDecimal.valueOf(debet.doubleValue()));
				entry.setOwner(companys.getOrganization());
				entry.setPeriod(accountingPeriodService.findOne(Components.string(periods)));
				entry.setNote(note.getText());

				for(Component component:transactions.getRows().getChildren())
				{
					Row row = (Row)component;
					
					OGLAccountList list = (OGLAccountList)row.getChildren().get(1);
					
					JournalEntryDetail detail = new JournalEntryDetail();
					detail.setAccount(list.getAccount());
					detail.setAmount(RowUtils.decimal(row, 3));
					detail.setJournal(entry);
					detail.setNote(RowUtils.string(row, 4));
					detail.setType(JournalEntryDetailType.valueOf(RowUtils.string(row, 2)));
					
					entry.getJournals().add(detail);
				}
				
				service.add(entry);
			
				Flow.next(getParent(), new JournalEntryGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		companys.setWidth("100%");
		
		populatePeriod();
		populateCOA();

		companys.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				populatePeriod();
				populateCOA();
				
				transactions.getRows().getChildren().clear();
			}
		});
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column(null,null,"280px"));
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("journalentry.grid.column.date")));
		row1.appendChild(date);
		row1.appendChild(new Label(lang.get("journalentry.grid.column.debet")));
		row1.appendChild(new Label(lang.get("journalentry.grid.column.credit")));
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("journalentry.grid.column.company")));
		row2.appendChild(companys);
		row2.appendChild(debet);
		row2.appendChild(credit);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("journalentry.grid.column.coa")));
		row3.appendChild(coas);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("journalentry.grid.column.ap")));
		row4.appendChild(periods);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("journalentry.grid.column.currency")));
		row5.appendChild(currencys);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("journalentry.grid.column.note")));
		row6.appendChild(note);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
	}
	
	private void initTransaction()
	{
		NRCToolbar toolbar = new NRCToolbar();

		appendChild(toolbar);
		appendChild(transactions);
		
		transactions.appendChild(new Columns());
		transactions.appendChild(new Rows());
		transactions.setWidth("100%");
		transactions.getColumns().appendChild(new Column(null, null, "25px"));
		transactions.getColumns().appendChild(new Column("Account", null, "225px"));
		transactions.getColumns().appendChild(new Column("Type", null, "100px"));
		transactions.getColumns().appendChild(new Column("Amount", null, "100px"));
		transactions.getColumns().appendChild(new Column("Note", null, null));
		transactions.setSpan("4");
		
		toolbar.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Components.isEmpty(coas))
				{
					Clients.showNotification("Please select Chart of Account first!",true);
					return;
				}
				
				OGLAccountList ogla = new OGLAccountList(companys.getOrganization());
				ogla.setWidth("100%");
				
				Row _row = new Row();
				_row.appendChild(new Checkbox());
				_row.appendChild(ogla);
				
				Listbox types = Components.fullSpanSelect();
				types.appendChild(new Listitem("DEBET","DEBET"));
				types.appendChild(new Listitem("CREDIT","CREDIT"));
				Components.setDefault(types);
				
				final Doublebox amout = new Doublebox(0d);
				amout.setWidth("100%");
				amout.setStyle("text-align:right");
				amout.addEventListener(Events.ON_CHANGE, new EventListener<Event>()
				{
					@Override
					public void onEvent(Event event) throws Exception
					{
						resetDisplay();
					}
				});
				
				Textbox txnote = new Textbox();
				txnote.setWidth("100%");
				
				_row.appendChild(types);
				_row.appendChild(amout);
				_row.appendChild(txnote);
				
				transactions.getRows().appendChild(_row);
				
				types.addEventListener(Events.ON_SELECT,new EventListener<Event>()
				{
					@Override
					public void onEvent(Event event) throws Exception
					{
						resetDisplay();
					}
				});
			}
		});
		
		toolbar.getRemove().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Iterator<Component> iterator = transactions.getRows().getChildren().iterator();
				while (iterator.hasNext())
				{
					Row row = (Row) iterator.next();
					if(RowUtils.isChecked(row, 0))
						iterator.remove();

					resetDisplay();
				}
			}
		});
		
		toolbar.getClear().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				transactions.getRows().getChildren().clear();
				debet.setValue(0d);
				credit.setValue(0d);
			}
		});
	}
	
	private void resetDisplay()
	{
		debet.setValue(0d);
		credit.setValue(0d);
		
		for(Component component:transactions.getRows().getChildren())
		{
			Row row = (Row)component;
		
			Listbox types = (Listbox)row.getChildren().get(2);
			Doublebox amount = (Doublebox)row.getChildren().get(3);
			
			if(Components.string(types).equals("DEBET"))
				debet.setValue(debet.getValue().doubleValue()+amount.doubleValue());
			else
				credit.setValue(credit.getValue().doubleValue()+amount.doubleValue());	
		}
	}
	
	private void populateCOA()
	{
		coas.getItems().clear();
		OrganizationAccount account = accountService.findOneByOrganization(companys.getOrganization().getId());
		if(account != null)
			coas.setSelectedItem(coas.appendItem(account.getName(), account.getId()));
	}
	
	private void populatePeriod()
	{
		periods.getChildren().clear();
		AccountingPeriod period = accountingPeriodService.findOpenChild(companys.getOrganization().getId(),date.getValue());
		if(period != null)
			periods.setSelectedItem(periods.appendItem(period.getName(),period.getId()));
	}
}
