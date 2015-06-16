/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.general.dm.Approveable;
import com.kratonsolution.belian.general.dm.BudgetApprover;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="budget")
public class Budget extends Approveable
{
	@ManyToOne
	@JoinColumn(name="fk_budget_approver")
	private BudgetApprover approver;
	
	@Override
	public BudgetApprover getApprover()
	{
		return approver;
	}
}
