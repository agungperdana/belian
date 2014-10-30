/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 *
 */
@Getter
@Setter
@Document(collection="geographic")
public class Geographic 
{
	public enum Type{COUNTRY,CITY,KECAMATAN,KELURAHAN,RW,RT}
	
	@Id
	private String id;

	@Field("code")
	private String code;
	
	@Field("name")
	private String name;
	
	@Field("type")
	private Type type = Type.COUNTRY;
	
	public static Geographic newInstance()
	{
		Geographic geographic = new Geographic();
		geographic.setId(UUID.randomUUID().toString());
		
		return geographic;
	}
}
