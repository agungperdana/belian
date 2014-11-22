/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Document(collection="product_price")
public class ProductPrice
{
	public enum Type {BASE,DISCOUNT,CHARGE}
	
	@Id
	private String id;
	
	@Field("from_date")
	private Date from;
	
	@Field("to_date")
	private Date to;
	
	@Field("price")
	private BigDecimal price = BigDecimal.ONE;
	
	@Field("currency_id")
	private String currencyId;
	
	@Field("currency_code")
	private String currencyCode;
	
	@Field("type")
	private String type;
	
	@Field("geographic_id")
	@Indexed
	private String geographicId;
	
	@Field("geographic_name")
	@Indexed
	private String geographicName;
	
	@Field("party_id")
	@Indexed
	private String partyId;
	
	@Field("party_name")
	@Indexed
	private String partyName;
	
	@Field("is_deleted")
	private boolean deleted;
}
