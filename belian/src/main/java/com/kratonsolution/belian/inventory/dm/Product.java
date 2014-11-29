/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	public enum Type {SERVICE,FINISHGOOD,RAWMATERIAL,SUBASEMBLY}
	
	@Id
	private String id;
	
	@Field("start_date")
	private Date start;
	
	@Field("end_date")
	private Date end;
	
	@Field("name")
	private String name;
	
	@Field("category_id")
	private String categoryId;
	
	@Field("category_name")
	private String categoryName;
	
	@Field("type")
	private Type type = Type.FINISHGOOD;
	
	private List<ProductFeature> features = new ArrayList<ProductFeature>();
	
	private List<ProductSupplier> suppliers = new ArrayList<ProductSupplier>();
	
	private List<ProductPrice> prices = new ArrayList<ProductPrice>();
	
	private List<ProductComponent> components = new ArrayList<ProductComponent>();
	
	private List<ProductCost> costs = new ArrayList<ProductCost>();
	
	private List<ProductCode> codes = new ArrayList<ProductCode>();
}
