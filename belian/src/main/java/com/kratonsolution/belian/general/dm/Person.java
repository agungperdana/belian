/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.kratonsolution.belian.global.dm.EconomicAgent;
import com.kratonsolution.belian.security.dm.User;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
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
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_user")
	private User user;
}
