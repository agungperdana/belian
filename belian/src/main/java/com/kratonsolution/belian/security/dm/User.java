/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.global.dm.Listable;
import com.kratonsolution.belian.global.dm.UserSetting;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="user")
public class User implements Serializable,Listable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="name",nullable=false)
	private String name;

	@Column(name="email",nullable=false,unique=true)
	private String email;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@Column(name="is_enabled")
	private boolean enabled;
	
	@OneToOne(cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="fk_user_setting")
	private UserSetting setting;
	
	@ManyToOne
	@JoinColumn(name="fk_person")
	private Person person;
	
	@Column(name="is_deleteable")
	private boolean deleteable;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<UserRole> roles = new HashSet<UserRole>();

	public void setPerson(Person person)
	{
		this.person = person;
		person.setUser(this);
	}

	@Override
	public String getLabel()
	{
		return getPerson().getName();
	}

	@Override
	public String getValue()
	{
		return getPerson().getId();
	}
}
