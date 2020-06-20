package com.kratonsolution.belian.party.impl.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.party.api.model.PartyRoleType;

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
@Table(name="party_role")
@Inheritance(strategy=InheritanceType.JOINED)
public class PartyRole implements Serializable
{
	private static final long serialVersionUID = -2424004223402414808L;

	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="start",nullable=false)
	protected Instant start;
	
	@Column(name="end")
	protected Instant end;
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	protected Party party;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	protected PartyRoleType type;
	
	@Version
	protected Long version;
	
	public PartyRole(){}
}
