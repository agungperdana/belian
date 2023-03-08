
package com.kratonsolution.belian.partys.dm;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import com.kratonsolution.belian.api.dm.IDValueRef;

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
