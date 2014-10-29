/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import java.util.UUID;

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
@Document(collection="product")
public class Product
{
	@Id
	private String id;
	
	@Field("name")
	private String name;
	
	@Field("code")
	private String code;
	
	@Field("rfid")
	private String rfid;
	
	public static Product newInstance()
	{
		Product product = new Product();
		product.setId(UUID.randomUUID().toString());
		
		return product;
	}
}
