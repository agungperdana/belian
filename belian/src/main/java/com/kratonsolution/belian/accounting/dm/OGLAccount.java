/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="organization_gl_account")
public class OGLAccount
{
	@Id
	private String id;
	
	@Column(name="is_selected")
	private boolean selected;
		
	@ManyToOne
	@JoinColumn(name="fk_account")
	private GLAccount account;
	
	@ManyToOne
	@JoinColumn(name="fk_organization_account")
	private OrganizationAccount parent;
	
	@Version
	private Long version;
}
