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
@Table(name="party_classification")
public class PartyClassification implements Serializable
{
	private static final long serialVersionUID = -3738615250193814386L;

	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="start")
	private Instant start;
	
	@Column(name="end")
	private Instant end;

	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private PartyClassificationType type = PartyClassificationType.INDUSTRY_CLASSIFICATION;

	@Column(name="value")
	private String value;
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	private Party party;
	
	@Version
	private Long version;
}