/**
 * 
 */
package com.kratonsolution.belian.ui.journalsetting;

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
import com.kratonsolution.belian.general.dm.OrganizationUnit;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.general.svc.OrganizationUnitService;
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
	
	private OrganizationUnitService unitService = Springs.get(OrganizationUnitService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private OrganizationAccountService organizationAccountService = Springs.get(OrganizationAccountService.class);
	
	private GLAccountService accountService = Springs.get(GLAccountService.class);
	
	private Listbox organizations = Components.newSelect();
	
	private Listbox cashsaleses = Components.newSelect();
	
	private Listbox cogses = Components.newSelect();

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
					setting.setCashSales(accountService.findOne(Components.string(cashsaleses)));
					setting.setCogs(accountService.findOne(Components.string(cogses)));

					service.add(setting);
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
			for(OrganizationUnit unit:unitService.findAll())
			{
				Listitem listitem = new Listitem(unit.getParty().getName(),unit.getParty().getId());
				organizations.appendChild(listitem);
				if(unit.getParty().getId().equals(setting.getOrganization().getId()))
					organizations.setSelectedItem(listitem);
			}
			
			OrganizationAccount accounts = organizationAccountService.findOneByOrganization(Components.string(organizations));
			for(OGLAccount account:accounts.getAccounts())
			{
				Listitem cash = new Listitem(account.getLabel(),account.getValue());
				Listitem cogs = new Listitem(account.getLabel(),account.getValue());
				
				cashsaleses.appendChild(cash);
				cogses.appendChild(cogs);
				
				if(account.getId().equals(setting.getCashSales().getId()))
					cashsaleses.setSelectedItem(cash);
				
				if(account.getId().equals(setting.getCogs().getId()))
					cogses.setSelectedItem(cogs);
			}
			
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"150px"));
			grid.getColumns().appendChild(new Column());
			
			Row row1 = new Row();
			row1.appendChild(new Label("Organization"));
			row1.appendChild(organizations);
			
			Row row2 = new Row();
			row2.appendChild(new Label("Cash Sales Account"));
			row2.appendChild(cashsaleses);
			
			Row row3 = new Row();
			row3.appendChild(new Label("COGS Account"));
			row3.appendChild(cogses);
			
			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
		}
	}
}
