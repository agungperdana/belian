package com.kratonsolution.belian.geographic.ui;

import java.util.Set;

import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.TreeitemRenderer;
import org.zkoss.zul.Treerow;

import com.kratonsolution.belian.geographic.api.GeographicData;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
public class GeographicTreeItemRenderer implements TreeitemRenderer<GeographicTreeNode>
{

	@Override
	public void render(Treeitem item, GeographicTreeNode node, int index) throws Exception {

		Treerow root = new Treerow();
		root.appendChild(new Treecell(node.getData().getCode()));
		root.appendChild(new Treecell(node.getData().getName()));
		root.appendChild(new Treecell(node.getData().getNote()));
		
		item.appendChild(root);
		
		pop(item, node.getData().getChilds());
	}
	
	private void pop(@NonNull Treeitem root, Set<GeographicData> child) {
		
		if(child != null && !child.isEmpty()) {
			child.forEach(data -> {
				
				Treeitem item = new Treeitem();
				
				Treerow dataRow = new Treerow();
				dataRow.appendChild(new Treecell(data.getCode()));
				dataRow.appendChild(new Treecell(data.getName()));
				dataRow.appendChild(new Treecell(data.getNote()));
				
				item.appendChild(dataRow);
				
				pop(item, data.getChilds());
			});
		}
	}
	
}
