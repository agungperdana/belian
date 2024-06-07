package com.kratonsolution.belian.access.role.impl.orm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.YesNoConverter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
@Getter
@Setter
@Entity
@Table(name="role")
public class Role implements Serializable
{
	public static final String SYSADMIN = "Sys Admin";
	
	public static final String SYSTEM = "System";
	
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="code")
	private String code;
	
	@Column(name="name")
	private String name;
	
	@Column(name="note")
	private String note;

	@Column(name="is_enabled")
	@Convert(converter = YesNoConverter.class)
	private boolean enabled;

	@Version
	private Long version;
	
	@OneToMany(mappedBy="role",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<RoleModule> accesses = new HashSet<RoleModule>();
	
	public Role(){}
	
	public boolean isUndeleteable()
	{
		return code.equals(SYSADMIN) || code.equals(SYSTEM);
	}

	public boolean isMandatory()
	{
		return code.equals(SYSTEM);
	}
}
