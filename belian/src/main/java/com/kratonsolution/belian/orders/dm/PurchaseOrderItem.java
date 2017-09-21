/**
 * 
 */
package com.kratonsolution.belian.orders.dm;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
@OnDelete(action=OnDeleteAction.CASCADE)
public class PurchaseOrderItem extends OrderItem
{
	public PurchaseOrderItem(){}
}
