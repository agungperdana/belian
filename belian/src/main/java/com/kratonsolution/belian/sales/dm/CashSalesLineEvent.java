/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.global.dm.EconomicEvent;
import com.kratonsolution.belian.inventory.dm.Product;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="cash_sales_line_event")
public class CashSalesLineEvent extends EconomicEvent<Product>
{
	@ManyToOne
	@JoinColumn(name="fk_product_resource")
	protected Product resource;
}
