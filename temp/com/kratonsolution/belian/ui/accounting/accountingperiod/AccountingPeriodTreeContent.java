/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.accountingperiod;

import java.util.Iterator;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Messagebox;

import com.kratonsolution.belian.accounting.dm.AccountingPeriod;
import com.kratonsolution.belian.accounting.svc.AccountingPeriodService;
import com.kratonsolution.belian.ui.GridContent;
import com.kratonsolution.belian.ui.Refreshable;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class AccountingPeriodTreeContent extends GridContent implements Refreshable
{
	private AccountingPeriodService service = Springs.get(AccountingPeriodService.class);
	
	private APTree tree;
	
	public AccountingPeriodTreeContent()
	{
		super();
		initToolbar();
		initTree();
	}
	
	protected void initToolbar()
	{
		appendChild(gridToolbar);
		
		gridToolbar.removeChild(gridToolbar.getSelect());
		gridToolbar.getRefresh().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				refresh();
			}
		});
		
		gridToolbar.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				AccountingPeriod parent = null;
				if(tree.getSelectedItem() != null)
					parent = service.findOne(tree.getSelectedItem().getId());
				
				appendChild(new AccountingPeriodFormContent(parent));
			}
		});
		
		gridToolbar.getDelete().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Messagebox.show(lang.get("message.removedata"),"Warning",Messagebox.CANCEL|Messagebox.OK, Messagebox.QUESTION,new EventListener<Event>()
				{
					@Override
					public void onEvent(Event event) throws Exception
					{
						if(event.getName().equals("onOK"))
						{
							if(tree.getSelectedItem() != null)
								service.delete(tree.getSelectedItem().getId());
								
							refresh();
						}
					}
				});
			}
		});
	}
	
	protected void initGrid(){}

	protected void initTree()
	{
		tree = new APTree();
		tree.setHeight("97%");
		tree.setWidth("100%");
		
		appendChild(tree);
	}
	
	@Override
	public void refresh()
	{
		removeChild(tree);
		initTree();
	}
	
	protected void remove(AccountingPeriod period)
	{
		if(!period.getMembers().isEmpty())
		{
			Iterator<AccountingPeriod> iterator = period.getMembers().iterator();
			while (iterator.hasNext())
			{
				AccountingPeriod member = (AccountingPeriod) iterator.next();
				iterator.remove();
			
				remove(member);
			}
		}
		
		if(period.getParent() != null)
		{
			AccountingPeriod parent = service.findOne(period.getParent().getId());
			Iterator<AccountingPeriod> iterator = parent.getMembers().iterator();
			while (iterator.hasNext())
			{
				AccountingPeriod member = (AccountingPeriod) iterator.next();
				if(member.getId().equals(period.getId()))
				{
					iterator.remove();
					break;
				}
			}
			
			service.edit(parent);
		}
		
		service.delete(period.getId());
	}
}