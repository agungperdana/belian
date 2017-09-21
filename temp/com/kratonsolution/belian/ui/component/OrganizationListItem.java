/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.partys.dm.Organization;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
public class OrganizationListItem extends Listitem
{
	private Organization organization;
	
	public OrganizationListItem(Organization organization)
	{
		setLabel(organization.getLabel());
		setValue(organization.getValue());
	}
}
