
package com.kratonsolution.belian.ui.tools.notification;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.common.util.DateTimes;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.orders.dm.RequestRole;
import com.kratonsolution.belian.orders.dm.RequestRoleRepository;
import com.kratonsolution.belian.orders.dm.RoleType;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class NotificationContent extends Hlayout
{
	private Language lang = Springs.get(Language.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Tabbox tabbox = new Tabbox();
	
	private Vlayout content = new Vlayout();
	
	public NotificationContent()
	{
		initAccordion();
		initContent();
	}
	
	private void initContent()
	{
		content.setHflex("1");
		content.setVflex("1");
		
		appendChild(content);
	}
	
	private void initAccordion()
	{
		tabbox.setWidth("250px");
		tabbox.setHeight("465px");
		tabbox.setMold("accordion");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab(lang.get("navbar.menu.orders.request"),"/icons/por16.png"));
		
		Tabpanel request = new Tabpanel();
		initRequest(request);
		tabbox.getTabpanels().appendChild(request);
		
		appendChild(tabbox);
	}
	
	private void initRequest(Tabpanel panel)
	{
		Listbox listbox = new Listbox();
		listbox.setHflex("1");
		listbox.setVflex("1");
		
		RequestRoleRepository service = Springs.get(RequestRoleRepository.class);
		
		for(RequestRole role:service.findAllForApprovalAndReview(utils.getPersonId()))
		{
			Listitem item = listbox.appendItem(DateTimes.format(role.getDate())+" ("+RoleType.ENTERED_BY.display(utils.getLanguage())+" : "+role.getRequest().getCreator()+")", role.getId());
			item.addEventListener(Events.ON_CLICK, new EventListener<Event>()
			{

				@Override
				public void onEvent(Event arg0) throws Exception
				{
					Flow.next(content, new RequestAcknowledgementForm(role));
				}
			});
			
			if(role.getType().equals(RoleType.APPROVER))
				item.setImage("/icons/need-approval16.png");
			else
				item.setImage("/icons/need-review16.png");
		}

		panel.appendChild(listbox);
	}
}
