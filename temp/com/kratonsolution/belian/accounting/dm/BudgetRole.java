/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kratonsolution.belian.global.dm.ApproveAndReviewable;
import com.kratonsolution.belian.global.dm.Roled;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="budget_role")
public class BudgetRole extends Roled
{
	@ManyToOne
	@JoinColumn(name="fk_budget")
	private Budget budget;
	
	public BudgetRole(){}

	@Override
	public ApproveAndReviewable getDocument()
	{
		return getBudget();
	}
}
