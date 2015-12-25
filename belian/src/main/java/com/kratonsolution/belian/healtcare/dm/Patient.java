/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

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
	private Set<MedicalRecord> records = new HashSet<MedicalRecord>();
	
	public Patient()
	{
		setType(Type.PATIENT);
	}
}
