/**
 * 
 */
package com.kratonsolution.belian.shipment.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
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
@Table(name="packaging_content")
public class PackagingContent implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ONE;
	
	@ManyToOne
	@JoinColumn(name="fk_shipment_item")
	private ShipmentItem shipmentItem;
	
	@ManyToOne
	@JoinColumn(name="fk_shipment_package")
	private ShipmentPackage packaging;
	
	@Version
	private Long version;

	public PackagingContent(){}
}
