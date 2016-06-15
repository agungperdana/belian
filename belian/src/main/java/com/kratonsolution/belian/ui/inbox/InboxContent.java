/**
 * 
 */
package com.kratonsolution.belian.ui.inbox;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.West;

import com.kratonsolution.belian.global.dm.Roled;
import com.kratonsolution.belian.global.svc.RoledService;
import com.kratonsolution.belian.ui.Removeable;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class InboxContent extends Borderlayout implements Removeable
{
	private RoledService roledService = Springs.get(RoledService.class);
	
	private West west = new West();
	
	private Center center = new Center();
	
	private Tabbox menu = new Tabbox();
	
	public InboxContent()
	{
		setWidth("100%");
		setVflex("1");
		
		setStyle("overflow:auto;");
		
		menu.setMold("accordion");
		menu.setWidth("99%");
		menu.setHeight("98%");
		menu.appendChild(new Tabs());
		menu.appendChild(new Tabpanels());
		
		west.setWidth("30%");
		west.appendChild(menu);
		west.setBorder("none");
		
		center.setBorder("none");
		
		appendChild(west);
		appendChild(center);
		
		initApprovable();
		initReviews();
		initMessage();
	}
	
	public void initApprovable()
	{
		Tab tab = new Tab("Approval", "/icons/approval.png");
		Tabpanel panel = new Tabpanel();
		
		menu.getTabs().appendChild(tab);
		menu.getTabpanels().appendChild(panel);
	
		Listbox list = new Listbox();
		list.setStyle("border:none");
		list.setWidth("100%");
		
		for(Roled roled:roledService.allNewApproveable())
		{
			Listitem item = new Listitem(roled.getDocument().getName());
			list.appendChild(item);
			item.addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					Flow.next(center, new ApproveAndReviewableForm(roled));
				}
			});
		}
		
		panel.appendChild(list);
	}
	
	public void initReviews()
	{
		Tab tab = new Tab("Review", "/icons/reviewable.png");
		Tabpanel panel = new Tabpanel();
		
		menu.getTabs().appendChild(tab);
		menu.getTabpanels().appendChild(panel);
	
		Listbox list = new Listbox();
		list.setStyle("border:none");
		list.setWidth("100%");
		
		for(Roled roled:roledService.allNewReviewable())
		{
			Listitem item = new Listitem(roled.getDocument().getName());
			list.appendChild(item);
			item.addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					Flow.next(center, new ApproveAndReviewableForm(roled));
				}
			});
		}
		
		panel.appendChild(list);
	}
	
	public void initMessage()
	{
		Tab tab = new Tab("Message", "/icons/message.png");
		Tabpanel panel = new Tabpanel();
	
		panel.appendChild(new MessageTree(center));
		
		menu.getTabs().appendChild(tab);
		menu.getTabpanels().appendChild(panel);
	}
}