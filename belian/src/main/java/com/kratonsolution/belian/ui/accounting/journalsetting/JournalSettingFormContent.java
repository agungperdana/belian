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
import com.kratonsolution.belian.general.svc.OrganizationUnitService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class JournalSettingFormContent extends FormContent
{	
	private JournalSettingService service = Springs.get(JournalSettingService.class);
	
	private OrganizationUnitService unitService = Springs.get(OrganizationUnitService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private OrganizationAccountService organizationAccountService = Springs.get(OrganizationAccountService.class);
	
	private GLAccountService accountService = Springs.get(GLAccountService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Listbox organizations = Components.newSelect();
	
	private Listbox cashes = Components.newSelect();
	
	private Listbox saleses = Components.newSelect();
	
	private Listbox ppnPayables = Components.newSelect();
	
	public JournalSettingFormContent()
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
				JournalSettingWindow window = (JournalSettingWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				JournalSetting setting = new JournalSetting();
				setting.setOrganization(organizationService.findOne(Components.string(organizations)));
				setting.setCash(accountService.findOne(Components.string(cashes)));
				setting.setSales(accountService.findOne(Components.string(saleses)));
				setting.setPpnPayable(accountService.findOne(Components.string(ppnPayables)));

				service.add(setting);
				
				JournalSettingWindow window = (JournalSettingWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		for(Organization unit:utils.getOrganizations())
			organizations.appendChild(new Listitem(unit.getName(),unit.getId()));

		organizations.addEventListener(Events.ON_SELECT, new EventListener()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				OrganizationAccount accounts = organizationAccountService.findOneByOrganization(Components.string(organizations));
				if(accounts != null)
				{
					for(OGLAccount account:accounts.getAccounts())
					{
						cashes.appendChild(new Listitem(account.getLabel(),account.getValue()));
						saleses.appendChild(new Listitem(account.getLabel(),account.getValue()));
						ppnPayables.appendChild(new Listitem(account.getLabel(),account.getValue()));
					}
				}
			}
		});
		
		Components.setDefault(cashes);
		Components.setDefault(saleses);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"150px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Organization"));
		row1.appendChild(organizations);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Cash Account"));
		row2.appendChild(cashes);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Sales Account"));
		row3.appendChild(saleses);
		
		Row row4 = new Row();
		row4.appendChild(new Label("PPN Payable Account"));
		row4.appendChild(ppnPayables);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
	}
}
