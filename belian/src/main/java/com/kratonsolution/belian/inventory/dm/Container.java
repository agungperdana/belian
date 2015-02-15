/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Document(collection="facility_container")
public class Container
{
	public enum Type{ROOM,BIN,BAREL,FILEDRAWER,SHELF}
	
	@Id
	private String id;
	
	@Field("code")
	private String code;
	
	@Field("name")
	private String name;
	
	@Field("note")
	private String note;
	
	@Field("type")
	private Type type = Type.SHELF;
	
	@DBRef
	private Facility facility;
	
	@DBRef
	private Container parent;
	
	@DBRef
	private List<Container> members = new ArrayList<Container>(); 
}
