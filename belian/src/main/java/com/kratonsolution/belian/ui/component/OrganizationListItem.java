/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import lombok.Getter;
import lombok.Setter;

import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.general.dm.Organization;

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
