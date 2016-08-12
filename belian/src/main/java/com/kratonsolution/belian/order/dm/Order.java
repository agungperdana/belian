/**
 * 
 */
package com.kratonsolution.belian.order.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
public abstract class Order implements Serializable
{
	protected String id = UUID.randomUUID().toString();
	
	protected Date orderDate;
	
	protected Date entryDate;
}
