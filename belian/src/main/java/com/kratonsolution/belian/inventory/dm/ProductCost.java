/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

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
	
	@Field("for_area_id")
	private String areaId;
	
	@Field("for_area_name")
	private String areaName;
	
	@Field("from_date")
	private Date from;
	
	@Field("to_date")
	private Date to;
	
	@Field("type")
	private String type;

	@Field("currency_id")
	private String currencyId;
	
	@Field("currency_code")
	private String currencyCode;
	
	@Field("is_deleted")
	private boolean deleted;
}
