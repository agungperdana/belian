/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.reports;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.ui.component.Icon;
import com.kratonsolution.belian.ui.healtcare.reports.comision.CommissionWindow;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ClinicReportWindow extends Window
{
	private Vbox vbox = new Vbox();
	
	private Icon comision = new Icon("Comision","/icons/comision.png");
	
	public ClinicReportWindow()
	{
		comision.setTooltiptext("Medicine sales comision");
		
		setWidth("600px");
		setHeight("400px");
		
		appendChild(vbox);
		
		Hbox hbox = new Hbox();
		hbox.setWidth("100%");
		hbox.appendChild(comision);
		
		vbox.appendChild(hbox);
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				detach();
			}
		});
		
		comision.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				CommissionWindow.injectInto(getPage());
				detach();
			}
		});
	}
}
