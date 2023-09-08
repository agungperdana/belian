package com.kratonsolution.belian.user.impl.orm;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


import com.kratonsolution.belian.common.persistence.Referenceable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
@Getter
@Setter
@Entity
@Table(name="user")
public class User implements Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="email")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="is_enabled")
	private boolean enabled;
	
	@ManyToOne()
	@JoinColumn(name="fk_user_setting")
	@NotFound(action = NotFoundAction.IGNORE)
	private UserSetting setting;
	
	@Column(name="is_deleteable")
	private boolean deleteable;

	@Version
	private Long version;

	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private Set<UserRole> roles = new HashSet<>();

	public User(){}

	@Override
	public String getLabel()
	{
		return userName;
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
