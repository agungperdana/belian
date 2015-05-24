/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import java.io.Serializable;

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

import com.kratonsolution.belian.general.dm.Organization;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="accessible_organization")
public class AccessibleOrganization implements Serializable
{
	@Id
	private String id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_role")
	private Role role;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_organization")
	private Organization organization;
	
	@Column(name="is_selected")
	private boolean selected;
	
	@Version
	private Long version;
}
