/**
 * 
 */
package com.kratonsolution.belian.shipment.dm;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name="pick_list_item")
public class PickListItem implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ONE;

	@ManyToOne
	@JoinColumn(name="fk_inventory_item")
	private InventoryItem inventoryItem;
	
	@ManyToOne
	@JoinColumn(name="fk_pick_list")
	private PickList list;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="pickListItem",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ItemIssuance> issuances = new HashSet<>();

	public PickListItem(){}
}
