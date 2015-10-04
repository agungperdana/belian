/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.global.dm.ReviewResult;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="budget_review_result")
public class BudgetReviewResult extends ReviewResult
{
}
