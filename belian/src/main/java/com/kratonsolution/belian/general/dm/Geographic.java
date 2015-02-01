/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Agung Dodi Perdana
 *
 */
@Getter
@Setter
@Document(collection="geographic")
public class Geographic 
{
	public enum Type{COUNTRY,CITY,PROVINCE,KECAMATAN,KELURAHAN,RW,RT}
	
	@Id
	private String id;

	@Field("code")
	private String code;
	
	@Field("name")
	private String name;
	
	@Field("type")
	private Type type = Type.COUNTRY;
}
