/**
 * 
 */
package com.kratonsolution.belian.ui.general.companystructure;

import java.io.Serializable;

import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.West;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.svc.CompanyStructureService;
import com.kratonsolution.belian.ui.Removeable;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CompanyStructureContent extends Borderlayout implements Serializable,Removeable
{
	private final CompanyStructureService controller = Springs.get(CompanyStructureService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private West west = new West();
	
	private Center center = new Center();
	
	private CompanyStructureTree tree = new CompanyStructureTree(center);
	
	public CompanyStructureContent()
	{
		setHflex("1");
		setVflex("1");
		west.setWidth("38%");
		west.setStyle("overflow:auto");
		
		center.setStyle("overflow:auto");
		
		appendChild(west);
		appendChild(center);
		
		west.appendChild(tree);
	}
}