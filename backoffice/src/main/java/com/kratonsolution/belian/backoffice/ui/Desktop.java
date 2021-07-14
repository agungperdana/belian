package com.kratonsolution.belian.backoffice.ui;

import org.zkoss.zk.ui.GenericRichlet;
import org.zkoss.zk.ui.Page;
import org.zkoss.zul.Style;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class Desktop extends GenericRichlet
{
	public static String APPLICATION_TITLE = "Belian ERP 2.0";
	
	@Override
	public void service(Page page) throws Exception
	{		
		page.setTitle(APPLICATION_TITLE);
		
		Style style = new Style("/css/belian.css");
		style.setPage(page);
		
		Screen screen = new Screen();
		screen.setPage(page);
		screen.init();
	}
}