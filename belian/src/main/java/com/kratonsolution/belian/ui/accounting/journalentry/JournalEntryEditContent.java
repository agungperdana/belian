/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.journalentry;

import java.math.BigDecimal;
import java.util.Date;
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
import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.accounting.dm.JournalEntry;
import com.kratonsolution.belian.accounting.dm.JournalEntryDetail;
import com.kratonsolution.belian.accounting.dm.JournalEntryDetailType;
import com.kratonsolution.belian.accounting.dm.OGLAccount;
import com.kratonsolution.belian.accounting.dm.OrganizationAccount;
import com.kratonsolution.belian.accounting.svc.AccountingPeriodService;
import com.kratonsolution.belian.accounting.svc.CurrencyService;
import com.kratonsolution.belian.accounting.svc.GLAccountService;
import com.kratonsolution.belian.accounting.svc.JournalEntryService;
import com.kratonsolution.belian.accounting.svc.OrganizationAccountService;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.accounting.organizationaccount.OGLAccountList;
import com.kratonsolution.belian.ui.component.CurrencyList;
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
public class JournalEntryEditContent extends FormContent
{	
	private JournalEntryService service = Springs.get(JournalEntryService.class);

	private CurrencyService currencyService = Springs.get(CurrencyService.class);

	private OrganizationService organizationService = Springs.get(OrganizationService.class);

	private OrganizationAccountService accountService = Springs.get(OrganizationAccountService.class);

	private AccountingPeriodService accountingPeriodService = Springs.get(AccountingPeriodService.class);

	private GLAccountService glAccountService = Springs.get(GLAccountService.class);

	private Datebox date = new Datebox(new Date());

	private OrganizationList companys = new OrganizationList();

	private Listbox coas = Components.newSelect();

	private Listbox periods = Components.newSelect();

	private CurrencyList currencys = new CurrencyList();

	private Textbox note = new Textbox();

	private Doublebox debet = Components.readOnlyDoubleBox();

	private Doublebox credit = Components.readOnlyDoubleBox();

	private Grid transactions = new Grid();

	private Row row;

	public JournalEntryEditContent(Row row)
	{
		super();
		this.row = row;
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
					Clients.showNotification("debet & credit must be equals", true);
					return;
				}

				JournalEntry entry = service.findOne(RowUtils.string(row, 5));
				if(entry != null)
				{
					entry.getJournals().clear();
					service.edit(entry);

					entry.setCredit(BigDecimal.valueOf(credit.doubleValue()));
					entry.setDebet(BigDecimal.valueOf(debet.doubleValue()));
					entry.setNote(note.getText());

					for(Component component:transactions.getRows().getChildren())
					{
						Row rw = (Row)component;

						OGLAccountList list = (OGLAccountList)rw.getChildren().get(1);
						
						JournalEntryDetail detail = new JournalEntryDetail();
						detail.setId(RowUtils.id(rw));
						detail.setAccount(list.getAccount());
						detail.setAmount(RowUtils.decimal(rw, 3));
						detail.setJournal(entry);
						detail.setNote(RowUtils.string(rw, 4));
						detail.setType(JournalEntryDetailType.valueOf(RowUtils.string(rw, 2)));

						entry.getJournals().add(detail);
					}

					service.edit(entry);
				}

