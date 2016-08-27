/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.kratonsolution.belian.global.dm.Listable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="party")
@Inheritance(strategy=InheritanceType.JOINED)
public class Party implements Serializable, Listable
{	
	@Id
	protected String id = UUID.randomUUID().toString();

	@Column(name="identity",unique=true)
	protected String identity;
	
	@Column(name="name")
	protected String name;
	
	
	@Column(name="is_removeable")
	protected boolean removeable = true;
	
	@ManyToOne
	@JoinColumn(name="fk_geographic_birth_place")
	@NotFound(action=NotFoundAction.IGNORE)
	protected Geographic birthPlace;
	
	@Column(name="birth_date")
	protected Date birthDate;

	@Column(name="tax_code")
	protected String taxCode;
	
	@Version
	protected Long version;
	
	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<Address> addresses = new HashSet<Address>();
	
	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<Contact> contacts = new HashSet<Contact>();
	
	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<PartyRole> partyRoles = new HashSet<>();
	
	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<PartySkill> skills = new HashSet<>();
	
	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<PartyClassification> classifications = new HashSet<>();
	
	@Override
	public String getLabel()
	{
		return getName();
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
