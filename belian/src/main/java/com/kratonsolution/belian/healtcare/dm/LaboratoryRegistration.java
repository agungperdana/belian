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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.general.dm.Organization;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="laboratory_registration")
public class LaboratoryRegistration implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="number")
	private String number;
	
	@Column(name="date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization organization;
	
	@ManyToOne
	@JoinColumn(name="fk_doctor")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name="fk_patient")
	private Patient patient;
	
	@Version
	private Long version;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_billing")
	private LaboratoryBilling billing;

	@OneToMany(mappedBy="registration",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<LaboratoryRegistrationItem> items = new HashSet<LaboratoryRegistrationItem>();
	
	public LaboratoryRegistration(){}
}
