/**
 * 
 */
package com.kratonsolution.belian.order.dm;

import java.io.Serializable;
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
	
	@ManyToOne
	@JoinColumn(name="fk_order")
	private Order order;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private StatusType type = StatusType.Active;
	
	@ManyToOne
	@JoinColumn(name="fk_requirement")
	private Requirement requirement;
	
	@Version
	private Long version;
	
	public RequirementStatus(){}
}
