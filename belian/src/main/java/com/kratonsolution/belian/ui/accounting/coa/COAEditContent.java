/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.coa;

import java.util.Iterator;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.accounting.dm.GLAccount;
import com.kratonsolution.belian.accounting.svc.GLAccountService;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.Refreshable;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class COAEditContent extends Vlayout implements Refreshable
{	
	private GLAccountService service = Springs.get(GLAccountService.class);

	private Language lang = Springs.get(Language.class);
	
	private GLAccount root;
	
	private COATree tree;
	
	public COAEditContent(GLAccount root)
	{
		setSpacing("3px");
		setWidth("100%");
		setHeight("97%");
		setStyle("overflow:auto");
		
		this.root = root;
		
		initToolbar();
		initTree();
	}
	
	protected void initToolbar()
	{
		Toolbar toolbar = new Toolbar();
		toolbar.setHeight("30px");
		toolbar.setWidth("100%");
		
		Toolbarbutton back = new Toolbarbutton(lang.get("label.component.button.back"),"/icons/back.png");
		Toolbarbutton account = new Toolbarbutton(lang.get("label.component.button.new"), "/icons/coasmall.png");
		Toolbarbutton delete = new Toolbarbutton(lang.get("label.component.button.delete"),"/icons/delete.png");
		
		back.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				COAWindow window = (COAWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
		
		account.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				GLAccount parent = null;
				if(tree.getSelectedItem() != null)
					parent = service.findOne(tree.getSelectedItem().getId());
				
				GLAFormContent content = new GLAFormContent(parent);
				appendChild(content);
			}
		});
		
		delete.addEventListener(Events.ON_CLICK,new EventListener<Event>()
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
								removeTreeitem(tree.getSelectedItem());
							
							refresh();
						}
					}
				});
			}
		});
		
		toolbar.appendChild(back);
		toolbar.appendChild(account);
		toolbar.appendChild(delete);
		
		appendChild(toolbar);
	}
	
	protected void initTree()
	{
		tree = new COATree(service.findOne(this.root.getId()));
		tree.setWidth("100%");
		tree.setHeight("97%");
		
		appendChild(tree);
	}

	@Override
	public void refresh()
	{
		removeChild(tree);
		initTree();
	}
	
	protected void removeTreeitem(Treeitem treeitem)
	{
		if(treeitem.getTreechildren() != null && treeitem.getTreechildren().getItemCount() > 0)
		{
			//treeitem contains children
			for(Treeitem item:treeitem.getTreechildren().getItems())
				removeTreeitem(item);
		}
		else
		{
			//does not have children,remove it
			GLAccount account = service.findOne(treeitem.getId());
			if(account != null)
			{
				service.delete(account);
				treeitem.getParent().removeChild(treeitem);
			}
		}
	}
	
	protected void remove(GLAccount account)
	{
		if(!account.getMembers().isEmpty())
		{
			Iterator<GLAccount> iterator = account.getMembers().iterator();
			while (iterator.hasNext())
			{
				GLAccount member = (GLAccount) iterator.next();
				iterator.remove();
			
				remove(member);
			}
		}
		
		if(account.getParent() != null)
		{
			GLAccount parent = service.findOne(account.getParent().getId());
			Iterator<GLAccount> iterator = parent.getMembers().iterator();
			while (iterator.hasNext())
			{
				GLAccount member = (GLAccount) iterator.next();
				if(member.getId().equals(account.getId()))
				{
					iterator.remove();
					break;
				}
			}
			
			service.edit(parent);
		}
	}
}
