/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.pharmacysales;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Row;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.HasCreateForm;
import com.kratonsolution.belian.ui.HasEditForm;
import com.kratonsolution.belian.ui.HasGrid;
import com.kratonsolution.belian.ui.nav.IconBar;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PharmacySalesWindow extends AbstractWindow implements HasGrid,HasCreateForm,HasEditForm
{
	private Language language = Springs.get(Language.class);
	
	private final Caption caption = new Caption(language.get("navbar.menu.healtcare.apotek"));
	
	private PharmacySalesButton status = new PharmacySalesButton();
	
	public static PharmacySalesWindow injectInto(Page page)
	{
		PharmacySalesWindow window = new PharmacySalesWindow();
		window.setPage(page);
		window.init();
		
		return window;
	}
	
	private PharmacySalesWindow()
	{
		super();
		setWidth("750px");
		setHeight("520px");
	}
	
	protected void init()
	{
		caption.setImage("/icons/apotek.png");
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
		appendChild(new PharmacySalesEditContent(row));
	}

	@Override
	public void removeEditForm()
	{
		for(Component component:getChildren())
		{
			if(component instanceof PharmacySalesEditContent)
			{
				removeChild(component);
				break;
			}
		}
	}

	@Override
	public void insertCreateForm()
	{
		appendChild(new PharmacySalesFormContent());
	}

	@Override
	public void removeCreateForm()
	{
		for(Component component:getChildren())
		{
			if(component instanceof PharmacySalesFormContent)
			{
				removeChild(component);
				break;
			}
		}
	}

	@Override
	public void insertGrid()
	{
		appendChild(new PharmacySalesGridContent());
	}

	@Override
	public void removeGrid()
	{
		for(Component component:getChildren())
		{
			if(component instanceof PharmacySalesGridContent)
			{
				removeChild(component);
				break;
			}
		}
	}	
}
