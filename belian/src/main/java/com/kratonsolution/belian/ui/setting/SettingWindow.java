/**
 * 
 */
package com.kratonsolution.belian.ui.setting;

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

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.svc.CurrencyService;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.security.dm.User;
import com.kratonsolution.belian.security.svc.UserService;
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
	private UserService userService = Springs.get(UserService.class);
	
	private GeographicService geographicService = Springs.get(GeographicService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private CurrencyService currencyService = Springs.get(CurrencyService.class);
	
	private SessionUtils sessionUtils = Springs.get(SessionUtils.class);
	
	private Vlayout layout = new Vlayout(); 
	
	private Tabbox tabbox = new Tabbox();

	private Listbox organizations = Components.newSelect();
	
	private Listbox locations = Components.newSelect(geographicService.findAll(),true);
	
	private Listbox languanges = Components.newSelect();
	
	private Listbox currencys = Components.newSelect();
	
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
		
		if(sessionUtils.getLocation() != null)
		{
			locations.appendChild(new Listitem(sessionUtils.getLocation().getLabel(), sessionUtils.getLocation().getValue()));
			locations.setSelectedIndex(0);
		}
		
		languanges.appendChild(new Listitem("Bahasa Indonesia", "id-ID"));
		languanges.appendChild(new Listitem("English", "en-US"));
		Components.setDefault(languanges);
		
		if("id-ID".equals(sessionUtils.getLanguage()))
			languanges.setSelectedIndex(0);
		if("en-US".equals(sessionUtils.getLanguage()))
			languanges.setSelectedIndex(1);
		
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
		
		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
		grid.getRows().appendChild(row4);
		
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
			user.getSetting().setLocation(geographicService.findOne(Components.string(locations)));
			user.getSetting().setOrganization(organizationService.findOne(Components.string(organizations)));
			user.getSetting().setCurrency(currencyService.findOne(Components.string(currencys)));
			
			userService.edit(user);
		}
		
		super.onClose();
	}
}
