/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kratonsolution.belian.global.dm.Statuses;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="budget_status")
public class BudgetStatus extends Statuses
{
	@ManyToOne
	@JoinColumn(name="fk_budget")
	private Budget budget;
	
	public BudgetStatus(){}
}
