/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kratonsolution.belian.general.dm.PersonRole;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Entity
@Table(name="patient")
public class Patient extends PersonRole
{
	@OneToMany(mappedBy="child")
	private Set<Biomedical> biomedicals = new HashSet<Biomedical>();
}
