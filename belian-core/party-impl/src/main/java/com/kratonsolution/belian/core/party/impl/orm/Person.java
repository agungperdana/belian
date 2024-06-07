package com.kratonsolution.belian.core.party.impl.orm;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

import com.kratonsolution.belian.common.orm.IDValueRef;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
@Getter
@Setter
@Entity
@DiscriminatorValue("Person")
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
	
	public Person(IDValueRef ref)
	{
		if(ref != null)
		{
			setId(ref.getId());
			setName(ref.getValue());
		}
		
		setName(ANONYMOUS);
	}
}
