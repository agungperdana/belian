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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="auto_journal_sales")
public class AutoJournalSales implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@ManyToOne
	@JoinColumn(name="fk_cash_account")
	@NotFound(action=NotFoundAction.IGNORE)
	private OGLAccount cash;
	
	@ManyToOne
	@JoinColumn(name="fk_service_sales_account")
	@NotFound(action=NotFoundAction.IGNORE)
	private OGLAccount serviceSales;
	
	@ManyToOne
	@JoinColumn(name="fk_goods_sales_account")
	@NotFound(action=NotFoundAction.IGNORE)
	private OGLAccount goodsSales;
	
	@ManyToOne
	@JoinColumn(name="fk_tax_payable_account")
	@NotFound(action=NotFoundAction.IGNORE)
	private OGLAccount taxPayable;
	
	@ManyToOne
	@JoinColumn(name="fk_payable_account")
	@NotFound(action=NotFoundAction.IGNORE)
	private OGLAccount payable;
	
	@ManyToOne
	@JoinColumn(name="fk_journal_setting")
	private AutoJournalSetting setting;
	
	@Version
	private Long version;
	
	public AutoJournalSales(){}
}
