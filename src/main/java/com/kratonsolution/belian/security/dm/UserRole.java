
package com.kratonsolution.belian.security.dm;

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
@Table(name="user_role")
@Cacheable
public class UserRole implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="fk_role")
	private Role role;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_user")
	private User user;

	@Column(name="is_enabled")
	private boolean enabled;

	@Version
	private Long version;
}