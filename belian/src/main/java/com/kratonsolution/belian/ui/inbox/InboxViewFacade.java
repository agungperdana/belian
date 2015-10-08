/**
 * 
 */
package com.kratonsolution.belian.ui.inbox;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.accounting.dm.BudgetReviewResult;
import com.kratonsolution.belian.global.dm.ReviewResult;
import com.kratonsolution.belian.ui.budget.BudgetViewRenderer;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class InboxViewFacade
{
	private Map<String,InboxViewRenderer> cache = new HashMap<String, InboxViewRenderer>();
	
	public InboxViewFacade()
	{
		cache.put(BudgetReviewResult.class.getName(),new BudgetViewRenderer());
	}
	
	public void open(Page page,ReviewResult result)
	{
		cache.get(result.getClass().getName()).showInboxDetail(page, result);
	}
}
