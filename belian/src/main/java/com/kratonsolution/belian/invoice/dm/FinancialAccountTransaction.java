/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

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
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="financial_account_transaction")
public class FinancialAccountTransaction implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="transaction_date")
	private Date transactionDate;
	
	@Column(name="entry_date")
	private Date entryDate;
	
	@ManyToOne
	@JoinColumn(name="fk_payment")
	private Payment payment;
	
	@ManyToOne
	@JoinColumn(name="fk_account")
	private FinancialAccount account;
	
	@Version
	private Long version;
}
