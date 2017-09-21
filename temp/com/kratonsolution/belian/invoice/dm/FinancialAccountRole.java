/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.order.dm.RoleType;
import com.kratonsolution.belian.partys.dm.Party;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="financial_account_role")
public class FinancialAccountRole implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@ManyToOne
	@JoinColumn(name="fk_party")
	private Party party;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private RoleType type = RoleType.OWNER;
	
	@ManyToOne
	@JoinColumn(name="fk_account")
	private FinancialAccount account;
	
	@Version
	private Long version;
	
	public FinancialAccountRole(){}
}
