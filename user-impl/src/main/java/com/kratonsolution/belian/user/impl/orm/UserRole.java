package com.kratonsolution.belian.user.impl.orm;

import java.io.Serializable;
import java.util.UUID;

import com.kratonsolution.belian.role.impl.orm.Role;
import jakarta.persistence.Cacheable;
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
@Table(name="user_role")
public class UserRole
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_user")
	private User user;

	@Column(name="fk_role")
	private String role;

	@Column(name="role_name")
	private String roleName;

	@Column(name="is_enabled")
	private boolean enabled;

	@Version
	private Long version;
}