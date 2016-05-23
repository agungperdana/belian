/**
 * 
 */
package com.kratonsolution.belian.ui.general.companystructure;

import java.util.ArrayList;
import java.util.Collection;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treeitem;

import com.kratonsolution.belian.general.dm.CompanyStructure;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
public class CompanyStructureTreeItem extends Treeitem
{
	private CompanyStructure company;
	
	private Component canvas;
	
	public static CompanyStructureTreeItem in(Component canvas,CompanyStructure company)
	{
		CompanyStructureTreeItem item = new CompanyStructureTreeItem(company);
		item.setCanvas(canvas);
		item.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				CompanyStructureEditContent content = new CompanyStructureEditContent(canvas, company);
				
				CompanyStructureTree tree = (CompanyStructureTree)item.getTree();
				content.addDataListener(tree);
				
				canvas.getChildren().clear();
				canvas.appendChild(content);
			}
		});
		
		return item;
	}
	
	public static Treeitem New(Component canvas,CompanyStructureDataListener listener)
	{
		Treeitem treeitem = new Treeitem("New");
		treeitem.setImage("/icons/new-warehouse.png");
		treeitem.appendChild(new Treechildren());
		treeitem.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				CompanyStructureTree parent = (CompanyStructureTree)treeitem.getTree();
				CompanyStructureFormContent form = new CompanyStructureFormContent(null);
				if(parent != null)
					form.addDataListener(parent);
				
				canvas.getChildren().clear();
				canvas.appendChild(form);
			}
		});
		
		return treeitem;
	}
	
	public static Collection<CompanyStructureTreeItem> list(Component canvas,Collection<CompanyStructure> list)
	{
		Collection<CompanyStructureTreeItem> outs = new ArrayList<CompanyStructureTreeItem>();
		
		for(CompanyStructure company:list)
		{
			if(company.getOrganization() != null)
				outs.add(in(canvas,company));
		}
	
		return outs;
	}
	
	public CompanyStructureTreeItem(CompanyStructure in)
	{
		this.company = in;
		setLabel(in.getOrganization().getName()+" ("+in.getType().name()+")");
		setImage("/icons/leaf.png");
		setId(in.getId());
		appendChild(new Treechildren());
	}
}
