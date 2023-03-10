
package com.kratonsolution.belian.common.persistence;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

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
