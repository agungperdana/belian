/**
 * 
 */
package com.kratonsolution.belian.ui.education.studyperiod;

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
public class StudyPeriodWindow extends AbstractWindow implements HasGrid,HasCreateForm,HasEditForm
{
	private Caption caption = new Caption(lang.get("navbar.menu.education.period"));
	
	private StudyPeriodButton status = new StudyPeriodButton();
	
	public static StudyPeriodWindow injectInto(Page page)
	{
		StudyPeriodWindow window = new StudyPeriodWindow();
		window.setPage(page);
		window.init();
		
		return window;
	}
	
	private StudyPeriodWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setImage("/icons/studyperiod.png");
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
		appendChild(new StudyPeriodEditContent(row));
	}

	@Override
	public void removeEditForm()
	{
		for(Component component:getChildren())
		{
			if(component instanceof StudyPeriodEditContent)
			{
				removeChild(component);
				break;
			}
		}
	}

	@Override
	public void insertCreateForm()
	{
		appendChild(new StudyPeriodFormContent());
	}

	@Override
	public void removeCreateForm()
	{
		for(Component component:getChildren())
		{
			if(component instanceof StudyPeriodFormContent)
			{
				removeChild(component);
				break;
			}
		}
	}

	@Override
	public void insertGrid()
	{
		appendChild(new StudyPeriodGridContent());
	}

	@Override
	public void removeGrid()
	{
		for(Component component:getChildren())
		{
			if(component instanceof StudyPeriodGridContent)
			{
				removeChild(component);
				break;
			}
		}
	}	
}