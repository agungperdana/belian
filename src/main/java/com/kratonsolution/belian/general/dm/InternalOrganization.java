package com.kratonsolution.belian.general.dm;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import com.kratonsolution.belian.partys.dm.Organization;
import com.kratonsolution.belian.partys.dm.PartyRole;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
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
