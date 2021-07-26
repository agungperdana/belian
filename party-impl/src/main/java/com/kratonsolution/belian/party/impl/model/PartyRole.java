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
import com.kratonsolution.belian.party.api.model.PartyRoleType;

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
@Table(name="party_role")
public class PartyRole implements Serializable
{
	private static final long serialVersionUID = -2424004223402414808L;

	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="start")
	private Date start;

	@Setter
	@Column(name="end")
	private Date end;

	@ManyToOne
	@JoinColumn(name="fk_party")
	private Party party;

	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private PartyRoleType type;

	@Version
	private Long version;

	PartyRole(){}

	public PartyRole(@NonNull Party parent, @NonNull Date start, @NonNull PartyRoleType type){

		this.party = parent;
		this.start = start;
		this.type = type;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("start", start)
				.add("end", end)
				.add("type", type)
				.toString();
	}
}
