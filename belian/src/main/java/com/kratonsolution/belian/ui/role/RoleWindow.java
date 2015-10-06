/**
 * 
 */
package com.kratonsolution.belian.ui.role;

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
public class RoleWindow extends AbstractWindow implements HasCreateForm,HasEditForm,HasGrid
{
	private final Caption caption = new Caption("Role");
	
	private Rolebutton status = new Rolebutton();
	
	public static RoleWindow injectInto(Page page)
	{
		RoleWindow window = new RoleWindow();
		window.setPage(page);
		window.init();
		
		return window;
	}
	
	private RoleWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setImage("/icons/role.png");
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
			if(component instanceof RoleGridContent)
			{
				removeChild(component);
				break;
			}
		}
	}

	public void insertGrid()
	{
		appendChild(new RoleGridContent());
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
		appendChild(new RoleEditContent(row));
	}

	@Override
	public void removeEditForm()
	{
		for(Component component:getChildren())
		{
			if(component instanceof RoleEditContent)
			{
				removeChild(component);
				break;
			}
		}
	}

	@Override
	public void insertCreateForm()
	{
		appendChild(new RoleFormContent());
	}

	@Override
	public void removeCreateForm()
	{
		for(Component component:getChildren())
		{
			if(component instanceof RoleFormContent)
			{
				removeChild(component);
				break;
			}
		}
	}
}
