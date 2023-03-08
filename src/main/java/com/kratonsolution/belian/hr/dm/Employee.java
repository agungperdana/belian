/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.kratonsolution.belian.partys.dm.PartyRole;

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
