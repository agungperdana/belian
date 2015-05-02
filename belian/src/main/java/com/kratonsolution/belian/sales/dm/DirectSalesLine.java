/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.global.dm.DecrementCommitment;
import com.kratonsolution.belian.inventory.dm.Product;

/**
 * @author Agung Dodi Perdana
 *
 */
@Setter
@Getter
@Entity
@Table(name="direct_sales_line")
public class DirectSalesLine extends DecrementCommitment<Product,DirectSalesLineEvent>
{	
	@Column(name="price")
	private BigDecimal price = BigDecimal.ZERO;
	
	@Column(name="discount")
	private BigDecimal discount = BigDecimal.ZERO;
	
	@Column(name="charge")
	private BigDecimal charge = BigDecimal.ZERO;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="fk_product_resource")
	private Product resource;
	
	@ManyToOne
	@JoinColumn(name="fk_direct_sales")
	private DirectSales cashSales;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_direct_sales_line_event")
	private DirectSalesLineEvent event;
}
