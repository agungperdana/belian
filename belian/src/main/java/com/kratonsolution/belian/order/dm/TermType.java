/**
 * 
 */
package com.kratonsolution.belian.order.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class TermType implements  Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="description")
	private String description;
	
	@Version
	private Long version;

	public TermType(){}
}
