
package com.kratonsolution.belian.ui.healthcares.clinic.patient;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PatientWindow extends AbstractWindow
{
	public static PatientWindow newInstance(Page page)
	{
		PatientWindow window = new PatientWindow();
		window.init();
		window.setPage(page);
		window.setDock(new PatientDock());
		window.doOverlapped();
		
		return window;
	}
	
	private PatientWindow()
	{
		super();
		setHeight("80%");
	}
	
	protected void init()
	{
		caption.setImage("/icons/patient32.png");
		caption.setLabel(lang.get("navbar.menu.healthcares.clinic.patient"));
		appendChild(new PatientGridContent());
	}	
}
