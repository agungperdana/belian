/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="person")
@Cacheable
public class Person extends Party
{
	@Transient
	public static final String ANONYMOUS = "ANONYMOUS";
	
	@Transient
	public static final String SYSADMIN = "SYSADMIN";
	
	@Column(name="gender")
	@Enumerated(EnumType.STRING)
	private Gender gender = Gender.MALE;
	
	@OneToMany(mappedBy="person",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<MaritalStatus> maritalStatuses = new HashSet<>();
	
	@OneToMany(mappedBy="person",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<PhysicalCharacteristic> physicalCharacteristics = new HashSet<>();
	
	@OneToMany(mappedBy="person",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Citizenship> citizenships = new HashSet<>();
	
	public Person()
	{
		setName(ANONYMOUS);
	}
}
