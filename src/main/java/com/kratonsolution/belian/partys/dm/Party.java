package com.kratonsolution.belian.partys.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.common.dm.Referenceable;
import com.kratonsolution.belian.general.dm.Geographic;

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
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Party implements Serializable, Referenceable
{	
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="code",unique=true,nullable=false)
	protected String code;
	
	@Column(name="name")
	protected String name;
	
	@ManyToOne
	@JoinColumn(name="fk_geographic_birth_place")
	@NotFound(action=NotFoundAction.IGNORE)
	protected Geographic birthPlace;
	
	@Column(name="birth_date")
	protected Date birthDate;

	@Column(name="tax_code")
	protected String taxCode;
	
	@Column(name="is_system")
	protected boolean system;
	
	@Version
	protected Long version;
	
	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	protected Set<Address> addresses = new HashSet<Address>();
	
	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	protected Set<Contact> contacts = new HashSet<Contact>();
	
	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<PartyRole> partyRoles = new HashSet<>();
	
	@OneToMany(mappedBy="fromParty",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<PartyRelationship> relationships = new HashSet<>();
	
	@OneToMany(mappedBy="toParty",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<PartyRelationship> structures = new HashSet<>();
	
	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<PartySkill> skills = new HashSet<>();
	
	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<PartyClassification> classifications = new HashSet<>();
	
	public Party(){}
	
	public Party(IDValueRef ref)
	{
		if(ref != null)
		{
			setId(ref.getId());
			setName(ref.getValue());
		}
	}
	
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
	
	public IDValueRef getFirstAddress()
	{
		for(Address address:getAddresses())
			return address.toRef();
			
		return null;
	}
	
	public IDValueRef getFirstContact()
	{
		for(Contact contact:getContacts())
			return contact.toRef();
			
		return null;
	}
	
	@Override
	public String toString()
	{
		return getId();
	}
}
