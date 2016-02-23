/**
 * 
 */
package com.kratonsolution.belian.ui.inbox;

import java.util.Iterator;

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

import com.kratonsolution.belian.global.dm.Approveable;
import com.kratonsolution.belian.global.svc.ApproveableService;
import com.kratonsolution.belian.tools.svc.InboxService;
import com.kratonsolution.belian.ui.util.Dates;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class InboxContent extends Borderlayout implements ApproveableListener
{
	private InboxService service = Springs.get(InboxService.class);
	
	private ApproveableService approveableService = Springs.get(ApproveableService.class);
	
	private West west = new West();
	
	private Center center = new Center();
	
	private Tabbox menu = new Tabbox();
	
	public InboxContent()
	{
		setWidth("100%");
		setHeight("100%");
		
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
		
		for(Approveable approveable:approveableService.findAllNew())
		{
			Listitem item = new Listitem(Dates.format(approveable.getDate())+" "+approveable.getType());
			item.setId(approveable.getId());
			list.appendChild(item);
			
			item.addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					ApproveableForm form = new ApproveableForm(approveable);
					form.addListener(InboxContent.this);
					center.getChildren().clear();
					center.appendChild(form);
				}
			});
		}
		
		panel.appendChild(list);
	}
	
	public void initMessage()
	{
		Tab tab = new Tab("Message", "/icons/message.png");
		Tabpanel panel = new Tabpanel();
		
		menu.getTabs().appendChild(tab);
		menu.getTabpanels().appendChild(panel);
	}

	@Override
	public void fireApproveableDataUpdated(Approveable approveable)
	{
		Listbox box = (Listbox)menu.getTabpanels().getChildren().get(0).getChildren().get(0);
		Iterator<Listitem> iterator = box.getItems().iterator();
		while (iterator.hasNext())
		{
			Listitem listitem = (Listitem) iterator.next();
			if(listitem.getId().equals(approveable.getId()))
				iterator.remove();
		}
		
		center.getChildren().clear();
	}
}