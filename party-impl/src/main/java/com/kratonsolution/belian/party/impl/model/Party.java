package com.kratonsolution.belian.party.impl.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.google.common.base.MoreObjects;
import com.kratonsolution.belian.geographic.impl.model.Geographic;

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
@Table(name="party")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Party implements Serializable
{	
	private static final long serialVersionUID = 1L;

	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="code")
	protected String code;
	
	@Column(name="name")
	protected String name;
	
	@ManyToOne
	@JoinColumn(name="fk_geographic_birth_place")
	@NotFound(action=NotFoundAction.IGNORE)
	protected Geographic birthPlace;
	
	@Column(name="birth_date")
	protected Instant birthDate;

	@Column(name="tax_code")
	protected String taxCode;
	
	@Version
	protected Long version;
	
	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	protected Set<Address> addresses = new HashSet<Address>();
	
	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	protected Set<Contact> contacts = new HashSet<Contact>();
	
	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	private Set<PartyRole> partyRoles = new HashSet<>();
	
	@OneToMany(mappedBy="fromParty",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	private Set<PartyRelationship> relationships = new HashSet<>();
	
	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	private Set<PartyClassification> classifications = new HashSet<>();
	
	public Party(){}
	
	@Override
	public String toString()
	{
		return MoreObjects.toStringHelper(this)
				.add("code", this.code)
				.add("name", this.name).toString();
	}
}
