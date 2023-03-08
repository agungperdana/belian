
package com.kratonsolution.belian.global.dm;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="quick_launch")
public class QuickLaunch implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="name")
	private String name;
	
	@Column(name="username")
	private String username;
	
	@Column(name="menu_enabled")
	private boolean menuEnabled;
	
	@Column(name="fisheye_enabled")
	private boolean fisheyeEnabled;
	
	@Version
	private Long version;

	public QuickLaunch(){}
}
