/**
 * 
 */
package com.kratonsolution.belian.order.dm;

import javax.persistence.Entity;
import javax.persistence.Table;

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
public class PurchaseOrderItem extends OrderItem
{

}
