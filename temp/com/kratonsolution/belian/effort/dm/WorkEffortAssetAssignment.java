/**
 * 
 */
package com.kratonsolution.belian.effort.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.asset.dm.Asset;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="work_effort_asset_assignment")
public class WorkEffortAssetAssignment implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Column(name="cost")
	private BigDecimal cost = BigDecimal.ZERO;

	@Column(name="comment")
	private String comment;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private AssetAssignmentType type = AssetAssignmentType.REQUESTED;
	
	@ManyToOne
	@JoinColumn(name="fk_asset")
	private Asset asset;
	
	@ManyToOne
	@JoinColumn(name="fk_work_effort")
	private WorkEffort effort;
	
	@Version
	private Long version;
	
	public WorkEffortAssetAssignment(){}
}
