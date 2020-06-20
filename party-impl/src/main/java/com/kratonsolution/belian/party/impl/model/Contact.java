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

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 1.0
 */
@Getter
@Setter
@Entity
@Table(name="contact")
public class Contact implements Serializable
{
	private static final long serialVersionUID = -3119257260126834977L;

	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="contact",nullable=false)
	private String contact;

	@Column(name="type",nullable=false)
	@Enumerated(EnumType.STRING)
	private ContactType type = ContactType.OFFICE_PHONE;
	
	@Column(name="is_active")
	private boolean active;

	@ManyToOne
	@JoinColumn(name="fk_party")
	private Party party;
	
	@Version
	private Long version;
	
	public Contact(){}
}
