
package com.kratonsolution.belian.ui.products.category;

import java.util.Collection;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Center;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treecol;
import org.zkoss.zul.Treecols;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.Treerow;

import com.kratonsolution.belian.common.app.Language;
import com.kratonsolution.belian.products.dm.ProductCategory;
import com.kratonsolution.belian.products.svc.ProductCategoryService;
import com.kratonsolution.belian.ui.Removeable;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductCategoryTree extends Tree implements Removeable
{
	private Language lang = Springs.get(Language.class);
	
	private ProductCategoryService service = Springs.get(ProductCategoryService.class);
	
	private Center center;
	
	public ProductCategoryTree(Center center)
	{
		this.center = center;
		
		setHflex("1");
		setHeight("98%");
		
		appendChild(new Treecols());
		appendChild(new Treechildren());
		
		getTreecols().appendChild(new Treecol(lang.get("navbar.menu.products.category"),null,"90%"));
		getTreecols().appendChild(new Treecol(""));
		
		Treeitem add = new Treeitem(lang.get("label.component.button.new"));
		add.setImage("/icons/new-warehouse.png");
		add.addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Flow.next(center, new ProductCategoryFormContent(null));
			}
		});
		
		getTreechildren().appendChild(add);
		
		for(ProductCategory category:service.findAllParent())
		{
			Treecell title = new Treecell(category.getName());
			Treecell close = new Treecell(null,"/icons/deletesmall.png");
			
			Treeitem parent = new Treeitem();
			parent.appendChild(new Treechildren());
			parent.appendChild(new Treerow());
			parent.getTreerow().appendChild(title);
			parent.getTreerow().appendChild(close);
			
			title.addEventListener(Events.ON_CLICK, new EventListener<Event>()
			{
				@Override
				public void onEvent(Event arg0) throws Exception
				{
					Flow.next(center, new ProductCategoryEditContent(center, category));
				}
			});
			
			close.addEventListener(Events.ON_CLICK, new EventListener<Event>()
			{
				@Override
				public void onEvent(Event arg0) throws Exception
				{
					Messagebox.show(lang.get("message.removedata"),"Warning",Messagebox.CANCEL|Messagebox.OK, Messagebox.QUESTION,new EventListener<Event>()
					{
						@Override
						public void onEvent(Event event) throws Exception
						{
							if(event.getName().equals("onOK"))
							{
								service.delete(category.getId());
								Flow.next(center, null);
								Flow.next(getParent(), new ProductCategoryTree(center));
							}
						}
					});
				}
			});

			extract(category.getChilds(), parent.getTreechildren());
			
			getTreechildren().appendChild(parent);
		}
	}
	
	private void extract(Collection<ProductCategory> childs,Treechildren treechildren)
	{
		for(ProductCategory next:childs)
		{
			Treecell title = new Treecell(next.getName());
			Treecell close = new Treecell(null,"/icons/deletesmall.png");
			
			Treeitem parent = new Treeitem();
			parent.appendChild(new Treechildren());
			parent.appendChild(new Treerow());
			parent.getTreerow().appendChild(title);
			parent.getTreerow().appendChild(close);
			
			title.addEventListener(Events.ON_CLICK, new EventListener<Event>()
			{
				@Override
				public void onEvent(Event arg0) throws Exception
				{
					Flow.next(center, new ProductCategoryEditContent(center, next));
				}
			});
			
			close.addEventListener(Events.ON_CLICK, new EventListener<Event>()
			{
				@Override
				public void onEvent(Event arg0) throws Exception
				{
					Messagebox.show(lang.get("message.removedata"),"Warning",Messagebox.CANCEL|Messagebox.OK, Messagebox.QUESTION,new EventListener<Event>()
					{
						@Override
						public void onEvent(Event event) throws Exception
						{
							if(event.getName().equals("onOK"))
							{
								service.delete(next.getId());
								Flow.next(center, null);
								Flow.next(getParent(), new ProductCategoryTree(center));
							}
						}
					});
				}
			});
			
			treechildren.appendChild(parent);
		
			if(!next.getChilds().isEmpty())
				extract(next.getChilds(), parent.getTreechildren());
		}
	}
}
