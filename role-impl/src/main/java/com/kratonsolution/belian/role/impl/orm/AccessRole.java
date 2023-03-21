package com.kratonsolution.belian.role.impl.orm;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
@Getter
@Setter
@Entity
@Table(name="access_role")
public class AccessRole implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_role")
	private Role role;

	@Column(name="fk_module")
	private String module;

	@Column(name="module_code")
	private String moduleCode;

	@Column(name="module_name")
	private String moduleName;

	@Column(name="is_can_read")
	private boolean canRead;

	@Column(name="is_can_update")
	private boolean canUpdate;
	
	@Column(name="is_can_delete")
	private boolean canDelete;
	
	@Column(name="is_can_create")
	private boolean canCreate;

	@Column(name="is_can_print")
	private boolean canPrint;
	
	@Version
	private Long version;
}
