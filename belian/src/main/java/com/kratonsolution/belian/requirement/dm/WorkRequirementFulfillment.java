/**
 * 
 */
package com.kratonsolution.belian.requirement.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

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
