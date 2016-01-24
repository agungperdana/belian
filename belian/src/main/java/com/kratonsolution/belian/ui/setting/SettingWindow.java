/**
 * 
 */
package com.kratonsolution.belian.ui.setting;

import java.util.Locale;

import org.zkoss.util.Locales;
import org.zkoss.web.Attributes;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.Clients;
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

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.svc.CurrencyService;
import com.kratonsolution.belian.accounting.svc.TaxService;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Geographic;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.global.svc.UserSettingService;
import com.kratonsolution.belian.security.dm.User;
import com.kratonsolution.belian.ui.AbstractWindow;
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
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private CurrencyService currencyService = Springs.get(CurrencyService.class);
	
	private TaxService taxService = Springs.get(TaxService.class);
	
	private SessionUtils sessionUtils = Springs.get(SessionUtils.class);
	
	private Vlayout layout = new Vlayout(); 
	
	private Tabbox tabbox = new Tabbox();

	private Listbox organizations = Components.newSelect();
	
	private Listbox locations = Components.newSelect();
	
	private Listbox languanges = Components.newSelect();
	
	private Listbox currencys = Components.newSelect();
	
	private Listbox taxes = Components.newSelect(taxService.findAll(), true);
	
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
		for(Organization organization:sessionUtils.getOrganizations())
		{
			Listitem listitem = new Listitem(organization.getName(), organization.getId());
			organizations.appendChild(listitem);
			if(sessionUtils.getOrganization() != null && organization.getId().equals(sessionUtils.getOrganization().getId()))
				organizations.setSelectedItem(listitem);
		}
		
		for(Currency currency:currencyService.findAll())
		{
			Listitem listitem = new Listitem(currency.getLabel(), currency.getValue());
			currencys.appendChild(listitem);
			if(sessionUtils.getCurrency() != null && currency.getId().equals(sessionUtils.getCurrency().getId()))
				currencys.setSelectedItem(listitem);
		}

		for(Geographic geographic:geographicService.findAll())
		{
			Listitem listitem = new Listitem(geographic.getLabel(),geographic.getValue());
			locations.appendChild(listitem);
			if(sessionUtils.getLocation() != null && 
					sessionUtils.getLocation().getId() != null && sessionUtils.getLocation().getId().equals(geographic.getId()))
				locations.setSelectedItem(listitem);
		}
		
		for(Listitem listitem:taxes.getItems())
		{
			if(sessionUtils.getTax() != null && sessionUtils.getTax().getId().equals(listitem.getValue().toString()))
			{
				taxes.setSelectedItem(listitem);
				break;
			}
		}
		
		languanges.appendChild(new Listitem("Bahasa Indonesia", "in_ID"));
		languanges.appendChild(new Listitem("English", "en_US"));
		Components.setDefault(languanges);
		
		if("in_ID".equals(sessionUtils.getLanguage()))
			languanges.setSelectedIndex(0);
		if("en_US".equals(sessionUtils.getLanguage()))
			languanges.setSelectedIndex(1);
		
		rowPerPage.setValue(sessionUtils.getRowPerPage());
		
		Tabpanel tabpanel = new Tabpanel();
		
		tabbox.getTabs().appendChild(new Tab("My Account"));
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
		row1.appendChild(new Label("Default Company"));
		row1.appendChild(organizations);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Default Work Location"));
		row2.appendChild(locations);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Language"));
		row3.appendChild(languanges);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Currency"));
		row4.appendChild(currencys);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Tax"));
		row5.appendChild(taxes);
		
		Row row6 = new Row();
		row6.appendChild(new Label("Row per page"));
		row6.appendChild(rowPerPage);
		
		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
		grid.getRows().appendChild(row4);
		grid.getRows().appendChild(row5);
		grid.getRows().appendChild(row6);
		
		tabpanel.appendChild(grid);
	}
	
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.HasStatus#insertStatus()
	 */
	@Override
	public void insertStatus()
	{
		// TODO Auto-generated method stub

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
		User user = sessionUtils.getUser();
		if(user != null)
		{
			user.getSetting().setLanguage(Components.string(languanges));
			user.getSetting().setRowPerPage(rowPerPage.intValue());

			Geographic location = geographicService.findOne(Components.string(locations));
			if(location != null)
			{
				user.getSetting().setLocationId(location.getId());
				user.getSetting().setLocationName(location.getName());
			}

			Organization organization = organizationService.findOne(Components.string(organizations));
			if(organization != null)
			{
				user.getSetting().setOrganizationId(organization.getId());
				user.getSetting().setOrganizationName(organization.getName());
			}

			Currency currency = currencyService.findOne(Components.string(currencys));
			if(currency != null)
			{
				user.getSetting().setCurrencyId(currency.getId());
				user.getSetting().setCurrencyName(currency.getName());
			}
			
			userService.edit(user);
			
			try
			{
				Locale locale = Locales.getLocale(new Locale(user.getSetting().getLanguage()));
				Sessions.getCurrent().setAttribute(Attributes.PREFERRED_LOCALE,locale);
				Clients.reloadMessages(locale);
				Locales.setThreadLocal(locale);
				Executions.sendRedirect("/home");
			} 
			catch (Exception e)
			{
			}
		}
		
		super.onClose();
	}
}
