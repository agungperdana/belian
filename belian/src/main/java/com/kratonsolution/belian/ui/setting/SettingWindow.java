/**
 * 
 */
package com.kratonsolution.belian.ui.setting;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
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

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Address;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.security.dm.User;
import com.kratonsolution.belian.security.svc.UserService;
import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class SettingWindow extends AbstractWindow
{
	private UserService userService = Springs.get(UserService.class);
	
	private GeographicService geographicService = Springs.get(GeographicService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private SessionUtils sessionUtils = Springs.get(SessionUtils.class);
	
	private Vlayout layout = new Vlayout(); 
	
	private Tabbox tabbox = new Tabbox();

	private Listbox organizations = Components.newSelect();
	
	private Listbox locations = Components.newSelect();
	
	private Listbox languanges = Components.newSelect();
	
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
			if(organization.getId().equals(sessionUtils.getOrganization().getId()))
				organizations.setSelectedItem(listitem);
		}
		
		organizations.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				locations.getChildren().clear();
				
				Organization organization = organizationService.findOne(Components.string(organizations));
				if(organization != null)
				{
					for(Address address:organization.getAddresses())
					{
						Listitem listitem = new Listitem(address.getCity().getName(),address.getCity().getId());
						locations.appendChild(listitem);
						
						if(address.getCity().getId().equals(sessionUtils.getLocation().getId()))
							locations.setSelectedItem(listitem);
					}
				}
			}
		});
		
		locations.appendChild(new Listitem(sessionUtils.getLocation().getName(), sessionUtils.getLocation().getId()));
		locations.setSelectedIndex(0);
		
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
		
		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
		
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
			
			userService.edit(user);
		}
		
		super.onClose();
	}
}
