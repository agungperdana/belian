/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="financial_account")
public class FinancialAccount implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="name")
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private FinancialAccountType type = FinancialAccountType.TEMPORARY_CASH_ACCOUNT;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="account",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<FinancialAccountRole> roles = new HashSet<>();
	
	@OneToMany(mappedBy="account",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<FinancialAccountTransaction> transactions = new HashSet<>();
	
	public FinancialAccount(){}
}
