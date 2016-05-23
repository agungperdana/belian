/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.general.dm.Organization;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="journal_setting")
@Cacheable
public class JournalSetting implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_organization",unique=true)
	@NotFound(action=NotFoundAction.IGNORE)
	private Organization organization;
	
	@ManyToOne
	@JoinColumn(name="fk_gl_account_cash")
	@NotFound(action=NotFoundAction.IGNORE)
	private GLAccount cash;
	
	@ManyToOne
	@JoinColumn(name="fk_gl_account_sales")
	@NotFound(action=NotFoundAction.IGNORE)
	private GLAccount sales;
	
	@ManyToOne
	@JoinColumn(name="fk_gl_account_ppn_payable")
	@NotFound(action=NotFoundAction.IGNORE)
	private GLAccount ppnPayable;
	
	@Version
	private Long version;
	
	public JournalSetting(){}
}
