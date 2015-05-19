/**
 * 
 */
package com.kratonsolution.belian.ui.journalentry;

import java.util.Date;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.accounting.dm.AccountingPeriod;
import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.dm.OrganizationAccount;
import com.kratonsolution.belian.accounting.svc.AccountingPeriodService;
import com.kratonsolution.belian.accounting.svc.CurrencyService;
import com.kratonsolution.belian.accounting.svc.JournalEntryService;
import com.kratonsolution.belian.accounting.svc.OrganizationAccountService;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class JournalEntryFormContent extends FormContent
{	
	private JournalEntryService service = Springs.get(JournalEntryService.class);
	
	private CurrencyService currencyService = Springs.get(CurrencyService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private OrganizationAccountService accountService = Springs.get(OrganizationAccountService.class);
	
	private AccountingPeriodService accountingPeriodService = Springs.get(AccountingPeriodService.class);
	
	private Datebox date = new Datebox(new Date());
	
	private Listbox owners = Components.newSelect();
	
	private Listbox coas = Components.newSelect();
	
	private Listbox periods = Components.newSelect();
	
	private Listbox currencys = Components.newSelect();
	
	private Textbox note = new Textbox();
	
	private Doublebox debet = Components.readOnlyDoubleBox();
	
	private Doublebox credit = Components.readOnlyDoubleBox();
	
	public JournalEntryFormContent()
	{
		super();
		initToolbar();
		initForm();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				JournalEntryWindow window = (JournalEntryWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				JournalEntryWindow window = (JournalEntryWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		date.setConstraint("no empty");
		note.setWidth("250px");
		
		for(Organization organization:organizationService.findAllByRolesTypeName("Internal Organization"))
			owners.appendChild(new Listitem(organization.getName(), organization.getId()));
		
		if(!owners.getChildren().isEmpty())
		{
			owners.addEventListener(Events.ON_SELECT, new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					coas.getChildren().clear();
					for(OrganizationAccount account:accountService.findAllByOrganization(Components.string(owners)))
						coas.appendChild(new Listitem(account.getName(),account.getId()));
				
					Components.setDefault(coas);
				}
			});
		}
		
		AccountingPeriod period = accountingPeriodService.findForDate(date.getValue());
		if(period != null)
			periods.appendChild(new Listitem(period.getName(),period.getId()));
		
		for(Currency currency:currencyService.findAll())
			currencys.appendChild(new Listitem(currency.getCode(), currency.getId()));
		
		Components.setDefault(periods);
		Components.setDefault(currencys);
		
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
		row2.appendChild(owners);
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
}
