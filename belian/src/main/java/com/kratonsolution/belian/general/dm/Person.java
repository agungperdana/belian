/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.global.dm.EconomicAgent;
import com.kratonsolution.belian.security.dm.User;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="person")
public class Person extends EconomicAgent
{
	public enum MaritalStatus {MARIED,DEFORCE,SINGLE}
	
	public enum Gender{MALE,FEMALE}

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
	
	@ManyToOne
	@JoinColumn(name="fk_user")
	private User user;
	
	public Person()
	{
		setName(ANONYMOUS);
	}
}
