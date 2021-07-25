package com.kratonsolution.belian.party.impl.model;

import java.io.Serializable;
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
import com.kratonsolution.belian.party.api.model.ContactType;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 1.0
 */
@Getter
@Entity
@Table(name="contact")
public class Contact implements Serializable
{
	private static final long serialVersionUID = -3119257260126834977L;

	@Id
	private String id = UUID.randomUUID().toString();

	@Setter
	@Column(name="contact",nullable=false)
	private String contact;

	@Setter
	@Column(name="type",nullable=false)
	@Enumerated(EnumType.STRING)
	private ContactType type = ContactType.OFFICE_PHONE;

	@Setter
	@Column(name="is_active")
	private boolean active;

	@ManyToOne
	@JoinColumn(name="fk_party")
	private Party party;

	@Version
	private Long version;

	Contact(){}

	public Contact(@NonNull Party parent, @NonNull String contact, @NonNull ContactType type, boolean isActive) {

		this.party = parent;
		this.contact = contact;
		this.type = type;
		this.active = isActive;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
					.add("contact", contact)
					.add("type", type)
					.add("active", active)
					.toString();
	}
}
