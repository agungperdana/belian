/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Cacheable
@Table(name="gl_account_balance")
public class GLAccountBalance implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_accounting_period")
	@NotFound(action=NotFoundAction.IGNORE)
	private AccountingPeriod period;
	
	@ManyToOne
	@JoinColumn(name="fk_gl_account")
	@NotFound(action=NotFoundAction.IGNORE)
	private GLAccount account;
	
	@ManyToOne
	@JoinColumn(name="fk_currency")
	@NotFound(action=NotFoundAction.IGNORE)
	private Currency currency;
	
	@Column(name="debet_balance")
	private BigDecimal debet = BigDecimal.ZERO;
	
	@Column(name="credit_balance")
	private BigDecimal credit = BigDecimal.ZERO;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="account")
	private Set<JournalPosting> postings = new HashSet<JournalPosting>();
	
	public GLAccountBalance(){}
}
