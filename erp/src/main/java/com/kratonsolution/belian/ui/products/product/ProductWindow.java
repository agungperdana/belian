
package com.kratonsolution.belian.ui.products.product;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductWindow extends AbstractWindow
{
	public static ProductWindow newInstance(Page page)
	{
		ProductWindow window = new ProductWindow();
		window.init();
		window.setDock(new ProductDock());
		window.setPage(page);
		window.doOverlapped();
		
		return window;
	}
	
	private ProductWindow()
	{
		super();
		setHeight("82%");
	}
	
	protected void init()
	{
		caption.setImage("/icons/product32.png");
		caption.setLabel(lang.get("navbar.menu.products.product"));
		appendChild(new ProductGridContent());
	}
}
