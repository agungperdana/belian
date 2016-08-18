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
@Table(name="requirement_role")
public class RequirementRole implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private RoleType type = RoleType.Initiator;

	@ManyToOne
	@JoinColumn(name="fk_order")
	private Order order;
	
	@Version
	private Long version;
	
	public RequirementRole(){}
}
