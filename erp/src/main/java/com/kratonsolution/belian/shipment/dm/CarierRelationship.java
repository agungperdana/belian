package com.kratonsolution.belian.shipment.dm;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.kratonsolution.belian.core.companystructure.impl.orm.InternalOrganization;
import com.kratonsolution.belian.core.party.impl.orm.PartyRelationship;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
@Getter
@Setter
@Entity
@Table(name="carier_relationship")
@Inheritance(strategy=InheritanceType.JOINED)
public class CarierRelationship extends PartyRelationship
{
	@ManyToOne
	@JoinColumn(name="fk_carrier")
	private Carrier carrier;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	private InternalOrganization organization;
}
