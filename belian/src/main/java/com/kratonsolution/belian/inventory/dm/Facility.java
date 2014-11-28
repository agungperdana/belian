/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.ArrayList;
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
@Document(collection="facility")
public class Facility
{
	public enum Type{WAREHOUSE,PLAN}
	
	@Id
	private String id;
	
	@Field("code")
	private String code;
	
	@Field("name")
	private String name;
	
	@Field("type")
	private String type;
	
	private List<Container> containers = new ArrayList<Container>(); 
}
