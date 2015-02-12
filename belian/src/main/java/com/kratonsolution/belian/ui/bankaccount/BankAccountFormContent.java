/**
 * 
 */
package com.kratonsolution.belian.ui.bankaccount;

import java.util.UUID;

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
import com.kratonsolution.belian.accounting.svc.BankAccountService;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.Organization.IndustryType;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class BankAccountFormContent extends FormContent
{	
	private final BankAccountService service = Springs.get(BankAccountService.class);
	
	private final OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private Textbox number = new Textbox();
	
	private Textbox holder = new Textbox();
	
	private Listbox bank = new Listbox();
	
	private Checkbox status = new Checkbox("Active");
	
	public BankAccountFormContent()
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
				BankAccountWindow window = (BankAccountWindow)getParent();
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
			
				if(Strings.isNullOrEmpty(holder.getText()))
					throw new WrongValueException(holder,"Holder cannot be empty");
				
				BankAccount account = new BankAccount();
				account.setId(UUID.randomUUID().toString());
				account.setNumber(number.getText());
				account.setBank(organizationService.findOne(bank.getSelectedItem().getValue().toString()));
				account.setHolder(holder.getText());
				account.setActive(status.isChecked());
				
				service.add(account);
				
				BankAccountWindow window = (BankAccountWindow)getParent();
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
		
		holder.setConstraint("no empty");
		holder.setWidth("300px");
		
		status.setChecked(true);
		bank.setMold("select");
		
		for(Organization organization :organizationService.findAllByIndustryType(IndustryType.BANKING))
			bank.appendChild(new Listitem(organization.getName(),organization.getId()));
		
		bank.setSelectedIndex(0);
		
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
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
	}
}
