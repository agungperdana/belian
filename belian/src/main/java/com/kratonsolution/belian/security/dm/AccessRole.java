/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Cacheable;
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
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="access_role")
@Cacheable
public class AccessRole implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_module")
	private Module module;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_role")
	private Role role;
	
	@Column(name="is_can_read")
	private boolean canRead;

	@Column(name="is_can_update")
	private boolean canUpdate;
	
	@Column(name="is_can_delete")
	private boolean canDelete;
	
	@Column(name="is_can_create")
	private boolean canCreate;

	@Column(name="is_can_print")
	private boolean canPrint;
	
	@Version
	private Long version;
}
