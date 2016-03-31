/**
 * 
 */
package com.kratonsolution.belian.ui.assettype;

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

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
public class AssetTypeTreeItem extends Treeitem implements FacilityDataListener
{
	private Facility facility;
	
	private FacilityDataListener listener;
	
	private Component canvas;
	
	public static AssetTypeTreeItem in(Component canvas,Facility facility)
	{
		AssetTypeTreeItem item = new AssetTypeTreeItem(facility);
		item.setCanvas(canvas);
		item.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				AssetTypeEditContent edit = new AssetTypeEditContent(facility);
				edit.addModelDataListener(item);
				
				canvas.getChildren().clear();
				canvas.appendChild(edit);
			}
		});
		
		return item;
	}
	
	public static Treeitem New(Component canvas,FacilityDataListener listener)
	{
		Treeitem treeitem = new Treeitem("New");
		treeitem.setImage("/icons/new-warehouse.png");
		treeitem.appendChild(new Treechildren());
		treeitem.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				AssetTypeFormContent form = new AssetTypeFormContent(null);
				form.addModelDataListener(listener);
				
				canvas.getChildren().clear();
				canvas.appendChild(form);
			}
		});
		
		return treeitem;
	}
	
	public static Collection<AssetTypeTreeItem> list(Component canvas,Collection<Facility> list)
	{
		Collection<AssetTypeTreeItem> outs = new ArrayList<AssetTypeTreeItem>();
		
		for(Facility facility:list)
			outs.add(in(canvas,facility));
	
		return outs;
	}
	
	public AssetTypeTreeItem(Facility in)
	{
		this.facility = in;
		setLabel(in.getCode()+" - "+in.getName());
		setImage("/icons/leaf.png");
		appendChild(new Treechildren());
	}

	@Override
	public void fireDataAdded(Facility facility)
	{
		getTreechildren().appendChild(AssetTypeTreeItem.in(canvas, facility));
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
