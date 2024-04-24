
package com.kratonsolution.belian.shipment.dm;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

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
