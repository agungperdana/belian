/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.effort.dm.TimeEntry;
import com.kratonsolution.belian.effort.dm.WorkEffort;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductFeature;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="invoice_item")
public class InvoiceItem implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private InvoiceItemType type = InvoiceItemType.INVOICE_PRODUCT;

	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ZERO;
	
	@Column(name="amount")
	private BigDecimal amount = BigDecimal.ZERO;
	
	@Column(name="taxable")
	private boolean taxable;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="fk_product_feature")
	private ProductFeature feature;
	
	@ManyToOne
	@JoinColumn(name="fk_work_effort")
	private WorkEffort workEffort;
	
	@ManyToOne
	@JoinColumn(name="fk_time_entry")
	private TimeEntry timeEntry;
	
	@ManyToOne
	@JoinColumn(name="fk_inventory_item")
	private InventoryItem inventoryItem;
	
	@ManyToOne
	@JoinColumn(name="fk_adjusted")
	private InvoiceItem adjusted;
	
	@ManyToOne
	@JoinColumn(name="fk_sold_with")
	private InvoiceItem soldWith;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="adjusted",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<InventoryItem> adjustments = new HashSet<>();
}
