package com.kratonsolution.belian.common.ui.util;

import org.zkoss.zul.Auxhead;
import org.zkoss.zul.Auxheader;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GridHelper {

	public static Auxhead buildHead(String headeritle, int headerSpan) {
		
		Auxhead head = new Auxhead();
		Auxheader header = new Auxheader(headeritle);
		header.setColspan(headerSpan);
		header.setRowspan(1);

		head.appendChild(header);
		
		return head;
	}
}
