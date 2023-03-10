
package com.kratonsolution.belian.security.impl.dm;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
@Table(name="access_role")
@Cacheable
public class AccessRole implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_module")
	@NotFound(action=NotFoundAction.IGNORE)
	private Module module;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_role")
	private Role role;
	
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
