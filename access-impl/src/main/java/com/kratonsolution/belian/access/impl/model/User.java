package com.kratonsolution.belian.access.impl.model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.jasypt.util.password.StrongPasswordEncryptor;

import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import com.kratonsolution.belian.common.jpa.model.Auditable;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Getter
@Entity
@Table(name = "user")
public class User extends Auditable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name = "name")
	private String name;

	@Setter
	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Setter
	@Column(name = "is_enabled")
	private boolean enabled;

	@Setter
	@Column(name = "is_expired")
	private boolean expired;

	@Setter
	@Column(name = "is_locked")
	private boolean locked;

	@OneToMany(mappedBy = "user", 
			cascade = CascadeType.ALL, 
			orphanRemoval = true, 
			fetch = FetchType.LAZY)
	private Set<UserRole> roles = new HashSet<>();

	@Version
	private Long version;

	User(){}

	public User(@NonNull String name, @NonNull String email, @NonNull String password, @NonNull Boolean enabled) {

		this.name = name;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
	}

	public boolean changePassword(@NonNull String newPassword, @NonNull String oldPassword) {

		if(new StrongPasswordEncryptor().checkPassword(oldPassword, this.password)) {

			this.password = new StrongPasswordEncryptor().encryptPassword(newPassword);
			return true;
		}

		return false;
	}

	public void addNewRole( @NonNull String roleCode, @NonNull String roleName) {

		if(!this.roles.stream().anyMatch(p->p.getRoleCode().equals(roleCode))) {
			this.roles.add(new UserRole(this, roleCode, roleName));
		}
	}

	public void updateRole( @NonNull String roleCode, @NonNull String roleName, Boolean enabled) {
		
		Optional<UserRole> opt = this.roles.stream().filter(p->p.getRoleCode().equals(roleCode)).findFirst();
		if(opt.isPresent()) {

			if(!Strings.isNullOrEmpty(roleName)) {
				opt.get().setRoleName(roleName);
			}

			if(enabled != null) {
				opt.get().setEnabled(enabled);
			}
		}
	}
	
	public void deleteRole(@NonNull String roleCode) {
		
		this.roles.removeIf(p->p.getRoleCode().equals(roleCode));
	}

	@Override
	public String toString() {

		return MoreObjects.toStringHelper(this).add("name", name)
				.add("enabled", enabled)
				.add("roles", roles).toString();
	}
}
