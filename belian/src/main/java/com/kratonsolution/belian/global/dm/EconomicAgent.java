/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.kratonsolution.belian.general.dm.Address;
import com.kratonsolution.belian.general.dm.Contact;
import com.kratonsolution.belian.general.dm.Geographic;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
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
	protected String id = UUID.randomUUID().toString();

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
	
	@Version
	protected Long version;
	
	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<Address> addresses = new HashSet<Address>();
	
	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<Contact> contacts = new HashSet<Contact>();
	
	@Column(name="is_deleteable")
	protected boolean deleteadble = true;
	
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
