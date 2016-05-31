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

import com.google.common.base.Strings;
import com.kratonsolution.belian.general.dm.PartyRole;
import com.kratonsolution.belian.general.dm.Person;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="patient")
public class Patient extends PartyRole
{
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_bpjs")
	private BPJS bpjs;
	
	@OneToMany(mappedBy="patient",fetch=FetchType.EAGER)
	@OrderBy("date DESC")
	private Set<DoctorAppointment> appointments = new HashSet<DoctorAppointment>();
	
	@OneToMany(mappedBy="patient",fetch=FetchType.EAGER)
	private Set<FamilyMember> members = new HashSet<>();
	
	public Patient(){}
	
	public boolean isBpjs()
	{
		return (bpjs != null && !Strings.isNullOrEmpty(bpjs.getCard()) && bpjs.isActive());
	}
	
	public Person getPerson()
	{
		return (Person)getParty();
	}
}
