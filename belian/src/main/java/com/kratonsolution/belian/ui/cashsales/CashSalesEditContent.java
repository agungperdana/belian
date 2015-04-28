/**
 * 
 */
package com.kratonsolution.belian.ui.cashsales;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.BankAccount;
import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.svc.BankAccountService;
import com.kratonsolution.belian.accounting.svc.CurrencyService;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.Organization.IndustryType;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class CashSalesEditContent extends FormContent
{	
	private final BankAccountService service = Springs.get(BankAccountService.class);

	private final OrganizationService organizationService = Springs.get(OrganizationService.class);

	private CurrencyService currencyService = Springs.get(CurrencyService.class);
	
	private Textbox number = new Textbox();

	private Textbox holder = new Textbox();

	private Listbox bank = new Listbox();

	private Checkbox status = new Checkbox("Active");
	
	private Listbox currencys = new Listbox();

	private Row row;

	public CashSalesEditContent(Row row)
	{
		super();
		this.row = row;
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
				window.removeEditForm();
				window.insertGrid();
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(number.getText()))
					throw new WrongValueException(number,"Number cannot be empty");
		
				if(Strings.isNullOrEmpty(holder.getText()))
					throw new WrongValueException(holder,"Holder cannot be empty");
		
				BankAccount account = service.findOne(RowUtils.rowValue(row, 6));
				if(account != null)
				{
					account.setNumber(number.getText());
					account.setHolder(holder.getText());
					account.setActive(status.isChecked());
					account.setBank(organizationService.findOne(bank.getSelectedItem().getValue().toString()));
					account.setCurrency(currencyService.findOne(currencys.getSelectedItem().getValue().toString()));
			
					service.edit(account);
				}
		
				CashSalesWindow window = (CashSalesWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		number.setConstraint("no empty");
		number.setWidth("300px");
		number.setText(RowUtils.rowValue(row, 1));
		
		holder.setConstraint("no empty");
		holder.setWidth("300px");
		holder.setText(RowUtils.rowValue(row, 3));
		
		status.setChecked(RowUtils.isChecked(row, 4));
		
		bank.setMold("select");
		currencys.setMold("select");
		
		for(Currency currency:currencyService.findAll())
			currencys.appendChild(new Listitem(currency.getCode(), currency.getId()));
		
		if(!currencys.getChildren().isEmpty())
			currencys.setSelectedIndex(0);
		
		for(Organization organization :organizationService.findAllByIndustryType(IndustryType.BANKING))
		{
			Listitem item = new Listitem(organization.getName(),organization.getId());
			
			bank.appendChild(item);
			if(organization.getName().equals(RowUtils.rowValue(row, 2)))
				bank.setSelectedItem(item);
		}

		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label("Number"));
		row1.appendChild(number);

		Row row2 = new Row();
		row2.appendChild(new Label("Bank"));
		row2.appendChild(bank);

		Row row3 = new Row();
		row3.appendChild(new Label("Holder"));
		row3.appendChild(holder);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Status"));
		row4.appendChild(status);

		Row row5 = new Row();
		row5.appendChild(new Label("Currency"));
		row5.appendChild(currencys);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}
}
