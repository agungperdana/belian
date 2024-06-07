package com.kratonsolution.belian.access.module.impl.orm;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.YesNoConverter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
@Getter
@Setter
@Entity
@Table(name="access_module")
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
	@Convert(converter = YesNoConverter.class)
	private boolean enabled;
	
	@Version
	private Long version;
	
	public Module(){}
}
