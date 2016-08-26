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
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="reveiveable_item")
public class ReceiveableItem implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ONE;
	
	@Column(name="serial")
	private String serial;
	
	@Column(name="expired")
	private Date expired;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;

	@ManyToOne
	@JoinColumn(name="fk_inventory_item")
	private InventoryItem inventoryItem;
	
	@ManyToOne
	@JoinColumn(name="fk_receivable")
	private Receivable receivable;
	
	@Version
	private Long version;
	
	public ReceiveableItem(){}
}
