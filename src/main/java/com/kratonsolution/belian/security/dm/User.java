
package com.kratonsolution.belian.security.dm;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;

import com.kratonsolution.belian.common.dm.Referenceable;
import com.kratonsolution.belian.global.dm.UserSetting;
import com.kratonsolution.belian.hr.dm.Employee;

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
@Table(name="user")
public class User implements Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="email",nullable=false,unique=true)
	private String userName;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@Column(name="is_enabled")
	private boolean enabled;
	
	@ManyToOne()
	@JoinColumn(name="fk_user_setting")
	private UserSetting setting;
	
	@Column(name="is_deleteable")
	private boolean deleteable;
	
	@Transient
	private Employee employee;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<UserRole> roles = new HashSet<UserRole>();

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
