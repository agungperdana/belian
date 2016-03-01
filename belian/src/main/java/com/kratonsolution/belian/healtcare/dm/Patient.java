/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.google.common.base.Strings;
import com.kratonsolution.belian.general.dm.PersonRole;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="patient")
public class Patient extends PersonRole
{
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_bpjs")
	private BPJS bpjs;
	
	@OneToMany(mappedBy="patient")
	@OrderBy("date DESC")
	private Set<DoctorAppointment> appointments = new HashSet<DoctorAppointment>();
	
	@OneToMany(mappedBy="patient",fetch=FetchType.EAGER)
	private Set<FamilyMember> members = new HashSet<>();
	
	public boolean isBpjs()
	{
		return (bpjs != null && !Strings.isNullOrEmpty(bpjs.getCard()) && bpjs.isActive());
	}
}
