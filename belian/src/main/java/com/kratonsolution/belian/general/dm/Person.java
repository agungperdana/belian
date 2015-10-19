/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

	@Column(name="gender")
	@Enumerated(EnumType.STRING)
	private Gender gender = Gender.MALE;
	
	@Column(name="marital_status")
	@Enumerated(EnumType.STRING)
	private MaritalStatus maritalStatus = MaritalStatus.SINGLE;
	
	@OneToOne(mappedBy="person")
	private User user;
}
