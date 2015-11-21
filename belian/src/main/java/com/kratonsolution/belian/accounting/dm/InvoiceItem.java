/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.global.dm.IncrementCommitment;
import com.kratonsolution.belian.sales.dm.SalesOrder;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="invoice_item")
public class InvoiceItem extends IncrementCommitment
{
	@ManyToOne
	@JoinColumn(name="fk_invoice")
	private Invoice invoice;
	
	@ManyToOne
	@JoinColumn(name="fk_sales_order")
	private SalesOrder order;
}
