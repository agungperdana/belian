/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.accounting.dm.Budget;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="budget_approver")
public class BudgetApprover extends PartyRelationship
{
	@OneToMany(mappedBy="approver")
	public Set<Budget> budgets = new HashSet<Budget>();
}
