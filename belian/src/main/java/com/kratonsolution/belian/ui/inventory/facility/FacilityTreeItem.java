/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.facility;

import java.util.ArrayList;
import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treeitem;

import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.ui.ModelDataListener;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
public class FacilityTreeItem extends Treeitem implements ModelDataListener
{
	private Facility facility;
	
	private ModelDataListener listener;
	
	private Component canvas;
	
	public static FacilityTreeItem in(Component canvas,Facility facility)
	{
		FacilityTreeItem item = new FacilityTreeItem(facility);
		item.setCanvas(canvas);
		item.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				FacilityEditContent edit = new FacilityEditContent(facility);
				edit.addModelDataListener(item);
				
				canvas.getChildren().clear();
				canvas.appendChild(edit);
			}
		});
		
		return item;
	}
	
	public static Treeitem New(Component canvas,ModelDataListener listener)
	{
		Treeitem treeitem = new Treeitem("New");
		treeitem.setImage("/icons/new-warehouse.png");
		treeitem.appendChild(new Treechildren());
		treeitem.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				FacilityFormContent form = new FacilityFormContent(null);
				form.addModelDataListener(listener);
				
				canvas.getChildren().clear();
				canvas.appendChild(form);
			}
		});
		
		return treeitem;
	}
	
	public static Collection<FacilityTreeItem> list(Component canvas,Collection<Facility> list)
	{
		Collection<FacilityTreeItem> outs = new ArrayList<FacilityTreeItem>();
		
		for(Facility facility:list)
			outs.add(in(canvas,facility));
	
		return outs;
	}
	
	public FacilityTreeItem(Facility in)
	{
		this.facility = in;
		setLabel(in.getCode()+" - "+in.getName());
		setImage("/icons/leaf.png");
		appendChild(new Treechildren());
	}

	@Override
	public void fireDataAdded(Facility facility)
	{
		getTreechildren().appendChild(FacilityTreeItem.in(canvas, facility));
	}

	@Override
	public void fireDataUpdated(Facility facility)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fireDataRemoved(Facility facility)
	{
		// TODO Auto-generated method stub
		
	}
}
