/**
 * 
 */
package com.kratonsolution.belian.ui.accountingsetting;

import java.util.HashSet;
import java.util.Set;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.accounting.dm.AccountingSettingAccount;
import com.kratonsolution.belian.accounting.dm.AccountingSettingType;
import com.kratonsolution.belian.accounting.dm.OGLAccount;
import com.kratonsolution.belian.accounting.dm.OrganizationAccount;
import com.kratonsolution.belian.accounting.svc.AccountingSettingAccountService;
import com.kratonsolution.belian.accounting.svc.AccountingSettingService;
import com.kratonsolution.belian.accounting.svc.GLAccountService;
import com.kratonsolution.belian.accounting.svc.OrganizationAccountService;
import com.kratonsolution.belian.general.dm.OrganizationUnit;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.general.svc.OrganizationUnitService;
import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class AccountingSettingWindow extends AbstractWindow
{
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private OrganizationUnitService unitService = Springs.get(OrganizationUnitService.class);
	
	private OrganizationAccountService accountService = Springs.get(OrganizationAccountService.class);
	
	private GLAccountService glAccountService = Springs.get(GLAccountService.class);
	
	private AccountingSettingAccountService settingAccountService = Springs.get(AccountingSettingAccountService.class);
	
	private AccountingSettingService settingService = Springs.get(AccountingSettingService.class);
	
	private Vlayout layout = new Vlayout(); 
	
	private Tabbox tabbox = new Tabbox();

	private Listbox cashSales = Components.fullSpanSelect();
	
	private Set<Rows> buffer = new HashSet<Rows>();
	
	public AccountingSettingWindow()
	{
		super();
		
		layout.setWidth("100%");
		layout.setHeight("100%");
		
		Caption caption = new Caption("Settings");
		caption.setImage("/icons/setting.png");
		appendChild(caption);
		
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.setWidth("100%");
		tabbox.setHeight("100%");
		
		layout.appendChild(tabbox);
		
		appendChild(layout);
		
		init();
	}
	
	private void init()
	{
		for(OrganizationUnit unit:unitService.findAll())
		{
			OrganizationAccount organizationAccount = accountService.findOneByOrganization(unit.getParty().getId());
			
			Tabpanel tabpanel = new Tabpanel();
			
			Grid grid = new Grid();
			grid.setHeight("100%");
			grid.setWidth("100%");
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"100px"));
			grid.getColumns().appendChild(new Column(null,null,"150px"));
			grid.getColumns().appendChild(new Column(null,null,"1px"));
			grid.getColumns().appendChild(new Column(null,null,"1px"));
			grid.getColumns().getChildren().get(2).setVisible(false);
			grid.getColumns().getChildren().get(3).setVisible(false);
			grid.setSpan("1");
			grid.appendChild(new Rows());
					
			tabpanel.appendChild(grid);
			
			tabbox.getTabs().appendChild(new Tab(unit.getParty().getName()));
			tabbox.getTabpanels().appendChild(tabpanel);
			
			for(AccountingSettingType type:AccountingSettingType.values())
			{
				Row row = new Row();
				row.appendChild(new Label(type.display()));
				
				if(organizationAccount != null)
				{
					for(OGLAccount account:organizationAccount.getAccounts())
					{
						Listitem listitem = new Listitem(account.getLabel(),account.getValue());
						row.appendChild(listitem);
						
						AccountingSettingAccount settingAccount = settingAccountService.findOneByOrganizationIdAndType(
																	RowUtils.string(row, 2), type);
//						if(settingAccount != null && settingAccount.getResource().getId().equals(account.getValue()))
							
							
					}
				}
				else
					row.appendChild(Components.fullSpanSelect());
			
				row.appendChild(new Label(unit.getParty().getId()));
				row.appendChild(new Label(type.name()));

				grid.getRows().appendChild(row);
			}
			
			this.buffer.add(grid.getRows());
		}
	}
	
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.HasStatus#insertStatus()
	 */
	@Override
	public void insertStatus()
	{
	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.HasStatus#removeStatus()
	 */
	@Override
	public void removeStatus()
	{
	}

	@Override
	public void onClose()
	{
		for(Rows rows:this.buffer)
		{
			for(Component component:rows.getChildren())
			{
				Row row = (Row)component;
				AccountingSettingAccount account = settingAccountService.findOneByOrganizationIdAndType(
														RowUtils.string(row, 2),
														AccountingSettingType.valueOf(RowUtils.string(row, 3))
													);
				if(account == null)
					account = new AccountingSettingAccount();
				
//				account.setOrganization(organizationService.findOne(RowUtils.string(row, index)));
			}
		}
	}
}
