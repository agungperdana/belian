/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

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
	
	public static Module newInstance()
	{
		Module module = new Module();
		module.setId(UUID.randomUUID().toString());
		
		return module;
	}
}
