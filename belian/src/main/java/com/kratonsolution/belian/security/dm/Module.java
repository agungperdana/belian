/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Document(collection="module")
public class Module
{
	@Id
	private String id;

	@Field("code")
	private String code;
	
	@Field("name")
	private String name;
}
