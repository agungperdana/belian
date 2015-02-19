/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import com.kratonsolution.belian.general.dm.Party;

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
	
	@DBRef
	private Party supplier;

	@Field("note")
	private String note;
	
	@Field("is_deleted")
	private boolean deleted;
}
