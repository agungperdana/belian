package com.kratonsolution.belian.geographic.ui;

import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.TreeitemRenderer;
import org.zkoss.zul.Treerow;

import com.kratonsolution.belian.common.ui.event.ContentEvent;
import com.kratonsolution.belian.common.ui.event.GeographicUIContentEvent;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Slf4j
public class GeographicTreeItemRenderer implements TreeitemRenderer<GeographicTreeNode>
{

	@Override
	public void render(Treeitem item, GeographicTreeNode node, int index) throws Exception {
		
		log.info("Tree item renderer {}", item);
		
		Treerow row = new Treerow();
		row.appendChild(new Treecell(node.getData().getCode()));
		row.appendChild(new Treecell(node.getData().getName()));
		row.appendChild(new Treecell(node.getData().getType().name()));
		row.appendChild(new Treecell(node.getData().getNote()));
		row.addEventListener(Events.ON_CLICK, e->{
			
			GeographicUIContentEvent event = new GeographicUIContentEvent(ContentEvent.EDIT_FORM);
			event.setCode(node.getData().getCode());
			EventQueues.lookup(GeographicUIContentEvent.class.getSimpleName()).publish(event);
		});
		
		item.appendChild(row);
	}
}
