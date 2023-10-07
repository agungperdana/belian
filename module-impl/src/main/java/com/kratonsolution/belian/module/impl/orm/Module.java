
package com.kratonsolution.belian.module.impl.orm;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.1
 */
@Getter
@Setter
@Entity
@Table(name="module")
@EqualsAndHashCode
public class Module implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="code")
	private String code;
	
	@Column(name="name")
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
