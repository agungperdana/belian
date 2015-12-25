/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.accountingperiod;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treecol;
import org.zkoss.zul.Treecols;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.Treerow;

import com.kratonsolution.belian.accounting.dm.AccountingPeriod;
import com.kratonsolution.belian.accounting.svc.AccountingPeriodService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class APTree extends Tree
{
	private AccountingPeriodService service = Springs.get(AccountingPeriodService.class);
	
	public APTree()
	{
		initHeaders();
		initRoot();
	}
	
	protected void initHeaders()
	{
		Treecols headers = new Treecols();
		headers.appendChild(new Treecol());
		
		appendChild(headers);
	}
	
	protected void initRoot()
	{
		Treechildren rootchildren = new Treechildren();
		appendChild(rootchildren);
		
		Treeitem root = new Treeitem("Accounting Period");
		root.setImage("/icons/leaf.png");
		
		rootchildren.appendChild(root);
		
		Treechildren childs = new Treechildren();
		root.appendChild(childs);
		
		for(final AccountingPeriod parent:service.findAllRoot())
		{
			Treerow treerow = new Treerow();
			treerow.appendChild(new Treecell(parent.getNumber()+" - "+parent.getName()));
			treerow.setImage("/icons/leaf.png");
			
			Treeitem period = new Treeitem();
			period.setId(parent.getId());
			period.appendChild(treerow);
			period.addEventListener(Events.ON_DOUBLE_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					getParent().appendChild(new AccountingPeriodEditContent(service.findOne(parent.getId())));
				}
			});
			
			childs.appendChild(period);

			Treechildren next = new Treechildren();
			period.appendChild(next);
			
			extract(parent, next);
		}
	}

	protected void extract(AccountingPeriod period,Treechildren treechildren)
	{
		if(!period.getMembers().isEmpty())
		{
			for(final AccountingPeriod member:period.getMembers())
			{
				Treerow treerow = new Treerow();
				treerow.appendChild(new Treecell(member.getNumber()+" - "+member.getName()));
				treerow.setImage("/icons/leaf.png");
				
				Treeitem item = new Treeitem();
				item.setId(member.getId());
				item.appendChild(treerow);
				item.addEventListener(Events.ON_DOUBLE_CLICK,new EventListener<Event>()
				{
					@Override
					public void onEvent(Event event) throws Exception
					{
						getParent().appendChild(new AccountingPeriodEditContent(service.findOne(member.getId())));
					}
				});
				
				treechildren.appendChild(item);
				
				Treechildren next = new Treechildren();
				item.appendChild(next);
				
				extract(member, next);
			}
		}
	}
}
