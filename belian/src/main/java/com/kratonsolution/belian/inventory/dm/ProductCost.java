/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.general.dm.Geographic;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
public class ProductCost
{
	public enum Type {PURCHASE,FREIGHT,ADMINISTRATIVE}
	
	@Id
	private String id;

	@Field("estimated_cost")
	private BigDecimal estimated = BigDecimal.ZERO;
	
	@DBRef
	private Geographic area;
	
	@Field("from_date")
	private Date from;
	
	@Field("to_date")
	private Date to;
	
	@Field("type")
	private Type type = Type.PURCHASE;

	@DBRef
	private Currency currency;
	
	@Field("is_deleted")
	private boolean deleted;
}
