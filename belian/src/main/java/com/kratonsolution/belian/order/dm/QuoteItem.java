/**
 * 
 */
package com.kratonsolution.belian.order.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.kratonsolution.belian.inventory.dm.UnitOfMeasure;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class QuoteItem implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ONE;
	
	@Column(name="unit_price")
	private BigDecimal unitPrice = BigDecimal.ONE;
	
	@Column(name="delivery_date")
	private Date deliveryDate;
	
	@ManyToOne
	@JoinColumn(name="fk_uom")
	private UnitOfMeasure uom;
	
	@Column(name="comment")
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="fk_request_item")
	private RequestItem request;
	
	@Version
	private Long version;
	
	public QuoteItem(){}
}
