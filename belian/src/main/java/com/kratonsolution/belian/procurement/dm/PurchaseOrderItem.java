/**
 * 
 */
package com.kratonsolution.belian.procurement.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.products.dm.Product;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="purchase_order_item")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class PurchaseOrderItem implements Serializable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	protected Product product;
	
	@JoinColumn(name="quantity")
	protected BigDecimal quantity;
	
	@Column(name="note")
	private String note;
	
	@Column(name="expired_date")
	private Date expiredDate;
	
	@ManyToOne
	@JoinColumn(name="fk_purchase_order_request_item")
	protected PurchaseOrderRequestItem requestItem;
	
	@Version
	protected Long version;
}
