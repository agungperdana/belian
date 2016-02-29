/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.journalsetting;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;

import com.kratonsolution.belian.accounting.dm.JournalSetting;
import com.kratonsolution.belian.accounting.dm.OGLAccount;
import com.kratonsolution.belian.accounting.dm.OrganizationAccount;
import com.kratonsolution.belian.accounting.svc.GLAccountService;
import com.kratonsolution.belian.accounting.svc.JournalSettingService;
import com.kratonsolution.belian.accounting.svc.OrganizationAccountService;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class JournalSettingEditContent extends FormContent
{	
	private JournalSettingService service = Springs.get(JournalSettingService.class);

	private OrganizationService organizationService = Springs.get(OrganizationService.class);

	private OrganizationAccountService organizationAccountService = Springs.get(OrganizationAccountService.class);

	private GLAccountService accountService = Springs.get(GLAccountService.class);

	private SessionUtils utils = Springs.get(SessionUtils.class);

	private Listbox organizations = Components.newSelect();

	private Listbox cashses = Components.newSelect();

	private Listbox saleses = Components.newSelect();

	private Listbox ppnpayables = Components.newSelect();

	private Row row;

	public JournalSettingEditContent(Row row)
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
				JournalSettingWindow window = (JournalSettingWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
				});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
				{
			@Override
			public void onEvent(Event event) throws Exception
			{
				JournalSetting setting = service.findOne(RowUtils.string(row, 2));
				if(setting != null)
				{
					setting.setOrganization(organizationService.findOne(Components.string(organizations)));
					setting.setCash(accountService.findOne(Components.string(cashses)));
					setting.setSales(accountService.findOne(Components.string(saleses)));
					setting.setPpnPayable(accountService.findOne(Components.string(ppnpayables)));

					service.edit(setting);
				}

				JournalSettingWindow window = (JournalSettingWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
				});
	}

	@Override
	public void initForm()
	{
		JournalSetting setting = service.findOne(RowUtils.string(row, 2));
		if(setting != null)
		{
			for(Organization unit:utils.getOrganizations())
			{
				Listitem listitem = new Listitem(unit.getName(),unit.getId());
				organizations.appendChild(listitem);
				if(unit.getId().equals(setting.getOrganization().getId()))
					organizations.setSelectedItem(listitem);
			}

			OrganizationAccount accounts = organizationAccountService.findOneByOrganization(Components.string(organizations));
			for(OGLAccount account:accounts.getAccounts())
			{
				Listitem cash = new Listitem(account.getLabel(),account.getValue());
				Listitem cogs = new Listitem(account.getLabel(),account.getValue());
				Listitem taxs = new Listitem(account.getLabel(),account.getValue());

				cashses.appendChild(cash);
				saleses.appendChild(cogs);
				ppnpayables.appendChild(taxs);

				if(setting.getCash() != null)
				{
					if(account.getId().equals(setting.getCash().getId()))
						cashses.setSelectedItem(cash);
				}

				if(setting.getSales() != null)
				{
					if(account.getId().equals(setting.getSales().getId()))
						saleses.setSelectedItem(cogs);
				}

				if(setting.getPpnPayable() != null)
				{
					if(account.getId().equals(setting.getPpnPayable().getId()))
						ppnpayables.setSelectedItem(taxs);
				}

			}

			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"150px"));
			grid.getColumns().appendChild(new Column());

			Row row1 = new Row();
			row1.appendChild(new Label("Organization"));
			row1.appendChild(organizations);

			Row row2 = new Row();
			row2.appendChild(new Label("Cash Account"));
			row2.appendChild(cashses);

			Row row3 = new Row();
			row3.appendChild(new Label("Sales Account"));
			row3.appendChild(saleses);

			Row row4 = new Row();
			row4.appendChild(new Label("PPN Payable Account"));
			row4.appendChild(ppnpayables);

			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
			rows.appendChild(row4);
		}
	}
}
