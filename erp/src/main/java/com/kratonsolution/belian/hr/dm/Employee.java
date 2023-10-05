
package com.kratonsolution.belian.hr.dm;

import com.kratonsolution.belian.party.impl.orm.PartyRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
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
