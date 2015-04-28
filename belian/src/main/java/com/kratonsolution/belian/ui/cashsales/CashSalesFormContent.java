/**
 * 
 */
package com.kratonsolution.belian.ui.cashsales;

import java.util.Date;
import java.util.UUID;

import org.zkoss.zk.ui.WrongValueException;
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

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.BankAccount;
import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.svc.CurrencyService;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.global.dm.EconomicAgent;
import com.kratonsolution.belian.global.svc.EconomicAgentService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class CashSalesFormContent extends FormContent
{	
	private EconomicAgentService service = Springs.get(EconomicAgentService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private CurrencyService currencyService = Springs.get(CurrencyService.class);
	
	private Textbox number = new Textbox();
	
	private Datebox date = new Datebox(new Date());
	
	private Doublebox term = new Doublebox();
	
	private Textbox note = new Textbox();
	
	private Listbox producers = new Listbox();
	
	private Listbox consumers = new Listbox();
	
	private Listbox currencys = new Listbox();
	
	private Listbox organizations = new Listbox();
	
	public CashSalesFormContent()
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
				CashSalesWindow window = (CashSalesWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(number.getText()))
					throw new WrongValueException(number,"Code cannot be empty");
			
				if(Strings.isNullOrEmpty(term.getText()))
					throw new WrongValueException(term,"Holder cannot be empty");
				
				BankAccount account = new BankAccount();
				account.setId(UUID.randomUUID().toString());
				account.setNumber(number.getText());
				account.setBank(organizationService.findOne(producers.getSelectedItem().getValue().toString()));
				account.setHolder(term.getText());
				account.setCurrency(currencyService.findOne(currencys.getSelectedItem().getValue().toString()));
				
				CashSalesWindow window = (CashSalesWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		number.setConstraint("no empty");
		number.setWidth("300px");
		
		term.setConstraint("no empty");
		term.setWidth("300px");
		
		producers.setMold("select");
		consumers.setMold("select");
		organizations.setMold("select");
		currencys.setMold("select");
		
		for(Organization organization :organizationService.findAllByRolesTypeName("Internal Organization"))
			organizations.appendChild(new Listitem(organization.getName(),organization.getId()));
			
		for(Currency currency:currencyService.findAll())
			currencys.appendChild(new Listitem(currency.getCode(), currency.getId()));
		
		if(!currencys.getChildren().isEmpty())
			currencys.setSelectedIndex(0);

		organizations.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
//				consumers.getChildren().clear();
//				for(EconomicAgent agent:service.findByRoleAndParty("Customer", organization.getId()))
//					consumers.appendChild(new Listitem(agent.getName(), agent.getId()));
//			
//				producers.getChildren().clear();
//				for(EconomicAgent agent:service.findByRoleAndParty("Sales Person", organization.getId()))
//					producers.appendChild(new Listitem(agent.getName(), agent.getId()));
			}
		});
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"135px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Document Owner"));
		row1.appendChild(organizations);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Document Number"));
		row2.appendChild(number);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Date"));
		row3.appendChild(date);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Credit Term"));
		row4.appendChild(term);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Currency"));
		row5.appendChild(currencys);
		
		Row row6 = new Row();
		row6.appendChild(new Label("Sales"));
		row6.appendChild(producers);
		
		Row row7 = new Row();
		row7.appendChild(new Label("Customer"));
		row7.appendChild(consumers);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		rows.appendChild(row7);
	}
}
