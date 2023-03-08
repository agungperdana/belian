
package com.kratonsolution.belian.orders.dm;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

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
