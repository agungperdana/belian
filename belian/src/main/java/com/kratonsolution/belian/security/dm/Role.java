/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Agung Dodi Perdana
 *
 */
@Getter
@Setter
@Document(collection="role")
public class Role
{
	@Id
	private String id;
	
	@Field("code")
	@Indexed(unique=true)
	private String code;
	
	@Field("name")
	@Indexed(unique=true)
	private String name;
	
	private List<AccessRole> accesses = new ArrayList<AccessRole>();
}
