/**
 * 
 */
package com.kratonsolution.belian.ui.organizationaccount;

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
public class OrganizationAccountWindow extends AbstractWindow implements HasCreateForm,HasEditForm,HasGrid
{
	private final Caption caption = new Caption("Organization GL Account");
	
	private OrganizationAccountButton status = new OrganizationAccountButton();
	
	public static OrganizationAccountWindow injectInto(Page page)
	{
		OrganizationAccountWindow window = new OrganizationAccountWindow();
		window.setPage(page);
		window.init();
		
		return window;
	}
	
	private OrganizationAccountWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setImage("/icons/orgacc.png");
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
		
		insertGrid();
	}
	
	@Override
	public void onClose()
	{
		setVisible(false);
		removeStatus();
		setPage(null);
	}
	
	public void removeGrid()
	{
		for(Component component:getChildren())
		{
			if(component instanceof OrganizationAccountGridContent)
			{
				removeChild(component);
				break;
			}
		}
	}

	public void insertGrid()
	{
		appendChild(new OrganizationAccountGridContent());
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
		appendChild(new OrganizationAccountEditContent(row));
	}

	@Override
	public void removeEditForm()
	{
		for(Component component:getChildren())
		{
			if(component instanceof OrganizationAccountEditContent)
			{
				removeChild(component);
				break;
			}
		}
	}

	@Override
	public void insertCreateForm()
	{
		appendChild(new OrganizationAccountFormContent());
	}

	@Override
	public void removeCreateForm()
	{
		for(Component component:getChildren())
		{
			if(component instanceof OrganizationAccountFormContent)
			{
				removeChild(component);
				break;
			}
		}
	}
}
