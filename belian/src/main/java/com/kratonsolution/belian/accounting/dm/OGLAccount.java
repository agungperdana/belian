/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

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
		
	@DBRef
	private GLAccount account;
}
