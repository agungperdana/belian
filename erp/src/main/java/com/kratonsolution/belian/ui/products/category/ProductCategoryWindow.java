
package com.kratonsolution.belian.ui.products.category;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductCategoryWindow extends AbstractWindow
{
	public static ProductCategoryWindow newInstance(Page page)
	{
		ProductCategoryWindow window = new ProductCategoryWindow();
		window.init();
		window.setDock(new ProductCategoryDock());
		window.setPage(page);
		window.doOverlapped();
		
		return window;
	}
	
	private ProductCategoryWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setLabel(lang.get("navbar.menu.products.category"));
		caption.setImage("/icons/category32.png");
		appendChild(new ProductCategoryContent());
	}
}
