/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.general.dm.Geographic;
import com.kratonsolution.belian.general.dm.Party;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
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
	
	@DBRef
	private Currency currency;
	
	@Field("type")
	private Type type = Type.BASE;
	
	@DBRef
	private Geographic geographic;
	
	@DBRef
	private Party party;
	
	@Field("is_deleted")
	private boolean deleted;
}
