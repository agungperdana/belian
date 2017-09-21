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
	@JoinColumn(name="fk_tax_sales_account")
	@NotFound(action=NotFoundAction.IGNORE)
	private OGLAccount taxSales;
	
	@ManyToOne
	@JoinColumn(name="fk_tuslah_payable_account")
	@NotFound(action=NotFoundAction.IGNORE)
	private OGLAccount tuslah;

	@ManyToOne
	@JoinColumn(name="fk_receivable_account")
	@NotFound(action=NotFoundAction.IGNORE)
	private OGLAccount receivable;
	
	@ManyToOne
	@JoinColumn(name="fk_branch_cash_account")
	@NotFound(action=NotFoundAction.IGNORE)
	private OGLAccount branchCash;
	
	@Version
	private Long version;
	
	public AutoJournalSales(){}
}
