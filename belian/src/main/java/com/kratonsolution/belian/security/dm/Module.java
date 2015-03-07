/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="module")
public class Module
{
	@Id
	private String id;

	@Column(name="code",unique=true,nullable=false)
	private String code;
	
	@Column(name="name",unique=true,nullable=false)
	private String name;
	
	@Column(name="note")
	private String note;
	
	@Column(name="is_enabled")
	private boolean enabled;
	
	@Version
	private Long version;
	
	public Module(){}
}
