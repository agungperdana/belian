package com.kratonsolution.belian.geographic.ui;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;

import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.geographic.api.GeographicData;
import com.kratonsolution.belian.geographic.api.application.GeographicService;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Getter
@Setter
public class GeographicTreeModel extends DefaultTreeModel<GeographicData>
{
	private static final long serialVersionUID = -7912337109938668518L;

	private DefaultTreeNode<GeographicData> root;
	
	public GeographicTreeModel(GeographicTreeNode root) {
		super(root);
		setMultiple(true);
		setRoot(root);
	}
	
	public void remove(DefaultTreeNode<GeographicData> parent, int indexFrom, int indexTo) throws IndexOutOfBoundsException {
        DefaultTreeNode<GeographicData> stn = parent;
        for (int i = indexTo; i >= indexFrom; i--)
            try {
                stn.getChildren().remove(i);
            } catch (Exception exp) {
                exp.printStackTrace();
            }
    }
 
    public void remove(DefaultTreeNode<GeographicData> target) throws IndexOutOfBoundsException {
        int index = 0;
        DefaultTreeNode<GeographicData> parent = null;
        // find the parent and index of target
        parent = dfSearchParent(getRoot(), target);
        for (index = 0; index < parent.getChildCount(); index++) {
            if (parent.getChildAt(index).equals(target)) {
                break;
            }
        }
        remove(parent, index, index);
    }

    public void insert(DefaultTreeNode<GeographicData> parent, int indexFrom, int indexTo, DefaultTreeNode<GeographicData>[] newNodes)
            throws IndexOutOfBoundsException {
        DefaultTreeNode<GeographicData> stn = parent;
        for (int i = indexFrom; i <= indexTo; i++) {
            try {
                stn.getChildren().add(i, newNodes[i - indexFrom]);
            } catch (Exception exp) {
                throw new IndexOutOfBoundsException("Out of bound: " + i + " while size=" + stn.getChildren().size());
            }
        }
    }

    public void add(DefaultTreeNode<GeographicData> parent, DefaultTreeNode<GeographicData>[] newNodes) {
        DefaultTreeNode<GeographicData> stn = (DefaultTreeNode<GeographicData>) parent;
 
        for (int i = 0; i < newNodes.length; i++)
            stn.getChildren().add(newNodes[i]);
 
    }
 
    private DefaultTreeNode<GeographicData> dfSearchParent(DefaultTreeNode<GeographicData> node, DefaultTreeNode<GeographicData> target) {
        if (node.getChildren() != null && node.getChildren().contains(target)) {
            return node;
        } else {
            int size = getChildCount(node);
            for (int i = 0; i < size; i++) {
                DefaultTreeNode<GeographicData> parent = dfSearchParent((DefaultTreeNode<GeographicData>) getChild(node, i), target);
                if (parent != null) {
                    return parent;
                }
            }
        }
        return null;
    }
    
    public static GeographicTreeModel buid() {
    	
    	GeographicService service = Springs.get(GeographicService.class);
    	
    	List<GeographicData> _roots = service.getAllGeographicRoots();
    	
    	GeographicTreeNode nodes[] = new GeographicTreeNode[_roots.size()];
    	for(int idx=0;idx<_roots.size();idx++) {
    		
    		GeographicData data = _roots.get(idx);
    		nodes[idx] = new GeographicTreeNode(data, toNode(new ArrayList<>(data.getChildren())));
    	}
    	
    	return new GeographicTreeModel(new GeographicTreeNode(null, nodes));
    }
    
    private static GeographicTreeNode[] toNode(List<GeographicData> childs) {
    	
    	if(childs != null && !childs.isEmpty()) {
    		
    		GeographicTreeNode nodes[] = new GeographicTreeNode[childs.size()];
    		for(int idx=0;idx<childs.size();idx++) {
    			
    			GeographicData data = childs.get(idx);
    			nodes[idx] = new GeographicTreeNode(data, toNode(new ArrayList<>(data.getChildren())));
    		}
    		
    		return nodes;
    	}
    	
    	return null;
    }
}
