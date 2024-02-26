/**
 * 
 */
package com.kratonsolution.belian.shipment.dm;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kratonsolution.belian.general.dm.InternalOrganization;
import com.kratonsolution.belian.partys.dm.PartyRelationship;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
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
