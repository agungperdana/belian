
package com.kratonsolution.belian.orders.dm;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import com.kratonsolution.belian.common.persistence.IDValueRef;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="sales_order")
public class SalesOrder extends Order
{
	public static SalesOrder pos()
	{
		SalesOrder order = new SalesOrder();
		order.setType(OrderType.POS);
		order.addCreateStatus();
		order.addDoneStatus();
		
		return order;
	}
	
	public static SalesOrder dropship()
	{
		SalesOrder order = new SalesOrder();
		order.setType(OrderType.DROPSHIP);
		order.addCreateStatus();
		order.addDoneStatus();
		
		return order;
	}
	
	public static SalesOrder standard()
	{
		SalesOrder order = new SalesOrder();
		order.setType(OrderType.STANDARD);
		
		return order;
	}
	
	public void addSalesPerson(IDValueRef person)
	{
		OrderRole orderRole = new OrderRole();
		orderRole.setOrder(this);
		orderRole.setPerson(person);
		orderRole.setType(OrderRoleType.SALESPERSON);

		getPartyOrderRoles().add(orderRole);
	}
}
