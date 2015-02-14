/**
 * 
 */
package com.kratonsolution.belian.ui.coa;

import java.util.Iterator;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.accounting.dm.GLAccount;
import com.kratonsolution.belian.accounting.svc.GLAccountService;
import com.kratonsolution.belian.ui.Refreshable;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class COAEditContent extends Vlayout implements Refreshable
{	
	private final GLAccountService service = Springs.get(GLAccountService.class);

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
		
		Toolbarbutton back = new Toolbarbutton("Back","/icons/back.png");
		Toolbarbutton account = new Toolbarbutton("New Account", "/icons/coasmall.png");
		Toolbarbutton delete = new Toolbarbutton("Delete","/icons/delete.png");
		
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
				Messagebox.show("Are you sure want to remove the data(s) ?","Warning",Messagebox.CANCEL|Messagebox.OK, Messagebox.QUESTION,new EventListener<Event>()
				{
					@Override
					public void onEvent(Event event) throws Exception
					{
						if(event.getName().equals("onOK"))
						{
							if(tree.getSelectedItem() != null)
							{
								remove(service.findOne(tree.getSelectedItem().getId()));
							}
							
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
		
		service.delete(account.getId());
	}
}