/**
 * 
 */
package com.kratonsolution.belian.ui.procurement.purchaseorderrequest;

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
public class PurchaseOrderRequestWindow extends AbstractWindow implements HasGrid,HasCreateForm,HasEditForm
{
	private Language lang = Springs.get(Language.class);

	private Caption caption = new Caption(lang.get("navbar.menu.procurement.purchaseorderrequest"));

	private PurchaseOrderRequestButton status = new PurchaseOrderRequestButton();

	public static PurchaseOrderRequestWindow injectInto(Page page)
	{
		PurchaseOrderRequestWindow window = new PurchaseOrderRequestWindow();
		window.setPage(page);
		window.init();

		return window;
	}

	private PurchaseOrderRequestWindow()
	{
		super();
		setWidth("750px");
		setHeight("520px");
	}

	protected void init()
	{
		caption.setImage("/icons/purchase_order_request.png");
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
		appendChild(new PurchaseOrderRequestEditContent(row));
	}

	@Override
	public void removeEditForm()
	{
		for(Component component:getChildren())
		{
			if(component instanceof PurchaseOrderRequestEditContent)
			{
				removeChild(component);
				break;
			}
		}
	}

	@Override
	public void insertCreateForm()
	{
		appendChild(new PurchaseOrderRequestFormContent());
	}

	@Override
	public void removeCreateForm()
	{
		for(Component component:getChildren())
		{
			if(component instanceof PurchaseOrderRequestFormContent)
			{
				removeChild(component);
				break;
			}
		}
	}

	@Override
	public void insertGrid()
	{
		appendChild(new PurchaseOrderRequestGridContent());
	}

	@Override
	public void removeGrid()
	{
		for(Component component:getChildren())
		{
			if(component instanceof PurchaseOrderRequestGridContent)
			{
				removeChild(component);
				break;
			}
		}
	}	
}
