/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.kratonsolution.belian.general.dm.PartyRole;
import com.kratonsolution.belian.security.dm.User;

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
	@OneToOne(cascade=CascadeType.ALL,orphanRemoval=true,optional=true)
	@JoinColumn(name="fk_user")
	private User user;
	
	@OneToMany(mappedBy="employee",fetch=FetchType.EAGER)
	private Set<Employment> employments = new HashSet<>();
}
