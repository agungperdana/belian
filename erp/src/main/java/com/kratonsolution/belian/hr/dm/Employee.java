
package com.kratonsolution.belian.hr.dm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import com.kratonsolution.belian.core.party.impl.orm.PartyRole;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="employee")
public class Employee extends PartyRole
{
	@Column(name="username",unique=true)
	private String username;
	
	public Employee(){}
}
