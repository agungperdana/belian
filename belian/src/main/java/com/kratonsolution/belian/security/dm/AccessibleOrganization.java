/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.kratonsolution.belian.general.dm.Organization;

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
@Table(name="accessible_organization")
public class AccessibleOrganization implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_role")
	@NotFound(action=NotFoundAction.IGNORE)
	private Role role;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_organization")
	@NotFound(action=NotFoundAction.IGNORE)
	private Organization organization;
	
	@Column(name="is_selected")
	private boolean selected;
	
	@Version
	private Long version;
}
