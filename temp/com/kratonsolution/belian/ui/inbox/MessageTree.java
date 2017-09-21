/**
 * 
 */
package com.kratonsolution.belian.ui.inbox;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Center;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treeitem;

import com.kratonsolution.belian.tools.svc.ImportantService;
import com.kratonsolution.belian.tools.svc.InboxService;
import com.kratonsolution.belian.tools.svc.SendService;
import com.kratonsolution.belian.ui.inbox.draft.DraftGridContent;
import com.kratonsolution.belian.ui.inbox.draft.DraftItem;
import com.kratonsolution.belian.ui.inbox.important.ImportantGridContent;
import com.kratonsolution.belian.ui.inbox.inbox.InboxGridContent;
import com.kratonsolution.belian.ui.inbox.inbox.InboxItem;
import com.kratonsolution.belian.ui.inbox.send.SendGridContent;
import com.kratonsolution.belian.ui.inbox.send.SendItem;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class MessageTree extends Tree
{
	private InboxItem inbox = new InboxItem();
	
	private Treeitem important = new Treeitem("Inportant");
	
	private DraftItem draft = new DraftItem();
	
	private SendItem send = new SendItem();
	
	public MessageTree(Center center)
	{
		setWidth("99%");
		setVflex(true);
		
		appendChild(new Treechildren());
		getTreechildren().appendChild(inbox);
		getTreechildren().appendChild(important);
		getTreechildren().appendChild(draft);
		getTreechildren().appendChild(send);
		
		initInbox(center);
		initImportant(center);
		initSend(center);
		initDraft(center);
	}
	
	private void initInbox(Center center)
	{
		InboxService service = Springs.get(InboxService.class);
		
		inbox.setImage("/icons/message-inbox.png");
		inbox.setLabel("Inbox("+service.size()+")");
		inbox.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				InboxGridContent content = new InboxGridContent();
				content.addMessageListener(draft);
				content.addMessageListener(send);
				content.addMessageListener(inbox);
				
				Flow.next(center, content);
			}
		});
	}
	
	private void initImportant(Center center)
	{
		ImportantService service = Springs.get(ImportantService.class);
		
		important.setImage("/icons/message-important.png");
		important.setLabel("Important("+service.size()+")");
		important.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Flow.next(center, new ImportantGridContent());
			}
		});
	}
	
	private void initSend(Center center)
	{
		SendService service = Springs.get(SendService.class);
		
		send.setImage("/icons/message-send.png");
		send.setLabel("Send("+service.size()+")");
		send.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Flow.next(center, new SendGridContent());
			}
		});
	}
	
	private void initDraft(Center center)
	{
		draft.setImage("/icons/message-draft.png");
		draft.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				DraftGridContent content = new DraftGridContent();
				content.addMessageListener(draft);
				Flow.next(center,content);
			}
		});
	}
}
