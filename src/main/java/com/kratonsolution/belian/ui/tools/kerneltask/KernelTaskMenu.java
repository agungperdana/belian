
package com.kratonsolution.belian.ui.tools.kerneltask;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class KernelTaskMenu extends AbstractMenuItem
{
	public static final String KERNEL_TASK_KEY = "KERNEL_TASK";
	
	public KernelTaskMenu()
	{
		setLabel(lang.get("navbar.menu.kernel"));
		setImage("/icons/kernel16.png");
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		Object object = Sessions.getCurrent().getAttribute(KERNEL_TASK_KEY);
		if(object != null)
		{
			Window window = (Window)object;
			window.doOverlapped();
		}
		else
		{
			Window window = new KernelTaskWindow();
			window.setPage(getPage());
			window.doOverlapped();
		
			Sessions.getCurrent().setAttribute(KERNEL_TASK_KEY, window);
		}
	}
}
