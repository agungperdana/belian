/**
 * 
 */
package com.kratonsolution.belian.ui.cashsales;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Vbox;

import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.nav.IconBar;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashierWindow extends AbstractWindow
{
	private Caption caption = new Caption("Cash Sales");

	private CashierButton status = new CashierButton();

	private Vbox vbox = new Vbox();
	private Hbox hbox1 = new Hbox();
	private Hbox hbox2 = new Hbox();
	private Hbox hbox3 = new Hbox();
	private Hbox hbox4 = new Hbox();
	private Hbox hbox5 = new Hbox();
	private Hbox hbox6 = new Hbox();
	private Hbox hbox7 = new Hbox();

	private Button table1 = new Button(null,"/icons/openorder.png");
	private Button table2 = new Button(null,"/icons/openorder.png");
	private Button table3 = new Button(null,"/icons/openorder.png");
	private Button table4 = new Button(null,"/icons/openorder.png");
	private Button table5 = new Button(null,"/icons/openorder.png");
	private Button table6 = new Button(null,"/icons/openorder.png");
	private Button table7 = new Button(null,"/icons/openorder.png");
	private Button table8 = new Button(null,"/icons/openorder.png");
	private Button table9 = new Button(null,"/icons/openorder.png");
	private Button table10 = new Button(null,"/icons/openorder.png");
	private Button table11 = new Button(null,"/icons/openorder.png");
	private Button table12 = new Button(null,"/icons/openorder.png");
	private Button table13 = new Button(null,"/icons/openorder.png");
	private Button table14 = new Button(null,"/icons/openorder.png");
	private Button table15 = new Button(null,"/icons/openorder.png");
	private Button table16 = new Button(null,"/icons/openorder.png");
	private Button table17 = new Button(null,"/icons/openorder.png");
	private Button table18 = new Button(null,"/icons/openorder.png");
	private Button table19 = new Button(null,"/icons/openorder.png");
	private Button table20 = new Button(null,"/icons/openorder.png");
	private Button table21 = new Button(null,"/icons/openorder.png");

	public static CashierWindow injectInto(Page page)
	{
		CashierWindow window = new CashierWindow();
		window.setPage(page);
		window.init();
		
		return window;
	}
	
	private CashierWindow()
	{
		super();
	}

	private void init()
	{
		caption.setImage("/icons/cashier.png");
		appendChild(caption);
		insertStatus();
		status.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(!isVisible())
					setVisible(true);
				else
					setTopmost();
			}
		});
		
		vbox.setSpacing("0");
		vbox.appendChild(hbox1);
		vbox.appendChild(hbox2);
		vbox.appendChild(hbox3);
		vbox.appendChild(hbox4);
		vbox.appendChild(hbox5);
		vbox.appendChild(hbox6);
		vbox.appendChild(hbox7);

		hbox1.appendChild(table1);
		hbox1.appendChild(table2);
		hbox1.appendChild(table3);

		hbox2.appendChild(table4);
		hbox2.appendChild(table5);
		hbox2.appendChild(table6);

		hbox3.appendChild(table7);
		hbox3.appendChild(table8);
		hbox3.appendChild(table9);

		hbox4.appendChild(table10);
		hbox4.appendChild(table11);
		hbox4.appendChild(table12);

		hbox5.appendChild(table13);
		hbox5.appendChild(table14);
		hbox5.appendChild(table15);

		hbox6.appendChild(table16);
		hbox6.appendChild(table17);
		hbox6.appendChild(table18);

		hbox7.appendChild(table19);
		hbox7.appendChild(table20);
		hbox7.appendChild(table21);
	
		appendChild(vbox);
	}

	@Override
	public void insertStatus()
	{
		for(Component component:getPage().getRoots())
		{
			if(component instanceof IconBar)
				component.appendChild(status);
		}
	}

	@Override
	public void removeStatus()
	{
		for(Component component:getPage().getRoots())
		{
			if(component instanceof IconBar)
				component.removeChild(status);
		}
	}
}
