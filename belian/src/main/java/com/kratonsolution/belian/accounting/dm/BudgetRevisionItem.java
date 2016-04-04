/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

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

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="budget_revision_item")
public class BudgetRevisionItem implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private BudgetRevisionType type = BudgetRevisionType.Addition;
	
	@ManyToOne
	@JoinColumn(name="fk_budget_item")
	private BudgetItem item;
	
	@ManyToOne
	@JoinColumn(name="fk_budget_revision")
	private BudgetRevision revision;
	
	@Column(name="note")
	private String note;
	
	@Version
	private Long version;
}
