/**
 * 
 */
package com.kratonsolution.belian.ui.prodcategory;

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
import com.kratonsolution.belian.ui.nav.NavigatorBar;

/**
 * @author agungdodiperdana
 *
 */
public class ProductCategoryWindow extends AbstractWindow implements HasGrid,HasCreateForm,HasEditForm
{
	private final Caption caption = new Caption("Product Category");
	
	private ProductCategoryButton status = new ProductCategoryButton();
	
	public static ProductCategoryWindow injectInto(Page page)
	{
		ProductCategoryWindow window = new ProductCategoryWindow();
		window.setPage(page);
		window.init();
		
		return window;
	}
	
	private ProductCategoryWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setImage("/icons/category.png");
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
			if(component instanceof NavigatorBar)
				component.appendChild(status);
		}
	}

	@Override
	public void removeStatus()
	{
		for(Component component:getPage().getRoots())
		{
			if(component instanceof NavigatorBar)
				component.removeChild(status);
		}
	}

	@Override
	public void insertEditForm(Row row)
	{
		appendChild(new ProductCategoryEditContent(row));
	}

	@Override
	public void removeEditForm()
	{
		for(Component component:getChildren())
		{
			if(component instanceof ProductCategoryEditContent)
			{
				removeChild(component);
				break;
			}
		}
	}

	@Override
	public void insertCreateForm()
	{
		appendChild(new ProductCategoryFormContent());
	}

	@Override
	public void removeCreateForm()
	{
		for(Component component:getChildren())
		{
			if(component instanceof ProductCategoryFormContent)
			{
				removeChild(component);
				break;
			}
		}
	}

	@Override
	public void insertGrid()
	{
		appendChild(new ProductCategoryGridContent());
	}

	@Override
	public void removeGrid()
	{
		for(Component component:getChildren())
		{
			if(component instanceof ProductCategoryGridContent)
			{
				removeChild(component);
				break;
			}
		}
	}	
}
