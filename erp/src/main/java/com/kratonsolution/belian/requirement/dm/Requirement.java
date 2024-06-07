
package com.kratonsolution.belian.requirement.dm;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.common.orm.IDValueRef;
import com.kratonsolution.belian.common.orm.Referenceable;

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
public abstract class Requirement implements Referenceable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="number")
	protected String number;
	
	@Column(name="creation_date")
	protected Date creationDate;
	
	@Column(name="required_date")
	protected Date requiredDate;
	
	@Column(name="description")
	protected String description;
	
	@Column(name="reason")
	protected String reason;
	
	@Column(name="estimated_budget")
	protected BigDecimal estimatedBudget = BigDecimal.ZERO;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	protected RequirementType type = RequirementType.INTERNAL_REQUIREMENT;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="organization_id")),
		@AttributeOverride(name="value",column=@Column(name="organization_value"))
	})
	private IDValueRef organization;
	
	@Version
	protected Long version;
	
	@OneToMany(mappedBy="requirement",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<RequirementStatus> statuses = new HashSet<>();
	
	@OneToMany(mappedBy="requirement",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<RequirementRole> roles = new HashSet<>();
	
	@Override
	public String getLabel()
	{
		return getNumber();
	}
	
	@Override
	public String getValue()
	{
		return getId();
	}
}
