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

import com.kratonsolution.belian.general.dm.Organization;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="bank_account")
public class BankAccount
{
	@Id
	private String id;
	
	@Column(name="number",nullable=false,unique=true)
	private String number;
	
	@Column(name="holder",nullable=false)
	private String holder;
	
	@ManyToOne
	@JoinColumn(name="fk_organization_bank")
	private Organization bank;

	@Column(name="status")
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name="fk_currency")
	private Currency currency;
	
	@Version
	private Long version;
}
