/**
 * 
 */
package com.kratonsolution.belian.ui.assettype;

import java.util.Collection;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treecol;
import org.zkoss.zul.Treecols;

import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class AssetTypeTree extends Tree
{
	private FacilityService service = Springs.get(FacilityService.class);
	
	private Component container;
	
	public AssetTypeTree(Component contentArea)
	{
		this.container = contentArea;
		
		setWidth("100%");
		setHeight("100%");
		appendChild(new Treecols());
		appendChild(new Treechildren());
		getTreecols().appendChild(new Treecol("Facilitys(s)"));
		getTreechildren().appendChild(AssetTypeTreeItem.New(contentArea,this));
		
		Collection<AssetTypeTreeItem> items = AssetTypeTreeItem.list(contentArea,service.findAllParent());
		getTreechildren().getChildren().addAll(items);
		
		for(AssetTypeTreeItem item:items)
			populate(item);
	}
	
	@Override
	public void fireDataAdded(Facility facility)
	{
		if(facility.getParent() == null)
			getTreechildren().appendChild(AssetTypeTreeItem.in(container,facility));
		else
			extract(AssetTypeTreeItem.in(container, facility), facility);
	}

	@Override
	public void fireDataUpdated(Facility facility)
	{
	}

	@Override
	public void fireDataRemoved(Facility facility)
	{
	}

	public void extract(AssetTypeTreeItem item,Facility child)
	{
		if(item.getFacility().getId().equals(child.getParent().getId()))
			item.getTreechildren().appendChild(AssetTypeTreeItem.in(container, child));
		else 
		{
			for(Component component:item.getTreechildren().getChildren())
				extract((AssetTypeTreeItem)component, child);
		}
	}
	
	public void populate(AssetTypeTreeItem parent)
	{
		for(Facility facility:parent.getFacility().getChilds())
		{
			AssetTypeTreeItem item = AssetTypeTreeItem.in(container, facility);
			parent.getTreechildren().appendChild(item);
			if(!facility.getChilds().isEmpty())
				populate(item);
		}
	}
}
