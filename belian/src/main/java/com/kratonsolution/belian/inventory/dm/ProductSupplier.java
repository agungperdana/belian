/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

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
public class ProductSupplier
{
	@Id
	private String id;

	@Field("from_date")
	private Date from;
	
	@Field("to_date")
	private Date to;
	
	@Field("party_id")
	private String partyId;
	
	@Field("party_name")
	private String partyName;
	
	@Field("is_deleted")
	private boolean deleted;
}
