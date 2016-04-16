/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.kratonsolution.belian.general.dm.PersonRole;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="employment")
public class Employment extends PersonRole
{
	@OneToMany(mappedBy="employment",cascade=CascadeType.ALL,orphanRemoval=true)
	@OrderBy("start DESC")
	private Set<PayHistory> payHistorys = new HashSet<>();
	
	@OneToMany(mappedBy="employment",cascade=CascadeType.ALL,orphanRemoval=true)
	@OrderBy("start DESC")
	private Set<Benefit> benefits = new HashSet<>();
}
