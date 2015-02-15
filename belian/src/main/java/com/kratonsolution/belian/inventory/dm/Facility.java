/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
	@Indexed(unique=true,name="facility_code_index")
	private String code;
	
	@Field("name")
	@Indexed(unique=true,name="facility_name_index")
	private String name;
	
	@Field("note")
	private String note;
	
	@Field("type")
	private Type type = Type.WAREHOUSE;
	
	@DBRef
	private List<Container> containers = new ArrayList<Container>(); 
}
