/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

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
public class JournalSetting implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_organization",unique=true)
	private Organization organization;
	
	@ManyToOne
	@JoinColumn(name="fk_gl_account_cash_sales")
	private GLAccount cashSales;
	
	@ManyToOne
	@JoinColumn(name="fk_gl_account_cogs")
	private GLAccount cogs;
	
	@ManyToOne
	@JoinColumn(name="fk_gl_account_tax")
	private GLAccount tax;
	
	@Version
	private Long version;
	
	public JournalSetting(){}
}
