/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.kratonsolution.belian.accounting.dm.Money;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Document(collection="product")
public class Product
{
	public enum Type {SERVICE,GOODS}
	
	@Id
	private String id;
	
	@Field("name")
	private String name;
	
	@Field("code")
	private String code;
	
	@Field("rfid")
	private String rfid;
	
	@Field("type")
	private Type type = Type.GOODS;
	
	private Money sellingPrice;
	
	private Money buyingPrice;
	
	public static Product newInstance()
	{
		Product product = new Product();
		product.setId(UUID.randomUUID().toString());
		product.setBuyingPrice(new Money());
		product.setSellingPrice(new Money());
		
		return product;
	}
}
