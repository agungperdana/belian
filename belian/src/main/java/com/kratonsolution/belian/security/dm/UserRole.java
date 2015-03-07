/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="user_role")
public class UserRole
{
	@Id
	private String id;
	
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