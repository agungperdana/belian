/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	
	@Column(name="identity",unique=true)
	private String identity;
	
	@Column(name="gender")
	@Enumerated(EnumType.STRING)
	private Gender gender = Gender.MALE;
	
	@Column(name="marital_status")
	@Enumerated(EnumType.STRING)
	private MaritalStatus maritalStatus = MaritalStatus.SINGLE;
	
	public Person()
	{
		setName(ANONYMOUS);
	}
}
