/**
 * 
 */
package com.kratonsolution.belian.ui.financial.trialbalance;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Row;

import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.HasCreateForm;
import com.kratonsolution.belian.ui.HasEditForm;
import com.kratonsolution.belian.ui.HasGrid;
import com.kratonsolution.belian.ui.nav.IconBar;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class TrialBalanceReportWindow extends AbstractWindow implements HasGrid,HasCreateForm,HasEditForm
{
	private Caption caption = new Caption(lang.get("navbar.menu.finance.trialbalance"));
	
	private TrialBalanceReportButton status = new TrialBalanceReportButton();
	
	public static TrialBalanceReportWindow injectInto(Page page)
	{
		TrialBalanceReportWindow window = new TrialBalanceReportWindow();
		window.setPage(page);
		window.init();
		
		return window;
	}
	
	private TrialBalanceReportWindow()
	{
		super();
		setWidth("675px");
		setHeight("575px");
	}
	
	protected void init()
	{
		caption.setImage("/icons/trial-balance.png");
		appendChild(caption);
		insertCreateForm();
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

	@Override
	public void insertEditForm(Row row)
	{
	}

	@Override
	public void removeEditForm()
	{
		for(Component component:getChildren())
		{
			if(component instanceof TrialBalanceReportResultContent)
			{
				removeChild(component);
				break;
			}
		}
	}

	@Override
	public void insertCreateForm()
	{
		appendChild(new TrialBalanceReportFormContent());
	}

	@Override
	public void removeCreateForm()
	{
		for(Component component:getChildren())
		{
			if(component instanceof TrialBalanceReportFormContent)
			{
				removeChild(component);
				break;
			}
		}
	}

	@Override
	public void insertGrid(){}

	@Override
	public void removeGrid(){}	
}
