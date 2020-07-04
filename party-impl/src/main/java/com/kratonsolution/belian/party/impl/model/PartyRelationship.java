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

import com.kratonsolution.belian.party.api.model.PartyRelationshipStatus;
import com.kratonsolution.belian.party.api.model.PartyRelationshipType;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Getter
@Entity
@Table(name="party_relationship")
public class PartyRelationship implements Serializable
{
	private static final long serialVersionUID = -3810420990043934420L;

	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="start")
	private Instant start;
	
	@Setter
	@Column(name="end")
	private Instant end;

	@ManyToOne
	@JoinColumn(name="fk_from_party")
	private Party fromParty;
	
	@ManyToOne
	@JoinColumn(name="fk_to_party")
	@NotFound(action = NotFoundAction.IGNORE)
	private Party toParty;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private PartyRelationshipType type;
	
	@Setter
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private PartyRelationshipStatus status = PartyRelationshipStatus.ACTIVE;
	
	@Version
	private Long version;
	
	PartyRelationship(){}
	
	public PartyRelationship(@NonNull Party parent, @NonNull Party toParty, @NonNull Instant start, @NonNull PartyRelationshipType type){
		
		this.fromParty = parent;
		this.toParty = toParty;
		this.start = start;
		this.type = type;
	}
}
