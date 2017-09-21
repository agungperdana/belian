/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.kratonsolution.belian.partys.dm.PartyRole;
import com.kratonsolution.belian.partys.dm.Person;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="doctor")
public class Doctor extends PartyRole
{
	public Doctor(){}
	
	public Person getPerson()
	{
		return (Person)getParty();
	}
}
