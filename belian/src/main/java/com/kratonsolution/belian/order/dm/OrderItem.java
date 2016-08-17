/**
 * 
 */
package com.kratonsolution.belian.order.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductFeature;
import com.kratonsolution.belian.inventory.dm.UnitOfMeasure;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="order_item")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class OrderItem implements Serializable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="quantity")
	protected BigDecimal quantity = BigDecimal.ONE;
	
	@Column(name="unit_price")
	protected BigDecimal untitPrice = BigDecimal.ONE;
	
	@ManyToOne
	@JoinColumn(name="fk_uom")
	protected UnitOfMeasure uom;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	protected Product product;
	
	@ManyToOne
	@JoinColumn(name="fk_feature")
	protected ProductFeature feature;
	
	@Column(name="note")
	protected String note;
	
	@Version
	protected Long version;
	
	@OneToMany(mappedBy="item",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<OrderTerm> terms = new HashSet<>();
	
	@OneToMany(mappedBy="salesItem",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<OrderItemAssosiation> salesAssosiations = new HashSet<>();
	
	@OneToMany(mappedBy="purchaseItem",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<OrderItemAssosiation> purchaseAssosiations = new HashSet<>();
	
	@OneToMany(mappedBy="orderItem",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<OrderRequirementCommitment> commitments = new HashSet<>();
}
