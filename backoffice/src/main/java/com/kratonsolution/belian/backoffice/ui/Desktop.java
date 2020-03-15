package com.kratonsolution.belian.backoffice.ui;

import org.zkoss.zk.ui.GenericRichlet;
import org.zkoss.zk.ui.Page;
import org.zkoss.zul.Style;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.Vlayout;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
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
		
		Vlayout midle = new Vlayout();
		midle.setVflex("1");
		midle.setHflex("1");

		Launcher moduleLauncher = new Launcher();
		
		SystemMonitor monitor = SystemMonitor.attach(new SystemMonitor(), page.getDesktop());
		monitor.register(moduleLauncher);
		
		Fisheyes fisheyes = new Fisheyes();
		fisheyes.appendChild(moduleLauncher.getRemoteControl(page));
		fisheyes.insertSpace(true);
		
		Vbox canvas = new Vbox();
		canvas.setSclass("frmaedisplay");
		canvas.setWidth("99%");
		canvas.setHeight("99%");
		canvas.setAlign("center");
		canvas.setPack("center");
		canvas.appendChild(new TopMenu());
		canvas.appendChild(midle);
		canvas.appendChild(fisheyes);
	
		canvas.setPage(page);
	}
}