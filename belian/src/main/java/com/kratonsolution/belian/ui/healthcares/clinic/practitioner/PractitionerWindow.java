/**
 * 
 */
package com.kratonsolution.belian.ui.healthcares.clinic.practitioner;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PractitionerWindow extends AbstractWindow
{
	public static PractitionerWindow newInstance(Page page)
	{
		PractitionerWindow window = new PractitionerWindow();
		window.init();
		window.setPage(page);
		window.setDock(new PractitionerDock());
		window.doOverlapped();
		
		return window;
	}
	
	private PractitionerWindow()
	{
		super();
		setHeight("80%");
	}
	
	protected void init()
	{
		caption.setImage("/icons/practitioner32.png");
		caption.setLabel(lang.get("navbar.menu.healthcares.clinic.practitioner"));
		appendChild(new PractitionerGridContent());
	}	
}
