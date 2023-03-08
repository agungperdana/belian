/**
 * 
 */
package com.kratonsolution.belian.tools.view;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import org.zkoss.zk.ui.Component;

import com.google.common.base.Strings;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@SessionScope
public class KernelTask
{
	private Map<String,Watchable> watchables = new HashMap<>();
	
	private  Docks docks;
	
	private Component focused;
	
	public void clears()
	{
		watchables.clear();
		focused = null;
	}
	
	public Collection<Watchable> list()
	{
		return watchables.values();
	}
	
	public boolean isExist(String name)
	{
		return watchables.containsKey(name) && watchables.get(name) != null && watchables.get(name).isAlive();
	}
	
	public void register(Watchable watchable)
	{
		if(watchable != null)
		{
			if(watchables.containsKey(watchable.getName()))
				watchables.get(watchable.getName()).kill();
				
			watchables.put(watchable.getName(), watchable);
		}
	}
	
	public void unregister(Watchable watchable)
	{
		if(watchable != null && watchables.containsKey(watchable.getName()))
			watchables.remove(watchable.getName(), watchable);
	}
	
	public void kill(Watchable watchable)
	{
		kill(watchable!=null?watchable.getName():null);
	}
	
	public void kill(String name)
	{
		if(!Strings.isNullOrEmpty(name) && watchables.containsKey(name))
		{
			Watchable watchable = watchables.get(name);
			watchable.kill();
			
			if(docks != null && watchable.getDock() != null)
				docks.unregister(watchable.getDock());
		
			unregister(watchable);
		}
	}
	
	public Component open(Watchable watchable)
	{
		register(watchable);
		watchable.open();
		showDock(watchable.getDock());
		
		setFocused((Component)watchable);
		
		return (Component)watchable;
	}
	
	public void showDock(Dock dock)
	{
		if(docks != null && dock != null)
			docks.register(dock);
	}
	
	public Component open(String name)
	{
		if(watchables.containsKey(name))
		{
			Watchable watchable = watchables.get(name);
			watchable.open();
			showDock(watchable.getDock());
			
			setFocused((Component)watchable);
		
			return (Component)watchable;
		}
		
		return null;
	}
	
	public Docks setDocks(Docks docks)
	{
		this.docks = docks;
		return this.docks;
	}
	
	public void setFocused(Component component)
	{
		this.focused = component;
	}
	
	public Component getFocused()
	{
		return this.focused;
	}
}
