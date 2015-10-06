/**
 * 
 */
package com.kratonsolution.belian.ui.accountingperiod;

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
 * @author agungdodiperdana
 *
 */
public class AccountingPeriodWindow extends AbstractWindow implements HasGrid,HasCreateForm,HasEditForm
{
	private final Caption caption = new Caption("Accounting Period");
	
	private AccountingPeriodButton status = new AccountingPeriodButton();
	
	public static AccountingPeriodWindow injectInto(Page page)
	{
		AccountingPeriodWindow window = new AccountingPeriodWindow();
		window.setPage(page);
		window.init();
		
		return window;
	}
	
	private AccountingPeriodWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setImage("/icons/period.png");
		appendChild(caption);
		insertGrid();
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
//		appendChild(new AccountingPeriodEditContent(row));
	}

	@Override
	public void removeEditForm()
	{
		for(Component component:getChildren())
		{
			if(component instanceof AccountingPeriodEditContent)
			{
				removeChild(component);
				break;
			}
		}
	}

	@Override
	public void insertCreateForm()
	{
//		appendChild(new AccountingPeriodFormContent());
	}

	@Override
	public void removeCreateForm()
	{
		for(Component component:getChildren())
		{
			if(component instanceof AccountingPeriodFormContent)
			{
				removeChild(component);
				break;
			}
		}
	}

	@Override
	public void insertGrid()
	{
		appendChild(new AccountingPeriodGridContent());
	}

	@Override
	public void removeGrid()
	{
		for(Component component:getChildren())
		{
			if(component instanceof AccountingPeriodGridContent)
			{
				removeChild(component);
				break;
			}
		}
	}	
}
