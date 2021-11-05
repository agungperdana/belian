package com.kratonsolution.belian.party.impl.model;

import java.io.Serializable;
import java.util.Date;
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

import com.google.common.base.MoreObjects;
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
	private Date start;
	
	@Setter
	@Column(name="end")
	private Date end;

	@ManyToOne
	@JoinColumn(name="fk_from_party")
	private Party fromParty;
	
	@ManyToOne
	@JoinColumn(name="fk_to_party")
	private Party toParty;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private PartyRelationshipType type;
	
	@Version
	private Long version;
	
	PartyRelationship(){}
	
	public PartyRelationship(@NonNull Party parent, @NonNull Party toParty, @NonNull Date start, @NonNull PartyRelationshipType type){
		
		this.fromParty = parent;
		this.toParty = toParty;
		this.start = start;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("To Party", toParty.getName())
				.add("start", start)
				.add("end", end)
				.add("type", type)
				.toString();
	}
}
