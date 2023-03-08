/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.kratonsolution.belian.partys.dm.Organization;
import com.kratonsolution.belian.partys.dm.PartyRole;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="internal_organization")
public class InternalOrganization extends PartyRole
{
	public Organization getOrganization()
	{
		return (Organization)getParty();
	}
}
