/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.kratonsolution.belian.accounting.dm.Money;

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
	
	private Money price;
	
	@Field("type")
	private Type type = Type.BASE;
	
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
}
