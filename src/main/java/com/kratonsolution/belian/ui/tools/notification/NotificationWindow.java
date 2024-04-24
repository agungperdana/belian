
package com.kratonsolution.belian.ui.tools.notification;

import org.zkoss.zk.ui.Page;
import org.zkoss.zul.Caption;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class NotificationWindow extends AbstractWindow
{
	public static NotificationWindow newInstance(Page page)
	{
		NotificationWindow window = new NotificationWindow();
		window.setPage(page);
		window.doOverlapped();
		
		return window;
	}
	
	public NotificationWindow()
	{
		super();
		init();
	}
	
	private void init()
	{
		Caption caption = new Caption();
		caption.setLabel(lang.get("navbar.menu.tools.notification"));
		caption.setImage("/icons/notification32.png");
		
		appendChild(new NotificationContent());
	}
	
	@Override
	public void onClose()
	{
		super.onClose();
		detach();
	}
}
