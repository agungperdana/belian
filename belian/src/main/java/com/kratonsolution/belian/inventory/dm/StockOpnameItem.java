/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.io.Serializable;
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

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="stock_opname_item")
public class StockOpnameItem implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="onhand")
	private BigDecimal onhand;
	
	@Column(name="opnamed")
	private BigDecimal opnamed;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@Column(name="note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name="fk_parent")
	private StockOpname parent;
	
	@Version
	private Long version;
	
	public StockOpnameItem(){}
}
