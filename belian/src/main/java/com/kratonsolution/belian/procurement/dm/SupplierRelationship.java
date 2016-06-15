/**
 * 
 */
package com.kratonsolution.belian.procurement.dm;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kratonsolution.belian.general.dm.InternalOrganization;
import com.kratonsolution.belian.general.dm.PartyRelationship;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="supplier_relationship")
public class SupplierRelationship extends PartyRelationship
{
	@ManyToOne
	@JoinColumn(name="fk_supplier")
	private Supplier supplier;
	
	@ManyToOne
	@JoinColumn(name="fk_internal_organization")
	private InternalOrganization organization;
	
	public SupplierRelationship(){}
}
