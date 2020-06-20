package com.kratonsolution.belian.party.impl.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Getter
@Setter
@Entity
@Table(name="party_relationship")
public class PartyRelationship implements Serializable
{
	private static final long serialVersionUID = -3810420990043934420L;

	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="start")
	private Instant start;
	
	@Column(name="end")
	private Instant end;

	@ManyToOne
	@JoinColumn(name="fk_from_party")
	private Party fromParty;
	
	@ManyToOne
	@JoinColumn(name="fk_to_party")
	@NotFound(action = NotFoundAction.IGNORE)
	private Party toParty;
	
	@ManyToOne
	@JoinColumn(name="fk_from_role")
	@NotFound(action = NotFoundAction.IGNORE)
	private PartyRole fromRole;
	
	@ManyToOne
	@JoinColumn(name="fk_to_role")
	@NotFound(action = NotFoundAction.IGNORE)
	private PartyRole toRole;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private PartyRelationshipType type;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private PartyRelationshipStatusType status = PartyRelationshipStatusType.ACTIVE;
	
	@Version
	private Long version;
	
	public PartyRelationship(){}
}
