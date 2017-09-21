/**
 * 
 */
package com.kratonsolution.belian.order.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
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
@Table(name="requirement_request")
public class RequirementRequest implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_request_item")
	private RequestItem request;
	
	@ManyToOne
	@JoinColumn(name="fk_requirement")
	private Requirement requirement;
	
	@Version
	private Long version;
}
