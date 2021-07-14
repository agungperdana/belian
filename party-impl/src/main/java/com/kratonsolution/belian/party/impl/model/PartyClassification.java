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

import com.kratonsolution.belian.party.api.model.PartyClassificationType;

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
@Table(name="party_classification")
public class PartyClassification implements Serializable
{
	private static final long serialVersionUID = -3738615250193814386L;

	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="start")
	private Instant start;

	@Setter
	@Column(name="end")
	private Instant end;

	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private PartyClassificationType type = PartyClassificationType.INDUSTRY_CLASSIFICATION;

	@Setter
	@Column(name="value")
	private String value;
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	private Party party;
	
	@Version
	private Long version;
	
	PartyClassification() {}
	
	public PartyClassification(@NonNull Party party, @NonNull Instant start, @NonNull String value, @NonNull PartyClassificationType type) {
		
		this.party = party;
		this.start = start;
		this.value = value;
		this.type = type;
	}
}