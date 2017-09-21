/**
 * 
 */
package com.kratonsolution.belian.ui.general.companystructure;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CompanyStructureWindow extends AbstractWindow
{
	public static CompanyStructureWindow newInstance(Page page)
	{
		CompanyStructureWindow window = new CompanyStructureWindow();
		window.init();
		window.setDock(new CompanyStructureDock());
		window.setPage(page);
		window.doOverlapped();
		
		return window;
	}
	
	private CompanyStructureWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setLabel(lang.get("navbar.menu.general.companystructure"));
		caption.setImage("/icons/companystructure32.png");
		appendChild(new CompanyStructureContent());
	}
}
