/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.Date;

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
@Document(collection="party_role")
public class PartyRole
{
	@Id
	private String id;
	
	@Field("from")
	private Date from;
	
	@Field("to")
	private Date to;

	@Field("is_deleted")
	private boolean deleted;
	
	@DBRef
	private PartyRoleType type;
}
