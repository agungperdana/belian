/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
public class OGLAccount
{
	@Id
	private String id;
	
	@Field("is_selected")
	private boolean selected;
		
	@DBRef
	private GLAccount account;
}
