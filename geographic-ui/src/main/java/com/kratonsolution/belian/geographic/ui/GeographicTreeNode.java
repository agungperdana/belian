package com.kratonsolution.belian.geographic.ui;

import org.zkoss.zul.DefaultTreeNode;

import com.kratonsolution.belian.geographic.api.GeographicData;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Getter
@Setter
public class GeographicTreeNode extends DefaultTreeNode<GeographicData> {

	private static final long serialVersionUID = 7319945984342340163L;
	
	private boolean open;
	
	public GeographicTreeNode(GeographicData data) {
		super(data);
	}

	public GeographicTreeNode(GeographicData data, DefaultTreeNode<GeographicData>[] children) {
		super(data, children);
	}
	
	public GeographicTreeNode(GeographicData data, DefaultTreeNode<GeographicData>[] children, boolean open) {
		super(data, children);
		setOpen(open);
	}
}
