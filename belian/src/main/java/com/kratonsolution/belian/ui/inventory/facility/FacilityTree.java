/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.facility;

import java.util.Collection;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treecol;
import org.zkoss.zul.Treecols;

import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.ui.ModelDataListener;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FacilityTree extends Tree implements ModelDataListener
{
	private FacilityService service = Springs.get(FacilityService.class);
	
	private Component container;
	
	public FacilityTree(Component contentArea)
	{
		this.container = contentArea;
		
		setWidth("100%");
		setHeight("100%");
		appendChild(new Treecols());
		appendChild(new Treechildren());
		getTreecols().appendChild(new Treecol("Facilitys(s)"));
		getTreechildren().appendChild(FacilityTreeItem.New(contentArea,this));
		
		Collection<FacilityTreeItem> items = FacilityTreeItem.list(contentArea,service.findAllParent());
		getTreechildren().getChildren().addAll(items);
		
		for(FacilityTreeItem item:items)
			populate(item);
	}
	
	@Override
	public void fireDataAdded(Facility facility)
	{
		if(facility.getParent() == null)
			getTreechildren().appendChild(FacilityTreeItem.in(container,facility));
		else
			extract(FacilityTreeItem.in(container, facility), facility);
	}

	@Override
	public void fireDataUpdated(Facility facility)
	{
	}

	@Override
	public void fireDataRemoved(Facility facility)
	{
	}

	public void extract(FacilityTreeItem item,Facility child)
	{
		if(item.getFacility().getId().equals(child.getParent().getId()))
			item.getTreechildren().appendChild(FacilityTreeItem.in(container, child));
		else 
		{
			for(Component component:item.getTreechildren().getChildren())
				extract((FacilityTreeItem)component, child);
		}
	}
	
	public void populate(FacilityTreeItem parent)
	{
		for(Facility facility:parent.getFacility().getChilds())
		{
			FacilityTreeItem item = FacilityTreeItem.in(container, facility);
			parent.getTreechildren().appendChild(item);
			if(!facility.getChilds().isEmpty())
				populate(item);
		}
	}
}
