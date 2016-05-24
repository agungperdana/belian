/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="module")
public class Module implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="code",unique=true,nullable=false)
	private String code;
	
	@Column(name="name",unique=true,nullable=false)
	private String name;
	
	@Column(name="note")
	private String note;
	
	@Enumerated(EnumType.STRING)
	@Column(name="module_group")
	private ModuleGroup group = ModuleGroup.GENERAL;
	
	@Column(name="is_enabled")
	private boolean enabled;
	
	@Version
	private Long version;
	
	public Module(){}
}
