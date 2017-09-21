/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.global.dm.Listable;
import com.kratonsolution.belian.global.dm.UserSetting;

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
public class User implements Listable
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
