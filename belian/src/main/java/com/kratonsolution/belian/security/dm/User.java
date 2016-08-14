/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.global.dm.Listable;
import com.kratonsolution.belian.global.dm.UserSetting;
import com.kratonsolution.belian.hr.dm.Employee;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Entity
@Table(name="user")
@Cacheable
public class User implements Listable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="email",nullable=false,unique=true)
	private String email;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@Column(name="is_enabled")
	private boolean enabled;
	
	@ManyToOne()
	@JoinColumn(name="fk_user_setting")
	private UserSetting setting;
	
	@OneToOne(mappedBy="user")
	private Employee employee;
	
	@Column(name="is_deleteable")
	private boolean deleteable;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<UserRole> roles = new HashSet<UserRole>();

	public User(){}

	public String getName()
	{
		if(this.employee != null)
			return employee.getParty().getName();
		
		return "Unemployed user";
	}
	
	public Person getPerson()
	{
		if(employee != null)
			return (Person)getEmployee().getParty();
		
		return null;
	}

	@Override
	public String getLabel()
	{
		return getName();
	}

	@Override
	public String getValue()
	{
		return getId();
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public boolean isEnabled()
	{
		if(isSysAdmin())
			return enabled;
		
		if(employee != null && !employee.getEmployments().isEmpty())
		{
			if(employee.getEnd() == null)
				return true;
			else if(employee.getEnd().compareTo(DateTimes.sql(new Date())) > 0)
				return true;
			else
				return false;
		}
		
		return false;
	}

	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}

	public UserSetting getSetting()
	{
		return setting;
	}

	public void setSetting(UserSetting setting)
	{
		this.setting = setting;
	}

	public Employee getEmployee()
	{
		return employee;
	}

	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}

	public boolean isDeleteable()
	{
		if(employee != null)
			return false;
		
		return deleteable;
	}

	public void setDeleteable(boolean deleteable)
	{
		this.deleteable = deleteable;
	}

	public Set<UserRole> getRoles()
	{
		return roles;
	}

	public void setRoles(Set<UserRole> roles)
	{
		this.roles = roles;
	}
	
	public boolean isSysAdmin()
	{
		return email.equals("admin@belian.com");
	}
}
