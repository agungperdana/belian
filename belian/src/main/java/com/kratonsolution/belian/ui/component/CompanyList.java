/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Listbox;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.CompanyStructure;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.svc.CompanyStructureService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CompanyList extends Listbox implements Serializable
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private CompanyStructureService service = Springs.get(CompanyStructureService.class);
	
	private Map<String,Organization> maps = new HashMap<>();
	
	public CompanyList()
	{
		setWidth("290px");
		setMold("select");
		
		for(CompanyStructure structure:service.findAllCompany(null))
		{
			appendItem(structure.getOrganization().getName(),structure.getOrganization().getId());
			if(!maps.containsKey(structure.getOrganization().getId()))
				maps.put(structure.getOrganization().getId(),structure.getOrganization());
		}
		
		if(getSelectedItem() == null && !getItems().isEmpty())
			setSelectedIndex(0);
	}
	
	public Organization getOrganization()
	{
		if(getSelectedItem() == null)
		{
			Clients.showNotification("Please select organization first.");
			return null;
		}
			
		return maps.get(getSelectedItem().getValue().toString());	
	}
	
	public void setOrganization(Organization organization)
	{
		if(organization != null)
		{
			getChildren().clear();
			setSelectedItem(appendItem(organization.getLabel(), organization.getValue()));
		}
	}
}
