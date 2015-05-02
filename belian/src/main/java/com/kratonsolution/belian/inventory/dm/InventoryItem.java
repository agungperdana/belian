/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.math.BigDecimal;

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
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="inventory_item")
public class InventoryItem
{
	@Id
	private String id;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="fk_facility")
	private Facility facility;
	
	@ManyToOne
	@JoinColumn(name="fk_container")
	private Container container;
	
	@Column(name="serial_number")
	private String serialNumber;
	
	@Column(name="onhand")
	private BigDecimal onhand = BigDecimal.ZERO;

	@Version
	private Long version;
}
