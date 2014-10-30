/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
public class Money
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Field("amount")
	private BigDecimal amount = BigDecimal.ZERO;
	
	@Field("currency")
	private String currency;
}
