/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Document(collection="person")
public class Person extends Party
{
	public enum MaritalStatus {MARIED,DEFORCE,SINGLE}
	
	public enum Gender{MALE,FEMALE}

	@Field("gender")
	private Gender gender = Gender.MALE;
	
	@Field("marital_status")
	private MaritalStatus maritalStatus = MaritalStatus.SINGLE;
	
	public static Person newInstance()
	{
		Person person = new Person();
		person.setId(UUID.randomUUID().toString());
		
		return person;
	}
}
