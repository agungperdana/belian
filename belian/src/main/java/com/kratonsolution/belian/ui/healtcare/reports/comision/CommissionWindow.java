/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.reports.comision;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.nav.IconBar;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CommissionWindow extends AbstractWindow
{
	private Language language = Springs.get(Language.class);
	
	private Caption caption = new Caption(language.get("navbar.menu.healtcare.report.comision"));
	
	private ComisionButton status = new ComisionButton();
	
	public static CommissionWindow injectInto(Page page)
	{
		CommissionWindow window = new CommissionWindow();
		window.setPage(page);
		window.init();
		
		return window;
	}
	
	private CommissionWindow()
	{
		super();
		setWidth("675px");
	}
	
	protected void init()
	{
		caption.setImage("/icons/commission32.png");
		appendChild(caption);
		insertStatus();
		appendChild(new CommissionContent());
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
