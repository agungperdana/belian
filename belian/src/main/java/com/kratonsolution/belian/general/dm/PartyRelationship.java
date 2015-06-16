/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.global.dm.EconomicAgent;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="party_relationship")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="relationship_type")
public class PartyRelationship
{
	@Id
	protected String id;
	
	@Column(name="date_from",nullable=false)
	protected Date from;
	
	@Column(name="date_to")
	protected Date to;
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	protected EconomicAgent party;

	@ManyToOne
	@JoinColumn(name="fk_party_responsible_to")
	protected EconomicAgent responsibleTo;

	@ManyToOne
	@JoinColumn(name="fk_party_role_type")
	protected PartyRoleType responsibleAs;
	
	@ManyToOne
	@JoinColumn(name="fk_party_relationhip_type")
	protected PartyRelationshipType relationshipType;
	
	@Version
	protected Long version;
}
