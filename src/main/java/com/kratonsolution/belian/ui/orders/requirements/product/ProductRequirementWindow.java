/**
 * 
 */
package com.kratonsolution.belian.ui.orders.requirements.product;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductRequirementWindow extends AbstractWindow
{
	public static ProductRequirementWindow newInstance(Page page)
	{
		ProductRequirementWindow window = new ProductRequirementWindow();
		window.init();
		window.setPage(page);
		window.setDock(new ProductRequirementDock());
		window.doOverlapped();
		
		return window;
	}
	
	private ProductRequirementWindow()
	{
		super();
		setHeight("85%");
	}
	
	protected void init()
	{
		caption.setImage("/icons/productrequirement32.png");
		caption.setLabel(lang.get("navbar.menu.orders.requirements.productrequirement"));
		appendChild(new ProductRequirementGridContent());
	}	
}
