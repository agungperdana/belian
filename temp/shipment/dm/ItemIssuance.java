/**
 * 
 */
package com.kratonsolution.belian.shipment.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.inventory.dm.InventoryItem;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="item_issuence")
public class ItemIssuance implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Timestamp date;

	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ONE;
	
	@ManyToOne
	@JoinColumn(name="fk_inventory_item")
	private InventoryItem inventoryItem;
	
	@ManyToOne
	@JoinColumn(name="fk_picklist_item")
	private PickListItem pickListItem;
	
	@Version
	private Long version;
	
	public ItemIssuance(){}
}
