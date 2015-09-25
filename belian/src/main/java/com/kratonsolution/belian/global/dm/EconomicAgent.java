/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.general.dm.Address;
import com.kratonsolution.belian.general.dm.Contact;
import com.kratonsolution.belian.general.dm.PartyRelationship;
import com.kratonsolution.belian.general.dm.PartyRole;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="party")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="agent_type")
public class EconomicAgent implements Serializable, Listable
{	
	@Id
	protected String id;

	@Column(name="name")
	protected String name;
	
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
	
	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<PartyRole> roles = new HashSet<PartyRole>();
	
	@OneToMany(mappedBy="child",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<PartyRelationship> relationships = new HashSet<PartyRelationship>();

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
