/**
 * 
 */
package com.kratonsolution.belian.procurement.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.accounting.dm.Payable;
import com.kratonsolution.belian.global.dm.Contract;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="purchase_order")
public class PurchaseOrder extends Contract<OrderItem, OrderPayment>
{
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_payable")
	private Payable payable;
	
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL)
	private Set<OrderItem> increments = new HashSet<OrderItem>();
	
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL)
	private Set<OrderPayment> decrements = new HashSet<OrderPayment>();
	
	@Override
	public Set<OrderItem> getIncrements()
	{
		return this.increments;
	}

	@Override
	public Set<OrderPayment> getDecrements()
	{
		return decrements;
	}
}
