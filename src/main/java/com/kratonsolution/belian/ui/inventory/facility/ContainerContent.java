
package com.kratonsolution.belian.ui.inventory.facility;

import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.West;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.api.dm.Observer;
import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.ui.CenterContent;
import com.kratonsolution.belian.ui.Removeable;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ContainerContent extends Borderlayout implements Removeable,Observer
{
	private West west = new West();
	
	private CenterContent center = new CenterContent();
	
	private Facility facility;
	
	public ContainerContent(Facility facility)
	{
		this.facility = facility;
		
		setHflex("1");
		setVflex("1");
		
		west.setWidth("200px");
		west.setBorder("none");
		
		center.setBorder("none");
		
		appendChild(west);
		appendChild(center);
		
		west.appendChild(new ContainerTree(facility,center));
		center.addObserver(this);
	}

	@Override
	public void valueChange(IDValueRef value)
	{
		west.getChildren().clear();
		west.appendChild(new ContainerTree(facility,center));
	}
}