package com.kratonsolution.belian.ui.tools.notification;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.tools.dm.Notification;
import com.kratonsolution.belian.tools.dm.NotificationRepository;
import com.kratonsolution.belian.tools.view.NotificationService;
import com.kratonsolution.belian.tools.view.Notifiedable;
import com.kratonsolution.belian.ui.nav.AbstractDock;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class NotificationDock extends AbstractDock implements Notifiedable
{
	private NotificationService manager = Springs.get(NotificationService.class);
	
	public NotificationDock()
	{
		setImage("/icons/notification.png");
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
		
		manager.register(this);
		manager.process();
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.tools.notification")))
		{
			NotificationWindow window = NotificationWindow.newInstance(getPage());
			window.setDock(NotificationDock.this);
			kernel.open(window);
		}
		else
			kernel.open(lang.get("navbar.menu.tools.notification"));
	}

	@Override
	public void fireMessageArive()
	{
		NotificationRepository repository = Springs.get(NotificationRepository.class);
		if(repository != null && repository.findById(utils.getUser().getUserName()) != null)
		{
			Notification notification = repository.findById(utils.getUser().getUserName()).orElse(null);
			if(notification.getNewMessage() > 0)
				setImage("/icons/newmessage32.gif");
			else
				setImage("/icons/notification.png");
		}
	}
}
