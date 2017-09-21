/**
 * 
 */
package com.kratonsolution.belian.ui.sales.salesreport;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.ReportToolbar;
import com.kratonsolution.belian.ui.nav.IconBar;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SalesReportWindow extends AbstractWindow
{
	private Language language = Springs.get(Language.class);
	
	private Caption caption = new Caption(language.get("navbar.menu.sales.salesreport"));

	private SalesReportButton status = new SalesReportButton();
		
	private Vlayout layout = new Vlayout();
	
	private ReportToolbar toolbar = new ReportToolbar();
	
	public static SalesReportWindow injectInto(Page page)
	{
		SalesReportWindow window = new SalesReportWindow();
		window.setPage(page);
		window.init();

		return window;
	}

	private SalesReportWindow()
	{
		super();
		setWidth("700px");
	}
	
	private void init()
	{
		caption.setImage("/icons/salesreport.png");
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
		
		toolbar.getGenerate().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{

			@Override
			public void onEvent(Event event) throws Exception
			{
				CashSalesReportForm form = new CashSalesReportForm(layout);
				form.setPage(getPage());
				form.setVisible(true);
			}
		});
	
		layout.setSpacing("3px");
		layout.setWidth("100%");
		layout.setHeight("97%");
		layout.setStyle("overflow:auto");
		layout.appendChild(toolbar);
		
		appendChild(caption);
		appendChild(layout);
	}
	
	@Override
	public void onClose()
	{
		setVisible(false);
		removeStatus();
		setPage(null);
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
