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

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.component.Icon;
import com.kratonsolution.belian.ui.healtcare.reports.comision.CommissionWindow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ClinicReportWindow extends Window
{
	private Language lang = Springs.get(Language.class);
	
	private Vbox vbox = new Vbox();
	
	private Icon comision = new Icon(lang.get("navbar.menu.healtcare.report.comision"),"/icons/comision.png");
	
	public ClinicReportWindow()
	{
		comision.setTooltiptext(lang.get("navbar.menu.healtcare.report.comision"));
		
		setWidth("600px");
		setHeight("400px");
		
		appendChild(vbox);
		
		Hbox hbox = new Hbox();
		hbox.setWidth("100%");
		hbox.appendChild(comision);
		hbox.setSpacing("30px");
		hbox.setPack("center");
		hbox.setAlign("center");
		
		vbox.appendChild(hbox);
		vbox.setSpacing("30px");
		vbox.setPack("center");
		vbox.setAlign("center");
		
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
