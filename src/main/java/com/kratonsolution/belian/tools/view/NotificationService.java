/**
 * 
 */
package com.kratonsolution.belian.tools.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.kratonsolution.belian.global.dm.AbstractService;
import com.kratonsolution.belian.tools.dm.Notification;
import com.kratonsolution.belian.tools.dm.NotificationRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@SessionScope
public class NotificationService extends AbstractService implements Serializable
{
	@Autowired
	private NotificationRepository repository;
	
	private List<Notifiedable> listeners = new ArrayList<>();
	
	public void minus()
	{
		Notification notification = repository.findOne(utils.getUser().getUserName());
		if(notification != null)
			notification.minus();
		
		process();
	}
	
	public void plus()
	{
		Notification notification = repository.findOne(utils.getUser().getUserName());
		if(notification != null)
			notification.plus();
		
		process();
	}
	
	public void process()
	{
		for(Notifiedable listener:listeners)
			listener.fireMessageArive();
	}
	
	public void register(Notifiedable notifiedable)
	{
		if(notifiedable != null)
			listeners.add(notifiedable);
	}
}
