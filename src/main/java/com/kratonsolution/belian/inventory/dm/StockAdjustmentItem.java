/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.api.dm.IDValueRef;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="stock_adjustment_item")
public class StockAdjustmentItem implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="expired_date")
	private Date expired;
	
	@Column(name="quantity")
	private BigDecimal adjustment;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="product_id")),
		@AttributeOverride(name="value",column=@Column(name="product_value"))
	})
	private IDValueRef product;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="container_id")),
		@AttributeOverride(name="value",column=@Column(name="container_value"))
	})
	private IDValueRef container;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private StockAdjustmentType type = StockAdjustmentType.ADDITION;
	
	@ManyToOne
	@JoinColumn(name="fk_stock_adjustment")
	private StockAdjustment parent;
	
	@Column(name="note")
	private String note;
	
	@Version
	private Long version;
	
	public StockAdjustmentItem()
	{
		setContainer(new IDValueRef());
	}
}
