/**
 * 
 */
package com.kratonsolution.belian.common.dm;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Embeddable
@Getter
@Setter
public class AuditLog implements Serializable
{
	@Column(name="creator")
	private String creator;
	
	@Column(name="editor")
	private String editor;
	
	@Column(name="created")
	private Timestamp created;
	
	@Column(name="last_edited")
	private Timestamp lastEdited;
}
