/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.math.BigDecimal;
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

import com.kratonsolution.belian.sales.dm.BillableItem;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="laboratory_billing_item")
public class LaboratoryBillingItem implements BillableItem
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="resource")
	private String resource;
	
	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ONE;
	
	@Column(name="unit_price")
	private BigDecimal unitPrice = BigDecimal.ZERO;
	
	@Column(name="category")
	private String category;
	
	@Column(name="note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name="fk_billing")
	private LaboratoryBilling billing;
	
	@Column(name="handled")
	private boolean handled;
	
	@Version
	private Long version;
	
	public LaboratoryBillingItem(){}
}
