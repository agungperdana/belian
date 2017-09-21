/**
 * 
 */
package com.kratonsolution.belian.ui.inbox.inbox;

import java.util.Collection;
import java.util.Vector;

import org.zkforge.ckez.CKeditor;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.hr.dm.EmployeeRepository;
import com.kratonsolution.belian.partys.dm.Party;
import com.kratonsolution.belian.partys.dm.Person;
import com.kratonsolution.belian.tools.dm.Message;
import com.kratonsolution.belian.tools.dm.MessageReceiver;
import com.kratonsolution.belian.tools.dm.MessageType;
import com.kratonsolution.belian.tools.svc.DraftService;
import com.kratonsolution.belian.tools.svc.SendService;
import com.kratonsolution.belian.ui.Removeable;
import com.kratonsolution.belian.ui.inbox.MessageListener;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class MessageForm extends Vlayout implements Removeable
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private DraftService draftService = Springs.get(DraftService.class);
	
	private SendService sendService = Springs.get(SendService.class);
	
	private EmployeeRepository employeeRepository = Springs.get(EmployeeRepository.class);
	
	private Toolbar toolbar = new Toolbar();
	
	private Textbox title = Components.mandatoryTextBox();
	
	private ReceiverBox receiver = new ReceiverBox();
	
	private CKeditor content = new CKeditor();
	
	private Grid grid = new Grid();
	
	private Collection<MessageListener> listeners = new Vector<>();
	
	public MessageForm()
	{
		title.setPlaceholder("Tittle");
		
		content.setHflex("1");
		content.setVflex("1");
		
		setWidth("100%");
		
		toolbar.setWidth("100%");
		
		appendChild(toolbar);
		appendChild(title);
		appendChild(receiver);
		appendChild(content);
		
		initToolbar();
	}
	
	private void initToolbar()
	{
		Toolbarbutton send = new Toolbarbutton("Send","/icons/inbox-send.png");
		Toolbarbutton draft = new Toolbarbutton("Draft","/icons/inbox-draft.png");
		Toolbarbutton delete = new Toolbarbutton("Cancel","/icons/inbox-cancel.png");
		
		toolbar.appendChild(send);
		toolbar.appendChild(draft);
		toolbar.appendChild(delete);
		
		send.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Message message = new Message();
				message.setDate(DateTimes.currentDate());
				message.setSender(utils.getEmployee());
				message.setTitle(title.getText());
				message.setType(MessageType.Send);
				message.setContent(content.getValue());
				
				for(Party party:receiver.getReceivers())
				{
					MessageReceiver receiver = new MessageReceiver();
					receiver.setMessage(message);
					receiver.setReceiver((Person)party);
					
					message.getReceivers().add(receiver);
				}
				
				sendService.add(message);
				
				for(MessageListener listener:listeners)
					listener.fireMesasgeEvent();
				
				Flow.next(getParent(), new InboxGridContent());
			}
		});
		
		draft.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Message message = new Message();
				message.setDate(DateTimes.currentDate());
				message.setSender(utils.getEmployee());
				message.setTitle(title.getText());
				message.setType(MessageType.Draft);
				
				draftService.add(message);
				
				for(MessageListener listener:listeners)
					listener.fireMesasgeEvent();
				
				Flow.next(getParent(), new InboxGridContent());
			}
		});
		
		delete.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new InboxGridContent());
			}
		});
	}
	
	public void addMessageListener(MessageListener listener)
	{
		if(listener != null)
			listeners.add(listener);
	}
	
	public void addMessageListeners(Collection<MessageListener> listeners)
	{
		if(listeners != null)
			this.listeners.addAll(listeners);
	}
}
