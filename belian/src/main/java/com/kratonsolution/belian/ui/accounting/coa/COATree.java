/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.coa;

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

import com.kratonsolution.belian.accounting.dm.GLAccount;
import com.kratonsolution.belian.accounting.svc.GLAccountService;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class COATree extends Tree
{
	private Language lang = Springs.get(Language.class);
	
	private GLAccountService service = Springs.get(GLAccountService.class);
	
	private GLAccount rootAccount;
	
	public COATree(GLAccount rootAccount)
	{
		this.rootAccount = rootAccount;
		initHeader();
		initRoot();
	}
	
	protected void initHeader()
	{
		Treecols headers = new Treecols();
		Treecol header = new Treecol(lang.get("coa.grid.column.title"));
		headers.appendChild(header);
		
		appendChild(headers);
	}
	
	protected void initRoot()
	{
		if(this.rootAccount != null)
		{
			Treechildren roots = new Treechildren();
			
			Treeitem treeitem = new Treeitem(rootAccount.getNumber()+" - "+rootAccount.getName());
			treeitem.setId(rootAccount.getId());
			treeitem.setImage("/icons/leaf.png");
			treeitem.addEventListener(Events.ON_DOUBLE_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					getParent().appendChild(new GLAEditContent(service.findOne(event.getTarget().getId())));
				}
			});
			
			Treechildren children = new Treechildren();
			treeitem.appendChild(children);
			
			extract(rootAccount, children);
			
			roots.appendChild(treeitem);
			
			appendChild(roots);
		}
	}
	
	protected void extract(GLAccount account,Treechildren treechildren)
	{
		if(!account.getMembers().isEmpty())
		{
			for(final GLAccount member:account.getMembers())
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
						getParent().appendChild(new GLAEditContent(service.findOne(event.getTarget().getId())));
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
