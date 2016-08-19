/**
 * 
 */
package com.kratonsolution.belian.shipment.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name="shipping_document")
public class ShippingDocument implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="description")
	private String description;

	@Version
	private Long version;
	
	public ShippingDocument(){}
}
