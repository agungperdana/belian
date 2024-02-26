/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zul.Menuseparator;

import com.kratonsolution.belian.ui.tools.datas.ProductDataImportMenu;
import com.kratonsolution.belian.ui.tools.kerneltask.KernelTaskMenu;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Tools extends AbstractMenu
{
	private KernelTaskMenu kernel = new KernelTaskMenu();
	
	private ProductDataImportMenu productDataImportMenu = new ProductDataImportMenu();
	
	public Tools()
	{
		setLabel(lang.get("navbar.menu.tools"));
		setImage("/icons/tools.png");
		
		popup.appendChild(kernel);
		popup.appendChild(new Menuseparator());
		popup.appendChild(productDataImportMenu);

		appendChild(popup);
	}
}
