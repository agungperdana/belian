
package com.kratonsolution.belian.requirement.dm;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.workefforts.dm.WorkEffort;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="work_requirement_fulfillment")
public class WorkRequirementFulfillment implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="requirement_id")),
		@AttributeOverride(name="value",column=@Column(name="requirement_value"))
	})
	protected IDValueRef workRequirement;
	
	@ManyToOne()
	@JoinColumn(name="fk_work_effort")
	private WorkEffort effort;
	
	@Version
	private Long version;

	public WorkRequirementFulfillment(){}
}
