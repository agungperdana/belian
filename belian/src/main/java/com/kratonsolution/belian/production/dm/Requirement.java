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
public class Requirement implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="date")
	private Date date;
	
	@Column(name="required_date")
	private Date required;
	
	@Column(name="quantity")
	private BigDecimal quantity;
	
	@Column(name="reason")
	private String reason;
	
	@Column(name="name")
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name="requirement_type")
	private RequirementType type;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization organization;
	
	@ManyToOne
	@JoinColumn(name="fk_staff")
	private Person staff;

	@Version
	private Long version;

	@OneToMany(mappedBy="requirement",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<RequirementRole> roles = new HashSet<>();
	
	@OneToMany(mappedBy="requirement",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<WorkEffort> efforts = new HashSet<>();
	
	public Requirement(){}
}
