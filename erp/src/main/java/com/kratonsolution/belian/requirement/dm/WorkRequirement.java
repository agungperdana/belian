package com.kratonsolution.belian.requirement.dm;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.kratonsolution.belian.common.persistence.IDValueRef;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="work_requirement")
public class WorkRequirement extends Requirement
{
	@Column(name="work_type")
	@Enumerated(EnumType.STRING)
	private WorkRequirementType workType = WorkRequirementType.MAINTENANCE;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="asset_id")),
		@AttributeOverride(name="value",column=@Column(name="asset_value"))
	})
	private IDValueRef asset;
	
	@Embedded
	private ProductionInfo productionInfo;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_deliverable")
	private Deliverable deliverable;
	
	public WorkRequirement(){}
	
	public WorkRequirement(IDValueRef ref)
	{
		if(isValid(ref))
		{
			setId(ref.getId());
			setNumber(ref.getValue());
		}
	}
}
