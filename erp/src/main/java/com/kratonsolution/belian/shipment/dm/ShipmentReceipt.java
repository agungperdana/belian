
package com.kratonsolution.belian.shipment.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.common.orm.IDValueRef;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="shipment_receipt")
public class ShipmentReceipt implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Date date;
	
	@Column(name="number")
	private String number;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="organization_id")),
		@AttributeOverride(name="value",column=@Column(name="organization_value"))
	})
	private IDValueRef organization;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="source_party_id")),
		@AttributeOverride(name="value",column=@Column(name="source_party_value"))
	})
	private IDValueRef source;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="shipment_id")),
		@AttributeOverride(name="value",column=@Column(name="shipment_value"))
	})
	private IDValueRef shipment;
		
	@Version
	private Long version;
	
	@OneToMany(mappedBy="receipt",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ShipmentReceiptItem> items = new HashSet<>();
	
	@OneToMany(mappedBy="receipt",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ShipmentReceiptRole> roles = new HashSet<>();
	
	public ShipmentReceipt(){}
}
