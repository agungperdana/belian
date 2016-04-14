/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.kratonsolution.belian.global.dm.ApproveAndReviewable;
import com.kratonsolution.belian.global.dm.Review;
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
@Table(name="budget")
public class Budget extends ApproveAndReviewable
{
	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private BudgetType type = BudgetType.Operating;
	
	@OneToMany(mappedBy="budget",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	@OrderBy("sequence")
	private Set<BudgetItem> items = new HashSet<BudgetItem>();
	
	@OneToMany(mappedBy="budget",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	@OrderBy("date")
	private Set<BudgetStatus> statuses = new HashSet<BudgetStatus>();
	
	@OneToMany(mappedBy="budget",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<BudgetRole> roles = new HashSet<>();
	
	@OneToMany(mappedBy="budget",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<BudgetRevision> revisions = new HashSet<>();
	
	@OneToMany(mappedBy="budget",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<BudgetReview> reviews = new HashSet<>();
	
	public Budget(){}

	@Override
	public Date getDate()
	{
		return getStart();
	}

	@Override
	public String getName()
	{
		return "Budget Request";
	}

	@Override
	public Statuses createStatus()
	{
		BudgetStatus status = new BudgetStatus();
		status.setBudget(this);
		this.getStatuses().add(status);

		return status;
	}

	@Override
	public Review createReview()
	{
		BudgetReview review = new BudgetReview();
		review.setBudget(this);
		this.getReviews().add(review);
		
		return review;
	}
}
