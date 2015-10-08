/**
 * 
 */
package com.kratonsolution.belian.ui.budget;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Page;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;

import com.kratonsolution.belian.accounting.dm.Budget;
import com.kratonsolution.belian.accounting.dm.BudgetReviewResult;
import com.kratonsolution.belian.accounting.svc.BudgetService;
import com.kratonsolution.belian.ui.inbox.InboxViewRenderer;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Dates;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BudgetViewRenderer implements InboxViewRenderer<BudgetReviewResult>
{
	private BudgetService service = Springs.get(BudgetService.class);
	
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.inbox.InboxViewRenderer#showInboxDetail(com.kratonsolution.belian.global.dm.ReviewResult)
	 */
	@Override
	public void showInboxDetail(Page page,BudgetReviewResult v)
	{
		BudgetWindow window = null;
		
		for(Component component:page.getRoots())
		{
			if(component instanceof BudgetWindow)
				window = (BudgetWindow)component;
		}
		
		if(window == null)
		{
			window = BudgetWindow.injectInto(page);
			window.removeGrid();
			
			Budget budget = service.findOne(v.getReviewable().getId());
			if(budget != null)
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(new Label(budget.getType().name()));
				row.appendChild(new Label(budget.getPartyRequested().getName()));
				row.appendChild(new Label(Dates.format(budget.getStart())));
				row.appendChild(new Label(Dates.format(budget.getEnd())));
				row.appendChild(new Label(budget.getComment()));
				row.appendChild(new Label(budget.getId()));
				
				window.insertEditForm(row);
			}

		}
		else if(!window.isVisible())
		{
			window.setVisible(true);
			window.setTopmost();
		}
		else
			window.setTopmost();
	}

}
