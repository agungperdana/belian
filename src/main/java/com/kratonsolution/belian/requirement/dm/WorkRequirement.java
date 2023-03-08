package com.kratonsolution.belian.requirement.dm;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kratonsolution.belian.api.dm.IDValueRef;

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
