/**
 * 
 */
package com.kratonsolution.belian.ui.setting;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Doublebox;
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

import com.kratonsolution.belian.general.dm.Geographic;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.global.dm.PrinterType;
import com.kratonsolution.belian.global.svc.UserSettingService;
import com.kratonsolution.belian.security.dm.User;
import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.component.CurrencyList;
import com.kratonsolution.belian.ui.component.FacilityList;
import com.kratonsolution.belian.ui.component.LanguageList;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.component.TaxList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SettingWindow extends AbstractWindow
{
	private UserSettingService userService = Springs.get(UserSettingService.class);
	
	private GeographicService geographicService = Springs.get(GeographicService.class);
	
	private Vlayout layout = new Vlayout(); 
	
	private Tabbox tabbox = new Tabbox();

	private OrganizationList organizations = new OrganizationList();
	
	private Listbox locations = Components.newSelect();
	
	private LanguageList languanges = new LanguageList();
	
	private CurrencyList currencys = new CurrencyList();
	
	private TaxList taxes = new TaxList();
	
	private Listbox printers = Components.newSelect();
	
	private FacilityList facilitys = new FacilityList();
	
	private Doublebox rowPerPage = new Doublebox(25);
	
	public SettingWindow()
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
		
		initMyAccount();
	}
	
	private void initMyAccount()
	{
		for(PrinterType type:PrinterType.values())
		{
			Listitem listitem = printers.appendItem(type.name(),type.name());
			if(utils.getPrinterType().equals(type))
				printers.setSelectedItem(listitem);
		}

		for(Geographic geographic:geographicService.findAll())
		{
			Listitem listitem = new Listitem(geographic.getLabel(),geographic.getValue());
			locations.appendChild(listitem);
			if(utils.getLocation() != null && 
					utils.getLocation().getId() != null && utils.getLocation().getId().equals(geographic.getId()))
				locations.setSelectedItem(listitem);
		}
		
		rowPerPage.setValue(utils.getRowPerPage());
		
		Tabpanel tabpanel = new Tabpanel();
		
		tabbox.getTabs().appendChild(new Tab(lang.get("generic.grid.column.account")));
		tabbox.getTabpanels().appendChild(tabpanel);
		
		Grid grid = new Grid();
		grid.setHeight("100%");
		grid.setWidth("100%");
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"150px"));
		grid.getColumns().appendChild(new Column(null,null,"150px"));
		grid.setSpan("1");
		grid.appendChild(new Rows());
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("generic.grid.column.company")));
		row1.appendChild(organizations);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("generic.grid.column.location")));
		row2.appendChild(locations);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("generic.grid.column.language")));
		row3.appendChild(languanges);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("generic.grid.column.currency")));
		row4.appendChild(currencys);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("generic.grid.column.tax")));
		row5.appendChild(taxes);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("generic.grid.column.rowperpage")));
		row6.appendChild(rowPerPage);
		
		Row row7 = new Row();
		row7.appendChild(new Label(lang.get("generic.grid.column.printer")));
		row7.appendChild(printers);
		
		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
		grid.getRows().appendChild(row4);
		grid.getRows().appendChild(row5);
		grid.getRows().appendChild(row6);
		grid.getRows().appendChild(row7);
		
		tabpanel.appendChild(grid);
	}
	
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.HasStatus#insertStatus()
	 */
	@Override
	public void insertStatus(){}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.HasStatus#removeStatus()
	 */
	@Override
	public void removeStatus(){}

	@Override
	public void onClose()
	{
		User user = utils.getUser();
		if(user != null && !user.isSysAdmin())
		{
			user.getSetting().setLanguage(Components.string(languanges));
			user.getSetting().setRowPerPage(rowPerPage.intValue());

			Geographic location = geographicService.findOne(Components.string(locations));
			if(location != null)
			{
				user.getSetting().setLocationId(location.getId());
				user.getSetting().setLocationName(location.getName());
			}

			if(organizations.getOrganization() != null)
			{
				user.getSetting().setOrganizationId(organizations.getOrganization().getId());
				user.getSetting().setOrganizationName(organizations.getOrganization().getName());
			}

			if(currencys.getCurrency() != null)
			{
				user.getSetting().setCurrencyId(currencys.getCurrency().getId());
				user.getSetting().setCurrencyName(currencys.getCurrency().getName());
			}
			
			if(taxes.getTax() != null)
			{
				user.getSetting().setTaxId(taxes.getTax().getId());
				user.getSetting().setTaxName(taxes.getTax().getName());
			}
			
			user.getSetting().setPrinter(PrinterType.valueOf(Components.string(printers)));
			userService.edit(user.getSetting());
			
			Executions.sendRedirect("/home");
		}
		
		super.onClose();
	}
}
