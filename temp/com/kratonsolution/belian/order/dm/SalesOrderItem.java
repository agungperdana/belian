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
@Table(name="sales_order_item")
public class SalesOrderItem extends OrderItem
{

}
