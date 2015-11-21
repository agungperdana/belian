/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.accounting.dm.InvoiceItem;
import com.kratonsolution.belian.global.dm.Contract;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="sales_order")
public class SalesOrder extends Contract<InvoiceItem, LineItem>
{
	@Column(name="order_date")
	private Date orderDate;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="order")
	private Set<InvoiceItem> increments = new HashSet<InvoiceItem>();
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="order")
	private Set<LineItem> decrements = new HashSet<LineItem>();
	
	@Override
	public Set<InvoiceItem> getIncrements()
	{
		return increments;
	}

	@Override
	public Set<LineItem> getDecrements()
	{
		return decrements;
	}
}
