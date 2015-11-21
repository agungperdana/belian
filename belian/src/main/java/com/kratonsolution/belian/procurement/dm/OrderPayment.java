/**
 * 
 */
package com.kratonsolution.belian.procurement.dm;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.accounting.dm.PaymentItem;
import com.kratonsolution.belian.global.dm.DecrementCommitment;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="order_payment")
public class OrderPayment extends DecrementCommitment
{
	@ManyToOne
	@JoinColumn(name="fk_purchase_order")
	private PurchaseOrder order;
	
	@ManyToOne
	@JoinColumn(name="fk_payment_item")
	private PaymentItem paymentItem;
}
