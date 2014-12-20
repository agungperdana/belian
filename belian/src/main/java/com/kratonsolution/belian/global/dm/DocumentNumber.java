/**
 * 
 */
package com.kratonsolution.belian.global.dm;

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
@Setter
@Getter
@Document(collection="document_number")
public class DocumentNumber
{
	public enum Type {CASHSALES}
	
	@Id
	private String id;
	
	@Field("type")
	@Indexed(unique=true)
	private Type type;
	
	@Field("sequence")
	private int index;
	
	public void next()
	{
		setIndex(getIndex()+1);
	}
}
