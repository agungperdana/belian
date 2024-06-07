
package com.kratonsolution.belian.ui.inventory.facility;

import java.util.Collection;
import java.util.Iterator;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treecol;
import org.zkoss.zul.Treecols;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.Treerow;

import com.kratonsolution.belian.common.orm.Observer;
import com.kratonsolution.belian.common.app.Language;
import com.kratonsolution.belian.inventory.dm.Container;
import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.inventory.svc.ContainerService;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.ui.CenterContent;
import com.kratonsolution.belian.ui.Removeable;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ContainerTree extends Tree implements Removeable
{
	private Language lang = Springs.get(Language.class);
	
	private FacilityService service = Springs.get(FacilityService.class);
	
	private ContainerService containerService = Springs.get(ContainerService.class);
	
	private Facility facility;
	
	public ContainerTree(Facility facility,CenterContent canvas)
	{
		setHflex("1");
		setHeight("99%");
		
		appendChild(new Treecols());
		appendChild(new Treechildren());
		
		Facility out = service.findById(facility.getId());
		
		getTreecols().appendChild(new Treecol(out != null?out.getName():"",null,"90%"));
		getTreecols().appendChild(new Treecol(""));
		
		Treeitem add = new Treeitem(lang.get("label.component.button.new"));
		add.setImage("/icons/new-warehouse.png");
		add.addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				canvas.getChildren().clear();
				canvas.appendChild(new ContainerFormContent(facility, null));
			}
		});
		
		getTreechildren().appendChild(add);
		
		for(Container container:out.getContainers())
		{
			Treecell title = new Treecell(container.getName());
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
					canvas.getChildren().clear();
					canvas.appendChild(new ContainerEditContent(facility, container));
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
								remove(container, canvas);
							}
						}
					});
				}
			});

			extract(container.getChilds(), parent.getTreechildren(),canvas);
			
			getTreechildren().appendChild(parent);
		}
	}
	
	private void extract(Collection<Container> childs,Treechildren treechildren,CenterContent canvas)
	{
		for(Container next:childs)
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
					canvas.getChildren().clear();
					canvas.appendChild(new ContainerEditContent(facility, next));
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
								remove(next,canvas);
							}
						}
					});
				}
			});
			
			treechildren.appendChild(parent);
		
			if(!next.getChilds().isEmpty())
				extract(next.getChilds(), parent.getTreechildren(),canvas);
		}
	}
	
	private void remove(Container container,CenterContent canvas)
	{
		if(container.getFacility() == null)
			containerService.delete(container.getId());
		else
		{
			Iterator<Container> iterator = container.getFacility().getContainers().iterator();
			while (iterator.hasNext())
			{
				Container con = (Container) iterator.next();
				if(con.getId().equals(container.getId()))
				{
					iterator.remove();
					break;
				}
			}
		
			service.edit(container.getFacility());
		}
		
		for(Observer observer:canvas.getObservers())
			observer.valueChange(null);
	}
}
