/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.healtcare.reports.ClinicReportWindow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ClinicReportMenu extends Listitem
{
	private Language language = Springs.get(Language.class);
	
	public ClinicReportMenu()
	{
		init();
	}
	
	public void init()
	{
		setLabel(language.get("generic.menu.report"));
		setImage("/icons/report.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				ClinicReportWindow win = new ClinicReportWindow();
				win.setPage(getPage());
				win.doModal();
			}
		});
	}
}
