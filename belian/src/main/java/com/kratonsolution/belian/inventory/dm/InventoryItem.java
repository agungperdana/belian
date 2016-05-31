/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
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
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="inventory_item")
public class InventoryItem implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="expired_date")
	private Date expiredDate;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="fk_facility")
	private Facility facility;
	
	@Column(name="serial_number")
	private String serialNumber;
	
	@Column(name="onhand")
	private BigDecimal onhand = BigDecimal.ZERO;
	
	@Version
	private Long version;
	
	public InventoryItem(){}
}
