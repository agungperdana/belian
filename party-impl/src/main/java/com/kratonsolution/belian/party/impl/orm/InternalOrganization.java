
package com.kratonsolution.belian.party.impl.orm;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

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
