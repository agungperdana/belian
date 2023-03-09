
package com.kratonsolution.belian.ui.general.person;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PersonWindow extends AbstractWindow
{
	public static PersonWindow newInstance(Page page)
	{
		PersonWindow window = new PersonWindow();
		window.init();
		window.setDock(new PersonDock());
		window.setPage(page);
		window.doOverlapped();
		
		return window;
	}
	
	private PersonWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setLabel(lang.get("navbar.menu.general.person"));
		caption.setImage("/icons/person32.png");
		appendChild(new PersonGridContent());
	}
}
