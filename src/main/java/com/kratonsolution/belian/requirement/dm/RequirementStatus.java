
package com.kratonsolution.belian.requirement.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.global.dm.AIOStatusType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="requirement_status")
public class RequirementStatus implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Date date;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private AIOStatusType type = AIOStatusType.ACTIVE;
	
	@ManyToOne
	@JoinColumn(name="fk_requirement")
	private Requirement requirement;
	
	@Version
	private Long version;
	
	public RequirementStatus(){}
}
