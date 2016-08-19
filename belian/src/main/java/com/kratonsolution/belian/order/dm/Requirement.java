/**
 * 
 */
package com.kratonsolution.belian.order.dm;

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
	
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="required_date")
	private Date requiredDate;
	
	@Column(name="note")
	private String note;
	
	@Column(name="estimated_budget")
	private BigDecimal estimatedBudget = BigDecimal.ZERO;
	
	@Enumerated(EnumType.STRING)
	@Column(name="source_type")
	private RequirementSourceType source = RequirementSourceType.INTERNAL;

	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private RequirementType type = RequirementType.PRODUCTION;
	
	@ManyToOne
	@JoinColumn(name="fk_parent")
	private Requirement parent;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="requirement",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<RequirementStatus> statuses = new HashSet<>();
	
	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Requirement> requirements = new HashSet<>();
	
	@OneToMany(mappedBy="requirement",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<RequirementRole> involvedPartys = new HashSet<>();
	
	@OneToMany(mappedBy="requirement",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<OrderRequirementCommitment> commitments = new HashSet<>();
}
