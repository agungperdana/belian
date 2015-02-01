/**
 * 
 */
package com.kratonsolution.belian.ui.module;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;

import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.nav.NavigatorBar;

/**
 * @author agungdodiperdana
 *
 */
public class ModuleWindow extends AbstractWindow
{
	private final Caption caption = new Caption("Module");
	
	private ModuleFormContent form = new ModuleFormContent();
	
	private ModuleGridContent grid = new ModuleGridContent();
	
	private Modulebutton status = new Modulebutton();
	
	public static ModuleWindow injectInto(Page page)
	{
		ModuleWindow window = new ModuleWindow();
		window.setPage(page);
		window.init();
		
		return window;
	}
	
	private ModuleWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setImage("/icons/module.png");
		caption.setParent(this);
		
		grid.setParent(this);
		
		insertStatus();
		status.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(!isVisible())
					setVisible(true);
				else
					setTopmost();
			}
		});
	}
	
	@Override
	public void onClose()
	{
		setVisible(false);
		removeStatus();
		setParent(null);
	}
	
	public void removeGrid()
	{
		removeChild(this.grid);
	}
	
	public void removeForm()
	{
		removeChild(form);
	}

	public void insertGrid()
	{
		grid = new ModuleGridContent();
		appendChild(grid);
	}
	
	public void insertForm()
	{
		form = new ModuleFormContent();
		appendChild(form);
	}

	@Override
	public void insertStatus()
	{
		for(Component component:getPage().getRoots())
		{
			if(component instanceof NavigatorBar)
				component.appendChild(status);
		}
	}

	@Override
	public void removeStatus()
	{
		for(Component component:getPage().getRoots())
		{
			if(component instanceof NavigatorBar)
				component.removeChild(status);
		}
	}
	
}
