/**
 * 
 */
package com.kratonsolution.belian.ui.cashaccount;

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
import com.kratonsolution.belian.accounting.dm.CashAccount;
import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.svc.CashAccountService;
import com.kratonsolution.belian.accounting.svc.CurrencyService;
import com.kratonsolution.belian.global.dm.EconomicAgent;
import com.kratonsolution.belian.global.dm.EconomicAgentRepository;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class CashAccountEditContent extends FormContent
{	
	private final CashAccountService service = Springs.get(CashAccountService.class);

	private final EconomicAgentRepository partyRepository = Springs.get(EconomicAgentRepository.class);

	private final CurrencyService currencyService = Springs.get(CurrencyService.class);

	private Textbox number = new Textbox();

	private Textbox name = new Textbox();

	private Listbox currency = new Listbox();

	private Listbox owner = new Listbox();

	private Checkbox status = new Checkbox("Active");

	private Row row;

	public CashAccountEditContent(Row row)
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
				CashAccountWindow window = (CashAccountWindow)getParent();
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

				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,"Name cannot be empty");

				CashAccount account = service.findOne(RowUtils.string(row, 6));
				account.setNumber(number.getText());
				account.setName(name.getText());
				account.setActive(status.isChecked());
				account.setCurrency(currencyService.findOne(currency.getSelectedItem().getValue().toString()));
				account.setOwner(partyRepository.findOne(owner.getSelectedItem().getValue().toString()));

				service.edit(account);

				CashAccountWindow window = (CashAccountWindow)getParent();
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
		number.setText(RowUtils.string(row, 1));
		
		name.setConstraint("no empty");
		name.setWidth("300px");
		name.setText(RowUtils.string(row, 2));
		
		status.setChecked(RowUtils.isChecked(row, 5));
		
		currency.setMold("select");
		owner.setMold("select");
		
		for(Currency ondb:currencyService.findAll())
		{
			Listitem listitem = new Listitem(ondb.getCode(),ondb.getId());
			currency.appendChild(listitem);
			if(ondb.getCode().equals(RowUtils.string(row, 3)))
				currency.setSelectedItem(listitem);
		}
		
		for(EconomicAgent party:partyRepository.findAll())
		{
			Listitem listitem = new Listitem(party.getName(),party.getId());
			owner.appendChild(listitem);
			if(party.getName().equals(RowUtils.string(row, 4)))
				owner.setSelectedItem(listitem);
		}
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Number"));
		row1.appendChild(number);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Name"));
		row2.appendChild(name);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Currency"));
		row3.appendChild(currency);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Owner"));
		row4.appendChild(owner);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Status"));
		row5.appendChild(status);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}
}
