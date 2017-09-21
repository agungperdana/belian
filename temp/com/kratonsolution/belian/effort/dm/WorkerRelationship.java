/**
 * 
 */
package com.kratonsolution.belian.effort.dm;

import javax.persistence.Entity;
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
@Table(name="worker_relationship")
public class WorkerRelationship extends PartyRelationship
{
	@ManyToOne
	@JoinColumn(name="fk_worker")
	private Worker worker;
	
	@ManyToOne
	@JoinColumn(name="fk_internal_organization")
	private InternalOrganization organization;
}
