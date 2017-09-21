/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PrintWindow extends Window
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Iframe iframe = new Iframe();
	
	private Button print = new Button("Print");
	
	public PrintWindow(String printsource)
	{
		setWidth("80%");
		setHeight("85%");
		setPosition("center");
		
		Vlayout layout = new Vlayout();
		layout.setHflex("1");
		layout.setVflex("1");
		
		Button close = new Button("Close");
		close.setIconSclass("z-icon-remove");
		close.setSclass("frmaedisplay");
		close.addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				PrintWindow.this.detach();
			}
		});

		print.setIconSclass("z-icon-print");
		print.setSclass("frmaedisplay");
		print.addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Clients.evalJavaScript("window.print()");
			}
		});
		
		Hbox hbox = new Hbox();
		hbox.setHflex("1");
		hbox.setHeight("30px");
		hbox.setAlign("center");
		hbox.setPack("center");
		hbox.appendChild(close);
		hbox.appendChild(print);
		
		if(utils.isPos())
		{
			iframe.setWidth("250px");
			iframe.setHeight("500px");
		}
		else
		{
			iframe.setHflex("1");
			iframe.setVflex("1");
		}
		
		if(!Strings.isNullOrEmpty(printsource))
			iframe.setSrc(printsource);
		
		layout.appendChild(iframe);
		layout.appendChild(hbox);
		
		appendChild(layout);
	}

	public Button getPrint()
	{
		return print;
	}
}
