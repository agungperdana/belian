/**
 * 
 */
package com.kratonsolution.belian.ui.assettype;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treecol;
import org.zkoss.zul.Treecols;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.West;

import com.kratonsolution.belian.asset.dm.AssetType;
import com.kratonsolution.belian.asset.svc.AssetTypeService;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.Removeable;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class AssetTypeContent extends Borderlayout implements Removeable
{
	private AssetTypeService service = Springs.get(AssetTypeService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private West west = new West();
	
	private Center center = new Center();
	
	private Tree tree = new Tree();
	
	public AssetTypeContent()
	{
		setHflex("1");
		setVflex("1");
		
		west.setWidth("30%");
		west.setStyle("overflow:auto;");
		
		appendChild(west);
		appendChild(center);
		
		initTree();
	}
	
	private void initTree()
	{
		tree.appendChild(new Treecols());
		tree.appendChild(new Treechildren());
		tree.getTreecols().appendChild(new Treecol("Asset Type(s)"));
		
		Treeitem con = new Treeitem("New Type");
		con.setImage("/icons/new-warehouse.png");
		con.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Flow.next(center,new AssetTypeFormContent(null));
			}
		});

		tree.getTreechildren().appendChild(con);
		
		for(AssetType type:service.findAllParent())
		{
			Treeitem treeitem = new Treeitem(type.getCode()+"-"+type.getName());
			treeitem.setImage("/icons/leaf.png");
			treeitem.setId(type.getId());
			treeitem.appendChild(new Treechildren());
			treeitem.addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event arg0) throws Exception
				{
					Flow.next(center, new AssetTypeEditContent(type));
				}
			});
			
			tree.getTreechildren().appendChild(treeitem);
			
			extract(treeitem, type);
		}
		
		west.appendChild(tree);
	}
	
	private void extract(Treeitem parent,AssetType asset)
	{
		for(AssetType child:asset.getChilds())
		{
			Treeitem treeitem = new Treeitem(child.getName());
			treeitem.setId(child.getId());
			treeitem.setImage("/icons/leaf.png");
			treeitem.appendChild(new Treechildren());
			treeitem.addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event arg0) throws Exception
				{
					Flow.next(center, new AssetTypeEditContent(child));
				}
			});
			
			parent.getTreechildren().appendChild(treeitem);
			
			if(!child.getChilds().isEmpty())
				extract(treeitem, child);
		}
	}
}