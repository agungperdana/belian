
package com.kratonsolution.belian.ui.general.companystructure;

import java.io.Serializable;

import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.West;

import com.kratonsolution.belian.company.structure.impl.application.CompanyStructureService;
import com.kratonsolution.belian.ui.Removeable;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CompanyStructureContent extends Borderlayout implements Serializable,Removeable
{
	private CompanyStructureService service = Springs.get(CompanyStructureService.class);
	
	private West west = new West();
	
	private Center center = new Center();
	
	public CompanyStructureContent()
	{
		setHflex("1");
		setVflex("1");
		
		west.setWidth("38%");
		west.setBorder("none");
		west.setStyle("overflow:auto");

		center.setBorder("none");
		center.setStyle("overflow:auto");
		
		appendChild(west);
		appendChild(center);
		
		west.appendChild(new CompanyStructureTree(center));
	}
}