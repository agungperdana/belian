/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.UUID;

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
@Table(name="accounting_setting")
public class AccountingSetting
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_cash_sales_account")
	private GLAccount cashSales;
	
	@Version
	private Long version;
	
	public AccountingSetting(){}
}
