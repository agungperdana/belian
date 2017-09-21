/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.facility;

import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.Label;
import org.zkoss.zul.West;

import com.kratonsolution.belian.ui.GridToolbar;
import com.kratonsolution.belian.ui.Removeable;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FacilityContent extends Borderlayout implements Removeable
{
	private GridToolbar toolbar = new GridToolbar();

	private West west = new West();
	
	private Center center = new Center();

	private FacilityTree tree = new FacilityTree(center);
	
	public FacilityContent()
	{
		setWidth("100%");
		setHeight("97%");
		setStyle("overflow:auto");
	
		initWest();
		initCenter();
	}
	
	private void initWest()
	{
		appendChild(west);
		
		west.setWidth("35%");
		west.setStyle("over-flow:auto;");
		west.setBorder("none");
		west.appendChild(tree);
	}
	
	private void initCenter()
	{
		appendChild(center);
		
		center.appendChild(new Label());
	}
}
