/**
 * 
 */
package com.kratonsolution.belian.shipment.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="shipment_package")
public class ShipmentPackage implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="create_date")
	private Date dateCreated;
	
	@ManyToOne
	@JoinColumn(name="fk_shipping_document")
	private ShippingDocument document;
	
	@Version
	private Long version;

	@OneToMany(mappedBy="packaging",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<PackagingContent> contents = new HashSet<>();
	
	@OneToMany(mappedBy="packaging",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ShipmentReceipt> receipts = new HashSet<>();
	
	public ShipmentPackage(){}
}
