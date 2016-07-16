/**
 * 
 */
package com.kratonsolution.belian.production.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Organization;
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
@Table(name="requirement")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Requirement implements Serializable
{
	@Id
	protected String id = UUID.randomUUID().toString();

	@Column(name="date")
	protected Date date;
	
	@Column(name="required_date")
	protected Date required;
	
	@Column(name="quantity")
	protected BigDecimal quantity = BigDecimal.ONE;
	
	@Column(name="reason")
	protected String reason;
	
	@Column(name="name")
	protected String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name="requirement_type")
	protected RequirementType type = RequirementType.Work;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	protected RequirementStatus status = RequirementStatus.Inprogress;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	protected Organization organization;
	
	@ManyToOne
	@JoinColumn(name="fk_staff")
	protected Person staff;

	@Version
	protected Long version;

	@OneToMany(mappedBy="requirement",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<RequirementRole> roles = new HashSet<>();
	
	protected abstract Set<? extends WorkEffort> getEfforts();
}
