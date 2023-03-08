/**
 * 
 */
package com.kratonsolution.belian.shipment.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.api.dm.IDValueRef;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="shipment_receipt_role")
public class ShipmentReceiptRole implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="party_id")),
		@AttributeOverride(name="value",column=@Column(name="party_value"))
	})
	private IDValueRef party;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private ShipmentRoleType type =ShipmentRoleType.RECEIVER;
	
	@ManyToOne
	@JoinColumn(name="fk_shipment_receipt")
	private ShipmentReceipt receipt;
	
	@Version
	private Long version;

	public ShipmentReceiptRole(){}
}