				Flow.next(getParent(), new JournalEntryGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		JournalEntry entry = service.findOne(RowUtils.id(row));
		if(entry != null)
		{
			date.setValue(entry.getDate());
			companys.setOrganization(entry.getOwner());
			coas.setSelectedItem(coas.appendItem(entry.getCoa().getName(), entry.getCoa().getId()));
			periods.setSelectedItem(periods.appendItem(entry.getPeriod().getLabel(), entry.getPeriod().getId()));
			currencys.setCurrency(entry.getCurrency());
			note.setText(entry.getNote());
			debet.setText(Numbers.format(entry.getDebet()));
			credit.setText(Numbers.format(entry.getCredit()));
		}

		Toolbarbutton posting = new Toolbarbutton("Posting", "/icons/locked.png");
		Toolbarbutton unposting = new Toolbarbutton("Unposting", "/icons/unlocked.png");
		
		if(entry.isPosted())
			toolbar.appendChild(unposting);
		else
			toolbar.appendChild(posting);
		
		posting.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				service.post(entry);
				toolbar.removeChild(posting);
				toolbar.appendChild(unposting);
				toolbar.getSave().setDisabled(true);
			}
		});
		
		unposting.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				service.unpost(entry);
				toolbar.removeChild(unposting);
				toolbar.appendChild(posting);
				toolbar.getSave().setDisabled(false);
			}
		});
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column(null,null,"280px"));
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column(null,null,"125px"));

		Row row1 = new Row();
		row1.appendChild(new Label("Date"));
		row1.appendChild(date);
		row1.appendChild(new Label("Debet"));
		row1.appendChild(new Label("Credit"));

		Row row2 = new Row();
		row2.appendChild(new Label("Owner"));
		row2.appendChild(companys);
		row2.appendChild(debet);
		row2.appendChild(credit);

		Row row3 = new Row();
		row3.appendChild(new Label("Chart of Account"));
		row3.appendChild(coas);

		Row row4 = new Row();
		row4.appendChild(new Label("Accounting Period"));
		row4.appendChild(periods);

		Row row5 = new Row();
		row5.appendChild(new Label("Currency"));
		row5.appendChild(currencys);

		Row row6 = new Row();
		row6.appendChild(new Label("Note"));
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

				Row row = new Row();
				row.appendChild(new Checkbox());

				Listbox accounts = Components.newSelect();
				OrganizationAccount account = accountService.findOne(Components.string(coas));
				if(account != null)
				{
					for(OGLAccount gl:account.getAccounts())
						accounts.appendChild(new Listitem(gl.getAccount().getName(), gl.getAccount().getId()));
				}

				row.appendChild(accounts);

				Listbox types = Components.newSelect();
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

				row.appendChild(types);
				row.appendChild(amout);
				row.appendChild(txnote);

				transactions.getRows().appendChild(row);

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

		JournalEntry entry = service.findOne(RowUtils.string(row, 5));
		if(entry != null)
		{
			for(JournalEntryDetail detail:entry.getJournals())
			{
				Row row = new Row();
				row.appendChild(new Checkbox());

				Listbox accounts = Components.newSelect();
				OrganizationAccount account = accountService.findOne(Components.string(coas));
				if(account != null)
				{
					for(OGLAccount gl:account.getAccounts())
					{
						Listitem listitem = new Listitem(gl.getAccount().getName(), gl.getAccount().getId());
						accounts.appendChild(listitem);
						if(gl.getAccount().getId().equals(detail.getAccount().getId()))
							accounts.setSelectedItem(listitem);
					}
				}

				row.appendChild(accounts);

				Listbox types = Components.newSelect();
				for(JournalEntryDetailType type:JournalEntryDetailType.values())
				{
					Listitem listitem = new Listitem(type.toString(), type.toString());
					types.appendChild(listitem);
					if(type.equals(detail.getType()))
						types.setSelectedItem(listitem);
				}

				types.addEventListener(Events.ON_SELECT,new EventListener<Event>()
						{
					@Override
					public void onEvent(Event event) throws Exception
					{
						resetDisplay();
					}
						});

				final Doublebox amout = new Doublebox(0d);
				amout.setWidth("100%");
				amout.setStyle("text-align:right");
				amout.setValue(detail.getAmount().doubleValue());
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
				txnote.setText(detail.getNote());

				row.appendChild(types);
				row.appendChild(amout);
				row.appendChild(txnote);

				transactions.getRows().appendChild(row);
			}
		}
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
}
