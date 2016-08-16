/**
 * 
 */
package com.kratonsolution.belian.order.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
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
