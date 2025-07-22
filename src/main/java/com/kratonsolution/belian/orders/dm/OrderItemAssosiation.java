
package com.kratonsolution.belian.orders.dm;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="order_item_assosiation")
public class OrderItemAssosiation implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Version
	private Long version;
}
