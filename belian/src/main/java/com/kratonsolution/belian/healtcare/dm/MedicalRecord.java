/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="medical_record")
public class MedicalRecord implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Date date;

	@Column(name="anamnesis")
	private String anamnesis;

	@Column(name="checking_result")
	private String checkingResult;
	
	@Column(name="diagnosis")
	private String diagnosis;
	
	@OneToMany(mappedBy="medical",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Medication> medications = new HashSet<Medication>();
	
	@OneToMany(mappedBy="medical",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Treatment> treatments = new HashSet<Treatment>();
	
	@Version
	private Long version;
	
	public MedicalRecord(){}
}
