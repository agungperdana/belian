/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Agung Dodi Perdana
 *
 */
@Getter
@Setter
@Document(collection="economic_exchange_log")
public class EconomicExchangeLog
{
	public enum Type {INCREMENT,DECREMENT}
	
	@Id
	private String id;
	
	@Field("type")
	private Type type;

	@Field("date")
	private Date date;
	
	@Field("name")
	private String name;
	
	@Field("value")
	private BigDecimal value = BigDecimal.ZERO;
}
