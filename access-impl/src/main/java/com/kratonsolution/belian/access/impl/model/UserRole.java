package com.kratonsolution.belian.access.impl.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Getter
@Entity
@Table(name = "user_role")
public class UserRole {

	@Id
	private String id = UUID.randomUUID().toString();

	@ManyToOne
	@JoinColumn(name = "fk_user")
	private User user;

	@Column(name = "role_code")
	private String roleCode;

	@Setter
	@Column(name = "role_name")
	private String roleName;

	@Setter
	@Column(name = "is_enabled")
	private boolean enabled;

	UserRole() {
	}

	public UserRole(@NonNull User user, @NonNull String roleCode, @NonNull String roleName) {

		this.user = user;
		this.roleCode = roleCode;
		this.roleName = roleName;
		this.enabled = true;
	}


	public UserRole(@NonNull User user, @NonNull String roleCode, @NonNull String roleName, boolean enabled) {

		this.user = user;
		this.roleCode = roleCode;
		this.roleName = roleName;
		this.enabled = enabled;
	}}