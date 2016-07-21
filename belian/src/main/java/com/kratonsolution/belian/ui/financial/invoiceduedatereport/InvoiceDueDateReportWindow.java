/**
 * 
 */
package com.kratonsolution.belian.ui.financial.invoiceduedatereport;

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
public class InvoiceDueDateReportWindow extends AbstractWindow implements HasGrid,HasCreateForm,HasEditForm
{
	private Language lang = Springs.get(Language.class);
	
	private Caption caption = new Caption(lang.get("navbar.menu.finance.invoiceduedatereport"));
	
	private InvoiceDueDateReportButton status = new InvoiceDueDateReportButton();
	
	public static InvoiceDueDateReportWindow injectInto(Page page)
	{
		InvoiceDueDateReportWindow window = new InvoiceDueDateReportWindow();
		window.setPage(page);
		window.init();
		
		return window;
	}
	
	private InvoiceDueDateReportWindow()
	{
		super();
		setWidth("675px");
		setHeight("575px");
	}
	
	protected void init()
	{
		caption.setImage("/icons/invoice-duedate.png");
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
			if(component instanceof InvoiceDueDateReportResultContent)
			{
				removeChild(component);
				break;
			}
		}
	}

	@Override
	public void insertCreateForm()
	{
		appendChild(new InvoiceDueDateReportFormContent());
	}

	@Override
	public void removeCreateForm()
	{
		for(Component component:getChildren())
		{
			if(component instanceof InvoiceDueDateReportFormContent)
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
