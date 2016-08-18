/**
 * 
 */
package com.kratonsolution.belian.shipment.dm;

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
@Table(name="shipment_rejection_reason")
public class ShipmentRejectionReason
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="note")
	private String description;
	
	@Version
	private Long version;

	@ManyToOne
	@JoinColumn(name="fk_shipment_receipt")
	private ShipmentReceipt receipt;
	
	public ShipmentRejectionReason(){}
}
