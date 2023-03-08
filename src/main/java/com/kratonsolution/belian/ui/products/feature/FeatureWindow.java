/**
 * 
 */
package com.kratonsolution.belian.ui.products.feature;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FeatureWindow extends AbstractWindow
{
	public static FeatureWindow newInstance(Page page)
	{
		FeatureWindow window = new FeatureWindow();
		window.init();
		window.setDock(new FeatureDock());
		window.setPage(page);
		window.doOverlapped();
		
		return window;
	}
	
	private FeatureWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setLabel(lang.get("navbar.menu.products.feature"));
		caption.setImage("/icons/feature32.png");
		appendChild(new FeatureGridContent());
	}
}
